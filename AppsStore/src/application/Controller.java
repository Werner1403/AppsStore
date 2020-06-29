package application;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class Controller {

	private double xOffset = 0;
	private double yOffset = 0;
	
	public void close() {
		System.exit(0);
	}

	public void noClose(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AppsStore.fxml"));
		Scene scene = new Scene(root, 500, 400);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void openConfirmbox(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ConfirmBox_Close.fxml"));
		Scene scene = new Scene(root, 200, 150);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void startButton(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("StartButton.fxml"));
		
		Scene scene = new Scene(root, 700, 500);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();

		root.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
		root.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
            	window.setX(event.getScreenX() - xOffset);
            	window.setY(event.getScreenY() - yOffset);
            }
        });
		window.setScene(scene);
		window.show();
	}
}
