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

public class Game {
	
	public static final int LIGHTING_LIMIT = 3;
	
	/**
	 * 
	 */
	private Character character;
	
	/**
	 * Representa el laberinto a crear
	 */
	private Maze maze;
	
	
	/**
	 * Crea un nuevo juego
	 */
	public Game() {
		
    }
	
	
	
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
		this.maze.fillMatriz();
	}

	/**
	 * 
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
	
	
	
	
	/**
	 * 
	 */
	public List<Integer> areaToLight(){
		List<Integer> area = new ArrayList<Integer>();
		
		Vertex vertex = character.getPosition();
		ArrayList<Edge<?>> edges = vertex.getEdges();
		
		for (int i = 0; i < edges.size(); i++) {
			//area.add(maze.getGraph().getIndexVertex((Path) edges.get(i).getDestination().getValue()));
		    //area.add(maze.getGraph().getIndexVertex((Path) edges.get(i).getDestination().getValue()));
		}
		return area;
	}
	
	/**
	 * 
	 */
	public List<Integer> iluminateLargerArea() {
		List<Integer> area = new ArrayList<Integer>();
		
		
		
		return null;
	}
}
