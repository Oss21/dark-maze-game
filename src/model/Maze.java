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
 * It is the class that represents the maze
 */
public class Maze implements Serializable{

	
	public static final String PATH_LABERINTO_1="resourses/data/laberinto_1.csv"; 
	
	/**
	 * Represents the maze.
	 */
	public String [][] matriz;
	
	/**
	 * Represents the graph when adjacency list is used.
	 */
	private String [][] aux_Matrix;
	
	/**
	 * Represents the graph when adjacency list is used.
	 */
	private GraphByLists<String, Double> graphByLists;
	
	/**
	 * Represents the graph when used with adjacency matrix.
	 */
	private GraphByMatrix<String, Double> graphByMatrix;

	/**
	 * Represents the list of trails in the graph.
	 */
	private HashMap<Integer,Path> hashMapPaths;

	/**
	 * Indicates whether the graph is implemented as a matrix or an adjacency list.
	 */
	private boolean isMatrix;

	/**
	 * Indicate how many steps are in the maze in the other words how many vertices are there.
	 */
	private int numberOfSteps = 1;
	
	/**
	 * Represents the cost of the road
	 */
	public static double COST = 1.0;
	
	

	/**
	 * Create a maze
	 * 
	 * @param isMatrix - Indicates the type of graph implementation.
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
	 * Returns the adjacency matrix.
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
	 * Check if the element in this position is a wall
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return True if it is a wall.
	 */
	private boolean isWall(int x, int y) {
		return aux_Matrix[x][y].equals("#");
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
		aux_Matrix = new String[row][column]; 
		matriz = new String[row][column];
		line = lector.readLine();
		int i = 0;
		while(line != null) {
			String[] elements = line.split(";");
			for (int j = 0; j < matriz[i].length; j++) {
				aux_Matrix[i][j] = elements[j];
				matriz[i][j] = elements[j];
				
			}
			i++;
			line = lector.readLine();
		}
	
		lector.close();
		fr.close();
	}
	
	
	/**
	 * This method allows to create a list adyacent.
	 *<pre>The matrix was already initialized and filled with their respective vertices </pre> 
	 */
	public void createListAdyacent() {
		this.graphByLists = new GraphByLists<String, Double>(numberOfSteps);
		 //Allows to fill the matrix with the respective vertices.
		for (int i = 0; i < aux_Matrix.length; i++) {
			for (int j = 0; j < aux_Matrix[i].length; j++) {
				if(!isWall(i, j) ) {
					aux_Matrix[i][j] =""+numberOfSteps++;
					graphByLists.addVertex(aux_Matrix[i][j]);
				}
			}
		}
		for (int i = 0; i < aux_Matrix.length; i++) {
			for (int j = 0; j < aux_Matrix[i].length; j++) {
				String[] value = finAdjacent(i,j).split(",");
				int k = 0;	
				while (k < value.length) {
					if(!matriz[i][j].equals("#") && !value[k].equals("NO")) {
						graphByLists.addEdge(aux_Matrix[i][j], value[k], GraphByLists.NOT_DIRECTED, COST,COST);
					}
					k++;
				}
			}
		}
	}
		
<<<<<<< Updated upstream
	
	/**
	 * This method allows to create a  Matrix adyacent.
	 *<pre>The matrix was already initialized and filled with their respective vertices </pre> 
	 */
	public void createMatrixAdyacent() {
		this.graphByMatrix = new GraphByMatrix<String, Double>(numberOfSteps);
		 //Allows to fill the matrix with the respective vertices.
		for (int i = 0; i < aux_Matrix.length; i++) {
			for (int j = 0; j < aux_Matrix[i].length; j++) {
				if(!isWall(i, j) ) {
					graphByMatrix.addVertex(aux_Matrix[i][j]);
				}
			}
		}
		for (int i = 0; i < aux_Matrix.length; i++) {
			for (int j = 0; j < aux_Matrix[i].length; j++) {
				String[] value = finAdjacent(i,j).split(",");
				int k = 0;	
				while (k < value.length) {
					if(!matriz[i][j].equals("#") && !value[k].equals("NO")) {
						graphByMatrix.addEdge(aux_Matrix[i][j], value[k],GraphByMatrix.NOT_DIRECTED, COST, COST);
					}
					k++;
				}
			}
		}
		

	}


=======
>>>>>>> Stashed changes

	/**
	 * This method checks if there are vertices around an origin vertex. 
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex.
	 * @return 
	 */
	public String finAdjacent(int x, int y) {
		String result = null;
		// Checks if there is a vertex above the origin vertex
		if(y-1 >= 0) {
			result = checkUp(x, y)+",";
		}else {
			result = "NO"+",";
		}
		
		// Checks if there is a vertex to the right of the origin vertex
		if(x+1 < aux_Matrix.length) {
			result += checkRight(x, y)+",";
		}else {
			result += "NO"+",";
		}
		
		//Checks if there is a vertex to the left of the origin vertex
		if(x-1 >= 0) {
			result += checkLeft(x, y)+",";
		}else {
			result += "NO"+",";
		}
		
		// Checks if there is a vertex below the origin vertex
		if(y+1 < aux_Matrix[0].length) {
			result += checkDown(x, y)+",";
		}else {
			result += "NO"+",";
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
		return (!aux_Matrix[x][--y].equals("#"))? aux_Matrix[x][y]:"NO" ;
	}
	
	/**
	 * Method helper find adjacent
	 *	This method checks if there is a vertex to the right of the origin vertex
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return The value that is in that position or No if it does not exist. 
	 */
	private String checkRight(int x, int y) {
		return (!aux_Matrix[++x][y].equals("#"))? aux_Matrix[x][y] : "NO";
	}
	

	/**
	 * Method helper find adjacent
	 *This method checks if there is a vertex to the left of the origin vertex
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return The value that is in that position or No if it does not exist. 
	 */
	private String checkLeft(int x, int y) {
		return (!aux_Matrix[--x][y].equals("#"))? aux_Matrix[x][y] : "NO";
	}
	
	
	/**
	 * Method helper find adjacent
	 *	This method checks if there is a vertex below the origin vertex
	 * @param x The x position of an origin vertex
	 * @param y The y position of an origin vertex
	 * @return The value that is in that position or No if it does not exist. 
	 */
	private String checkDown(int x, int y) {
		return (!aux_Matrix[x][++y].equals("#"))? aux_Matrix[x][y] : "NO";
	}
	
	
	
	
	
	public String[][] getAux_Matrix() {
		return aux_Matrix;
	}



	public void setAux_Matrix(String[][] aux_Matrix) {
		this.aux_Matrix = aux_Matrix;
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
