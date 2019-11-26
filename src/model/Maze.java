package model;

import customInterface.IGraph;
import dataStructure.GraphByLists;
import dataStructure.GraphByMatrix;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;

/**
 *
 */
public class Maze implements Serializable{

	public static String PATH_LABERINTO_1="data/laberinto_1.csv"; 
	
	/**
	 * Representa el laberinto
	 */
	public String [][] matriz;
	
	/**
	 * Representa el grafo cuando se utiliza lista de adyacencia
	 */
	private GraphByLists<Path, Integer> graphByLists;
	
	/**
	 * Representa al grafo cuando se utiliza con matrix de adyacencia
	 */
	private GraphByMatrix<Path, Integer> graphByMatrix;

	/**
	 * Representa la lista de senderos en el grafo.
	 */
	private HashMap<Integer,Path> hashMapPaths;

	/**
	 * Indica si el grafo se implementa como una matrix o una lista de adjacencia.
	 */
	private boolean isMatrix;


	/**
	 * Crea un laberinto
	 * @param isMatrix - indica el tipo de implementacion del grafo.
	 */
	public Maze(boolean isMatrix) {
		if (isMatrix) {
			this.graphByMatrix = new GraphByMatrix<Path, Integer>(matriz.length);
		} else {
			this.graphByLists = new GraphByLists<Path, Integer>(matriz.length);
		}
		
		hashMapPaths = new HashMap<>();
		this.isMatrix = isMatrix;
	}

	
	/**
	 * Devuelve el grafo.
	 * @return graph - es el grafo.
	 */
	public IGraph<Path,Integer> getGraph(){
		IGraph<Path, Integer> graph;
		
		return graph = isMatrix ? this.graphByMatrix : this.graphByLists;
	}
	
	/**
	 * 
	 * @throws IOException
	 */
	public void fillMatriz() throws IOException {
		File file = new File(PATH_LABERINTO_1);
		FileReader fr = new FileReader(file);
		BufferedReader lector = new BufferedReader(fr);
		String line = lector.readLine();
		
		String [] dimensiones  = line.split(";");
		int row = Integer.parseInt(dimensiones[0]);
		int column = Integer.parseInt(dimensiones[1]);
		matriz = new String[row][column];
		
		lector.readLine();
		int i = 0;
		while(line != null) {
			String[] elements = line.split(";");
			for (int j = 0; j < matriz[i].length; j++) {
				matriz[i][j] = elements[j];
			}
			i++;
			line = lector.readLine();
		}
	
		lector.close();
		fr.close();
	}
	
	/**
	 * 
	 */
	public void printMatriz() {
	
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	
	
	
	public String finAdjacent(int x, int y) {
		String result = null;
		// Checks if there is a vertex above the origin vertex
		if(matriz[x][y-1] != null) {
			result = checkUp(x, y)+",";
		}
		
		// Checks if there is a vertex to the right of the origin vertex
		if(matriz[x+1][y] != null ) {
			result = checkRight(x, y)+",";
		}
		
		//Checks if there is a vertex to the left of the origin vertex
		if(matriz[x-1][y] != null) {
			result = checkLeft(x, y)+",";
		}
		
		// Checks if there is a vertex below the origin vertex
		if(matriz[x][y+1] != null) {
			result = checkDown(x, y)+",";
		}
		return result;
	}
	
	
	
	
	
	
	/**
	 * Method helper find adjacent
	 *	This method checks if there is a vertex above the origin vertex
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return The value that is in that position or No if it does not exist. 
	 */
	private String checkUp(int x, int y) {
		return (matriz[x][--y] != "#")? matriz[x][y]:"NO" ;
	}
	
	/**
	 * Method helper find adjacent
	 *	This method checks if there is a vertex to the right of the origin vertex
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return The value that is in that position or No if it does not exist. 
	 */
	private String checkRight(int x, int y) {
		return (matriz[++x][y] != "#")? matriz[x][y] : "NO";
	}
	

	/**
	 * Method helper find adjacent
	 *	This method checks if there is a vertex to the left of the origin vertex
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return The value that is in that position or No if it does not exist. 
	 */
	private String checkLeft(int x, int y) {
		return (matriz[--x][y] != "#")? matriz[x][y] : "NO";
	}
	
	
	/**
	 * Method helper find adjacent
	 *	This method checks if there is a vertex below the origin vertex
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return The value that is in that position or No if it does not exist. 
	 */
	private String checkDown(int x, int y) {
		return (matriz[x][++y] != "#")? matriz[x][y] : "NO";
	}
	
	
	
	
	
	
}

