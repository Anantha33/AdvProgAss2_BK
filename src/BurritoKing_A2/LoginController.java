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
	Main main = new Main();
	
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
		firstName = getFirstName();
		lastName = getLastName();
		
		if (selectUsername(usernameTF.getText()) && passwordTF.getText().equals(selectPassword(usernameTF.getText())))
		{	
			UserSingleton.getInstance().setCurrentUserDetails(firstName, lastName);
			//UserSingleton.getInstance().setCurrentLName(lastName);
			//main.openDashboardPage();
			FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
			Scene dashboardScene = new Scene(fxmlLoader.load());
			DashboardController dc = fxmlLoader.getController();
			dc.getCurrentUsername(usernameTF.getText());
			dc.displayFName();
			dc.displayLName();
			Stage dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
			dashboardStage.setTitle("Dashboard");
			dashboardStage.setScene(dashboardScene);
			dashboardStage.show();
			dc.setActiveOrder();
		}
		else
		{
			errorMessage.setText("Invalid username or password!");
		}
	}
	
	
	public void openWelcomePage(ActionEvent event) throws IOException
	 {
		main.openWelcomePage();
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
	
	
	public boolean selectUsername(String username)
	{
		String sql = "SELECT Username FROM Customer WHERE Username = ?";  
        
        try
        {  
            Connection conn = this.connect();
            PreparedStatement pstmt  = conn.prepareStatement(sql);
            pstmt.setString(1, username);
            ResultSet rs = pstmt.executeQuery();  
            
            if (rs.next())
            {
            	usernameExists = true;
            }
            else
            {
            	usernameExists = false;
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
