package BurritoKing_A2;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.*;

public class SignUpController 
{	
	private String existingUsername = "Andy";
	
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	public PasswordField cPasswordTF;
	public TextField firstNameTF;
	public TextField lastNameTF;
	
	
	public void openLoginPage(ActionEvent event) throws IOException
	 {
		 if (usernameTF.getText().isBlank() || passwordTF.getText().isBlank() || cPasswordTF.getText().isBlank() || 
				 firstNameTF.getText().isBlank() || lastNameTF.getText().isBlank())
		 {
			 System.out.println("Fields cannot be empty");
		 }
		 else if (!passwordTF.getText().equals(cPasswordTF.getText()))
		 {
			 System.out.println("Please enter identical passwords");
		 }
		 else if (usernameTF.getText().equals(existingUsername))
		 {
			 System.out.println("The username already exists");
		 }
		 else
		 {
			 insertCustomer(usernameTF.getText(), passwordTF.getText(), firstNameTF.getText(), lastNameTF.getText());
			 Pages pages = new Pages();
			 pages.loginPage(event);
		 }
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
	
	
	public void insertCustomer(String username, String password, String firstname, String lastname)
	{
		String sql = "INSERT INTO Customer VALUES (?,?,?,?)";
		try
        {  
            Connection conn = this.connect();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            pstmt.setString(2, password);
            pstmt.setString(3, firstname);
            pstmt.setString(4, lastname);
            pstmt.executeUpdate();
        }
		catch (SQLException e) 
		{
            System.out.println(e.getMessage());
        }
	}
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	{
		Pages pages = new Pages();
		pages.welcomePage(event);
	}
}
