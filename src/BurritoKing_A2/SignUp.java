package BurritoKing_A2;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SignUp 
{
	public void signUpPage()
	{
		try
		{
			Stage secondaryStage = new Stage();
			secondaryStage.setTitle("SignUp Page");
			
			Pane second = new Pane();
			Label username = new Label("Username: ");
			Label password = new Label("Password: ");
			Button test = new Button("Test");
			
			/*test.setOnAction(new EventHandler<ActionEvent>() 
			{
			    @Override
			    public void handle(ActionEvent event) 
			    {
			    	end();
			        System.out.println("Button clicked");
			        secondaryStage.close();
			    }
			});*/
			
			
			second.getChildren().add(username);
			second.getChildren().add(password);
			second.getChildren().add(test);
			
			Scene secondscene = new Scene(second, 400, 400);
			secondaryStage.setScene(secondscene);
			secondaryStage.show();
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}
}
