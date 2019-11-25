package dataStructure;

/**
 * An aux class that helps the method Dijkstra.
 * 
 * 
 *
 * @param <T> The type of this class.
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

	/**
	 * The vertex that the node will have.
	 */
	private Vertex<T> vertex;

	/**
	 * The cost of this node.
	 */
	private Double cost;

	/**
	 * A constructor to create a Node.
	 * 
	 * @param vertex The vertex.
	 * @param cost   The cost of this node.
	 */
	public Node(Vertex<T> vertex, Double cost) {

		this.vertex = vertex;
		this.cost = cost;

	}

	/**
	 * Gets the vertex that this node represents.
	 * 
	 * @return Returns the vertex that the node represents.
	 */
	public Vertex<T> getVertex() {
		return vertex;
	}

	/**
	 * Modify the current vertex by another one.
	 * 
	 * @param vertex The new vertex.
	 */
	public void setVertex(Vertex<T> vertex) {
		this.vertex = vertex;
	}

	/**
	 * Gets the cost of the node.
	 * 
	 * @return Returns the cost of the node.
	 */
	public Double getCost() {
		return cost;
	}

	/**
	 * Modify the current cost of the node by another one.
	 * 
	 * @param cost The new cost of the node.
	 */
	public void setCost(Double cost) {
		this.cost = cost;
	}

	@Override
	public int compareTo(Node<T> n) {

		int value = 0;

		if (this.cost <= n.cost) {

			value = -1;

		} else {

			value = 1;

		}

		return value;

	}

}
