package AppsStore.src.application;
	
import java.io.IOException;

import javax.lang.model.element.VariableElement;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.scene.Parent;
import javafx.scene.Scene;


public class The_Programm_Appstore extends Application {
	Stage window;
	@Override
	public void start(Stage primaryStage) throws IOException {
		window = new Stage();
		Parent root = FXMLLoader.load(getClass().getResource("The_Programm_Appstore.fxml"));
		window.setScene(new Scene(root));
		window.setTitle("Appstore");
		window.setFullScreen(true);
		window.setResizable(false);
		window.show();
		
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
