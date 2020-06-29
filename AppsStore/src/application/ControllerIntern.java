package application;

import java.io.IOException;
import java.sql.SQLException;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class ControllerIntern {
	
	@FXML
	TextField search;

	@FXML
	ListView<String> show;
		
	@FXML
	Node details;
	
	@FXML
	Node showApps;
	
	private double xOffset = 0;
	private double yOffset = 0;

	public void close() {
		System.exit(0);
	}
	
	public void dragWindow(MouseEvent e) {
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
            window.setX(e.getScreenX() - xOffset);
            window.setY(e.getScreenY() - yOffset);
        
	}
	
	public void minimize(ActionEvent e)throws IOException {
		((Stage)((ToggleButton)e.getSource()).getScene().getWindow()).setIconified(true);
	}

	public void noCloseIntern(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("StartButton.fxml"));
		Scene scene = new Scene(root, 700, 500);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void openConfirmboxIntern(ActionEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("ConfirmBox_CloseIntern.fxml"));
		Scene scene = new Scene(root, 200, 150);
		scene.getStylesheets().add(getClass().getResource("TheStyle.css").toExternalForm());
		Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
		window.setScene(scene);
		window.show();
	}

	public void searchBar() throws ClassNotFoundException, SQLException {
		String s = search.getText();
		DBManager db = new DBManager();
		show.setItems(db.NameSearch(s));
	}
	
	public void showDetails(ActionEvent e) throws IOException, SQLException, ClassNotFoundException
	{
			DBManager db = new DBManager();
			Parent root = FXMLLoader.load(getClass().getResource("Details.fxml"));
			Scene scene = new Scene(root, 700, 500);
			Stage window = (Stage) ((Node) e.getSource()).getScene().getWindow();
			window.setScene(scene);
			window.show();
			String listname = (String) (show.getSelectionModel().getSelectedItem());
			Label name = (Label)scene.lookup("#name");
			name.setText(listname);
			String category =  db.categ(listname);
			Label categ = (Label)scene.lookup("#categ");
			categ.setText(category);
			String sizeS = db.size(listname);
			Label size = (Label)scene.lookup("#size");
			size.setText(sizeS);
			String rate = db.rating(listname);
			Label rating = (Label)scene.lookup("#rating");
			rating.setText(rate);
	}
	
	public void back(ActionEvent e) throws IOException
	{
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
	
	public void showCategorys(ActionEvent e) throws ClassNotFoundException, SQLException
	{
		DBManager db = new DBManager();
		show.setItems(db.Categorys());
		details.setVisible(false);
		showApps.setVisible(true);
	}
	
	public void showCatApps(ActionEvent e) throws ClassNotFoundException, SQLException
	{
		DBManager db = new DBManager();
		String categ = (String) (show.getSelectionModel().getSelectedItem());
		show.setItems(db.CatApps(categ));
		details.setVisible(true);
		showApps.setVisible(false);
	}
}










