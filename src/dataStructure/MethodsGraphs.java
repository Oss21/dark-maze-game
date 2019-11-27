package dataStructure;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents the main methods of graph algorithms.
 * 
 * 
 *
 * @param <T> The vertex type of a graph that this class will do graph
 *        algorithms.
 * @param <E> The edge type of a graph that this class will do graph algorithms.
 */
public class MethodsGraphs<T extends Comparable<T>, E extends Comparable<E>> implements Serializable {
	
	/**
	 * Constructor of MethodsGraph.
	 */
	public MethodsGraphs() {

	}

	// DFS by graph by Matrix Aux
	/**
	 * This method realize the depth first search in a graph in order as the
	 * vertices were added. (This is the aux method for a graph by matrix)
	 * 
	 * @param g       The graph.
	 * @param v       The vertex where the method will start the path.
	 * @param visited A boolean array where the method controls which vertex has
	 *                been visited.
	 * @param stack   A stack that the method uses to realize the DFS path.
	 * @param dfs     An arraylist to save how the method was adding all vertices
	 *                according to the order.
	 * @return Returns the arraylist dfs.
	 */
	private ArrayList<Vertex<T>> DFS(GraphByMatrix<T, E> g, Vertex<T> v, boolean[] visited, Stack<Vertex<T>> stack, ArrayList<Vertex<T>> dfs) {
		if (dfs.size() == g.getVertices().size()) {
			return dfs;
		}
		ArrayList<Vertex<T>> vertices = g.getVertices();
		int index = g.getIndexVertex(v.getValue());
		visited[index] = true;
		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {
				if (stack.peek() != v) {
					stack.push(v);
					dfs.add(v);
				}
				if (visited[g.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {
					return DFS(g, (Vertex<T>) vertices.get(index).getEdges().get(i).getDestination(), visited, stack, dfs);
			}
		}
			stack.pop();
		return DFS(g, stack.peek(), visited, stack, dfs);
	}

	// DFS by graph by Matrix

	/**
	 * This method realize the depth first search in a graph in order as the
	 * vertices were added.
	 * 
	 * @param g The graph which the method will do the DFS Algorithm
	 * @param v The vertex which the method will start the DFS algorithm
	 * @return Returns an arraylist in order how the method has done the DFS
	 *         algorithm.
	 */
	public ArrayList<Vertex<T>> DFS(GraphByMatrix<T, E> g, Vertex<T> v) {
		boolean[] visited = new boolean[g.getVertices().size()];
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		ArrayList<Vertex<T>> dfs = new ArrayList<>();
		stack.push(v);
		dfs.add(v);
		return DFS(g, v, visited, stack, dfs);
	}

	// DFS by graph Lists Aux

	/**
	 * This method realize the depth first search in a graph in order as the
	 * vertices were added. (This is the aux method for a graph by lists)
	 * 
	 * @param g       The graph.
	 * @param v       The vertex where the method will start the path.
	 * @param visited A boolean array where the method controls which vertex has
	 *                been visited.
	 * @param stack   A stack that the method uses to realize the DFS path.
	 * @param dfs     An arraylist to save how the method was adding all vertices
	 *                according to the order.
	 * @return Returns the arraylist dfs.
	 */
	private ArrayList<Vertex<T>> DFS(GraphByLists<T, E> g, Vertex<T> v, boolean[] visited, Stack<Vertex<T>> stack, ArrayList<Vertex<T>> dfs) {
		if (dfs.size() == g.getVertices().size()) {
			return dfs;
		}
		ArrayList<Vertex<T>> vertices = g.getVertices();
		int index = g.getIndexVertex(v.getValue());
		visited[index] = true;
		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {
			if (stack.peek() != v) {
				stack.push(v);
				dfs.add(v);
			}
			if (visited[g.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {
				return DFS(g, (Vertex<T>) vertices.get(index).getEdges().get(i).getDestination(), visited, stack, dfs);
			}
		}
		stack.pop();
		return DFS(g, stack.peek(), visited, stack, dfs);
	}

	// DFS by Graph by lists.

	/**
	 * This method realize the depth first search in a graph in order as the
	 * vertices were added.
	 * 
	 * @param g The graph which the method will do the DFS Algorithm
	 * @param v The vertex which the method will start the DFS algorithm
	 * @return Returns an arraylist in order how the method has done the DFS
	 *         algorithm.
	 */
	public ArrayList<Vertex<T>> DFS(GraphByLists<T, E> g, Vertex<T> v) {
		boolean[] visited = new boolean[g.getVertices().size()];
		Stack<Vertex<T>> stack = new Stack<Vertex<T>>();
		ArrayList<Vertex<T>> dfs = new ArrayList<>();
		stack.push(v);
		dfs.add(v);
		return DFS(g, v, visited, stack, dfs);
	}

	// BFS by graph by Matrix. Aux

	/**
	 * This method realize the Breadth First Search in a graph in order as the
	 * vertices were added to the graph. (This is an auxiliar method of BFS
	 * algorithm to a graph by matrix)
	 * 
	 * @param g       The graph.
	 * @param v       The vertex where the method will start the BFS algorithm.
	 * @param visited An array of boolean where the method controls which vertices
	 *                are already visited.
	 * @param queue   A queue which the method uses to do the BFS algorithm.
	 * @param bfs     An arraylist of vertices where the method adds the path of the
	 *                algorithm.
	 * @return
	 */
	private ArrayList<Vertex<T>> BFS(GraphByMatrix<T, E> g, Vertex<T> v, boolean[] visited, Queue<Vertex<T>> queue,	ArrayList<Vertex<T>> bfs) {
		if (bfs.size() == g.getVertices().size()) {
			return bfs;
		}
		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();
		visited[index] = true;
		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {
			if (visited[g.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {
				queue.add((Vertex<T>) vertices.get(index).getEdges().get(i).getDestination());
			}
		}
		bfs.add(queue.poll());
		return BFS(g, queue.peek(), visited, queue, bfs);
	}

	// BFS by graph by Matrix.

	/**
	 * This method realize the Breadth First Search in a graph in order as the
	 * vertices were added to the graph.
	 * 
	 * @param g The graph.
	 * @param v The vertex where the method will start the algorithm.
	 * @return Return an arraylist of vertices in order of how the algorithm do the
	 *         path of the whole graph.
	 */
	public ArrayList<Vertex<T>> BFS(GraphByMatrix<T, E> g, Vertex<T> v) {
		boolean[] visited = new boolean[g.getVertices().size()];
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		ArrayList<Vertex<T>> bfs = new ArrayList<>();
		queue.add(v);
		return BFS(g, v, visited, queue, bfs);
	}

	// BFS by graph by Lists Aux.
	/**
	 * This method realize the Breadth First Search in a graph in order as the
	 * vertices were added to the graph. (This is an auxiliar method of BFS
	 * algorithm to a graph by lists)
	 * 
	 * @param g       The graph.
	 * @param v       The vertex where the method will start the BFS algorithm.
	 * @param visited An array of boolean where the method controls which vertices
	 *                are already visited.
	 * @param queue   A queue which the method uses to do the BFS algorithm.
	 * @param bfs     An arraylist of vertices where the method adds the path of the
	 *                algorithm.
	 * @return
	 */
	private ArrayList<Vertex<T>> BFS(GraphByLists<T, E> g, Vertex<T> v, boolean[] visited, Queue<Vertex<T>> queue, ArrayList<Vertex<T>> bfs) {
		if (bfs.size() == g.getVertices().size()) {
			return bfs;
		}
		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();
		visited[index] = true;
		for (int i = 0; i < vertices.get(index).getEdges().size(); i++) {
			if (visited[g.getIndexVertex((T) vertices.get(index).getEdges().get(i).getDestination().getValue())] == false) {
				queue.add((Vertex<T>) vertices.get(index).getEdges().get(i).getDestination());
			}
		}
		bfs.add(queue.poll());
		return BFS(g, queue.peek(), visited, queue, bfs);
	}

	// BFS by graph by lists.
	/**
	 * This method realize the Breadth First Search in a graph in orden as the
	 * vertices were added to the graph.
	 * 
	 * @param g The graph.
	 * @param v The vertex where the method will start the algorithm.
	 * @return Return an arraylist of vertices in order of how the algorithm do the
	 *         path of the whole graph.
	 */
	public ArrayList<Vertex<T>> BFS(GraphByLists<T, E> g, Vertex<T> v) {
		boolean[] visited = new boolean[g.getVertices().size()];
		Queue<Vertex<T>> queue = new LinkedList<Vertex<T>>();
		ArrayList<Vertex<T>> bfs = new ArrayList<>();
		queue.add(v);
		return BFS(g, v, visited, queue, bfs);
	}

	// Dijkstra by graph by matrix relax aux.

	/**
	 * This is an auxiliar method that helps the method Dijkstra. This method
	 * consist in modify the array of distances.
	 * 
	 * @param actual    The index of the actual vertex where the algorithm is
	 *                  working.
	 * @param adj       The adjacent vertex of actual vertex.
	 * @param weight    The edge weight between actual and adj vertices.
	 * @param distances An array of distance where each position represents the
	 *                  distance between each vertex to another vertex.
	 * @param queue     This queue controls the last distances of each vertex to
	 *                  another vertex.
	 * @param g         The graph.
	 */
	private void relax(int actual, int adj, double weight, double[] distances, PriorityQueue<Node<T>> queue, GraphByMatrix<T, E> g) {
		if (distances[actual] + weight < distances[adj]) {
			distances[adj] = distances[actual] + weight;
			queue.add(new Node<T>(g.getVertices().get(adj), distances[adj]));
		}
	}

	// Dijkstra by graph by matrix aux.

	/**
	 * This method realize the algorithm Dijkstra. This method computes the minimum
	 * path cost of one vertex with all vertices of the graph. This is the aux
	 * method.
	 * 
	 * @param g            The graph.
	 * @param v            The vertex where the algorithm will compute the minimum
	 *                     path cost with all vertices of the graph.
	 * @param included     A boolean array to control which vertex is already
	 *                     included or visited before by the algorithm.
	 * @param distances    An aux double array of distances which the method uses to
	 *                     compute the minimum path costs.
	 * @param minDistances A double array which the method saves all the minimum
	 *                     path costs of the vertex v to all vertices of the graph.
	 * @param queue        A queue that the method uses to compute the minimum path
	 *                     costs.
	 * @return Returns the array minDistances. (The position that has the value 0.0
	 *         is the position of the vertex v which the method compute all the
	 *         minimum path costs.
	 */
	private double[] Dijkstra(GraphByMatrix<T, E> g, Vertex<T> v, boolean[] included, double[] distances, ArrayList<Double> minDistances, PriorityQueue<Node<T>> queue) {
		for (int i = 0; i < distances.length; i++) {
			distances[i] = Double.MAX_VALUE;
		}
		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();
		distances[index] = 0.0;
		queue.add(new Node<>(v, distances[index]));
		while (!queue.isEmpty()) {
			Node<T> u = queue.poll();
			int indexAux = g.getIndexVertex(u.getVertex().getValue());
			if (included[indexAux]) {
				u = queue.poll();
			}
			included[indexAux] = true;
			for (int i = 0; i < vertices.get(indexAux).getEdges().size(); i++) {
				int adj = g.getIndexVertex((T) vertices.get(indexAux).getEdges().get(i).getDestination().getValue());
				double weight = vertices.get(indexAux).getEdges().get(i).getCost();
				if (included[adj] == false) {
					relax(indexAux, adj, weight, distances, queue, g);
				}
			}
		}
		return distances;
	}

	// Dijkstra by graph by matrix.

	/**
	 * This method realize the algorithm Dijkstra. This method computes the minimum
	 * path cost of one vertex with all vertices of the graph.
	 * 
	 * @param g The graph.
	 * @param v The vertex where the method will compute all the minimum path costs
	 *          of this vertex to the all vertices of the graph.
	 * @return An array of distances where each position is the minimum path cost of
	 *         the vertex v with the vertex in the position of the distances
	 *         array.(The position that has the value 0.0 is the position of the
	 *         vertex v which the method compute all the minimum path costs.
	 */
	public double[] Dijkstra(GraphByMatrix<T, E> g, Vertex<T> v) {
		boolean[] included = new boolean[g.getVertices().size()];
		double[] distances = new double[g.getVertices().size()];
		PriorityQueue<Node<T>> queue = new PriorityQueue<>();
		ArrayList<Double> minDistances = new ArrayList<>();
		return Dijkstra(g, v, included, distances, minDistances, queue);
	}

	// Dijkstra by graph by matrix relax aux.

	/**
	 * This is an auxiliar method that helps the method Dijkstra. This method
	 * consist in modify the array of distances.
	 * 
	 * @param actual    The index of the actual vertex where the algorithm is
	 *                  working.
	 * @param adj       The adjacent vertex of actual vertex.
	 * @param weight    The edge weight between actual and adj vertices.
	 * @param distances An array of distance where each position represents the
	 *                  distance between each vertex to another vertex.
	 * @param queue     This queue controls the last distances of each vertex to
	 *                  another vertex.
	 * @param g         The graph.
	 */
	private void relax(int actual, int adj, double weight, double[] distances, PriorityQueue<Node<T>> queue, GraphByLists<T, E> g) {
		if (distances[actual] + weight < distances[adj]) {
			distances[adj] = distances[actual] + weight;
			queue.add(new Node<T>(g.getVertices().get(adj), distances[adj]));
		}
	}

	// Dijkstra by graph by matrix aux.

	/**
	 * This method realize the algorithm Dijkstra. This method computes the minimum
	 * path cost of one vertex with all vertices of the graph. This is the aux
	 * method.
	 * 
	 * @param g            The graph.
	 * @param v            The vertex where the algorithm will compute the minimum
	 *                     path cost with all vertices of the graph.
	 * @param included     A boolean array to control which vertex is already
	 *                     included or visited before by the algorithm.
	 * @param distances    An aux double array of distances which the method uses to
	 *                     compute the minimum path costs.
	 * @param minDistances A double array which the method saves all the minimum
	 *                     path costs of the vertex v to all vertices of the graph.
	 * @param queue        A queue that the method uses to compute the minimum path
	 *                     costs.
	 * @return Returns the array minDistances. (The position that has the value 0.0
	 *         is the position of the vertex v which the method compute all the
	 *         minimum path costs.
	 */
	private double[] Dijkstra(GraphByLists<T, E> g, Vertex<T> v, boolean[] included, double[] distances, ArrayList<Double> minDistances, PriorityQueue<Node<T>> queue) {
		for (int i = 0; i < distances.length; i++) {
			distances[i] = Double.MAX_VALUE;
		}
		int index = g.getIndexVertex(v.getValue());
		ArrayList<Vertex<T>> vertices = g.getVertices();
		distances[index] = 0.0;
		queue.add(new Node<>(v, distances[index]));
		while (!queue.isEmpty()) {
			Node<T> u = queue.poll();
			int indexAux = g.getIndexVertex(u.getVertex().getValue());
			if (included[indexAux]) {
				u = queue.poll();
			}
			included[indexAux] = true;
			for (int i = 0; i < vertices.get(indexAux).getEdges().size(); i++) {
				int adj = g.getIndexVertex((T) vertices.get(indexAux).getEdges().get(i).getDestination().getValue());
				double weight = vertices.get(indexAux).getEdges().get(i).getCost();
				if (included[adj] == false) {
					relax(indexAux, adj, weight, distances, queue, g);
				}
			}
		}
		return distances;
	}

	// Dijkstra by graph by matrix.

	/**
	 * This method realize the algorithm Dijkstra. This method computes the minimum
	 * path cost of one vertex with all vertices of the graph.
	 * 
	 * @param g The graph.
	 * @param v The vertex where the method will compute all the minimum path costs
	 *          of this vertex to the all vertices of the graph.
	 * @return An array of distances where each position is the minimum path cost of
	 *         the vertex v with the vertex in the position of the distances
	 *         array.(The position that has the value 0.0 is the position of the
	 *         vertex v which the method compute all the minimum path costs.
	 */
	public double[] Dijkstra(GraphByLists<T, E> g, Vertex<T> v) {
		boolean[] included = new boolean[g.getVertices().size()];
		double[] distances = new double[g.getVertices().size()];
		PriorityQueue<Node<T>> queue = new PriorityQueue<>();
		ArrayList<Double> minDistances = new ArrayList<>();
		return Dijkstra(g, v, included, distances, minDistances, queue);
	}

	// Floyd-Warshall by graph by matrix aux.

	/**
	 * This method realize the Floyd-Warshall algorithm. This method computes the
	 * minimum path cost of all vertices to the all vertices of the graph. (This is
	 * the aux method).
	 * 
	 * @param g        The graph.
	 * @param matrixFW A matrix where the method will save all the minimum path
	 *                 costs of each vertex with another vertex.
	 * @return Returns the matrix with all the minimum path costs of each vertex
	 *         with another vertex.
	 */
	private double[][] floydWarshall(GraphByMatrix<T, E> g, double[][] matrixFW) {
		// Refill the matrix in all positions except when i == j with the value
		// "infinite"
		for (int i = 0; i < matrixFW.length; i++) {
			for (int j = 0; j < matrixFW[0].length; j++) {
				if (i != j) {
					matrixFW[i][j] = Double.MAX_VALUE;
				}
			}
		}
		// Refill the matrix with all shortest path of each adjacent vertex.
		for (int i = 0; i < g.getVertices().size(); i++) {
			for (int j = 0; j < g.getVertices().get(i).getEdges().size(); j++) {
				int index = g.getIndexVertex((T) g.getVertices().get(i).getEdges().get(j).getDestination().getValue());
				if (matrixFW[i][index] != Double.MAX_VALUE) {
					if (matrixFW[i][index] > g.getVertices().get(i).getEdges().get(j).getCost()) {
						matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();
					}
				} else {
					matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();
				}
			}
		}
		for (int k = 0; k < matrixFW.length; k++) {
			for (int i = 0; i < matrixFW.length; i++) {
				for (int j = 0; j < matrixFW.length; j++) {
					matrixFW[i][j] = Math.min(matrixFW[i][j], matrixFW[i][k] + matrixFW[k][j]);
				}
			}
		}
		return matrixFW;
	}

	// Floyd-Warshall by graph by matrix.

	/**
	 * This method realize the Floyd-Warshall algorithm. This method computes the
	 * minimum path cost of all vertices to the all vertices of the graph.
	 * 
	 * @param g The graph.
	 * @return A matrix that has all the minimum path cost of each vertex with
	 *         another vertex.
	 */
	public double[][] floydWarshall(GraphByMatrix<T, E> g) {
		double[][] matrixFW = new double[g.getVertices().size()][g.getVertices().size()];
		return floydWarshall(g, matrixFW);
	}

	// Floyd-Warshall by graph by lists aux.
	/**
	 * This method realize the Floyd-Warshall algorithm. This method computes the
	 * minimum path cost of all vertices to the all vertices of the graph. (This is
	 * the aux method).
	 * 
	 * @param g        The graph.
	 * @param matrixFW A matrix where the method will save all the minimum path
	 *                 costs of each vertex with another vertex.
	 * @return Returns the matrix with all the minimum path costs of each vertex
	 *         with another vertex.
	 */
	private double[][] floydWarshall(GraphByLists<T, E> g, double[][] matrixFW) {
		// Refill the matrix in all positions except when i == j with the value
		// "infinite"
		for (int i = 0; i < matrixFW.length; i++) {
			for (int j = 0; j < matrixFW[0].length; j++) {
				if (i != j) {
					matrixFW[i][j] = Double.MAX_VALUE;
				}
			}
		}
		// Refill the matrix with all shortest path of each adjacent vertex.
		for (int i = 0; i < g.getVertices().size(); i++) {
			for (int j = 0; j < g.getVertices().get(i).getEdges().size(); j++) {
				int index = g.getIndexVertex((T) g.getVertices().get(i).getEdges().get(j).getDestination().getValue());
				if (matrixFW[i][index] != Double.MAX_VALUE) {
					if (matrixFW[i][index] > g.getVertices().get(i).getEdges().get(j).getCost()) {
						matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();
					}
				} else {
					matrixFW[i][index] = g.getVertices().get(i).getEdges().get(j).getCost();
				}
			}
		}
		for (int k = 0; k < matrixFW.length; k++) {
			for (int i = 0; i < matrixFW.length; i++) {
				for (int j = 0; j < matrixFW.length; j++) {
					matrixFW[i][j] = Math.min(matrixFW[i][j], matrixFW[i][k] + matrixFW[k][j]);
				}
			}
		}
		return matrixFW;
	}

	// Floyd-Warshall by graph by lists.

	/**
	 * This method realize the Floyd-Warshall algorithm. This method computes the
	 * minimum path cost of all vertices to the all vertices of the graph.
	 * 
	 * @param g The graph.
	 * @return A matrix that has all the minimum path cost of each vertex with
	 *         another vertex.
	 */
	public double[][] floydWarshall(GraphByLists<T, E> g) {
		double[][] matrixFW = new double[g.getVertices().size()][g.getVertices().size()];
		return floydWarshall(g, matrixFW);
	}

	/**
	 * This is an aux method that helps the method kruskal. This method gets the
	 * real disjoin position of an exactly position.
	 * 
	 * @param disjoin The array of integers that save the value of each vertex.
	 * @param pos     The pos where the method will get the real disjoin position
	 *                according to the disjoin value in this position.
	 * @return The real disjoin value of a vertex.
	 */
	private int disjoinAuxVertex(int[] disjoin, int pos) {
		if (disjoin[pos] < 0) {
			return pos;
		} else {
			return disjoinAuxVertex(disjoin, disjoin[pos]);
		}
	}

	/**
	 * This method realize the kruskal algorithm. This method computes the minimum
	 * spanning tree of a graph.
	 * 
	 * @param g       The graph.
	 * @param disjoin An array where the method controls the value disjoin of each
	 *                vertex.
	 * @param edges   An arraylist of edges which the method uses to get the cheaper
	 *                edge.
	 * @return Returns the minimum spanning tree cost.
	 */
	private double kruskal(GraphByMatrix<T, E> g, int[] disjoin, ArrayList<Edge<E>> edges) {
		double minCost = 0.0;
		int edgesValidate = 0;
		for (int i = 0; i < disjoin.length; i++) {
			disjoin[i] = -1;
		}
		while (edgesValidate != g.getVertices().size() - 1) {
			Edge<E> aux = edges.remove(0);
			Vertex<T> ini = (Vertex<T>) aux.getFrom();
			Vertex<T> dest = (Vertex<T>) aux.getDestination();
			int posIni = g.getIndexVertex(ini.getValue());
			int posDest = g.getIndexVertex(dest.getValue());
			if ((disjoin[posIni] < 0) && (disjoin[posDest] < 0)) {
				disjoin[posDest] += disjoin[posIni];
				disjoin[posIni] = posDest;
				minCost += aux.getCost();
				edgesValidate++;
			} else {
				int disjoinFrom = disjoinAuxVertex(disjoin, posIni);
				int disjoinTo = disjoinAuxVertex(disjoin, posDest);
				if (disjoinFrom != disjoinTo) {
					int valueFrom = disjoin[disjoinFrom];
//					int valueTo = disjoin[disjoinTo];
					disjoin[disjoinTo] += valueFrom;
					disjoin[disjoinFrom] = disjoinTo;
					minCost += aux.getCost();
					edgesValidate++;
				}
			}
		}
		return minCost;
	}

	/**
	 * This method realize the kruskal algorithm. This method computes the minimum
	 * spanning tree of a graph.
	 * 
	 * @param g The graph.
	 * @return Returns the minimum spanning tree cost.
	 */
	public double kruskal(GraphByMatrix<T, E> g) {
		ArrayList<Edge<E>> edges = g.getEdges();
		int[] disjoin = new int[g.getVertices().size()];
		Collections.sort(edges);
		return kruskal(g, disjoin, edges);
	}

	/**
	 * This method realize the kruskal algorithm. This method computes the minimum
	 * spanning tree of a graph.
	 * 
	 * @param g       The graph.
	 * @param disjoin An array where the method controls the value disjoin of each
	 *                vertex.
	 * @param edges   An arraylist of edges which the method uses to get the cheaper
	 *                edge.
	 * @return Returns the minimum spanning tree cost.
	 */
	private double kruskal(GraphByLists<T, E> g, int[] disjoin, ArrayList<Edge<E>> edges) {
		double minCost = 0.0;
		int edgesValidate = 0;
		for (int i = 0; i < disjoin.length; i++) {
			disjoin[i] = -1;
		}
		while (edgesValidate != g.getVertices().size() - 1) {
			Edge<E> aux = edges.remove(0);
			Vertex<T> ini = (Vertex<T>) aux.getFrom();
			Vertex<T> dest = (Vertex<T>) aux.getDestination();
			int posIni = g.getIndexVertex(ini.getValue());
			int posDest = g.getIndexVertex(dest.getValue());
			if ((disjoin[posIni] < 0) && (disjoin[posDest] < 0)) {
				disjoin[posDest] += disjoin[posIni];
				disjoin[posIni] = posDest;
				minCost += aux.getCost();
				edgesValidate++;
			} else {
				int disjoinFrom = disjoinAuxVertex(disjoin, posIni);
				int disjoinTo = disjoinAuxVertex(disjoin, posDest);
				if (disjoinFrom != disjoinTo) {
					int valueFrom = disjoin[disjoinFrom];
//					int valueTo = disjoin[disjoinTo];
					disjoin[disjoinTo] += valueFrom;
					disjoin[disjoinFrom] = disjoinTo;
					minCost += aux.getCost();
					edgesValidate++;
				}
			}
		}
		return minCost;
	}

	/**
	 * This method realize the kruskal algorithm. This method computes the minimum
	 * spanning tree of a graph.
	 * 
	 * @param g The graph.
	 * @return Returns the minimum spanning tree cost.
	 */
	public double kruskal(GraphByLists<T, E> g) {
		ArrayList<Edge<E>> edges = g.getEdges();
		int[] disjoin = new int[g.getVertices().size()];
		Collections.sort(edges);
		return kruskal(g, disjoin, edges);
	}

	/**
	 * This method identify which vertex has the cheaper cost. (This is an aux
	 * method to compute prim and djikstra algorithms).
	 * 
	 * @param costs   The costs of each vertex.
	 * @param visited A boolean array to controls which vertex is already visited.
	 * @return Returns the index which the array costs has the cheaper cost.
	 */
	private int indexMinimumCost(double[] costs, boolean[] visited) {
		int indexAux = 0;
		double[] costsCopy = new double[costs.length];
		for (int i = 0; i < costs.length; i++) {
			costsCopy[i] = costs[i];
		}
		for (int i = 0; i < visited.length; i++) {
			if (visited[i]) {
				costsCopy[i] = Integer.MAX_VALUE;
			}
		}
		double min = costsCopy[0];
		for (int i = 1; i < costs.length; i++) {
			if (costsCopy[i] < min) {
				min = costsCopy[i];
				indexAux = i;
			}
		}
		return indexAux;
	}

	/**
	 * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree cost of a graph.
	 * 
	 * @param g        The graph.
	 * @param ini      The vertex where the method will start the algorithm.
	 * @param vertices The vertices of the graph.
	 * @param visited  A boolean array to controls which vertex is already visited.
	 * @param costs    An array of costs where the method saves the cheaper costs of
	 *                 the edges of the graph.
	 * @param paths    An array to get the path of the prim algorithm.
	 * @param visits   An integer to control how many vertex are already visited.
	 * @param start    The index where the method will start the algorithm.
	 * @param cost     The cost of the minimum spanning tree.
	 * @param initial  The index of the vertex ini.
	 * @return Returns the cost of the minimum spanning tree.
	 */
	private double prim(GraphByMatrix<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited, double[] costs, int[] paths, int visits, int start, double cost, int initial) {
		if (visits == vertices.size()) {
			for (int i = 0; i < costs.length; i++) {
				if (i != initial) {
					cost += costs[i];
				}
			}
			return cost;
		}
		visited[start] = true;
		visits += 1;
		Vertex<T> actual = ini;
		if (visits <= vertices.size()) {
			int indexActual = g.getIndexVertex(actual.getValue());
			for (int i = 0; i < actual.getEdges().size(); i++) {
				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {
					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual.getEdges().get(i).getCost()) {
						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;
					}
				}
			}
			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;
			return prim(g, ini, vertices, visited, costs, paths, visits, start, cost, initial);
		}
		return cost;
	}

	/**
	 * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree cost of a graph.
	 * 
	 * @param g   The graph.
	 * @param ini The vertex where the method will start the algorithm.
	 * @return Returns the cost of the minimum spanning tree.
	 */
	public double prim(GraphByMatrix<T, E> g, Vertex<T> ini) {
		ArrayList<Vertex<T>> vertices = g.getVertices();
		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;
		// Refill costs
		for (int i = 0; i < costs.length; i++) {
			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < paths.length; i++) {
			paths[i] = -1;
		}
		return prim(g, ini, vertices, visited, costs, paths, visits, start, cost, initial);
	}

	/**
	 * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree cost of a graph.
	 * 
	 * @param g        The graph.
	 * @param ini      The vertex where the method will start the algorithm.
	 * @param vertices The vertices of the graph.
	 * @param visited  A boolean array to controls which vertex is already visited.
	 * @param costs    An array of costs where the method saves the cheaper costs of
	 *                 the edges of the graph.
	 * @param paths    An array to get the path of the prim algorithm.
	 * @param visits   An integer to control how many vertex are already visited.
	 * @param start    The index where the method will start the algorithm.
	 * @param cost     The cost of the minimum spanning tree.
	 * @param initial  The index of the vertex ini.
	 * @return Returns the cost of the minimum spanning tree.
	 */
	private double prim(GraphByLists<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited, double[] costs, int[] paths, int visits, int start, double cost, int initial) {
		if (visits == vertices.size()) {
			for (int i = 0; i < costs.length; i++) {
				if (i != initial) {
					cost += costs[i];
				}
			}
			return cost;
		}
		visited[start] = true;
		visits += 1;
		Vertex<T> actual = ini;
		if (visits <= vertices.size()) {
			int indexActual = g.getIndexVertex(actual.getValue());
			for (int i = 0; i < actual.getEdges().size(); i++) {
				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {
					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual.getEdges().get(i).getCost()) {
						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;
					}
				}
			}
			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;
			return prim(g, ini, vertices, visited, costs, paths, visits, min, cost, initial);
		}
		return cost;
	}

	/**
	 * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree cost of a graph.
	 * 
	 * @param g   The graph.
	 * @param ini The vertex where the method will start the algorithm.
	 * @return Returns the cost of the minimum spanning tree.
	 */
	public double prim(GraphByLists<T, E> g, Vertex<T> ini) {
		ArrayList<Vertex<T>> vertices = g.getVertices();
		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;
		// Refill costs
		for (int i = 0; i < costs.length; i++) {
			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < paths.length; i++) {
			paths[i] = -1;
		}
		return prim(g, ini, vertices, visited, costs, paths, visits, start, cost, initial);
	}

	/**
	 * This method does the Dijkstra algorithm but gets the path of one vertex to
	 * all the vertices of the graph.
	 * 
	 * @param g          The graph.
	 * @param ini        The vertex where the method will start the algorithm.
	 * @param vertices   The vertices of the graph.
	 * @param visited    A boolean array to controls if a vertex is already visited
	 *                   or not.
	 * @param costs      An array of costs where the method will change with the
	 *                   edges cheaper costs from one vertex to another vertex.
	 * @param vertexPath The array that contains the path of one vertex to each
	 *                   vertex.
	 * @param path       The object Path that will save the array vertexPath.
	 * @param visits     An integer to control how many visits the method has done.
	 * @param start      An integer where the method start the algorithm.
	 * @return Returns an object of type Path.
	 */
	private Path<T, E> dijkstra(GraphByMatrix<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
			double[] costs, int[] vertexPath, Path<T, E> path, int visits, int start) {
		if (visits == vertices.size()) {
			return path;
		}
		visited[start] = true;
		visits += 1;
		Vertex<T> actual = ini;
		if (visits <= vertices.size()) {
			int indexActual = g.getIndexVertex(actual.getValue());
			for (int i = 0; i < actual.getEdges().size(); i++) {
				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {
					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > costs[indexActual] + actual.getEdges().get(i).getCost()) {
						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = costs[indexActual] + actual.getEdges().get(i).getCost();
						vertexPath[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;
					}
				}
			}
			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;
			return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);
		}
		return path;
	}

	/**
	 * This method does the Dijkstra algorithm but gets the path of one vertex to
	 * all the vertices of the graph.
	 * 
	 * @param g   The graph.
	 * @param ini The vertex where the method will start the algorithm.
	 * @return Returns an object of type Path.
	 */
	public Path<T, E> dijkstra(GraphByMatrix<T, E> g, Vertex<T> ini) {
		ArrayList<Vertex<T>> vertices = g.getVertices();
		double[] costs = new double[g.getVertices().size()];
		boolean[] visited = new boolean[g.getVertices().size()];
		int[] vertexPath = new int[g.getVertices().size()];
		int start = g.getIndexVertex(ini.getValue());
		int visits = 0;
		Path<T, E> path = new Path<>(null, g, vertexPath);
		for (int i = 0; i < costs.length; i++) {
			if (i != start) {
				costs[i] = Double.MAX_VALUE;
			}
		}
		for (int i = 0; i < vertexPath.length; i++) {
			vertexPath[i] = -1;
		}
		return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);
	}

	/**
	 * This method does the Dijkstra algorithm but gets the path of one vertex to
	 * all the vertices of the graph.
	 * 
	 * @param g          The graph.
	 * @param ini        The vertex where the method will start the algorithm.
	 * @param vertices   The vertices of the graph.
	 * @param visited    A boolean array to controls if a vertex is already visited
	 *                   or not.
	 * @param costs      An array of costs where the method will change with the
	 *                   edges cheaper costs from one vertex to another vertex.
	 * @param vertexPath The array that contains the path of one vertex to each
	 *                   vertex.
	 * @param path       The object Path that will save the array vertexPath.
	 * @param visits     An integer to control how many visits the method has done.
	 * @param start      An integer where the method start the algorithm.
	 * @return Returns an object of type Path.
	 */
	private Path<T, E> dijkstra(GraphByLists<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited, double[] costs, int[] vertexPath, Path<T, E> path, int visits, int start) {
		if (visits == vertices.size()) {
			return path;
		}
		visited[start] = true;
		visits += 1;
		Vertex<T> actual = ini;
		if (visits <= vertices.size()) {
			int indexActual = g.getIndexVertex(actual.getValue());
			for (int i = 0; i < actual.getEdges().size(); i++) {
				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {
					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > costs[indexActual] + actual.getEdges().get(i).getCost()) {
						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = costs[indexActual] + actual.getEdges().get(i).getCost();
						vertexPath[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;
					}
				}
			}
			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;
			return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);
		}
		return path;
	}

	/**
	 * This method does the Dijkstra algorithm but gets the path of one vertex to
	 * all the vertices of the graph.
	 * 
	 * @param g   The graph.
	 * @param ini The vertex where the method will start the algorithm.
	 * @return Returns an object of type Path.
	 */
	public Path<T, E> dijkstra(GraphByLists<T, E> g, Vertex<T> ini) {
		ArrayList<Vertex<T>> vertices = g.getVertices();
		double[] costs = new double[g.getVertices().size()];
		boolean[] visited = new boolean[g.getVertices().size()];
		int[] vertexPath = new int[g.getVertices().size()];
		int start = g.getIndexVertex(ini.getValue());
		int visits = 0;
		Path<T, E> path = new Path<>(g, null, vertexPath);
		for (int i = 0; i < costs.length; i++) {
			if (i != start) {
				costs[i] = Double.MAX_VALUE;
			}
		}
		for (int i = 0; i < vertexPath.length; i++) {
			vertexPath[i] = -1;
		}
		return dijkstra(g, ini, vertices, visited, costs, vertexPath, path, visits, start);
	}

	/**
	 * 
	 * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree path of a graph.
	 * 
	 * @param g        The graph.
	 * @param ini      The vertex where the method will start the algorithm.
	 * @param vertices The vertices of the graph.
	 * @param visited  A boolean array to controls which vertex is already visited.
	 * @param costs    An array of costs where the method saves the cheaper costs of
	 *                 the edges of the graph.
	 * @param paths    An array to get the path of the prim algorithm.
	 * @param visits   An integer to control how many vertex are already visited.
	 * @param start    The index where the method will start the algorithm.
	 * @param cost     The cost of the minimum spanning tree.
	 * @param initial  The index of the vertex ini.
	 * @param pathO    The object Path that contains the path of the minimum
	 *                 spanning tree.
	 * @return Returns the Object Path.
	 */
	private Path<T, E> primP(GraphByMatrix<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
		double[] costs, int[] paths, int visits, int start, double cost, int initial, Path<T, E> pathO) {
		if (visits == vertices.size()) {
			return pathO;
		}
		visited[start] = true;
		visits += 1;
		Vertex<T> actual = ini;
		if (visits <= vertices.size()) {
			int indexActual = g.getIndexVertex(actual.getValue());
			for (int i = 0; i < actual.getEdges().size(); i++) {
				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {
					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual
							.getEdges().get(i).getCost()) {
						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual
								.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;
					}
				}
			}
			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;
			return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);
		}
		return pathO;
	}

	/**
	 * * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree path of a graph.
	 * 
	 * @param g   The graph.
	 * @param ini The vertex where the method will start the algorithm.
	 * @return Return an object of Path type.
	 */
	public Path<T, E> primP(GraphByMatrix<T, E> g, Vertex<T> ini) {
		ArrayList<Vertex<T>> vertices = g.getVertices();
		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;
		Path<T, E> pathO = new Path<>(null, g, paths);
		// Refill costs
		for (int i = 0; i < costs.length; i++) {
			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < paths.length; i++) {
			paths[i] = -1;
		}
		return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);
	}

	/**
	 * 
	 * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree path of a graph.
	 * 
	 * @param g        The graph.
	 * @param ini      The vertex where the method will start the algorithm.
	 * @param vertices The vertices of the graph.
	 * @param visited  A boolean array to controls which vertex is already visited.
	 * @param costs    An array of costs where the method saves the cheaper costs of
	 *                 the edges of the graph.
	 * @param paths    An array to get the path of the prim algorithm.
	 * @param visits   An integer to control how many vertex are already visited.
	 * @param start    The index where the method will start the algorithm.
	 * @param cost     The cost of the minimum spanning tree.
	 * @param initial  The index of the vertex ini.
	 * @param pathO    The object Path that contains the path of the minimum
	 *                 spanning tree.
	 * @return Returns the Object Path.
	 */
	private Path<T, E> primP(GraphByLists<T, E> g, Vertex<T> ini, ArrayList<Vertex<T>> vertices, boolean[] visited,
		double[] costs, int[] paths, int visits, int start, double cost, int initial, Path<T, E> pathO) {
		if (visits == vertices.size()) {
			return pathO;
		}
		visited[start] = true;
		visits += 1;
		Vertex<T> actual = ini;
		if (visits <= vertices.size()) {
			int indexActual = g.getIndexVertex(actual.getValue());
			for (int i = 0; i < actual.getEdges().size(); i++) {
				if (!visited[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())]) {
					if (costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] > actual
							.getEdges().get(i).getCost()) {
						costs[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = actual
								.getEdges().get(i).getCost();
						paths[g.getIndexVertex((T) actual.getEdges().get(i).getDestination().getValue())] = indexActual;
					}
				}
			}
			int min = indexMinimumCost(costs, visited);
			ini = g.getVertices().get(min);
			start = min;
			return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);
		}
		return pathO;
	}

	/**
	 * * This method realize the prim algorithm in a graph. This method computes the
	 * minimum spanning tree path of a graph.
	 * 
	 * @param g   The graph.
	 * @param ini The vertex where the method will start the algorithm.
	 * @return Return an object of Path type.
	 */
	public Path<T, E> primP(GraphByLists<T, E> g, Vertex<T> ini) {
		ArrayList<Vertex<T>> vertices = g.getVertices();
		boolean[] visited = new boolean[vertices.size()];
		double[] costs = new double[vertices.size()];
		int[] paths = new int[vertices.size()];
		int visits = 0;
		int start = g.getIndexVertex(ini.getValue());
		double cost = 0.0;
		int initial = start;
		Path<T, E> pathO = new Path<>(g, null, paths);
		// Refill costs
		for (int i = 0; i < costs.length; i++) {
			if (i != start) {
				costs[i] = Integer.MAX_VALUE;
			}
		}
		for (int i = 0; i < paths.length; i++) {
			paths[i] = -1;
		}
		return primP(g, ini, vertices, visited, costs, paths, visits, start, cost, initial, pathO);
	}

	public String stringPath(GraphByLists<T,E> g, Vertex<T> from, Vertex<T> destination) {
		MethodsGraphs<T, E> m = new MethodsGraphs<>();
		ArrayList<Vertex<T>> path = m.dijkstra(g, from).creatingPath(from, destination);
		String pathTxt = "";
		for (int i = 0; i < path.size() - 1; i++) {
			Vertex<T> a = path.get(i);
			Vertex<T> b = path.get(i + 1);
			pathTxt += a.toString() + " -- " + g.edgesBetween(a.getValue(), b.getValue()) + " --> " + b.toString()
					+ "\n";
		}
		return pathTxt;
	}
	

}