package Examples;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class add_other_window_example extends Application{
	
	Stage window;
	Button buttton;
	

	public static void main(String[] args) {
		launch(args);

	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		window = primaryStage;
		window.setTitle("Window 1");
		
		buttton = new Button("Open a window");
		buttton.setOnAction(e -> add_other_window_example_alertpox.display("hello du nibba", "i am very gay!"));
		
		
		StackPane layout = new StackPane();
		layout.getChildren().add(buttton);
		Parent root;
		Scene scene = new Scene(layout,600,300);
		window.setScene(scene);
		window.show();
		
	}
}


