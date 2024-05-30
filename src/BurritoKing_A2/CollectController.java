package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

public class CollectController implements Initializable
{
	
	static Date date = new Date();
	static LocalDate localDate = date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
	
	static int day = localDate.getDayOfMonth();
	static String dayString = String.valueOf(day);
	
	static int month= localDate.getMonthValue();
	static String monthString = String.valueOf(month);
	
	static int year = localDate.getYear();
	static String yearString = String.valueOf(year);
	
	
	Pages pages = new Pages();
	
	@FXML
	public TextField collectOrderIDTF;
	
	@FXML
	public TextField collectOrderTimeTF;
	
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
	public TableView collectOrderTable;
	
	
	public void collectOrder(ActionEvent event) throws IOException
	{
		String currentOrderDate = Database.getOrderDate(collectOrderIDTF.getText());
		
		System.out.println(currentOrderDate);
		
		String currentOrderDay = currentOrderDate.substring(0,2);
		System.out.println(currentOrderDay);
		
		String currentOrderMonth = currentOrderDate.substring(3,5);
		System.out.println(currentOrderMonth);
		
		String currentOrderYear = currentOrderDate.substring(6,10);
		System.out.println(currentOrderYear);
		
		if (collectOrderTimeTF.getText().isBlank())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter a time!");
            alert.showAndWait();
		}
		else if (!PaymentController.isValidTime(collectOrderTimeTF.getText()))
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Time!");
            alert.showAndWait();
		}
		
		else
		{
			if (Database.collectOrder(collectOrderIDTF.getText(), collectOrderTimeTF.getText()))
			{
				Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
	            alert.setTitle("Success");
	            alert.setHeaderText(null);
	            alert.setContentText("Order collected successfully!");
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
	}
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		pages.dashboardPage(event);
	}
	
	public void collectOrderIDTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			collectOrderIDTF.backward();
			collectOrderIDTF.deleteNextChar();
		}
	}
	
	public void collectTimeTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9:]"))
		{
			event.consume();
			
			collectOrderTimeTF.backward();
			collectOrderTimeTF.deleteNextChar();
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
		collectOrderTable.setItems(orderslist);
	}
}
