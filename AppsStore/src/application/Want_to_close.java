package application;



import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Want_to_close extends Application{

	Button button;
	Stage window;
	
	
	public static void main(String[] args) {
	
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		
		window = primaryStage;
		
		window.setOnCloseRequest(e ->{
			e.consume();
			closeProgramm();
			});
		
		button = new Button();
		button.setText("close");			
		button.setOnAction(e ->{closeProgramm();});
		
		StackPane layout = new StackPane();
		layout.getChildren().add(button);
		
		Parent root;
		Scene scene = new Scene(layout,300,500);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}
	
	private void closeProgramm() {
		Boolean answer = ConfirmBox.display("Close?", "You want to close?");
		if(answer) {
			window.close();
		}
		
		
	}
	

}
