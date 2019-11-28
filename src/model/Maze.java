package model;

import customInterface.IGraph;
import dataStructure.GraphByLists;
import dataStructure.GraphByMatrix;
import model.Path.PathType;

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
	
	
	public static final String PATH_IDENTIFIER = "-";

	public static final String WALL_IDENTIFIER = "w";

	public static final String HOLE_IDENTIFIER = "h";

	public static final String LAKE_IDENTIFIER = "l";

	public static final String QUICKSAND_IDENTIFIER = "q";
	
	public static final String POINTLIGHT_IDENTIFIER = "pl";

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
	private GraphByLists<Path, Double> graphByLists;
	
	/**
	 * Represents the graph when used with adjacency matrix.
	 */
	private GraphByMatrix<Path, Double> graphByMatrix;
	
	/**
	 * 
	 */
	private HashMap<String, Path> paths;
	
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
		this.isMatrix = isMatrix;
		
		this.paths = new HashMap<>();
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
						numberOfSteps++;
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
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private Path createPath(int i, int j) {
		Path newP = null;
		
		if (isPath(i, j)) {
			newP = new Path(PathType.PATH, aux_Matrix[i][j], isPointLight(i, j));
		}else if (isLake(i, j)) {
			newP = new Path(PathType.LAKE, aux_Matrix[i][j], isPointLight(i, j));
		}else if (isHole(i, j)) {
			newP = new Path(PathType.HOLE, aux_Matrix[i][j], isPointLight(i, j));
		}else if (isQuickSand(i, j)) {
			newP = new Path(PathType.QUICKSAND, aux_Matrix[i][j], isPointLight(i, j));
		}else if (isWall(i, j)) {
			newP = new Path(PathType.WALL, aux_Matrix[i][j], isPointLight(i, j));
		}
		
		return newP;
	}
	
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isPath(int i, int j) {
		return (matrix[i][j].equals(PATH_IDENTIFIER) || matrix[i][j].equals(ENTRY_IDENTIFIER) || matrix[i][j].equals(EXIT_IDENTIFIER));
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isLake(int i, int j) {
		return matrix[i][j].equals(LAKE_IDENTIFIER);
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isHole(int i, int j) {
		return matrix[i][j].equals(HOLE_IDENTIFIER);
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isQuickSand(int i, int j) {
		return matrix[i][j].equals(QUICKSAND_IDENTIFIER);
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isWall(int i, int j) {
		return matrix[i][j].equals(WALL_MAZE_IDENTIFIER);
	}
	
	/**
	 * 
	 * @param i
	 * @param j
	 * @return
	 */
	private boolean isPointLight(int i, int j) {
		return matrix[i][j].equals(POINTLIGHT_IDENTIFIER);
	}
	
	
	/**
	 * This method allows to create a list adjacent.
	 *<pre>The matrix was already initialized and filled with their respective vertices </pre> 
	 */
	public void createListAdyacent() {
		this.graphByLists = new GraphByLists<Path, Double>(numberOfSteps);
		
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				if (!isWall(i, j)) {
					Path p = createPath(i, j);

					graphByLists.addVertex(p);
					paths.put(p.getId(), p);
				}
			}
		}
		
		createEdges(graphByLists);
	}
	
	
	/**
	 * This method allows to create a Matrix.
	 *<pre>The matrix was already initialized and filled with their respective vertices </pre> 
	 */
	public void createMatrixAdyacent() {
		this.graphByMatrix = new GraphByMatrix<Path, Double>(numberOfSteps);
		
		for (int i = 0; i < aux_Matrix.length; i++) {
			for (int j = 0; j < aux_Matrix[i].length; j++) {
				if(!isWall(i, j) ) {
					Path p = createPath(i, j);

					graphByMatrix.addVertex(p);
					paths.put(p.getId(), p);
				}
			}
		}
		createEdges(graphByMatrix);
	}
	
	
	/**
	 * 
	 * @param graph
	 */
	private void createEdges(IGraph<Path, Double> graph) {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				
				if (!isWall(i, j)) {
					String[] adjacents = findAdjacent(i, j).split(";");
					
					int k = 0;
					while(k < adjacents.length) {
						Path from = paths.get(aux_Matrix[i][j]);
						Path destination = paths.get(adjacents[k]);
						
						if (destination != null) {
							graph.addEdge(from, destination, false, COST, from.getValue() + destination.getValue());
						}
						k++;
					}
				}
			}
		}
	}
	

	/**
	 * This method checks if there are vertices around an origin vertex. 
	 * @param i The x position of an origin vertex
	 * @param j The y position of an origin vertex.
	 * @return 
	 */
	private String findAdjacent(int i, int j) {
		String result = "";
		
		//Up
		if (i-1 >= 0) {
			if (!aux_Matrix[i-1][j].equals(WALL_MAZE_IDENTIFIER)) {
				result = result + ";" + aux_Matrix[i-1][j];
			}
		}
		//Down
		if (i+1 <= aux_Matrix.length - 1) {
			if (!aux_Matrix[i+1][j].equals(WALL_MAZE_IDENTIFIER)) {
				result = result + ";" + aux_Matrix[i+1][j];
			}
		}
		//Right
		if (j+1 <= aux_Matrix[0].length - 1) {
			if (!aux_Matrix[i][j+1].equals(WALL_MAZE_IDENTIFIER)) {
				result = result + ";" + aux_Matrix[i][j+1];
			}
		}
		//Left
		if (j-1 >= 0) {
			if (!aux_Matrix[i][j-1].equals(WALL_MAZE_IDENTIFIER)) {
				result = result + ";" + aux_Matrix[i][j-1];
			}
		}
		return result;
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
	public IGraph<Path, Double> getGraph() {
		IGraph<Path, Double> graph = null;
		
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
	
	/**
	 * 
	 */
	public Path searchPath(String id) {
		return this.paths.get(id);
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
