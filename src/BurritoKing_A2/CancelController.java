package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;

public class CancelController 
{
	Pages pages = new Pages();
	
	@FXML
	public TextField cancelOrderIDTF;
	
	@FXML
	public TableView<OrderClass> cancelOrderTable;
	
	public void showData()
	{
		TableColumn<OrderClass, String> OrderID = new TableColumn<>("Order ID");
		OrderID.setCellValueFactory(new PropertyValueFactory<>("OrderID"));
		
		cancelOrderTable.getColumns().add(OrderID);
		//cancelOrderTable.getItems().add(new OrderClass(1, 10));
	}
	
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
}
