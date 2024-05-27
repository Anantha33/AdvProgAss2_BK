package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class CancelController 
{
	Pages pages = new Pages();
	
	@FXML
	public TextField cancelOrderIDTF;
	
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
            alert.setContentText("Order already cancelled");
            alert.showAndWait();
		}
	}
}
