package controller;

import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.stage.Stage;
import model.Game;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class StartWindowsController implements Initializable {
	
	
	/**
	 * 
	 */
	@FXML
    private Button btNuevaPartida;
	
	/**
	 * 
	 */
    @FXML
    private Button btCargarPartida;
    
    /**
     * 
     */
    @FXML
    private Button btSalir;
	
	
    
	/**
	 * 
	 */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
    	
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
		ven.setLoadGame(true);
		
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
		ven.setLoadGame(false);
		
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setScene(new Scene(root));
		stage.show();
    }
}
