package dataStructure;

/**
 * This class represents an edge of a graph. 
 * 
 *
 * @param <E> The edge type.
 */
public class Edge<E extends Comparable<E>> implements Comparable<Edge<E>> {

	/**
	 * The value E that the edge will contain.
	 */
	private E value;
	
	/**
	 * The edge cost.
	 */
	private double cost;
	
	/**
	 * A variable to identify if the edge is directed or not.
	 */
	private boolean directed;
	
	/**
	 * The vertex where the edge begins.
	 */
	private Vertex<?> from;
	
	/**
	 * The vertex where the edge ends.
	 */
	private Vertex<?> destination;

	/**
	 * A constructor of an edge.
	 * @param directed Identify if the edge is directed or not. (True = directed) (False = Undirected)
	 * @param cost The edge cost.
	 * @param value The edge value.
	 */
	public Edge(boolean directed, double cost, E value) {

		this.value = value;
		this.cost = cost;
		this.directed = directed;

	}

	/**
	 * A constructor of an edge.
	 * @param from The vertex where the edge begins.
	 * @param destination The vertex where the edge ends.
	 * @param cost The edge cost.
	 * @param directed Identify if the edge is directed or not (False = Undirected) (True = Directed).
	 * @param value The edge value.
	 */
	public Edge(Vertex<?> from, Vertex<?> destination, double cost, boolean directed, E value) {

		this.from = from;
		this.destination = destination;
		this.value = value;
		this.cost = cost;
		this.directed = directed;

	}

	/**
	 * Method to get the vertex where the edge begins.
	 * @return Returns the vertex where the edge begins.
	 */
	public Vertex<?> getFrom() {
		return from;
	}

	/**
	 * Method to modify the vertex where edge begins.
	 * @param from The new vertex that will replace the current vertex.
	 */
	public void setFrom(Vertex<?> from) {
		this.from = from;
	}

	/**
	 * Method to get the vertex where the edge ends.
	 * @return Returns the vertex where the edge ends.
	 */
	public Vertex<?> getDestination() {
		return destination;
	}

	/**
	 * Method to modify the vertex where the edge ends.
	 * @param destination The new vertex that will replace the current vertex.
	 */
	public void setDestination(Vertex<?> destination) {
		this.destination = destination;
	}

	/**
	 * Method to get the value that the edge represents.
	 * @return Returns the value of the edge.
	 */
	public E getValue() {
		return value;
	}

	/**
	 * Method to modify value of the edge.
	 * @param value The new value.
	 */
	public void setName(E value) {
		this.value = value;
	}

	/**
	 * Method to get if the edge is directed or undirected.
	 * @return Returns True if the edge is directed or false is the edge is undirected.
	 */
	public boolean isDirected() {
		return directed;
	}

	/**
	 * Method to modify the edge direction.
	 * @param directed The new direction of the edge.
	 */
	public void setDirected(boolean directed) {
		this.directed = directed;
	}

	/**
	 * Method to get the edge cost.
	 * @return Returns the cost of the edge.
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Modify the cost of the edge.
	 * @param cost The new cost of the edge.
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	
	@Override
	public int compareTo(Edge<E> e) {

		int x = 0;

		if (this.cost - e.cost < 0) {

			x = -1;

		} else if (this.cost - e.cost > 0) {

			x = 1;

		}

		return x;

	}

	@Override
	public String toString() {

		return ""+ cost;

	}

}
