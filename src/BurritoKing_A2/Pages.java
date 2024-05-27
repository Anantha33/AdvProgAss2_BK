package BurritoKing_A2;

import java.io.IOException;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.event.ActionEvent;

public class Pages 
{		
	public void welcomePage(ActionEvent event) throws IOException
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
	
	public void loginPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/LoginPage.fxml"));
		Parent root = loader.load();
		Scene loginScene = new Scene(root);
		LoginController lc = loader.getController();
		Stage loginStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		loginStage.setScene(loginScene);
		loginStage.setTitle("Login Page");
		loginStage.show();
	}
	
	public void signUpPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/SignUpPage.fxml"));
		Parent root = loader.load();
		Scene signUpScene = new Scene(root);
		SignUpController sc = loader.getController();
		Stage signUpStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		signUpStage.setScene(signUpScene);
		signUpStage.setTitle("Sign Up Page");
		signUpStage.show();
	}
	
	public void dashboardPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
		Scene dashboardScene = new Scene(loader.load());
		DashboardController dc = loader.getController();
		dc.displayFullName();
		Stage dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setTitle("Dashboard");
		dashboardStage.setScene(dashboardScene);
		dashboardStage.show();
	}
	
	public void profilePage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProfilePage.fxml"));
		Parent root = loader.load();
		Scene profileScene = new Scene(root);
		ProfileController pc = loader.getController();
		pc.displayCurrentUsername();
		pc.displayCurrentFName();
		pc.displayCurrentLName();
		Stage profileStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		profileStage.setTitle("Profile Page");
		profileStage.setScene(profileScene);
		profileStage.show();
	}
	
	public void cartPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Cart.fxml"));
		Parent root = loader.load();
		Scene cartScene = new Scene(root);
		Stage cartStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		cartStage.setTitle("Cart");
		cartStage.setScene(cartScene);
		cartStage.show();
	}
	
	public void orderDetailsPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/OrderDetailsPage.fxml"));
		Parent root = loader.load();
		Scene orderDetailsScene = new Scene(root);
		Stage orderDetailsStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		orderDetailsStage.setTitle("Order Details");
		orderDetailsStage.setScene(orderDetailsScene);
		orderDetailsStage.show();
	}
	
	public void allOrdersPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/AllOrders.fxml"));
		Parent root = loader.load();
		Scene allOrderScene = new Scene(root);
		Stage allOrderStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		allOrderStage.setScene(allOrderScene);
		allOrderStage.setTitle("All Orders");
		allOrderStage.show();
	}
	
	public void upgradeProfilePage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/UpgradeProfilePage.fxml"));
		Parent root = loader.load();
		Scene upgradeProfileScene = new Scene(root);
		Stage upgradeProfileStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		upgradeProfileStage.setScene(upgradeProfileScene);
		upgradeProfileStage.setTitle("Upgrade Profile Page");
		upgradeProfileStage.show();
	}
	
	public void editFNamePage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditFNamePage.fxml"));
		Scene editFNameScene = new Scene(loader.load());
		Stage editFNameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		editFNameStage.setTitle("Edit First Name");
		editFNameStage.setScene(editFNameScene);
		editFNameStage.show();
	}
	
	public void editLNamePage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditLNamePage.fxml"));
		Scene editLNameScene = new Scene(loader.load());
		Stage editLNameStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		editLNameStage.setTitle("Edit Last Name");
		editLNameStage.setScene(editLNameScene);
		editLNameStage.show();
	}
	
	public void editPasswordPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/EditPasswordPage.fxml"));
		Scene editPasswordScene = new Scene(loader.load());
		Stage editPasswordStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		editPasswordStage.setTitle("Edit Last Name");
		editPasswordStage.setScene(editPasswordScene);
		editPasswordStage.show();
	}
	
	public void paymentPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/PaymentPage.fxml"));
		Scene paymentScene = new Scene(loader.load());
		Stage paymentStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		paymentStage.setTitle("Payment Page");
		paymentStage.setScene(paymentScene);
		paymentStage.show();
	}
	
	public void cancelOrderPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/CancelOrderPage.fxml"));
		Scene cancelOrderScene = new Scene(loader.load());
		Stage cancelOrderStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		cancelOrderStage.setTitle("Payment Page");
		cancelOrderStage.setScene(cancelOrderScene);
		cancelOrderStage.show();
	}
}
