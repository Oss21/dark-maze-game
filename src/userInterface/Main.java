package userInterface;
	
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;


public class Main extends Application {
	/**
	 *
	 */
	@Override
	public void start(Stage stage) {
		try {
			
			Parent root = FXMLLoader.load(getClass().getResource("StartWindowGUI.fxml"));
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.setTitle("Dark Maze Game");
			stage.getIcons().add(new Image("/img/logo.png"));
			stage.setResizable(true);
			stage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
