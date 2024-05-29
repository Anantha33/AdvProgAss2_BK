package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.*;

public class DashboardController implements Initializable
{	
	Pages pages = new Pages();
	
	String currentFName = UserSingleton.getInstance().getCurrentFName();
	String currentLName = UserSingleton.getInstance().getCurrentLName();
	boolean currentIsVIP = UserSingleton.getInstance().getCurrentVIPStatus();
	
	@FXML
	public Label userFullName;
	public Button upgradeUserButton;
	
	@FXML
	public TableColumn<OrderClass, Integer> colOrderID;
	
	@FXML
	public TableColumn<OrderClass, Double> colOrderTotalCost;
	
	@FXML
	public TableColumn<OrderClass, String> colOrderStatus;
	
	@FXML
	public TableColumn<OrderClass, String> colOrderedItems;
	
	@FXML
	public TableView awaitingOrdersTable;
	
	
	public void openCart(ActionEvent event) throws IOException
	{
		pages.cartPage(event);
	}
	

	public void openProfilePage(ActionEvent event) throws IOException
	{
		pages.profilePage(event);
	}
	
	
	public void viewAllOrders(ActionEvent event) throws IOException
	{
		pages.allOrdersPage(event);
	}
	
	
	public void openLoginPage(ActionEvent event) throws IOException
	{
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Logout Successful");
        alert.setHeaderText(null);
        alert.setContentText("Successfully logged out!");
        alert.showAndWait();
        
		pages.loginPage(event);
	}
	
	
	public void openUpgradeProfile(ActionEvent event) throws IOException
	{
		pages.upgradeProfilePage(event);
	}
	
	public void displayCurrentTime()
	{
		System.out.println(currentDateTime);
	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		userFullName.setText(currentFName + " " + currentLName);
		
		if (currentIsVIP)
		{
			upgradeUserButton.setDisable(true);
		}
		else
		{
			upgradeUserButton.setDisable(false);
		}
		
		
		colOrderID.setCellValueFactory(cellData -> cellData.getValue().getOrderID().asObject());
		colOrderedItems.setCellValueFactory(cellData -> cellData.getValue().getOrderAllItems());
		colOrderTotalCost.setCellValueFactory(cellData -> cellData.getValue().getOrderTotalCost().asObject());
		colOrderStatus.setCellValueFactory(cellData -> cellData.getValue().getOrderStatus());
		
		ObservableList<OrderClass> orderslist = Database.getAllAwaitingOrders();
		populateTable(orderslist);
	}
	
	private void populateTable(ObservableList<OrderClass> orderslist) 
	{
		awaitingOrdersTable.setItems(orderslist);
	}
	
	long currentTimeInMillis = System.currentTimeMillis();

	Date currentDate = new Date(currentTimeInMillis);

	String currentDateTime = currentDate.toString();
}
