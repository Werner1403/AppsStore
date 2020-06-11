
package application;

import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
/**
 * @deprecated
 * @author werne
 *
 */
public class ConfirmBox {
	
	static boolean answer;
	private static double xOffset = 0;
	 private static double yOffset = 0;
	public static boolean display(String title,String message) {
		
		Stage window = new Stage();
		
		window.initModality(Modality.APPLICATION_MODAL);
		window.setTitle(title);
		window.setMinWidth(250);		
		Label label = new Label();
		label.setText(message);
		label.setId("label_confirm");
		
		//create 2 buttons
		Button yesButton= new Button("yes");
		yesButton.setId("button_Coonfirm");
		Button noButton = new Button("no");
		noButton.setId("button_Coonfirm");
		
		yesButton.setOnAction(e -> {
			answer = true;
			window.close();
		});
		
		noButton.setOnAction(e -> {
			answer = false;
			window.close();
		});
		
		
		VBox layout = new VBox(10);
		layout.getChildren().addAll(label,yesButton,noButton);
		layout.setAlignment(Pos.CENTER);
		layout.setId("scene_confirm");
		
		Scene scene = new Scene(layout,140,140);
		
		window.setScene(scene);
		scene.getStylesheets().add(Main_StartView.class.getResource("TheStyle.css").toExternalForm());
		window.setResizable(false);
		window.initStyle(StageStyle.UNDECORATED);
		layout.setOnMousePressed(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                xOffset = event.getSceneX();
                yOffset = event.getSceneY();
            }
        });
        layout.setOnMouseDragged(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                window.setX(event.getScreenX() - xOffset);
                window.setY(event.getScreenY() - yOffset);
            }
        });
		window.showAndWait();
		
		return answer;
		
	}
	
}
