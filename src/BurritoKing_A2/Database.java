package BurritoKing_A2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Database 
{
	private static final String DATABASE_URL = "jdbc:sqlite:C:/Sqlite/AdvProgA2.db";
	
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
	
	public static boolean authenticateUser(String username, String password) 
    {
		boolean validUser = false;
        try (Connection conn = getConnection()) 
        {
            String query = "SELECT * FROM Customer WHERE Username = ? AND Password = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            stmt.setString(2, password);
            ResultSet rs = stmt.executeQuery();
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
	
	public static boolean isUsernameExists(String username) 
	{
        try (Connection conn = getConnection()) 
        {
            String query = "SELECT COUNT(*) FROM Customer WHERE Username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            return rs.getInt(1) > 0;
        } 
        catch (SQLException e) 
        {
            e.printStackTrace();
            return false;
        }
    }
	
	public static void updateFirstName(String newFirstName, String username)
	{
		try (Connection conn = getConnection())
		{
			String query = "UPDATE Customer SET FirstName = ? WHERE Username = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newFirstName);
			stmt.setString(2, username);
			int updateCount = stmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	
	public static void updateLastName(String newLastName, String username)
	{
		try (Connection conn = getConnection())
		{
			String query = "UPDATE Customer SET LastName = ? WHERE Username = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newLastName);
			stmt.setString(2, username);
			int updateCount = stmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	
	public static void updatePassword(String newPassword, String username)
	{
		try (Connection conn = getConnection())
		{
			String query = "UPDATE Customer SET Password = ? WHERE Username = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, newPassword);
			stmt.setString(2, username);
			int updateCount = stmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	
	public static void upgradeUser(String email, String username)
	{
		try (Connection conn = getConnection())
		{
			String query = "UPDATE Customer SET IsVIP = 1, Email = ? WHERE Username = ?";
			PreparedStatement stmt = conn.prepareStatement(query);
			stmt.setString(1, email);
			stmt.setString(2, username);
			int updateCount = stmt.executeUpdate();
		}
		catch (SQLException e) 
        {
            e.printStackTrace();
        }
	}
	
	
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
	 
	 public static void newOrder(String orderTime)
	 {
		 String sql = "INSERT INTO Orders ('NumOfBurritos', 'NumOfFries', 'NumOfSodas', 'NumOfMeals', 'TotalCost', "
		 		+ "'OrderDate', 'OrderTime', 'PrepTime', 'OrderStatus', 'User') VALUES (?,?,?,?,?,?,?,?,?,?)" ;
		 
		 try (Connection conn = getConnection())
		 {
			 PreparedStatement pstmt  = conn.prepareStatement(sql);
			 pstmt.setInt(1, OrderDetailsSingleton.getInstance().getCurrentNumOfBurritos());
			 pstmt.setInt(2, OrderDetailsSingleton.getInstance().getCurrentNumOfFries());
			 pstmt.setInt(3, OrderDetailsSingleton.getInstance().getCurrentNumOfSodas());
			 pstmt.setInt(4, OrderDetailsSingleton.getInstance().getCurrentNumOfMeals());
			 pstmt.setDouble(5, OrderDetailsSingleton.getInstance().getCurrentTotalCost());
			 pstmt.setString(6, "12/12/2012");
			 pstmt.setString(7, orderTime);
			 pstmt.setDouble(8, OrderDetailsSingleton.getInstance().getCurrentPrepTime());
			 pstmt.setString(9, "Await for collection");
			 pstmt.setString(10, UserSingleton.getInstance().getCurrentUsername());
			 pstmt.executeUpdate();
		 }
		 catch (SQLException e) 
         {  
           System.out.println(e.getMessage());  
         }
	 }
	 
	 
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
}
