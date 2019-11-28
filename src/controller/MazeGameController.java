package controller;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.util.Optional;

import dataStructure.Vertex;
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
import model.Maze;

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
	
	/**
	 * It represents the condition of whether the game has been loaded from a previously played game, or is a new game
	 */
	public boolean isLoaded;
	
	/**
	 * Matrix containing the characters of the maze
	 */
	private String[][] maze;
	
	/**
	 * Matrix containing the identifiers of the vertices
	 */
	private String[][] vertexID;
	
	/**
	 * Matrix that contains the images that the screen maze represents
	 */
	private ImageView [][] paths;

	/**
	 * Image representing the path where the player can pass without any problem
	 */
	private Image path;
	
	/**
	 * Image representing the obstacle of a wall in the maze
	 */
	private Image wall;
	
	/**
	 * Image representing the obstacle of a hole in the maze
	 */
	private Image hole;
	
	/**
	 * Image representing the water obstacle in the maze
	 */
	private Image lake;
	
	/**
	 * Image representing the obstacle of quicksand in the maze
	 */
	private Image quickSand;
	
	/**
	 * Image representing the limiting walls of the maze
	 */
	private Image wallMaze;
	
	/**
	 * Image representing the playable character of the maze
	 */
	private Image sam;
	
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
    	path = new Image(PATH_IMAGE_URL);
    	wall = new Image(WALL_IMAGE_URL);
    	hole = new Image(HOLE_IMAGE_URL);
    	lake = new Image(LAKE_IMAGE_URL);
    	quickSand = new Image(QUICKSAND_IMAGE_URL);
    	wallMaze = new Image(WALL_MAZE_IMAGE_URL);
    	sam = new Image(SAM_IMAGE_URL);
    }
    
    
    
    /**
     * Change the game.
     * @param game - The new game
     */   
    public void setGame(Game game) {
		this.game = game;
	}
    
    
    /**
     * Method that changes the condition of whether the game has been loaded from a previously played game, or is a new game
     */
    public void setIsLoaded(boolean isLoaded) {
    	this.isLoaded = isLoaded;
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
    		Alert alert = new Alert(AlertType.CONFIRMATION, "Si no ha guardado su progreso en el juego, se borrará.", ButtonType.OK, ButtonType.CANCEL);
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

    
   /**
    * 
    * @param event
    */
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
     * Method that paints the screen maze
     */
    public void createMaze() {
    	this.maze =  this.game.getMaze().getMatriz();
    	this.vertexID = this.game.getMaze().getAux_Matrix();
    	this.paths = new ImageView[maze.length][maze[0].length];
    	
    	this.grid = new GridPane();
    	
    	for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				
				ImageView iView = new ImageView();
				iView.setFitWidth(50);
				iView.setPreserveRatio(true);
				
				if (!maze[i][j].equals("#")) {
					iView.setId(vertexID[i][j]);

				}else {
					iView.setId("#");
				}
				
				switch (maze[i][j]) {
				case "-":
					iView.setImage(path);
					this.paths[i][j] = iView;
					break;
					
				case Maze.PATH_IDENTIFIER:
					iView.setImage(path);
					this.paths[i][j] = iView;
					break;
					
				case Maze.WALL_IDENTIFIER:
					iView.setImage(wall);
					this.paths[i][j] = iView;
					break;
					
				case Maze.HOLE_IDENTIFIER:
					iView.setImage(hole);
					this.paths[i][j] = iView;
					break;
					
				case Maze.LAKE_IDENTIFIER:
					iView.setImage(lake);
					this.paths[i][j] = iView;
					break;
					
				case Maze.QUICKSAND_IDENTIFIER:
					iView.setImage(quickSand);
					this.paths[i][j] = iView;
					break;
					
				case Maze.WALL_MAZE_IDENTIFIER:
					iView.setImage(wallMaze);
					this.paths[i][j] = iView;
					break;
					
				case "en":
					iView.setImage(path);
					this.paths[i][j] = iView;
					printPlayerOnMaze(i,j, iView);
					break;
					
				case "ex":
					iView.setImage(path);
					this.paths[i][j] = iView;
				}
				this.grid.add(iView, j, i);
			}
			
		}
    	spMaze.setContent(grid);
    }
    
    
    /**
     * 
     */
    private void printPlayerOnMaze(int i, int j, ImageView imageView) {
    	if (isLoaded) {
    		System.out.println("Cargado");
			int[] c = getCoordenate(this.game.getMaze().getGraph().getIndexVertex(this.game.getMaze().getCharacter().getPosition().getValue()));
			paths[c[0]][c[1]].setImage(sam);
			
		}else {
			System.out.println("Nuevo");
			this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(Integer.parseInt(vertexID[i][j])));
			imageView.setImage(sam);
		}
    }
    
    
    /**
     * Method that is responsible for detecting and executing the events of buttons A, W, S, D
     */
    public void detectKeys(Scene scene) {
    	scene.setOnKeyPressed(new EventHandler<KeyEvent>() {
			@Override
			public void handle(KeyEvent event) {
				switch (event.getCode()) {
					case W:
						changePositionUp();
						break;
					case S:
						changePositionDown();
						break;
					case D:
						changePositionRight();
						break;
					case A:
						changePositionLeft();
						break;
				}
			}
		});
    }
    
    
    /**
     * Method responsible for determining the coordinates of the vertex within the containers of the images
     * @param number - It is the number to be determined within the matrix of the images
     * @return - An array of two positions, y, which represents the row in the matrix and, j, which represents the row.
     */
    private int[] getCoordenate(int number) {
    	int[] coordenate = new int[2];
    	boolean stop = false;
    	
    	for (int i = 0; i < paths.length && !stop; i++) {
			for (int j = 0; j < paths[i].length && !stop; j++) {
				
				if (!paths[i][j].getId().equals("#")) {
					int numero = (int) Integer.parseInt(paths[i][j].getId());
					if (numero == number) {
						coordenate[0] = i;
						coordenate[1] = j;
					}
				}
			}
		}
    	return coordenate;
    }
    
    
    /**
     * Method that is responsible for changing the position of the game character up.
     */
    private void changePositionUp() {
    	Vertex vertex = this.game.getMaze().getCharacter().getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[0] - 1) >= 0) {
    		if (!paths[c[0]-1][c[1]].getId().equals("#")) {
        		paths[c[0]-1][c[1]].setImage(sam);
        		paths[c[0]-1][c[1]].setRotate(270);
        		this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(Integer.parseInt(paths[c[0]-1][c[1]].getId())));
    		}
		}
    }
    
    
    /**
     * Method that is responsible for changing the position of the game character down.
     */
    private void changePositionDown() {
    	Vertex vertex = this.game.getMaze().getCharacter().getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[0] + 1) <= maze.length) {
    		if (!paths[c[0]+1][c[1]].getId().equals("#")) {
    			paths[c[0]+1][c[1]].setImage(sam);
    			paths[c[0]+1][c[1]].setRotate(90);
    			this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(Integer.parseInt(paths[c[0]+1][c[1]].getId())));
			}
		}
    }
    
    
    /**
     * Method that is responsible for changing the position of the game character to the right.
     */
    private void changePositionRight() {
    	Vertex vertex = this.game.getMaze().getCharacter().getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[1] + 1) <= maze[0].length) {
    		if (!paths[c[0]][c[1]+1].getId().equals("#")) {
    			paths[c[0]][c[1]+1].setImage(sam);
    			paths[c[0]][c[1]+1].setRotate(0);
    			this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(Integer.parseInt(paths[c[0]][c[1]+1].getId())));
			}
		}
    }
    
    
    /**
     * Method that is responsible for changing the position of the game character to the left.
     */
    private void changePositionLeft() {
    	Vertex vertex = this.game.getMaze().getCharacter().getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[1] - 1) >= 0) {
    		if (!paths[c[0]][c[1]-1].getId().equals("#")) {
    			paths[c[0]][c[1]-1].setImage(sam);
    			paths[c[0]][c[1]-1].setRotate(180);
    			this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(Integer.parseInt(paths[c[0]][c[1]-1].getId())));
			}
		}
    }
    
}




