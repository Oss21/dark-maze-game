package dataStructure;

import java.io.Serializable;
import java.util.ArrayList;

import customInterface.IGraph;

/**
 * Class representing the implementation of an adjacency matrices.
 */
public class GraphByMatrix<T extends Comparable<T>, E extends Comparable<E>> implements IGraph<T, E>, Serializable {

	/**
	 * It is the adjacent matrix.
	 */
	private ArrayList<Edge<E>>[][] adjMatrix;

	/**
	 * It is the verteces list.
	 */
	private ArrayList<Vertex<T>> vertices;
	
	/**
	 * It is the edges list.
	 */
	private ArrayList<Edge<E>> edges;
	
	/**
	 * It is the number of vertex.
	 */
	private int numVertex;

	/**
	 * Graph Constructor
	 * 
	 * @param numVertex The number of vertices that the graph will have.
	 */
	public GraphByMatrix(int numVertex) {

		this.numVertex = numVertex;
		vertices = new ArrayList<Vertex<T>>();
		adjMatrix = new ArrayList[numVertex][numVertex];
		edges = new ArrayList<>();

		initMatrix();

	}

	/**
	 * This method puts ArrayList in all matrix positions.
	 */
	private void initMatrix() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				adjMatrix[i][j] = new ArrayList<Edge<E>>();
			}
		}
	}

	/**
	 * Change the edge list.
	 */
	public void setEdges(ArrayList<Edge<E>> edges) {
		this.edges = edges;
	}

	/**
	 * This method gets the index where the vertex is saved. Then with this index,
	 * it is possible to identify this vertex like a row or like a column in the
	 * matrix
	 * 
	 * @param valueVertex The value of the vertex
	 * @return The index where the vertex is saved in the vertices array.
	 */
	public int getIndexVertex(T valueVertex) {
		int index = -1;
		for (int i = 0; i < vertices.size(); i++) {
			if (vertices.get(i).getValue().equals(valueVertex))
				index = i;
		}
		return index;
	}

	/**
	 * Create an edge between two vertices.
	 */
	@Override
	public void addEdge(T from, T destination, boolean directed, double cost, E value) {
		int f = getIndexVertex(from);
		int d = getIndexVertex(destination);
		if (directed) {
			adjMatrix[f][d].add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			vertices.get(f).getEdges()
					.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			edges.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
		} else {
			adjMatrix[f][d].add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			adjMatrix[d][f].add(new Edge<E>(new Vertex<T>(destination), new Vertex<T>(from), cost, directed, value));
			vertices.get(f).getEdges()
					.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
			vertices.get(d).getEdges()
					.add(new Edge<E>(new Vertex<T>(destination), new Vertex<T>(from), cost, directed, value));
			edges.add(new Edge<E>(new Vertex<T>(from), new Vertex<T>(destination), cost, directed, value));
		}
	}

	/**
	 * Remove an edge between two vertices.
	 */
	@Override
	public void removeEdge(T from, T destination, boolean directed, double cost) {
		int f = getIndexVertex(from);
		int d = getIndexVertex(destination);
		if (directed) {
			for (int i = 0; i < adjMatrix[f][d].size(); i++) {
				if (adjMatrix[f][d].get(i).getCost() == cost)
					adjMatrix[f][d].remove(i);
			}
		} else {
			for (int i = 0; i < adjMatrix[f][d].size(); i++) {
				if (adjMatrix[f][d].get(i).getCost() == cost)
					adjMatrix[f][d].remove(i);
				if (adjMatrix[d][f].get(i).getCost() == cost)
					adjMatrix[d][f].remove(i);
			}
		}
	}

	/**
	 * Add a vertex to the graph.
	 */
	@Override
	public void addVertex(T valueVertex) {
		if (vertices.size() < numVertex)
			vertices.add(new Vertex<T>(valueVertex));
	}

	/**
	 * Remove a vertex to the graph.
	 */
	@Override
	public void removeVertex(T valueVertex) {

	}

	/**
	 * Check if two vertices are adjacent.
	 */
	@Override
	public boolean isAdjacent(T vertexA, T vertexB) {
		boolean is = false;
		int a = getIndexVertex(vertexA);
		int b = getIndexVertex(vertexB);
		if (adjMatrix[a][b].size() > 0 || adjMatrix[b][a].size() > 0) {
			is = true;
		}
		return is;
	}

	/**
	 * Gets the edges of the specified vertex.
	 * 
	 * @param valueVertex The vertex to know its edges.
	 * @return The edges of the specified vertex.
	 */
	public ArrayList<Edge<?>> getEdgesOfVertex(T valueVertex) {

		int E = getIndexVertex(valueVertex);
		ArrayList<Edge<?>> edges = new ArrayList<>();

		for (int i = 0; i < adjMatrix[0].length; i++) {
			if (!adjMatrix[E][i].isEmpty()) {
				edges.addAll(adjMatrix[E][i]);
			}
		}
		return edges;
	}

	/**
	 * Gets the quantity of edges of the specified vertex.
	 * 
	 * @param valueVertex The vertex to know its quantity of edges.
	 * @return The quantity of edges of the specified vertex.
	 */
	public int numEdgesOfVertex(T valueVertex) {
		return getEdgesOfVertex(valueVertex).size();
	}

	
	
	public void primMatriz() {
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < adjMatrix[i].length; j++) {
				System.out.print(adjMatrix[i][j]+" ");
			}
			System.out.println();
		}
	}
	
	
	/**
	 * Gets the edges between two vertices.
	 * 
	 * @param vertexA The vertex "from" (origin of the edge)
	 * @param vertexB The vertex "to" (where the edge ends)
	 * @return The edges between two vertices specified.
	 */
	public ArrayList<Edge<E>> edgesBetween(T vertexA, T vertexB) {
		ArrayList<Edge<E>> edges = new ArrayList<>();
		int indexA = getIndexVertex(vertexA);
		int indexB = getIndexVertex(vertexB);
		edges = adjMatrix[indexA][indexB];
		return edges;
	}

	/**
	 * Returns the number of vertices.
	 */
	@Override
	public int getNumVertex() {
		return vertices.size();
	}

	/**
	 * Returns the adjacent matrix.
	 */
	public ArrayList<Edge<E>>[][] getAdjMatrix() {
		return adjMatrix;
	}

	/**
	 *  Change the adjacent matrix.
	 * @param adjMatrix - The new adjacent matrix.
	 */
	public void setAdjMatrix(ArrayList<Edge<E>>[][] adjMatrix) {
		this.adjMatrix = adjMatrix;
	}

	/**
	 * Returns the vertices list.
	 */
	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	/**
	 * Change the vertices list.
	 * @param vertices -the new vertices list.
	 */
	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	/**
	 * Draw a graph with all connections Vertices-Edges. Including Directed and
	 * Undirected edges between all vertices.
	 * 
	 * @return The graph like a string.
	 */
	public String graphToString() {
		String g = "";
		for (int i = 0; i < adjMatrix.length; i++) {
			for (int j = 0; j < vertices.size(); j++) {
				if (!adjMatrix[i][j].isEmpty()) {
					for (int k = 0; k < adjMatrix[i][j].size(); k++) {
						if (adjMatrix[i][j].get(k).isDirected())
							g += vertices.get(i).toString() + " -- " + adjMatrix[i][j].get(k).toString() + " --> "
									+ vertices.get(j).toString() + "\n";
						else
							g += vertices.get(i).toString() + " <-- " + adjMatrix[i][j].get(k).toString() + " --> "
									+ vertices.get(j).toString() + "\n";
					}
				}
			}
			g += "\n";
		}
		return g;
	}

	/**
	 * Returns the edges list.
	 */
	public ArrayList<Edge<E>> getEdges() {
		return edges;
	}

}