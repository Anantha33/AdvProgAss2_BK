package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.*;
import javafx.fxml.*;

//This class handles the navigation to various other pages of the program, as well as displaying all orders waiting to be collected
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
	
	public void openCollectOrderPage(ActionEvent event) throws IOException
	{
		pages.collectOrderPage(event);
	}
	
	public void openCancelOrderPage(ActionEvent event) throws IOException
	{		
		pages.cancelOrderPage(event);
	}
	
	//Logging out
	public void openLoginPage(ActionEvent event) throws IOException
	{
		OrderDetailsSingleton.getInstance().setCurrentOrderDetails(0, 0, 0, 0, 
				CartController.getFriesRemainingAfterCurrentOrder(), 0, 0);
		
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


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		//Displaying the first and last name of the user
		userFullName.setText(currentFName + " " + currentLName);
		
		if (currentIsVIP)
		{
			upgradeUserButton.setDisable(true);
		}
		else
		{
			upgradeUserButton.setDisable(false);
		}
		
		//Setting the table to show all orders that are waiting to be collected
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
}
