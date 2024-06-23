
import java.sql.*;
import java.util.*;

public class OracleJDBCTeam2{
	public static Scanner sc = new Scanner(System.in);
	 public static Connection connectionString()
	 {
		    try {

             Class.forName("oracle.jdbc.driver.OracleDriver");

            } catch (ClassNotFoundException e) {

             System.out.println("Where is your Oracle JDBC Driver?");
             e.printStackTrace();
             return null;

            }
            Connection connection = null;

            try {

           //below include your login and your password
           connection =
           DriverManager.getConnection("jdbc:oracle:thin:@acaddbprod.uta.edu:1523/pcse1p.data.uta.edu", "nxv0544","Narl1ngt0n22");
           return connection;
           } catch (SQLException e) {
             System.out.println("Connection Failed! Check output console");
             e.printStackTrace();
             return null;

           }
	 }
        public static void main(String[] argv) {
            System.out.println("Welcome to ABC Restaurant");
            System.out.println("Are you a Customer or an Evaluator\r\n");
            char person = sc.next().charAt(0);
            if (person=="C"){
                System.out.println("Choose an option: \r\n"
                + "1. Place an order\r\n"
                + "2. Just see the Menu\r\n");
            }
            else{
                System.out.println("Please select from the options below to see our stats\r\n"
                + "3. Customer IDs who have shown interest in giving rating\r\n"
                + "4. Customer IDs,Emails who have shown interest in ordering more than once\r\n"
                + "5. Most frequently used Inventory Item IDs\r\n"
                + "6. Customer ID, Name, Email who have opted for Dine-IN order type");
            }
            registerCustomer();
    }
        public static void registerCustomer() {
        	if (connectionString() != null) {
            	    
            	    int decision = sc.nextInt();
            	    switch(decision) 
            	    {
            	    case 1: {
            		System.out.println("To place an order please enter your details");
            		int id;
            		
            		System.out.print("First Name - ");
            		String f_name = sc.next();
            		System.out.print("Last Name - ");
            		String l_name = sc.next();
            		System.out.print("Age - ");
            		int age = sc.nextInt();
            		System.out.print("Gender - ");
            		char gender = sc.next().charAt(0);
            		System.out.print("Phone Number - ");
            		long pno = sc.nextLong();
            		System.out.print("Email ID - ");
            		String email = sc.next();
            		String idStr = String.valueOf(pno);
            		int lastThreeIndex = idStr.length()-3; 
            		int lastFourIndex = idStr.length()-4;
            		int lastFourDigits = Integer.parseInt(idStr.substring(lastFourIndex));
            		int lastThreeDigits = Integer.parseInt(idStr.substring(lastThreeIndex));
            		
            
            	try {
            		Statement stmt = connectionString().createStatement();
            		id = lastThreeDigits;
            		int y = 0;
            		
            		String q1 = "insert into Fall22_S003_2_Customer values('"+id+"','"+email+"','"+pno+"','" +age+ "', '" +f_name+ "', '" +l_name+ "', '" +gender+ "')";
                    int x = stmt.executeUpdate(q1);
                    if(x==1)
                    	y = placeOrder(id,lastFourDigits);
                    if(y==1) {
                    	System.out.println("Your order has been placed");
                    }
            		stmt.close();
            		connectionString().close();
            		
            	}
            	catch (SQLException e) {

                    System.out.println("error in accessing the Fall22_S003_2_Customer relation");
                    e.printStackTrace();
                    return;
            	}
            	    }
            	    break;
            	    
            	    case 2: {
            	    	System.out.println("Please see our Menu and take your time to place an order");
            	    	try {
                			int i = 0;
                			Statement stmt = connectionString().createStatement();
                			String menu = "select DISTINCT(ordercategory) from Fall22_S003_2_Order";
                        	ResultSet rs = stmt.executeQuery(menu);
                        	while(rs.next()) {
                        		i = i + 1;
                        		System.out.println(i+"."+rs.getString("ordercategory"));
                        	}
                        	rs.close();
                        	stmt.close();
                        	connectionString().close();
                            
                		}
                		catch(SQLException e) {
                			System.out.println("Error in accessing the Fall22_S003_2_Order relation");
                			e.printStackTrace();
                			return;
                		}
                        
            	    }
            	    
            	    break;
            	    case 3:
            	    {
            	    	try {
                    		System.out.println("Fetched first 5 Customer IDs who have shown interest in giving rating");
                    		Statement stmt = connectionString().createStatement();
                    		String q1 = "select cid,count(rating) as Count_of_Ratings from Fall22_S003_2_Feedback group by cid order by Count_of_Ratings desc fetch first 5 rows only";
                    		ResultSet rs = stmt.executeQuery(q1);
                    		String second = rs.getMetaData().getColumnName(1);
                        	while(rs.next())
                        		System.out.println(rs.getString("cid")+"----"+rs.getString(second));
                        	rs.close();
                        	stmt.close();
                            connectionString().close();
                    	}catch (SQLException e) {

                            System.out.println("error in accessing the relation");
                            e.printStackTrace();
                            return;
                    	}
            	    }
            	    break;
            	    case 4:
            	    {
            	    	try {
                    		System.out.println("Fetched Customer IDs,Emails who have shown interest in ordering more than once");
                    		Statement stmt = connectionString().createStatement();
                    		String q1 = "select cid,email from Fall22_S003_2_Customer where cid in (select cid from Fall22_S003_2_Order group by cid having count(*)>1)";
                    		ResultSet rs = stmt.executeQuery(q1);
                        	while(rs.next())
                        		System.out.println(rs.getString("cid")+"----"+rs.getString("email"));
                        	rs.close();
                        	stmt.close();
                            connectionString().close();
                    	}catch (SQLException e) {

                            System.out.println("error in accessing the relation");
                            e.printStackTrace();
                            return;
                    	}
            	    }
            	    break;
            	    case 5:
            	    {
            	    	try {
                    		System.out.println("Fetched Most frequently used Inventory Item IDs");
                    		Statement stmt = connectionString().createStatement();
                    		String q1 = "select o.item_id_used,count(o.id) from Fall22_S003_2_Order o inner join Fall22_S003_2_Supplies s on o.item_id_used=s.item_id group by cube(o.item_id_used) order by count(o.id)";
                    		ResultSet rs = stmt.executeQuery(q1);
                    		String first = rs.getMetaData().getColumnName(1);
                    		String second = rs.getMetaData().getColumnName(2);
                        	while(rs.next())
                        		System.out.println(rs.getString(first)+"----"+rs.getString(second));
                        	rs.close();
                        	stmt.close();
                            connectionString().close();
                    	}catch (SQLException e) {

                            System.out.println("error in accessing the relation");
                            e.printStackTrace();
                            return;
                    	}
            	    }
            	    break;
            	    case 6:
            	    {
            	    	try {
                    		System.out.println("Fetched Customer ID, Name, Email who have opted for Dine-IN order type");
                    		Statement stmt = connectionString().createStatement();
                    		String q1 = "select cid,f_name,email from Fall22_S003_2_Customer where cid in(select cid from Fall22_S003_2_Order where type='dine_in' and cid in ( select o.cid from Fall22_S003_2_Order o join Fall22_S003_2_Feedback f on o.cid=f.cid where f.rating>=7))";
                    		ResultSet rs = stmt.executeQuery(q1);
                        	while(rs.next())
                        		System.out.println(rs.getString("cid")+"----"+rs.getString("f_name")+"----"+rs.getString("email"));
                        	rs.close();
                        	stmt.close();
                            connectionString().close();
                    	}catch (SQLException e) {

                            System.out.println("error in accessing the relation");
                            e.printStackTrace();
                            return;
                    	}
            	    }
            	    break;
            	    default: System.out.println("Thank you for visiting our Restaurant");
        	}
        	}
            
            else {
            	System.out.println("Failed to make connection!!");
            	return;
            }
        	
        }
        public static int placeOrder(int cid, int orderId)
        {
        	if(connectionString()!=null) {
        	int oid = orderId;
        	System.out.println("Please start ordering by choosing your options");
    		System.out.println("---------Order Category--------");
    		System.out.println("1.breakfast------------------15/-\r\n"
    				+ "2.IndoChinese_maincourse--------------55/-\r\n"
    				+ "3.Indian_maincourse-------------------60/-\r\n"
    				+ "4.cold_beverages----------------------9/-\r\n"
    				+ "5.chinese_maincourse------------------55/-\r\n"
    				+ "6.thai_maincourse---------------------65/-\r\n"
    				+ "7.soda_beverages----------------------5/-\r\n"
    				+ "8.confectionary_desserts--------------20/-\r\n"
    				+ "9.combo_meal--------------------------65/-\r\n"
    				+ "10.hot_beverages----------------------11/-\r\n"
    				+ "11.frozen_desserts--------------------30/-");
    		System.out.print("Please enter the number corresponding to you choice of order category - ");
            int oC = sc.nextInt();
            String order_category="";
            int item_used;
            int price;
            switch(oC)
            {
            case 1: 
            	order_category = "breakfast";
            	price = 15;
            	item_used = 301;
            	break;
            case 3: 
            	order_category = "Indian_maincourse";
            	price = 60;
            	item_used = 823;
            	break;
            case 4: 
            	order_category = "cold_beverages";
            	price = 9;
            	item_used = 741;
            	break;
            case 10: 
            	order_category = "hot_bevarages";
            	price = 11;
            	item_used = 462;
            	break;
            case 2: 
            	order_category = "IndoChinese_maincourse";
            	price = 55;
            	item_used = 176;
            	break;
            case 6: 
            	order_category = "thai_maincourse";
            	price = 65;
            	item_used = 750;
            	break;
            case 7: 
            	order_category = "soda_beverages";
            	price = 5;
            	item_used = 758;
            	break;
            case 8: 
            	order_category = "confectionary_desserts";
            	price = 20;
            	item_used = 914;
            	break;
            case 9: 
            	order_category = "combo_meal";
            	price = 65;
            	item_used = 615;
            	break;
            case 5: 
            	order_category = "chinese_maincourse";
            	price = 55;
            	item_used = 987;
            	break;
            case 11: 
            	order_category = "frozen_desserts";
            	price = 30;
            	item_used = 132;
            	break;
            default: 
            	order_category = "water";
            	price = 8;
            	item_used = 875;
            	break;
            }
    		System.out.println("-----------Order Type------------");
    		System.out.println("1. Dine In    2. To Go");
    		System.out.print("Please enter your order type - ");
    		int ot = sc.nextInt();
    		String order_type = "";
    		if(ot == 1)
    			order_type = "dine_in";
    		else
    			order_type = "to_go";
    		int cust_id = cid;
    		
            //DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/Mon/uuuu HH:mm");
            //LocalDateTime nowTaken = LocalDateTime.now();
            //LocalDateTime nowGiven = nowTaken.plusMinutes(8);
            String order_taken_time = "06-DEC-2022 19:11";
            //dtf.format(nowTaken).toString();
            String order_served_time = "06-DEC-2022 19:19";
            //dtf.format(nowGiven).toString();
            try {
            	Statement stmt = connectionString().createStatement();
            	int Eid = 1311276;
            	String EmpID = "select * from Fall22_S003_2_Dept_Emp where DeptId = 3 and ROWNUM = 1";
            	ResultSet rs = stmt.executeQuery(EmpID);
            	while(rs.next())
            		Eid = rs.getInt("eid");
            	rs.close();
                String q2 = "insert into Fall22_S003_2_Order values('"+oid+"','"+order_category+"','"+order_type+"','" +price+ "', '" +order_taken_time+ "', '" +order_served_time+ "', '" +cust_id+ "', '" +Eid+ "', '" +item_used+ "')";
                int y = stmt.executeUpdate(q2);	
                stmt.close();
                connectionString().close();
                return y;
                
            }catch (SQLException e) {

                System.out.println("error in accessing the Fall22_S003_2_Order relation");
                e.printStackTrace();
                return 0;
        	}
        	}
            else {
            	System.out.println("Failed to make connection!!");
            	return 0;
            }
        	
        }
        

}
