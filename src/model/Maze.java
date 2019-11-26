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

	public static final String PATH_LABERINTO_1="resourses/data/laberinto_1.csv"; 
	
	/**
	 * Representa el laberinto
	 */
	public String [][] matriz;
	
	/**
	 * Representa el grafo cuando se utiliza lista de adyacencia
	 */
	private GraphByLists<String, Double> graphByLists;
	
	/**
	 * Representa al grafo cuando se utiliza con matrix de adyacencia
	 */
	private GraphByMatrix<String, Integer> graphByMatrix;

	/**
	 * Representa la lista de senderos en el grafo.
	 */
	private HashMap<Integer,Path> hashMapPaths;

	/**
	 * Indica si el grafo se implementa como una matrix o una lista de adjacencia.
	 */
	private boolean isMatrix;

	/**
	 * Indicate how many steps are in the maze in the other words how many vertices are there.
	 */
	private int numberOfSteps;
	
	/**
	 * Represents the cost of the road
	 */
	public static double COST = 1.0;
	
	

	/**
	 * Crea un laberinto
	 * @param isMatrix - indica el tipo de implementacion del grafo.
	 */
	public Maze(boolean isMatrix) {
//		if (isMatrix) {
//			this.graphByMatrix = new GraphByMatrix<String, Integer>(matriz.length);
//		} else {
//			this.graphByLists = new GraphByLists<String, Integer>(matriz.length);
//		}
//		
//		hashMapPaths = new HashMap<>();
//		this.isMatrix = isMatrix;
	}

	
	
	/**
	 * 
	 */
	public String[][] getMatriz() {
		return matriz;
	}
	
	/**
	 * Number of steps
	 * @return The number of steps in the maze.
	 */
	public int getNumberOfSteps() {
		return numberOfSteps;
	}


	
	/**
	 * This method fill the matrix according to the read
	 * file that contains the dimensions of the matrix and its template.
	 * @throws IOException If the file path is not found
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
		
		line = lector.readLine();
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
	 * This method allows to fill the matrix with the respective vertices.
	 */
	public void fillMatrixWithNumber() {
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				if(matriz[i][j] != "#") {
					matriz[i][j] = "V"+ numberOfSteps++;
				}
			}
		}
	}

	
		
	
	/**
	 * This method allows to create a list adyacent.
	 *<pre>The matrix was already initialized and filled with their respective vertices </pre> 
	 */
	public void createListAdyacent() {
		this.graphByLists = new GraphByLists<String, Double>(numberOfSteps);
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				String[] value = finAdjacent(i,j).split(",");
				int k = 0;	
				while (k > value.length) {
					if(value[k] != "NO") {
						graphByLists.addEdge(matriz[i][j], value[k], GraphByLists.NOT_DIRECTED, COST,COST);
					}
					k++;
				}
			}
		}
		//
	}
		
		
		
	
	
	
	
	
	
	
	
	
	/**
	 * This method checks if there are vertices around an origin vertex. 
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex.
	 * @return 
	 */
	public String finAdjacent(int x, int y) {
		String result = null;
		// Checks if there is a vertex above the origin vertex
		if(matriz[x][y-1] != null) {
			result = checkUp(x, y)+",";
		}else {
			result = "NO"+",";
		}
		
		// Checks if there is a vertex to the right of the origin vertex
		if(matriz[x+1][y] != null ) {
			result = checkRight(x, y)+",";
		}else {
			result = "NO"+",";
		}
		
		//Checks if there is a vertex to the left of the origin vertex
		if(matriz[x-1][y] != null) {
			result = checkLeft(x, y)+",";
		}else {
			result = "NO"+",";
		}
		
		// Checks if there is a vertex below the origin vertex
		if(matriz[x][y+1] != null) {
			result = checkDown(x, y)+",";
		}else {
			result = "NO"+",";
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
	 *This method checks if there is a vertex to the left of the origin vertex
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
	
	
	
	
	
	
}//FIN



















///**
// * 
// */
//public void printMatriz() {
//
//	for (int i = 0; i < matriz.length; i++) {
//		for (int j = 0; j < matriz[i].length; j++) {
//			System.out.print(matriz[i][j]+" ");
//		}
//		System.out.println();
//	}
//	
//}
//




///**
// * Devuelve el grafo.
// * @return graph - es el grafo.
// */
//public IGraph<String,Integer> getGraph(){
//	IGraph<Path, Integer> graph;
//	
//	return graph = isMatrix ? this.graphByMatrix : this.graphByLists;
//}
