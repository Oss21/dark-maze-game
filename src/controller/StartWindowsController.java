package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;
import model.Game;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

/**
 * Represents the driver of the start window
 */
public class StartWindowsController {

	/**
	 * Represent the new game button
	 */
	@FXML
	private Button btNewGame;

	/**
	 * Represent the load game button
	 */
	@FXML
	private Button btLoadGame;

	/**
	 * Represent the exit button
	 */
	@FXML
	private Button btExit;

	/**
	 * It is the initiator of the window.
	 */
	public void initialize() {

	}

	/**
	 * Control the action of clicking on the exit button.
	 */
	@FXML
	void leaveClicked(ActionEvent event) {
		System.exit(0);
	}

	/**
	 * Control the action of clicking on the load game button.
	 */
	@FXML
	void loadGameClicked(ActionEvent event) {
		Game game = new Game();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/MazeGameGUI.fxml"));
		Scene scene = null;
		Parent root = null;

		try {
			root = loader.load();
			scene = new Scene(root);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		try {
			game.loadGame();
			
			MazeGameController ven = loader.getController();
			ven.setGame(game);
			ven.setIsLoaded(true);
			ven.disableButtons();
			ven.createMaze();
			ven.detectKeys(scene);
			
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
			stage.show();
			
		}catch (ClassNotFoundException | NullPointerException |  IOException e) {
			Alert alert = new Alert(AlertType.ERROR, "No se encuestra su progreso en la partida", ButtonType.CLOSE);
			alert.setHeaderText("Se ha borrado o alterado el archivo donde se encontraba su progreso en la partida");
			alert.show();
		}
	}

	/**
	 * Control the action of clicking on the new game button.
	 */
	@FXML
	void newGameClicked(ActionEvent event) {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/MazeGameGUI.fxml"));
		Parent root = null;

		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		Game game = new Game();
		MazeGameController ven = loader.getController();
		ven.setGame(game);
		ven.setIsLoaded(false);

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
