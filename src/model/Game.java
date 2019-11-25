package model;

public class Game {

	/**
	 * Representa el laberinto a crear
	 */
	private Maze maze;
	
	
	/**
	 * Crea un nuevo juego
	 */
	public Game() {
		
    }
	
	
	/**
	 * Inicializa todo el proceso para comenzar la creacion de un nuevo laberinto
	 * @param isMatrix
	 */
	public void genareteMaze(boolean isMatrix){
		this.maze = new Maze(isMatrix);
	}



}
