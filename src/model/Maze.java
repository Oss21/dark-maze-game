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

import org.junit.jupiter.params.shadow.com.univocity.parsers.conversions.NumericConversion;

/**
 * It is the class that represents the maze
 */
public class Maze implements Serializable{
	
	
	public static final String PATH_IDENTIFIER = "p";

	public static final String WALL_IDENTIFIER = "w";

	public static final String HOLE_IDENTIFIER = "h";

	public static final String LAKE_IDENTIFIER = "l";

	public static final String QUICKSAND_IDENTIFIER = "q";

	public static final String WALL_MAZE_IDENTIFIER = "#";
	
	public static final String ENTRY_IDENTIFIER = "en";
	
	public static final String EXIT_IDENTIFIER = "ex";
	
	public static final String PATH_LABERINTO_1="resourses/data/laberinto_1.csv";
	
	/**
	 * Is the character. 
	 */
	private Character character;
	
	/**
	 * Represents the maze.
	 */
	public String [][] matrix;
	
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
	private int numberOfSteps;
	
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
		this.character = new Character();
		this.numberOfSteps = 0;
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
		return matrix;
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
	public void fillMatrix() throws IOException {
		File file = new File(PATH_LABERINTO_1);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		String line = br.readLine();
		int i = 0;
		
		while(line != null) {
			String[] content = line.split(";");
			numberOfSteps++;
			
			if (i == 0) {
				int m = Integer.parseInt(content[0]);
				int n = Integer.parseInt(content[1]);
				
				this.matrix = new  String[m][n];
				this.aux_Matrix = new String[m][n];
				
			}else {
				for (int j = 0; j < content.length; j++) {
					matrix[i-1][j] = content[j];
					
					if (content[j].equals("#")) {
						aux_Matrix[i-1][j] = content[j];
					}else {
						aux_Matrix[i-1][j] = "" + numberOfSteps;
					}
				}
			}
			 i++;
			 line = br.readLine();
		 }
		br.close();
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
					if(!matrix[i][j].equals("#") && !value[k].equals("NO")) {
						graphByLists.addEdge(aux_Matrix[i][j], value[k], GraphByLists.NOT_DIRECTED, COST,COST);
					}
					k++;
				}
			}
		}
	}
	
	
	/**
	 * This method allows to create a Matrix.
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
					if(!matrix[i][j].equals("#") && !value[k].equals("NO")) {
						graphByMatrix.addEdge(aux_Matrix[i][j], value[k],GraphByMatrix.NOT_DIRECTED, COST, COST);
					}
					k++;
				}
			}
		}
		

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
	
	
	/**
	 * 
	 * @return
	 */
	public String[][] getAux_Matrix() {
		return aux_Matrix;
	}
	
	
	/**
	 * 
	 * @param aux_Matrix
	 */
	public void setAux_Matrix(String[][] aux_Matrix) {
		this.aux_Matrix = aux_Matrix;
	}
	
	
	/**
	 * 
	 * @return
	 */
	public IGraph getGraph() {
		IGraph graph = null;
		
		if (isMatrix) {
			graph = graphByMatrix;
		}else {
			graph = graphByLists;
		}
		return graph;
	}
	
	/**
	 * 
	 * @return
	 */
	public Character getCharacter() {
		return character;
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
