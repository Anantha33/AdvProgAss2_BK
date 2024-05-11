package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.*;
import java.sql.DriverManager;  
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException;  
import java.sql.Statement;  

public class LoginController 
{
	String currentUser;
	private Stage loginStage;
	private Scene loginScene;

	private Parent root;
	
	@FXML
	public TextField usernameTF;
	
	@FXML
	public PasswordField passwordTF;
	
	@FXML
	public Label errorMessage;
	
	
	public void showLoginPage(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("/LoginPage.fxml"));
		loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		loginStage.setTitle("Login Page");
		loginScene = new Scene(root);
		loginStage.setScene(loginScene);
		loginStage.show();
	}
	
	public void openDashboard(ActionEvent event) throws IOException
	{
		selectAll();
		if (usernameTF.getText().equals(currentUser) && passwordTF.getText().equals("axy"))
		{	
			DashboardController dc = new DashboardController();
			dc.showDashboardPage(event);
		}
		else
		{
			errorMessage.setText("Invalid username or password!");
		}
	}
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		 WelcomeController welcome = new WelcomeController();
		 welcome.showWelcomePage(event);
	 }
	
	private Connection connect() 
	{  
	     // SQLite connection string  
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
	
	public void selectAll()
	{  
         String sql = "SELECT Username FROM Customer WHERE Username = 'Andy'";  
         
         try
         {  
             Connection conn = this.connect();  
             Statement stmt  = conn.createStatement();  
             ResultSet rs    = stmt.executeQuery(sql);  
              
             // loop through the result set  
             while (rs.next()) 
             {  
            	 currentUser = rs.getString("Username");
            	 System.out.println(currentUser);
            	 /*System.out.println(rs.getString("Username") +  "\t" +   
                                    rs.getString("Password") + "\t" +  
                                    rs.getString("FirstName") + "\t" +
                                    rs.getString("LastName"));*/
             }  
         } 
         catch (SQLException e) 
         {  
            System.out.println(e.getMessage());  
         }  
     }  
}
