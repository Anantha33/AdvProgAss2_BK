package BurritoKing_A2;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

public class EditProfileController 
{
	
	@FXML
	public TextField newFirstNameTF;
	public TextField newLastNameTF;
	public PasswordField newPasswordTF;
	public PasswordField cNewPasswordTF;
	
	public void updateFirstName(ActionEvent event) throws IOException
	{
		if (newFirstNameTF.getText() != null)
		{
			Database.updateFirstName(newFirstNameTF.getText(), UserSingleton.getInstance().getCurrentUsername());
			UserSingleton.getInstance().setCurrentUserDetails(UserSingleton.getInstance().getCurrentUsername(), 
					newFirstNameTF.getText(), UserSingleton.getInstance().getCurrentLName(), 
					UserSingleton.getInstance().getCurrentVIPStatus());
			showAlert("Success", "First name updated successfully!");
		}
		else
		{
			showAlert("Error", "New first name cannot be null");
		}
	}
	
	
	public void updateLastName(ActionEvent event) throws IOException
	{
		if (newLastNameTF.getText() != null)
		{
			Database.updateLastName(newLastNameTF.getText(), UserSingleton.getInstance().getCurrentUsername());
			UserSingleton.getInstance().setCurrentUserDetails(UserSingleton.getInstance().getCurrentUsername(), 
					UserSingleton.getInstance().getCurrentFName(), newLastNameTF.getText(), 
					UserSingleton.getInstance().getCurrentVIPStatus());
			showAlert("Success", "Last name updated successfully!");
		}
		else
		{
			showAlert("Error", "New last name cannot be null");
		}
	}
	
	
	public void updatePassword(ActionEvent event) throws IOException
	{
		if (newPasswordTF.getText().isBlank() || cNewPasswordTF.getText().isBlank())
		{
			showAlert("Error", "Fields cannot be empty!");
			/*Database.updateLastName(newLastNameTF.getText(), UserSingleton.getInstance().getCurrentUsername());
			UserSingleton.getInstance().setCurrentUserDetails(UserSingleton.getInstance().getCurrentUsername(), UserSingleton.getInstance().getCurrentFName(), newLastNameTF.getText());
			showAlert("Success", "Last name updated successfully!");*/
		}
		
		else if (!cNewPasswordTF.getText().equals(newPasswordTF.getText()))
		{
			showAlert("Error", "Passwords do not match!");
		}
		
		else
		{
			Database.updatePassword(newPasswordTF.getText(), UserSingleton.getInstance().getCurrentUsername());
			showAlert("Success", "Password updated successfully!");
		}
	}
	
	
	public void openProfilePage(ActionEvent event) throws IOException
	{
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/ProfilePage.fxml"));
		Parent root = loader.load();
		Scene profileScene = new Scene(root);
		ProfileController pc = loader.getController();
		pc.displayCurrentUsername();
		pc.displayCurrentFName();
		pc.displayCurrentLName();
		Stage profileStage = (Stage)((Node)event.getSource()).getScene().getWindow();
		profileStage.setTitle("Profile Page");
		profileStage.setScene(profileScene);
		profileStage.show();
	}
	
	private void showAlert(String title, String message) 
	{
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        alert.setTitle(title);
        alert.setHeaderText(null);
        alert.setContentText(message);
        alert.showAndWait();
    }
}
