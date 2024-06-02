package BurritoKing_A2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

//This class implements all the functions related to the database
public class Database 
{
	private static final String DATABASE_URL = "jdbc:sqlite:src/AdvProgA2.db";
	
	static Date date = new Date();
	static LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	
	static int day = localDate.getDayOfMonth();
	static String dayString = String.valueOf(day);
	
	static int month = localDate.getMonthValue();
	static String monthString = String.valueOf(month);
	
	static int year = localDate.getYear();
	static String yearString = String.valueOf(year);
	
	public static List<OrderClass> ll = new LinkedList<OrderClass>();
	
	//Initiating the connection with the database
	public static Connection getConnection() throws SQLException 
    {
        try 
        {
            Class.forName("org.sqlite.JDBC");
            return DriverManager.getConnection(DATABASE_URL);
        } 
        catch (ClassNotFoundException e) 
        {
            e.printStackTrace();
            throw new RuntimeException("SQLite JDBC driver not found");
        }
    }
	
	//Inserting new user
	public static void insertNewUser(String username, String password, String firstName, String lastName)
	{
		 String sql = "INSERT INTO Customer (Username, Password, firstName, lastName) VALUES (?, ?, ?, ?)";
		 
		 try (Connection conn = getConnection())
		 {
			 PreparedStatement pstmt = conn.prepareStatement(sql);
			 pstmt.setString(1, username);
			 pstmt.setString(2, password);
			 pstmt.setString(3, firstName);
			 pstmt.setString(4, lastName);
			 pstmt.executeUpdate();
		 }
		 catch (SQLException e) 
	     {
			 e.printStackTrace();
	     }
	}
	
