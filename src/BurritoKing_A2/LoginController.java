package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.*;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class LoginController 
{
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	public Label errorMessage;
	
	Pages pages = new Pages();
	
	public void openDashboard(ActionEvent event) throws IOException
	{
		if (usernameTF.getText().equals(selectUsername(usernameTF.getText())) && 
				passwordTF.getText().equals(selectPassword(usernameTF.getText())))
			{
				Pages pages = new Pages();
				pages.dashboardPage(event);
			}
		else
		{
			errorMessage.setText("Invalid username or password!");
		}
	}
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		 Pages pages = new Pages();
		 pages.welcomePage(event);
	 }
	
	
	private Connection connect() 
	{  
	     //SQLite connection string  
	     String url = "jdbc:sqlite:C:/Sqlite/AdvProgA2.db";  
	     Connection conn = null;  
	     try 
	     {  
	        conn = DriverManager.getConnection(url);  
	     } 
	     catch (SQLException e)
	     {  
	        System.out.println(e.getMessage());  
	     }  
	     return conn;  
    }  
	
	
	public String selectUsername(String username)
	{
		String usernameExists = "";
		String sql = "SELECT Username FROM Customer WHERE Username = ?";  
        
        try
        {  
            Connection conn = this.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();  
            
            while (rs.next())
            {
            	usernameExists = rs.getString("username");
            }
        } 
        catch (SQLException e) 
        {  
           System.out.println(e.getMessage());  
        }
        return usernameExists;
	}
	
	
	public String selectPassword(String username)
	{  
		 String passwordExists = "";
         String sql = "SELECT Password FROM Customer WHERE Username = ?" ;  
         
         try
         {  
             Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             pstmt.setString(1, username);
             ResultSet rs = pstmt.executeQuery();  
             
             while (rs.next())
             {
            	 passwordExists = rs.getString("password");
             }
         } 
         catch (SQLException e) 
         {  
            System.out.println(e.getMessage());  
         }
         return passwordExists;
     }  
}
