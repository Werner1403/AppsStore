package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Controller {

	public void close()
	{
		System.exit(0);
	}
	
	public void noClose(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("AppsStore.fxml"));
		Scene scene = new Scene(root,500,400);
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void openConfirmbox(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("ConfirmBox_Close.fxml"));
		Scene scene = new Scene(root,200,150);
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void startButton(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("StartButton.fxml"));
		Scene scene = new Scene(root,200,150);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
}
