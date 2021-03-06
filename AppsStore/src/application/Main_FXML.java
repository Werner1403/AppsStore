package application;

import javafx.stage.Stage;
import javafx.stage.StageStyle;
import javafx.scene.Parent;
import javafx.scene.Scene;

import java.io.IOException;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;

public class Main_FXML extends Application {

	public static void main(String[] args) {

		launch(args);
	} 

	public void start(Stage primaryStage) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("AppsStore.fxml"));
		Scene scene = new Scene(root, 170, 140);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		primaryStage.setScene(scene);
		primaryStage.initStyle(StageStyle.TRANSPARENT);
		primaryStage.show();
	}

}
