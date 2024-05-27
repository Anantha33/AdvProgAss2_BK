package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;

public class AllOrdersController 
{
	Pages pages = new Pages();
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		pages.dashboardPage(event);
	}
	
	public void openCancelOrderPage(ActionEvent event) throws IOException
	{		
		pages.cancelOrderPage(event);
	}
}
