package controller;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;
import model.Game;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StartWindowsController {

	/**
	 * 
	 */
	@FXML
	private Button btNewGame;

	/**
	 * 
	 */
	@FXML
	private Button btLoadGame;

	/**
	 * 
	 */
	@FXML
	private Button btExit;

	/**
	 * 
	 */
	public void initialize() {

	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	void leaveClicked(ActionEvent event) {
		System.exit(0);
	}

	/**
	 * 
	 * @param event
	 */
	@FXML
	void loadGameClicked(ActionEvent event) {

		Game game = new Game();

		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/MazeGameGUI.fxml"));
		Parent root = null;

		try {
			root = loader.load();
		} catch (IOException e) {
			e.printStackTrace();
		}

		game.loadGame();

		MazeGameController ven = loader.getController();
		ven.setGame(game);
		ven.disableButtons();
		ven.createMaze();
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}

	/**
	 * 
	 * @param event
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

		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
	}
}
