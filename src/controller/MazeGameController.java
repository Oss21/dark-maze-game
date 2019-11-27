package controller;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.util.Optional;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import model.Game;

/**
 * Represents the controller of the game window.
 */
public class MazeGameController {
	
	/**
	 * It is the image path of path.
	 */
	private static final String PATH_IMAGE_URL = "/img/cesped.jpg";
	
	/**
	 * It is the image path of wall.
	 */
	private static final String WALL_IMAGE_URL = "/img/dique.jpg";
	
	/**
	 * It is the image path of hole.
	 */
	private static final String HOLE_IMAGE_URL = "/img/hole.png";
	
	/**
	 * It is the image path of lake.
	 */
	private static final String LAKE_IMAGE_URL = "/img/agua.jpg";
	
	/**
	 * It is the image path of quicksand.
	 */
	private static final String QUICKSAND_IMAGE_URL = "/img/arena.png";

	/**
	 * It is the image path of wall
	 */
	private static final String WALL_MAZE_IMAGE_URL = "/img/pared.jpg";
	
	/**
	 * It is the image path of Sam
	 */
	private static final String SAM_IMAGE_URL = "/img/Sam.gif";
	
	/**
	 * It is the matrix button
	 */
	private Game game;
	// BORRAR
	private String[][] maze;
	private String[][] vertexID;
	private ImageView [][] paths;
	
    /**
     * It is the matrix button
     */
    @FXML
    private Button btMatriz;

    /**
     * It is the list button
     */
    @FXML
    private Button btList;

     /**
     * It is the give solution button
     */
    @FXML
    private Button btGiveSolution;

    /**
     * It is go to point light button
     */
    @FXML
    private Button btGoToPointLight;

    /**
     * It is the use flashlight
     */
    @FXML
    private Button btUseFlashlight;

    /**
     * It is save game button
     */
    @FXML
    private Button btSaveGame;


    /**
     * It is the back button
     */
    @FXML
    private Button btBack;

    /**
     * It is the pane for print the maze.
     */
    @FXML
    private ScrollPane spMaze;
    
    /**
     * It is the relation with the game.
     */
    private GridPane grid;
    
    
    /**
     * It is the initiator of the window methods
     */
    public void initialize() {
    	
    }
    
    
    /**
     * Change the game.
     * @param game - The new game
     */   
    public void setGame(Game game) {
		this.game = game;
	}
    
    
    /**
     * Disable the create graph buttons
     */
    public void disableButtons() {
    	this.btList.setDisable(true);
    	this.btMatriz.setDisable(true);
    }
    
    /**
   	 * Control the action of clicking on the back button.
   	 */
    @FXML
	void backClicked(ActionEvent event) {

    	if(btSaveGame.isDisable()) {
    		
    		FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/StartWindowGUI.fxml"));
			Parent root = null;
			
			try {
				root = loader.load();
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(new Scene(root));
			stage.show();
    		
    	}else {
    		
    		Alert alert = new Alert(AlertType.CONFIRMATION, "Si no ha guardado su progreso en el juego, se borrará.",
					ButtonType.OK, ButtonType.CANCEL);
			alert.setHeaderText("¿Seguro desea salir sin guardar el juego");
	
			Optional<ButtonType> result = alert.showAndWait();

		
				
			if (result.get().equals(ButtonType.OK)) {
				
				FXMLLoader loader = new FXMLLoader(getClass().getResource("/userInterface/StartWindowGUI.fxml"));
				Parent root = null;
				
				try {
					root = loader.load();
				} catch (IOException e) {
					e.printStackTrace();
				}
			
				Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
				stage.setScene(new Scene(root));
				stage.show();
			}
    	}
	}

    /**
  	 * Control the action of clicking on the give solution button.
  	 */
    @FXML
    void giveSolutionClicked(ActionEvent event) {
    	
    }

   
    @FXML
    void listClicked(ActionEvent event) {
    	try {
    		Scene scene = (Scene) ((Node) event.getSource()).getScene().getWindow().getScene();
    		
			game.genareteMaze(false);
	    	createMaze();
	    	detectKeys(scene);
			
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR, "Se ha borrado o alterado el documento donde se tienen los datos del programa", ButtonType.CLOSE);
			alert.setHeaderText("Se ha borrado o alterado los archivos del programa");
			alert.show();
		}
    }

    /**
  	 * Control the action of clicking on the matrix button.
  	 */
    @FXML
    void matrixClicked(ActionEvent event) {
		try {
			Scene scene = (Scene) ((Node) event.getSource()).getScene().getWindow().getScene();
			
			game.genareteMaze(true);
			createMaze();
			detectKeys(scene);
			
		} catch (IOException e) {
			Alert alert = new Alert(AlertType.ERROR, "Se ha borrado o alterado el documento donde se tienen los datos del programa", ButtonType.CLOSE);
			alert.setHeaderText("Se ha borrado o alterado los archivos del programa");
			alert.show();
		}
    }

    /**
  	 * Control the action of clicking on the point light button.
  	 */
    @FXML
    void pointLightClicked(ActionEvent event) {
    	
    }

    /**
	 * Control the action of clicking on the save game button.
	 */
    @FXML
    void saveGameClicked(ActionEvent event) {
    	game.saveGame();
    	btSaveGame.setDisable(true);
    }

    /**
	 * Control the action of clicking on the use flashlight button.
	 */
    @FXML
    void useFlashlightClicked(ActionEvent event) {

    }
 
    /**
     * Create the maze
     */
    public void createMaze() {
    		//BORRAR
    	this.maze =  this.game.getMaze().getMatriz();
    	this.vertexID = this.game.getMaze().getAux_Matrix();
    	this.paths = new ImageView[maze.length][maze[0].length];
    	this.grid = new GridPane();
    	
    	Image p = new Image(PATH_IMAGE_URL);
    	Image w = new Image(WALL_IMAGE_URL);
    	Image h = new Image(HOLE_IMAGE_URL);
    	Image l = new Image(LAKE_IMAGE_URL);
    	Image q = new Image(QUICKSAND_IMAGE_URL);
    	Image w2 = new Image(WALL_MAZE_IMAGE_URL);
    	Image sam = new Image(SAM_IMAGE_URL);
    	
    	
    	for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				
				ImageView iView = new ImageView();
				iView.setFitWidth(50);
				iView.setPreserveRatio(true);
				
				if (!maze[i][j].equals("#")) {
					iView.setId(vertexID[i][j]);
					System.out.println(iView.getId());
				}else {
					iView.setId("W");
				}
				
				switch (maze[i][j]) {
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
				case "#":
					iView.setImage(w2);
					break;
				case "en":
					iView.setImage(sam);
					iView.setRotate(90);
					break;
				case "ex":
					iView.setImage(p);
				}
				this.paths[i][j] = iView;
				this.grid.add(iView, j, i);
			}
			
		}
    	spMaze.setContent(grid);
    }
    
    /**
     * Detects when keyboard keys are pressed.
     */
    private void detectKeys(Scene scene) {
		
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
					case UP:
						
						break;
					case DOWN:
						
						break;
					case RIGHT:
						
						break;
					case LEFT:
						
						break;
				}
			}
		});
    	
    	
    	scene.setOnKeyReleased(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				
			}
		});
    }
    
    /**
     * 
     * @param k
     */
    private void changePlayerPosition(KeyCode k) {
    	
    }
}




