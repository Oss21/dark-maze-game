package controller;

import java.io.IOException;


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;

import java.util.List;
import java.util.Optional;
import java.util.Stack;

import dataStructure.Vertex;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
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
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.GridPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import model.Character;
import model.Game;
import model.Maze;
import model.Path;

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
	 * 
	 */
	private static final String DARKNESS_IMAGE_URL = "/img/oscuro.jpg";
	
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
	 * 
	 */
	private Image darkness;
	
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
    	darkness = new Image(DARKNESS_IMAGE_URL);
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
    public void disableCreateButtons(boolean disable) {
    	this.btList.setDisable(disable);
    	this.btMatriz.setDisable(disable);
    }
    
    
    /**
     * 
     */
    public void disableFunctionButtons(boolean disable) {
    	this.btGiveSolution.setDisable(disable);
    	this.btGoToPointLight.setDisable(disable);
    	this.btUseFlashlight.setDisable(disable);
    	this.btSaveGame.setDisable(disable);
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
    	paintEntireMaze();
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
	    	paintMaze();
	    	paintDarkMaze();
	    	detectKeys(scene);
	    	
	    	btList.setDisable(true);
	    	btMatriz.setDisable(true);
	    	disableCreateButtons(false);
			
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
			paintMaze();
			detectKeys(scene);
			
			btMatriz.setDisable(true);
			btList.setDisable(true);
			disableFunctionButtons(false);
			
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
    	try {
			game.saveGame();
			btSaveGame.setDisable(true);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
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
    public void paintEntireMaze() {
    	
    	for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[i].length; j++) {
				
				switch (maze[i][j]) {
						
					case Maze.PATH_IDENTIFIER:
						paths[i][j].setImage(path);
						break;
						
					case Maze.WALL_IDENTIFIER:
						paths[i][j].setImage(wall);
						break;
						
					case Maze.HOLE_IDENTIFIER:
						paths[i][j].setImage(hole);
						break;
						
					case Maze.LAKE_IDENTIFIER:
						paths[i][j].setImage(lake);
						break;
						
					case Maze.QUICKSAND_IDENTIFIER:
						paths[i][j].setImage(quickSand);
						break;
						
					case Maze.POINTLIGHT_IDENTIFIER:
						paths[i][j].setImage(path);
						break;
						
					case Maze.WALL_MAZE_IDENTIFIER:
						paths[i][j].setImage(wallMaze);
						break;
						
					case Maze.ENTRY_IDENTIFIER:
						paths[i][j].setImage(path);
						break;
						
					case Maze.EXIT_IDENTIFIER:
						paths[i][j].setImage(path);
					}
			}
		}
    	printPlayerOnMaze();
    }
    
    
    /**
     * 
     */
    public void paintMaze() {
    	if (this.game.getMaze().getMatriz() == null || this.game.getMaze().getAux_Matrix() == null) {
			throw new NullPointerException();
			
		} else {
			
			this.maze =  this.game.getMaze().getMatriz();
	    	this.vertexID = this.game.getMaze().getAux_Matrix();
	    	this.paths = new ImageView[maze.length][maze[0].length];
	    	
	    	this.grid = new GridPane();
	    	grid.setBackground(new Background(new BackgroundFill(Color.BLACK, CornerRadii.EMPTY, Insets.EMPTY)));
	    	
	    	for (int i = 0; i < maze.length; i++) {
				for (int j = 0; j < maze[i].length; j++) {
					
					ImageView iView = new ImageView();
					iView.setFitWidth(50);
					iView.setPreserveRatio(true);
					
					if (!maze[i][j].equals(Maze.WALL_MAZE_IDENTIFIER)) {
						iView.setId(vertexID[i][j]);

					}else {
						iView.setId(Maze.WALL_MAZE_IDENTIFIER);
					}
					
					if (!isLoaded && maze[i][j].equals(Maze.ENTRY_IDENTIFIER)) {
						printPlayerOnMaze(i, j, iView);
					}
					
					grid.add(iView, j, i);
					this.paths[i][j] = iView;
				}
	    	}
	    	paintDarkMaze();
	    	if (isLoaded) {
				printPlayerOnMaze();
			}
	    	spMaze.setContent(grid);
			
		}
    }
    	
    
    
    /**
     * 
     */
    private void paintDarkMaze() {
    	
    	for (int i = 0; i < maze.length; i++) {
    		for (int j = 0; j < maze[0].length; j++) {
    			this.paths[i][j].setImage(darkness);
			}
    	}	
    }
    
    
    /**
     * 
     * @param i
     * @param j
     */
    private void printPath(int i, int j) {
    	
    	switch (maze[i][j]) {
				
			case Maze.PATH_IDENTIFIER:
				paths[i][j].setImage(path);
				break;
				
			case Maze.WALL_IDENTIFIER:
				paths[i][j].setImage(wall);
				break;
				
			case Maze.HOLE_IDENTIFIER:
				paths[i][j].setImage(hole);
				break;
				
			case Maze.LAKE_IDENTIFIER:
				paths[i][j].setImage(lake);
				break;
				
			case Maze.QUICKSAND_IDENTIFIER:
				paths[i][j].setImage(quickSand);
				break;
				
			case Maze.POINTLIGHT_IDENTIFIER:
				paths[i][j].setImage(path);
				break;
				
			case Maze.WALL_MAZE_IDENTIFIER:
				paths[i][j].setImage(wallMaze);
				break;
				
			case Maze.ENTRY_IDENTIFIER:
				paths[i][j].setImage(path);
				break;
				
			case Maze.EXIT_IDENTIFIER:
				paths[i][j].setImage(path);
				break;
		}
    }
    
    
   /**
    * 
    * @param i
    * @param j
    * @param imageView
    */
    private void printPlayerOnMaze(int i, int j, ImageView imageView) {
    	Character character = this.game.getMaze().getCharacter();

		imageView.setImage(sam);
		character.setPosition(this.game.getMaze().getGraph().searchVertex(this.game.getMaze().searchPath(vertexID[i][j])));
    }
    
    /**
     * 
     */
    private void printPlayerOnMaze() {
    	Character character = this.game.getMaze().getCharacter();

		Vertex<Path> v = character.getPosition();
		int[] c = getCoordenate(this.game.getMaze().getGraph().getIndexVertex(v.getValue()));
		paths[c[0]][c[1]].setImage(sam);
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
				default:
					break;
				}
			}
		});
    }
    
    
    /**
     * Method responsible for determining the coordinates of the vertex within the containers of the images
     * @param id - It is the number to be determined within the matrix of the images
     * @return - An array of two positions, y, which represents the row in the matrix and, j, which represents the row.
     */
    private int[] getCoordenate(int id) {
    	int[] coordenate = new int[2];
    	boolean stop = false;
    	
    	for (int i = 0; i < vertexID.length && !stop; i++) {
			for (int j = 0; j < vertexID[i].length && !stop; j++) {
				
				if (!vertexID[i][j].equals(Maze.WALL_MAZE_IDENTIFIER)) {
					
					if (Integer.parseInt(vertexID[i][j]) == id) {
						coordenate[0] = i;
						coordenate[1] = j;
						stop = true;
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
    	Character character = this.game.getMaze().getCharacter();
    	
    	Vertex<Path> vertex = character.getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[0] - 1) >= 0) {
    		if (!paths[c[0]-1][c[1]].getId().equals(Maze.WALL_MAZE_IDENTIFIER)) {
    			paintDarkMaze();
    			printAdjacentsPaths(c[0]+1, c[1]);
    			
        		paths[c[0]-1][c[1]].setImage(sam);
        		paths[c[0]-1][c[1]].setRotate(270);
        		character.setPosition(this.game.getMaze().getGraph().searchVertex(this.game.getMaze().searchPath(paths[c[0]-1][c[1]].getId())));
    		}
		}
    }
    
    
    /**
     * Method that is responsible for changing the position of the game character down.
     */
    private void changePositionDown() {
    	Character character = this.game.getMaze().getCharacter();
    	
    	Vertex<Path> vertex = character.getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[0] + 1) <= maze.length - 1) {
    		if (!paths[c[0]+1][c[1]].getId().equals(Maze.WALL_MAZE_IDENTIFIER)) {
    			paintDarkMaze();
    			printAdjacentsPaths(c[0]+1, c[1]);
    			
    			
    			paths[c[0]+1][c[1]].setImage(sam);
    			paths[c[0]+1][c[1]].setRotate(90);
    			this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(this.game.getMaze().searchPath(paths[c[0]+1][c[1]].getId())));
			}
		}
    }
    
    
    /**
     * Method that is responsible for changing the position of the game character to the right.
     */
    private void changePositionRight() {
    	Character character = this.game.getMaze().getCharacter();
    	
    	Vertex<Path> vertex = character.getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[1] + 1) <= maze[0].length - 1) {
    		if (!paths[c[0]][c[1]+1].getId().equals(Maze.WALL_MAZE_IDENTIFIER)) {
    			paintDarkMaze();
    			printAdjacentsPaths(c[0]+1, c[1]);
    			
    			paths[c[0]][c[1]+1].setImage(sam);
    			paths[c[0]][c[1]+1].setRotate(0);
    			this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(this.game.getMaze().searchPath(paths[c[0]][c[1]+1].getId())));
			}
		}
    }
    
    
    /**
     * Method that is responsible for changing the position of the game character to the left.
     */
    private void changePositionLeft() {
    	Character character = this.game.getMaze().getCharacter();
    	
    	Vertex<Path> vertex = character.getPosition();
    	int[] c = getCoordenate(game.getMaze().getGraph().getIndexVertex(vertex.getValue()));
    	
    	if ((c[1] - 1) >= 0) {
    		if (!paths[c[0]][c[1]-1].getId().equals(Maze.WALL_MAZE_IDENTIFIER)) {
    			paintDarkMaze();
    			printAdjacentsPaths(c[0]+1, c[1]);
    			
    			paths[c[0]][c[1]-1].setImage(sam);
    			paths[c[0]][c[1]-1].setRotate(180);
    			this.game.getMaze().getCharacter().setPosition(this.game.getMaze().getGraph().searchVertex(this.game.getMaze().searchPath(paths[c[0]][c[1]-1].getId())));
			}
		}
    }
    
    
    /**
     * 
     * @param i
     * @param j
     */
    private void printAdjacentsPaths(int i, int j) {
		Stack<String> adjacents = this.game.searchAdjacentsPaths(i, j);
    	
		int k = 0;
		while(k < adjacents.size()) {
			int[] c = getCoordenate(Integer.parseInt(adjacents.pop()));
			printPath(c[0], c[1]);
		}
    }
    
    
    /**
     * 
     */
    private void printAdjacentsWalls(int i, int j) {
    	
    }
    
}




