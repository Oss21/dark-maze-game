package model;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

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
	public void loadGame() {
		
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
