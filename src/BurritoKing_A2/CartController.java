package BurritoKing_A2;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.stage.Stage;

public class CartController implements Initializable
{
	@FXML
	public Spinner<Integer> burritoSpinner;
	SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE);
	
	public void openDashboardPage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/Dashboard.fxml"));
		Scene dashboardScene = new Scene(loader.load());
		DashboardController dc = loader.getController();
		dc.displayFullName();
		Stage dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setTitle("Dashboard");
		dashboardStage.setScene(dashboardScene);
		dashboardStage.show();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) 
	{
		SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, Integer.MAX_VALUE);
		valueFactory.setValue(0);
		
		burritoSpinner.setValueFactory(valueFactory);
	}
}
