package AppsStore.src.Examples;



import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class eventhandler_on_button_example extends Application{

	Button button;
	
	
	public static void main(String[] args) {
	
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		primaryStage.setTitle("hello_world");
		
		button = new Button();
		button.setText("Click Me");			
		button.setOnAction(e ->{ System.out.println("hey now im a kockstar");});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Parent root;
		Scene scene = new Scene(layout,300,500);
		primaryStage.setScene(scene);
		primaryStage.show();		
	}
	
	
	

}