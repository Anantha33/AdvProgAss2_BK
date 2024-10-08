package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
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

//This class implements the functionality of collecting an order.
//It initializes the collect order page with a table consisting of orders to be collected.
//It checks the date and time of the order and the collection date and time; based on that, it displays an error message
//or a success message to the user.
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
	
	String orderDay;
	String orderMonth;
	String orderYear;
	
	String orderReadyTimeHH;
	String orderReadyTimemm;
	
	String collectTimeHH;
	String collectTimemm;
	
	
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
		if (collectOrderIDTF.getText().isBlank())
		{
			Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Please enter an order ID!");
            alert.showAndWait();
		}
		
		else if (collectOrderTimeTF.getText().isBlank())
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
			String currentOrderDate = Database.getOrderDate(collectOrderIDTF.getText());
			
			Matcher datePattern = Pattern.compile("([^/]+)/([^/]+)/([^/]+)").matcher(currentOrderDate);
			
			//Dividing the order date into day, month and year
			if (datePattern.matches())
			{
				orderDay = datePattern.group(1);
				orderMonth = datePattern.group(2);
				orderYear = datePattern.group(3);
			}
			
			if (orderDay.equals(dayString) && orderMonth.equals(monthString) && orderYear.equals(yearString))
			{
				String orderReadyTime = Database.getOrderReadyTime(collectOrderIDTF.getText());
				
				Matcher readyTimePattern = Pattern.compile("([^:]+):([^:]+)").matcher(orderReadyTime);
				
				//Dividing the ready time into hours and minutes
				if (readyTimePattern.matches())
				{
					orderReadyTimeHH = readyTimePattern.group(1);
					orderReadyTimemm = readyTimePattern.group(2);
				}
				
				double orderReadyTimeInMinutes = (Double.parseDouble(orderReadyTimeHH)*60) + (Double.parseDouble(orderReadyTimemm));
				
				
				Matcher collectTimePattern = Pattern.compile("([^:]+):([^:]+)").matcher(collectOrderTimeTF.getText());
				
				//Dividing the pickup time into hours and minutes
				if (collectTimePattern.matches())
				{
					collectTimeHH = collectTimePattern.group(1);
					collectTimemm = collectTimePattern.group(2);
				}
				
				double collectTimeInMinutes = (Double.parseDouble(collectTimeHH)*60) + (Double.parseDouble(collectTimemm));
				
				//Checking if the pickup time is greater than or equal to the time the order gets ready
				if (collectTimeInMinutes < orderReadyTimeInMinutes)
				{
					Alert alert = new Alert(Alert.AlertType.ERROR);
		            alert.setTitle("Error");
		            alert.setHeaderText(null);
		            alert.setContentText("Order is not ready yet!");
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
			    		
			    		collectOrderIDTF.clear();
			    		collectOrderTimeTF.clear();
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
		    		
		    		collectOrderIDTF.clear();
		    		collectOrderTimeTF.clear();
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
	}
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		pages.dashboardPage(event);
	}
	
	//Regex implementation to handle invalid inputs
	public void collectOrderIDTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9]"))
		{
			event.consume();
			
			collectOrderIDTF.backward();
			collectOrderIDTF.deleteNextChar();
		}
	}
	
	//Regex implementation to handle invalid inputs
	public void collectTimeTyped(KeyEvent event) throws IOException
	{
		if (event.getCharacter().matches("[^0-9:]"))
		{
			event.consume();
			
			collectOrderTimeTF.backward();
			collectOrderTimeTF.deleteNextChar();
		}
	}

	//Setting the table to show all orders that are waiting to be collected
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