	//Validating the user during login
	public static boolean authenticateUser(String username, String password) 
    {
		String sql = "SELECT * FROM Customer WHERE Username = ? AND Password = ?";
		boolean validUser = false;
        try (Connection conn = getConnection()) 
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) 
            {
            	validUser = true;
            }
            else
            {
            	validUser = false;
            }
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
        }
        return validUser;
    }
	
	//Checking whether the given username already exists or not
	public static boolean isUsernameExists(String username) 
	{
		String sql = "SELECT COUNT(*) FROM Customer WHERE Username = ?";
        try (Connection conn = getConnection()) 
        {
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
	
	//Updating the first name
	public static void updateFirstName(String newFirstName) 
	{
		String sql = "UPDATE Customer SET FirstName = ? WHERE Username = ?";
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newFirstName);
			pstmt.setString(2, UserSingleton.getInstance().getCurrentUsername());
			int updateCount = pstmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	//Updating the last name
	public static void updateLastName(String newLastName) 
	{
		String sql = "UPDATE Customer SET LastName = ? WHERE Username = ?";
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newLastName);
			pstmt.setString(2, UserSingleton.getInstance().getCurrentUsername());
			int updateCount = pstmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	//Getting the password of the user
	public static String getPassword(String username) 
	{
		String sql = "SELECT Password FROM Customer WHERE Username = ?";
		String currentPassword = "";
		
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();  
			
			while (rs.next())
			{
				currentPassword = rs.getString("Password");
			}
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
		return currentPassword;
	}
	
	//Updating the password
	public static void updatePassword(String newPassword) 
	{
		String sql = "UPDATE Customer SET Password = ? WHERE Username = ?";
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, newPassword);
			pstmt.setString(2, UserSingleton.getInstance().getCurrentUsername());
			int updateCount = pstmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	//Upgrading the user to VIP
	public static void upgradeUser(String email) 
	{
		String sql = "UPDATE Customer SET IsVIP = 1, Email = ? WHERE Username = ?";
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, email);
			pstmt.setString(2, UserSingleton.getInstance().getCurrentUsername());
			int updateCount = pstmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	//Updating the credits of a VIP user
	public static void updateCredits(double totalCredits) 
	{
		String sql = "UPDATE Customer SET Credits = ? WHERE Username = ?";
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setDouble(1, totalCredits);
			pstmt.setString(2, UserSingleton.getInstance().getCurrentUsername());
			int updateCount = pstmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	//Getting the current credits of the user
	public static double getCurrentCredits(String username) 
	{
		String sql = "SELECT Credits FROM Customer WHERE Username = ?";
		double currentCredits = 0;
		
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, username);
			ResultSet rs = pstmt.executeQuery();  
			
			while (rs.next())
			{
				currentCredits = rs.getDouble("Credits");
			}
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
		return currentCredits;
	}
	
	//Getting the first name of the user
	public static String getFirstName(String username) 
	{
		String sql = "SELECT FirstName FROM Customer WHERE Username = ?" ;  
		String firstName = "";
        try (Connection conn = getConnection())
        {  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();  
            
            while (rs.next())
            {
           	 firstName = rs.getString("FirstName");
            }
        } 
        catch (SQLException e) 
        {  
           System.out.println(e.getMessage());  
        }
        return firstName;
		 
	 }
	
	//Getting the last name of the user
	public static String getLastName(String username) 
	{
		String sql = "SELECT LastName FROM Customer WHERE Username = ?" ;  
        String lastName = "";
        try (Connection conn = getConnection())
        {  
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();  
            
            while (rs.next())
            {
           	 lastName = rs.getString("LastName");
            }
        } 
        catch (SQLException e) 
        {  
           System.out.println(e.getMessage());  
        }
        return lastName;
		 
	 }
	
	//Getting the VIP Status of the user
	public static boolean getVIPStatus(String username) 
	{
		String sql = "SELECT isVIP FROM Customer WHERE Username = ?" ;
		boolean vipStatus = false;
		 
		try (Connection conn = getConnection())
		{  
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();  
            
            while (rs.next())
            {
           	 int status = rs.getInt("isVIP");
           	 
           	 if (status == 0)
           	 {
           		 vipStatus = false;
           	 }
           	 else
           	 {
           		 vipStatus = true;
           	 }
            }
        } 
        catch (SQLException e) 
        {  
           System.out.println(e.getMessage());  
        }
		return vipStatus;
	 }
	 
	//Inserting a new order into the database
	public static void newOrder(String orderTime, String readyTime) 
	{
		String sql = "INSERT INTO Orders ('NumOfBurritos', 'NumOfFries', 'NumOfSodas', 'NumOfMeals', 'TotalCost', "
				+ "'OrderDate', 'OrderTime', 'PrepTime', 'ReadyTime', 'OrderStatus', 'User') VALUES (?,?,?,?,?,?,?,?,?,?,?)";
		 
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			pstmt.setInt(1, OrderDetailsSingleton.getInstance().getCurrentNumOfBurritos());
			pstmt.setInt(2, OrderDetailsSingleton.getInstance().getCurrentNumOfFries());
			pstmt.setInt(3, OrderDetailsSingleton.getInstance().getCurrentNumOfSodas());
			pstmt.setInt(4, OrderDetailsSingleton.getInstance().getCurrentNumOfMeals());
			pstmt.setDouble(5, OrderDetailsSingleton.getInstance().getCurrentTotalCost());
			pstmt.setString(6, dayString + "/" + monthString + "/" + yearString);
			pstmt.setString(7, orderTime);
			pstmt.setDouble(8, OrderDetailsSingleton.getInstance().getCurrentPrepTime());
			pstmt.setString(9, readyTime);
			pstmt.setString(10, "Await for collection");
			pstmt.setString(11, UserSingleton.getInstance().getCurrentUsername());
			pstmt.executeUpdate();
		}
		catch (SQLException e) 
		{  
			System.out.println(e.getMessage());  
		}
	}
	 
	//Getting the latest Order ID
	public static int latestOrderID() 
	{
		String sql = "SELECT OrderID FROM Orders ORDER BY OrderID DESC LIMIT 1";
		int latestOrderID = 0;
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
		 
			if (rs.next())
			{
				latestOrderID = rs.getInt("OrderID");
			}
			else
			{
				latestOrderID = 0;
			}
		}
		catch (SQLException e) 
		{  
			System.out.println(e.getMessage());  
		}
		return latestOrderID;
	}
	 
	//Changing the status of an order to cancelled
	public static boolean cancelOrder(String orderID) 
	{
		String sql = "UPDATE Orders SET OrderStatus = 'Cancelled' WHERE OrderID = ? AND OrderStatus = ? AND User = ?";
		boolean result = false;
		
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, orderID);
			pstmt.setString(2, "Await for collection");
			pstmt.setString(3, UserSingleton.getInstance().getCurrentUsername());
			int updateCount = pstmt.executeUpdate();
			if (updateCount == 1)
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}
		catch (SQLException e) 
		{ 
			result = false;
			System.out.println(e.getMessage());  
		}
		return result;
	}
	 
	//Changing the status of an order to collected
	public static boolean collectOrder(String orderID, String collectTime) 
	{
		String sql = "UPDATE Orders SET OrderStatus = 'Collected', PickupDate = ?, PickupTime = ?"
	 		+ " WHERE OrderID = ? AND OrderStatus = ? AND User = ?";
		boolean result = false;
	 
		try (Connection conn = getConnection())
		{
			PreparedStatement pstmt  = conn.prepareStatement(sql);
			pstmt.setString(1, dayString + "/" + monthString + "/" + yearString);
			pstmt.setString(2, collectTime);
			pstmt.setString(3, orderID);
			pstmt.setString(4, "Await for collection");
			pstmt.setString(5, UserSingleton.getInstance().getCurrentUsername());
			int updateCount = pstmt.executeUpdate();
			if (updateCount == 1)
			{
				result = true;
			}
			else
			{
				result = false;
			}
		}
		catch (SQLException e) 
		{ 
			result = false;
			System.out.println(e.getMessage());  
		}
		return result;
	}
	 
	//Getting the date of the order
	public static String getOrderDate(String orderID) 
	{
		 String sql = "SELECT OrderDate FROM Orders WHERE OrderID = ?";
		 String orderDate = "";
		 try (Connection conn = getConnection())
		 {
			 PreparedStatement pstmt  = conn.prepareStatement(sql);
			 pstmt.setString(1, orderID);
			 ResultSet rs = pstmt.executeQuery();
			 
			 while (rs.next())
			 {
				 orderDate = rs.getString("OrderDate");
			 }
		 }
		 catch (SQLException e) 
	     {
			 System.out.println(e.getMessage());  
	     }
		 return orderDate;
	}
 
	//Getting the time at which the order will be ready for pickup
	public static String getOrderReadyTime(String orderID) 
	{
		 String sql = "SELECT ReadyTime FROM Orders WHERE OrderID = ?";
		 String orderReadyTime = "";
		 try (Connection conn = getConnection())
		 {
			 PreparedStatement pstmt  = conn.prepareStatement(sql);
			 pstmt.setString(1, orderID);
			 ResultSet rs = pstmt.executeQuery();
			 
			 while (rs.next())
			 {
				 orderReadyTime = rs.getString("ReadyTime");
			 }
		 }
		 catch (SQLException e) 
	     {
			 System.out.println(e.getMessage());  
	     }
		 return orderReadyTime;
	}
 
	//Getting all the orders of a user
	public static ObservableList<OrderClass> getAllOrders() 
	{
		 ObservableList<OrderClass> orderslist = FXCollections.observableArrayList();
		 String sql = "SELECT OrderID, NumOfBurritos, NumOfFries, NumOfSodas, NumOfMeals, TotalCost, OrderDate, OrderTime,"
			 		+ " OrderStatus FROM Orders WHERE User = ? ORDER BY OrderDate DESC, OrderTime DESC";
		 try (Connection conn =  getConnection())
		 {
			 PreparedStatement pstmt  = conn.prepareStatement(sql);
			 pstmt.setString(1, UserSingleton.getInstance().getCurrentUsername());
			 ResultSet rs = pstmt.executeQuery();
			 orderslist = getOrderObjects(rs);
		 }
		 catch (SQLException e)
	     { 
	       System.out.println(e.getMessage());  
	     }
		 return orderslist;
	}
 
	//Getting all the orders of a user that are waiting to be collected
	public static ObservableList<OrderClass> getAllAwaitingOrders() 
	{
		 ObservableList<OrderClass> orderslist = FXCollections.observableArrayList();
		 String sql = "SELECT OrderID, NumOfBurritos, NumOfFries, NumOfSodas, NumOfMeals, TotalCost, OrderDate, OrderTime,"
		 		+ " OrderStatus FROM Orders WHERE User = ? AND OrderStatus = 'Await for collection'";
		 try (Connection conn =  getConnection())
		 {
			 PreparedStatement pstmt  = conn.prepareStatement(sql);
			 pstmt.setString(1, UserSingleton.getInstance().getCurrentUsername());
			 ResultSet rs = pstmt.executeQuery();
			 orderslist = getOrderObjects(rs);
		 }
		 catch (SQLException e) 
	     { 
	       System.out.println(e.getMessage());  
	     }
		 return orderslist;
	}

	//Setting the orders into an observable list
	private static ObservableList<OrderClass> getOrderObjects(ResultSet rs) throws SQLException 
	{
		try
		{
			ObservableList<OrderClass> orderslist = FXCollections.observableArrayList();
			
			while (rs.next())
			{
				OrderClass oc = new OrderClass();
				oc.setOrderID(rs.getInt("OrderID"));
				oc.setOrderNumOfBurritos(rs.getInt("NumOfBurritos"));
				oc.setOrderNumOfFries(rs.getInt("NumOfFries"));
				oc.setOrderNumOfSodas(rs.getInt("NumOfSodas"));
				oc.setOrderNumOfMeals(rs.getInt("NumOfMeals"));
				oc.setOrderAllItems();
				oc.setOrderTotalCost(rs.getDouble("TotalCost"));
				oc.setOrderDate(rs.getString("OrderDate"));
				oc.setOrderTime(rs.getString("OrderTime"));
				oc.setOrderStatus(rs.getString("OrderStatus"));
					orderslist.add(oc);
				}
				return orderslist;
			}	
			catch (SQLException e)
			{
				e.printStackTrace();
			}
			return null;
		}
	}