package userInterface;
	
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.fxml.FXMLLoader;

/**
 * It is the class that launches the game.
 */
public class Main extends Application {
	
	/**
	 * Initialize the game.
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
	
	/**
	 * Launch the game
	 * @param args - arguments of app for init
	 */
	public static void main(String[] args) {
		launch(args);
	}
}
