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
import java.sql.PreparedStatement;
import java.sql.Connection;  
import java.sql.ResultSet;  
import java.sql.SQLException; 

public class LoginController 
{	
	public Scene profilePageScene;
	public Stage profilePageStage;
	//private Parent root;
	
	private boolean usernameExists = false;
	private String passwordExists;
	private String firstName = "";
	private String lastName = "";
	
	@FXML
	public TextField usernameTF;
	public PasswordField passwordTF;
	public Label errorMessage;
	
	Pages pages = new Pages();
	
	public void openDashboard(ActionEvent event) throws IOException
	{	
		if (Database.authenticateUser(usernameTF.getText(), passwordTF.getText()))
		{	
			firstName = getFirstName();
			lastName = getLastName();
			UserSingleton.getInstance().setCurrentUserDetails(usernameTF.getText(), firstName, lastName);
			FXMLLoader loader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
			Scene dashboardScene = new Scene(loader.load());
			DashboardController dc = loader.getController();
			dc.displayFullName();
			Stage dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			dashboardStage.setTitle("Dashboard");
			dashboardStage.setScene(dashboardScene);
			dashboardStage.show();
		}
		else
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Login Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid username or password");
            alert.showAndWait();
		}
	}
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/WelcomePage.fxml"));
		Parent root = loader.load();
		Scene welcomeScene = new Scene(root);
		WelcomeController wc = loader.getController();
		Stage welcomeStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		welcomeStage.setScene(welcomeScene);
		welcomeStage.setTitle("Welcome Page");
		welcomeStage.show();
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
	
	
	 public String getFirstName()
	 {
		 String sql = "SELECT FirstName FROM Customer WHERE Username = ?" ;  
         
         try
         {  
             Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             pstmt.setString(1, usernameTF.getText());
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
	 
	 
	 public String getLastName()
	 {
		 String sql = "SELECT LastName FROM Customer WHERE Username = ?" ;  
         
         try
         {  
             Connection conn = this.connect();
             PreparedStatement pstmt  = conn.prepareStatement(sql);
             pstmt.setString(1, usernameTF.getText());
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
}
