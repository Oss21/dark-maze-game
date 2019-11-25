package model;

import customExceptions.PassageAlreadyExistException;
import customExceptions.PathAlreadyExistException;
import customExceptions.PathNotExistException;
import customInterface.IGraph;
import dataStructure.AdjacentListGraph;
import dataStructure.AdjacentMatrixGraph;
import dataStructure.Vertex;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

/**
 *
 */
public class Maze {

	
	public String [][] matriz;
	
	public static String PATH_LABERINTO_1="data/laberinto_1.csv"; 
	
	/**
	 * Representa el grafo
	 */
	private IGraph<Path,Integer> graph;

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
		graph = isMatrix ? new AdjacentMatrixGraph<>(false,true) : new AdjacentListGraph<>(false,true);
		hashMapPaths = new HashMap<>();
		this.isMatrix = isMatrix;

	}

	/**
	 * Devuelve el grafo.
	 * @return graph - es el grafo.
	 */
	public IGraph<Path,Integer> getGraph(){
		return graph;
	}

	/**
	 * Devuelve la lista de senderos en el laberinto.
	 * @return hashMapPaths - la lista de senderos.
	 */
	public HashMap<Integer,Path> getHashMapPaths(){
		return hashMapPaths;
	}


	// TODO
	public void findMinimumPathEntryToExit(){}

	// TODO
	public void findMinimumPathCurrentPointToLightPoint(){}


	/**
	 * Busca un sendero indicando su valor.
	 * @param value - es el valor del sendero.
	 * @return searched - es el sendero buscado, si no existe devuelve null.
	 */
	public Vertex<Path,Integer> searchPath(int value){
		Path searched = hashMapPaths.get(hashMapPaths.containsKey(value));
		return searched == null ? null : searchPath(value);
	}

	/**
	 * Agrega un sendero al grafo.
	 * @param value - es el valor del sendero.
	 * @param pathType - es el tipo de sendero.
	 * @throws PathAlreadyExistException - excepción que se lanza si el sendero a agregar ya existe.
	 */
	public void addPath(int value, Path.PathType pathType) throws PathAlreadyExistException{
		if (searchPath(value) != null){
			throw new PathAlreadyExistException("El sendero a agregar ya existe en el laberinto");
		}
		Path newPath = new Path(value,pathType);
		hashMapPaths.put(value, newPath);
		graph.addVertex(newPath,value);
	}

	/**
	 * Elimina un sendero del grafo.
	 * @param value - es el valor del sendero.
	 * @throws PathNotExistException - excepción que se lanza si el sendero a eliminar no existe.
	 */
	public void removePath(int value) throws PathNotExistException{
		Vertex<Path,Integer> toRemove = searchPath(value);
		if (toRemove == null){
			throw new PathNotExistException("El sendero a eliminar no existe en el laberinto");
		}
		hashMapPaths.remove(toRemove);
		graph.removeVertex(toRemove);
	}

	/**
	 * Crea un pasadizo entre un par de senderos.
	 * @param source - es el primer sendero a conectar.
	 * @param destination - es el segundo sendero a conectar.
	 * @param cost - es el costo de cruzar el pasadizo.
	 * @throws PathNotExistException - excepción que se lanza si alguno de los senderos a conectar no existe.
	 * @throws PassageAlreadyExistException - excepción que se lanza si el pasadizo entre dos senderos ya existe.
	 */
	public void addPassage(int source, int destination, double cost) throws PathNotExistException, PassageAlreadyExistException {
		Vertex<Path, Integer> sou = searchPath(source);
		Vertex<Path, Integer> des = searchPath(destination);
		if (sou == null || des == null){
			throw new PathNotExistException("Alguno de los senderos a conectar no existe");
		}
		if (graph.areAdjacent(sou, des)){
			throw new PassageAlreadyExistException("El pasadizo a crear ya existe");
		}
		graph. addEdge(sou,des,cost);
	}

	
			
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
	
	public void printMatriz() {
	
		for (int i = 0; i < matriz.length; i++) {
			for (int j = 0; j < matriz[i].length; j++) {
				System.out.print(matriz[i][j]+" ");
			}
			System.out.println();
		}
		
	}
	
	
	
	
}

