package AppsStore.src.application;




import java.io.FileNotFoundException;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Main_StartView extends Application{

	Stage window;
	
	
	public static void main(String[] args) {
	
		launch(args);
		
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception, FileNotFoundException {
		
		window = primaryStage;
		
		window.setTitle("JavaFX_PLayStore");
		
		
		Label label = new Label("JavaFX PlayStore");
		label.setFont(new Font("Ubuntu-Bold", 15));
		label.setId("label-startscreen");
		
		
		Label label2 = new Label("By: Werner|Lucas");
		label2.setId("label-startscreen");
		
		Button button_Start = new Button("Start");
		
		
		
		Button button_close = new Button("Close");
		button_close.setMinWidth(65);
		button_close.setOnAction(e ->{
			closeProgramm();
			
		});
		
		
		window.setOnCloseRequest(e ->{
			e.consume();
			closeProgramm();
			});
		
		GridPane gridPane = new GridPane();
		gridPane.setPadding(new Insets(10,10,10,10));
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		gridPane.getChildren().addAll(label,label2,button_close,button_Start);
		
		GridPane.setConstraints(label, 9, 0);
		GridPane.setConstraints(label2, 9, 1);
		GridPane.setConstraints(button_Start, 9, 10);
		GridPane.setHalignment(button_Start, HPos.CENTER);
		GridPane.setConstraints(button_close, 9, 11);
		GridPane.setHalignment(button_close, HPos.CENTER);
		
		
		
		Scene scene = new Scene(gridPane,400,270);
		scene.getStylesheets().add(Main_StartView.class.getResource("TheStyle.css").toExternalForm());
		window.setScene(scene);
		window.setResizable(false);
		
		
		window.show();		
	}
	
	private void closeProgramm() {
		Boolean answer = ConfirmBox.display("Close?", "You want to close?");
		if(answer) {
			window.close();
		}
		
		
	}
	

}
