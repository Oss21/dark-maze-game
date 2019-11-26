package controller;

import javafx.fxml.Initializable;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.Game;


public class MazeGameController implements Initializable {
	
	private Game game;
	private boolean loadGame;
	
    @FXML
    private Button btMatriz;

    @FXML
    private Button btLista;

    @FXML
    private Button btDarSolucion;

    @FXML
    private Button btIrAPuntoDeLuz;

    @FXML
    private Button btUsarLinterna;

    @FXML
    private Button btGuardarPartida;

    @FXML
    private Button btAtras;

    @FXML
    private Pane pnMaze;
	
	
    
    @Override
    public void initialize(URL location, ResourceBundle resources) {
		
    }
    
    
    
    public void setLoadGame(boolean loadGame) {
		this.loadGame = loadGame;
	}
    
    public void setGame(Game game) {
		this.game = game;
	}
    
    
    @FXML
    void backClicked(ActionEvent event) {

    }

    @FXML
    void giveSolutionClicked(ActionEvent event) {

    }

    @FXML
    void listClicked(ActionEvent event) {

    }

    @FXML
    void matrixClicked(ActionEvent event) {

    }

    @FXML
    void pointLightClicked(ActionEvent event) {

    }

    @FXML
    void saveGameClicked(ActionEvent event) {

    }

    @FXML
    void useFlashlightClicked(ActionEvent event) {

    }
    
    
}




