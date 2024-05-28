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
import javafx.scene.input.KeyEvent;

public class CancelController implements Initializable
{
	Pages pages = new Pages();
	
	@FXML
	public TextField cancelOrderIDTF;
	
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
	public TableView cancelOrderTable;
	
	public void openAllOrdersPage(ActionEvent event) throws IOException
	{
		pages.allOrdersPage(event);
	}
	
	public void cancelOrder(ActionEvent event) throws IOException
	{
		if (Database.cancelOrder(cancelOrderIDTF.getText()))
		{
			Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Success");
            alert.setHeaderText(null);
            alert.setContentText("Order cancelled successfully!");
            alert.showAndWait();
            
            ObservableList<OrderClass> orderslist = Database.getAllAwaitingOrders();
    		populateTable(orderslist);
		}
		else		
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Order ID!");
            alert.showAndWait();
		}
	}
	
	public void orderIDTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			cancelOrderIDTF.backward();
			cancelOrderIDTF.deleteNextChar();
		}
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		colOrderID.setCellValueFactory(cellData -> cellData.getValue().getOrderID().asObject());
		colOrderDate.setCellValueFactory(cellData -> cellData.getValue().getOrderDate());
		colOrderTime.setCellValueFactory(cellData -> cellData.getValue().getOrderTime());
		colOrderTotalCost.setCellValueFactory(cellData -> cellData.getValue().getOrderTotalCost().asObject());
		colOrderStatus.setCellValueFactory(cellData -> cellData.getValue().getOrderStatus());
		
		ObservableList<OrderClass> orderslist = Database.getAllAwaitingOrders();
		populateTable(orderslist);
	}
	
	private void populateTable(ObservableList<OrderClass> orderslist) 
	{
		cancelOrderTable.setItems(orderslist);
	}
}
