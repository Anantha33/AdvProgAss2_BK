package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

//This class shows the user all of their orders, irrespective of the order status
public class AllOrdersController implements Initializable
{
	Pages pages = new Pages();
	
	@FXML
	public TableColumn<OrderClass, Integer> colOrderID;
	
	@FXML
	public TableColumn<OrderClass, Double> colOrderTotalCost;
	
	@FXML
	public TableColumn<OrderClass, String> colOrderDate;
	
	@FXML
	public TableColumn<OrderClass, String> colOrderTime;
	
	@FXML
	public TableColumn<OrderClass, String> colOrderStatus;
	
	
	@FXML
	public TableView allOrdersTable;
	
	//Opening the dashboard page
	public void openDashboardPage(ActionEvent event) throws IOException 
	{
		pages.dashboardPage(event);
	}
	
	//Initializing the table to show all orders
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		colOrderID.setCellValueFactory(cellData -> cellData.getValue().getOrderID().asObject());
		colOrderDate.setCellValueFactory(cellData -> cellData.getValue().getOrderDate());
		colOrderTime.setCellValueFactory(cellData -> cellData.getValue().getOrderTime());
		colOrderTotalCost.setCellValueFactory(cellData -> cellData.getValue().getOrderTotalCost().asObject());
		colOrderStatus.setCellValueFactory(cellData -> cellData.getValue().getOrderStatus());
		
		ObservableList<OrderClass> orderslist = Database.getAllOrders();
		populateTable(orderslist);
	}

	private void populateTable(ObservableList<OrderClass> orderslist) 
	{
		//Populating the table with the values of the observable list
		allOrdersTable.setItems(orderslist); 
	}
}