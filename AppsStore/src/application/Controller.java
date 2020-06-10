package application;

import java.io.IOException;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.stage.Stage;

public class Controller {
	
	ChoiceBox<String> choicebox;
	
	public void close()
	{
		System.exit(0);
	}
	
	public void noCloseIntern(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("StartButton.fxml"));
		Scene scene = new Scene(root,700,500);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	public void noClose(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("AppsStore.fxml"));
		Scene scene = new Scene(root,500,400);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void openConfirmbox(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("ConfirmBox_Close.fxml"));
		Scene scene = new Scene(root,200,150);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void openConfirmboxIntern(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("ConfirmBoxIntern.fxml"));
		Scene scene = new Scene(root,300,300);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void startButton(ActionEvent e) throws IOException
	{
		Parent root = FXMLLoader.load(getClass().getResource("StartButton.fxml"));
		Scene scene = new Scene(root,700,500);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node)e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}
	
	public void categoryWindow(ActionEvent e)
	{
		@SuppressWarnings("unchecked")
		ChoiceBox<String> cb = new ChoiceBox(FXCollections.observableArrayList(
			    "First", "Second", "Third")
			);
	}
	
}
	













