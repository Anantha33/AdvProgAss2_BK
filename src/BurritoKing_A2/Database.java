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
}
