package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

import org.ietf.jgss.Oid;

import dataStructure.Edge;
import dataStructure.Vertex;
import javafx.scene.media.VideoTrack;

/**
 * Represents the game.
 */
public class Game {
	
	/**
	 * Indicates the number of trails that the character can illuminate.
	 */
	public static final int LIGHTING_LIMIT = 3;
	
	/**
	 * It represents the maze to create.
	 */
	private Maze maze;
	
	
	/**
	 * Create a new game.
	 */
	public Game() {
		
    }
	
	/**
	 * Return the maze.
	 * @return maze - It's the maze.
	 */
	public Maze getMaze() {
		return maze;
	}
	
	/**
	 * Inicializa todo el proceso para comenzar la creacion de un nuevo laberinto
	 * @param isMatrix
	 * @throws IOException 
	 */
	public void genareteMaze(boolean isMatrix) throws IOException{
		this.maze = new Maze(isMatrix);
		this.maze.fillMatrix();
		
		if (isMatrix) {
			this.maze.createMatrixAdyacent();
		}else {
			this.maze.createListAdyacent();
		}
	}

	/**
	 * Load the game state.
	 */
	public void loadGame(){
		try {
			File file = new File("resourses/serialization/serialization.dat");
			if (file.exists()) {
				ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
				maze = (Maze) ois.readObject();
				ois.close();
			} else {
				file.createNewFile();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}catch (ClassNotFoundException e) {
				e.printStackTrace();
		}
	}
	
	
	/**
	 * Save the game state.
	 */
	public void saveGame() {
		File file = new File("resourses/serialization/serialization.dat");
		if (file.exists()) {
			file.delete();
		}
		try {
			ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
			oos.writeObject(maze);
			oos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
