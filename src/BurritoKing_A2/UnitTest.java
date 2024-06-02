package BurritoKing_A2;

import static org.junit.Assert.*;
import org.junit.Test;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//This is the class for unit test of the various functions used
public class UnitTest 
{

	private static final String DATABASE_URL = "jdbc:sqlite:src/AdvProgA2.db";

    //Helper method to set up a test user in the database
    private void setUpTestUser() throws SQLException 
    {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL)) 
        {
        	//Inserting new user
            String sql = "INSERT INTO Customer (Username, Password, FirstName, LastName) VALUES (?,?,?,?)"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testuser");
            pstmt.setString(2, "testpassword");
            pstmt.setString(3, "testfirstname");
            pstmt.setString(4, "testlastname");
            pstmt.executeUpdate();
        }
    }

    //Helper method to clean up the test user from the database
    private void tearDownTestUser() throws SQLException 
    {
        try (Connection conn = DriverManager.getConnection(DATABASE_URL)) 
        {
        	//Deleting the recently added user
            String sql = "DELETE FROM Customer WHERE Username = ?"; 
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, "testuser");
            pstmt.executeUpdate();
        }
    }
    
    //Testing whether the user is a valid user in the database or not
    @Test
    public void testAuthenticateUser() 
    {
        try 
        {
            setUpTestUser();
            
            //Checking if the password corresponds to the user
            boolean isAuthenticated = Database.authenticateUser("testuser", "testpassword"); 
            assertTrue("User should be authenticated with valid credentials", isAuthenticated);

            boolean isNotAuthenticated = Database.authenticateUser("testuser", "wrongpassword");
            assertFalse("User should not be authenticated with invalid credentials", isNotAuthenticated);

        } 
        catch (SQLException e) 
        {
            fail("SQLException occurred during test: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                tearDownTestUser();
            } 
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
    
    //Testing whether a particular username exists or not in the database
    @Test
    public void testIsUsernameExists() 
    {
        try 
        {
            setUpTestUser();
            
            //Checking whether the username exists
            boolean exists = Database.isUsernameExists("testuser"); 
            assertTrue("Username should exist in the database", exists);

            boolean doesNotExist = Database.isUsernameExists("nonexistentuser");
            assertFalse("Username should not exist in the database", doesNotExist);

        } 
        catch (SQLException e) 
        {
            fail("SQLException occurred during test: " + e.getMessage());
        } 
        finally 
        {
            try 
            {
                tearDownTestUser();
            } 
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
        }
    }
    
    //Testing whether the user is a VIP or not
    @Test
    public void testVIPStatus()
    {
    	try
    	{
    		setUpTestUser();
    		
    		//Checking the vip status of the user
    		boolean notVip = Database.getVIPStatus("testuser");
    		assertFalse("User is not a VIP", notVip);
    		
    		boolean Vip = Database.getVIPStatus("Andy");
    		assertTrue("User is a VIP", Vip);
    		
    		
    	}
    	catch (SQLException e) 
        {
            fail("SQLException occurred during test: " + e.getMessage());
        }
    	finally 
        {
            try 
            {
                tearDownTestUser();
            } 
            catch (SQLException e) 
            {
            	e.printStackTrace();
            }
        }
    }
    
    //Testing whether the first name is getting updated or not
    @Test
    public void updateFirstName()
    {
    	try
    	{
    		//Setting the current user
    		UserSingleton.getInstance().setCurrentUserDetails("Andy", "Andy", "Kris", false, 0); 
    		
    		//Setting the new first name
    		Database.updateFirstName("Anantha"); 
    		
    		//Retrieving the first name of the user
    		String newFirstName = Database.getFirstName("Andy"); 
    		
    		//Asserting whether the new first name is equal to the given parameter
    		assertEquals(newFirstName, "Anantha"); 
    	}
    	catch (Exception e) 
        {
            fail("SQLException occurred during test: " + e.getMessage());
        }
    	finally
    	{
    		try
    		{
    			//Rolling back to the original first name
    			Database.updateFirstName("Andy"); 
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
    
    //Testing the credits of the user
    @Test
    public void checkingCredits() 
    {
    	try
    	{
    		//Setting the current user
    		UserSingleton.getInstance().setCurrentUserDetails("Andy", "Andy", "Kris", false, 0); 
    		
    		//Updating the credits
    		Database.updateCredits(100.0); 
    		
    		String credits = String.valueOf(Database.getCurrentCredits("Andy"));
    		
    		//Asserting whether the retrieved credits is not equal to the given parameter
    		assertNotEquals(credits, "0"); 
    	}
    	catch (Exception e) 
        {
            fail("SQLException occurred during test: " + e.getMessage());
        }
    	finally
    	{
    		try
    		{
    			//Rolling back to the original credits
    			Database.updateCredits(0); 
    		}
    		catch (Exception e)
    		{
    			e.printStackTrace();
    		}
    	}
    }
}
