package controller;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import model.Game;


public class MazeGameController {
	
	private static final String PATH_IMAGE_URL = "/img/path.png";
	private static final String WALL_IMAGE_URL = "/img/wall.png";
	private static final String HOLE_IMAGE_URL = "/img/hole.png";
	private static final String LAKE_IMAGE_URL = "/img/lake.png";
	private static final String QUICKSAND_IMAGE_URL = "/img/quicksand.png";
	
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
    	
    }

    @FXML
    void giveSolutionClicked(ActionEvent event) {
    	
    }

    @FXML
    void listClicked(ActionEvent event) {
    	try {
			game.genareteMaze(false);
	    	createMaze();
			
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR, "Se ha borrado o alterado el documento donde se tienen los datos del programa", ButtonType.CLOSE);
			alert.setHeaderText("Se ha borrado o alterado los archivos del programa");
			alert.show();
		}
    }

    @FXML
    void matrixClicked(ActionEvent event) {
		try {
			game.genareteMaze(true);
			createMaze();
			
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR, "Se ha borrado o alterado el documento donde se tienen los datos del programa", ButtonType.CLOSE);
			alert.setHeaderText("Se ha borrado o alterado los archivos del programa");
			alert.show();
		}
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
    	grid.setGridLinesVisible(true);
    	
    	Image p = new Image(PATH_IMAGE_URL);
    	Image w = new Image(WALL_IMAGE_URL);
    	Image h = new Image(HOLE_IMAGE_URL);
    	Image l = new Image(LAKE_IMAGE_URL);
    	Image q = new Image(QUICKSAND_IMAGE_URL);
    	 
    	
    	for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				ImageView iView = new ImageView();
				iView.setFitWidth(30);
				iView.setPreserveRatio(true);

				
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
    	System.out.println("hola");
    	pnMaze.getChildren().add(grid);
    }
    
}




