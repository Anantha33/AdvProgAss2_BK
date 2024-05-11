package BurritoKing_A2;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;
import javafx.fxml.*;

public class DashboardController 
{
	private Stage dashboardStage;
	private Scene dashboardScene;
	private Parent root;
	@FXML
	public Label userFName;
	
	@FXML
	public Label userLName;
	
	public void showDashboardPage(ActionEvent event) throws IOException
	{
		root = FXMLLoader.load(getClass().getResource("/Dashboard.fxml"));
		dashboardStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		dashboardStage.setTitle("Dashboard");
		dashboardScene = new Scene(root);
		dashboardStage.setScene(dashboardScene);
		dashboardStage.show();
		//userFName.setText("Andy");
		//System.out.println(userFName);
	}
	
	public void setUserFName(ActionEvent event) throws IOException
	{
		System.out.println(userFName.getText());
		//userFName.setText("Andy");
	}
	
	public void getUserFName()
	{
		System.out.println(userFName.getText());
	}
}
