package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import model.Game;


public class MazeGameController {
	
	private Game game;
	
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
    
    
    
    
    public void initialize() {
    	
    }
    
    
       
    public void setGame(Game game) {
		this.game = game;
	}
    
    public void disableButtons() {
    	this.btLista.setDisable(true);
    	this.btMatriz.setDisable(true);
    }
    
    @FXML
    void backClicked(ActionEvent event) {
    	System.out.println("Clicked");
    }

    @FXML
    void giveSolutionClicked(ActionEvent event) {
    	
    }

    @FXML
    void listClicked(ActionEvent event) {
    	game.genareteMaze(false);
    }

    @FXML
    void matrixClicked(ActionEvent event) {
		game.genareteMaze(true);
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
    
    
    
    private void createMaze() {
    	
    }
    
}




