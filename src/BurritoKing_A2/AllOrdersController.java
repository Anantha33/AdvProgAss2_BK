package BurritoKing_A2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

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
	
	@FXML
	public Button exportOrdersButton;
	
	//Opening the dashboard page
	public void openDashboardPage(ActionEvent event) throws IOException 
	{
		pages.dashboardPage(event);
	}
	
	public void exportAllOrders(ActionEvent event) 
	{
        FileChooser fileChooser = new FileChooser();
        fileChooser.setTitle("Save Orders");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));

        Stage stage = (Stage) exportOrdersButton.getScene().getWindow();
        File file = fileChooser.showSaveDialog(stage);

        if (file != null) 
        {
            saveOrdersToFile(file);
        }
    }

    private void saveOrdersToFile(File file) 
    {
        ObservableList<OrderClass> orders = Database.getAllOrders();

        try (FileWriter writer = new FileWriter(file)) 
        {
            // Write CSV header
            writer.write("Order ID,Total Cost,Order Status,Ordered Items\n");

            for (OrderClass order : orders) 
            {
                writer.write(order.getOrderID().get() + "," +
                             order.getOrderTotalCost().get() + "," +
                             order.getOrderStatus().get() + "," +
                             order.getOrderAllItems().get() + "\n");
            }
        } 
        catch (IOException e) 
        {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("An error occurred while saving the file.");
            alert.showAndWait();
        }
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