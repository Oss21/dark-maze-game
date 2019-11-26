package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Game;


public class MazeGameController {
	
	private static final String PATH_IMAGE_URL = "";
	private static final String WALL_IMAGE_URL = "";
	private static final String HOLE_IMAGE_URL = "";
	private static final String LAKE_IMAGE_URL = "";
	private static final String QUICKSAND_IMAGE_URL = "";
	
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
    	String[][] matrix =  this.game.getMaze().getMatriz();
    	GridPane grid = new GridPane();
    	
    	Image p = new Image(PATH_IMAGE_URL);
    	Image w = new Image(WALL_IMAGE_URL);
    	Image h = new Image(HOLE_IMAGE_URL);
    	Image l = new Image(LAKE_IMAGE_URL);
    	Image q = new Image(QUICKSAND_IMAGE_URL);
    	 
    	
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[0].length; j++) {
				
				ImageView iView = new ImageView();
				
				switch (matrix[i][j]) {
				case "-":
					iView.setImage(p);
					break;
				case "p":
					iView.setImage(p);
					break;
				case "w":
					iView.setImage(w);
					break;
				case "h":
					iView.setImage(h);
					break;
				case "l":
					iView.setImage(l);
					break;
				case "q":
					iView.setImage(q);
					break;
				}
				grid.add(iView, j, i);
			}
		}
    	pnMaze.getChildren().add(grid);
    }
    
}




