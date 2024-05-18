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
                /*user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                user.setFirstName(rs.getString("first_name"));
                user.setLastName(rs.getString("last_name"));
                user.setVIP(rs.getBoolean("is_vip"));
                user.setCredits(rs.getInt("credits"));*/
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
}
