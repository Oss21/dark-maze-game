package dataStructure;

import java.util.ArrayList;

/**
 * This class represents a vertex of a graph.
 * 
 *
 * @param <T> The graph type.
 */
public class Vertex<T extends Comparable<T>> implements Comparable<Vertex<T>> {

	/**
	 * The value of the vertex.
	 */
	private T value;
	/**
	 * A edges list that the vertex have. 
	 */
	private ArrayList<Edge<?>> edges;

	/**
	 * A constructor to create a vertex.
	 * @param value The value of the vertex.
	 */
	public Vertex(T value) {
		this.value = value;
		edges = new ArrayList<>();

	}

	/**
	 * This method gets the edges of the vertex.
	 * @return Returns a list of edges of this vertex.
	 */
	public ArrayList<Edge<?>> getEdges() {
		return edges;
	}

	/**
	 * Modify the edges that this vertex have.
	 * @param edges The new list to replace the current.
	 */
	public void setEdges(ArrayList<Edge<?>> edges) {
		this.edges = edges;
	}

	/**
	 * The value of this vertex.
	 * @return Returns the value of this vertex.
	 */
	public T getValue() {
		return value;
	}

	/**
	 * Modify the value of this vertex.
	 * @param value The new value.
	 */
	public void setValue(T value) {
		this.value = value;
	}

	@Override
	public String toString() {

		return value.toString();

	}

	/**
	 * Method to verify if two vertices are equals.
	 * @param v The vertex to compare.
	 * @return A boolean variable where true means that the two vertices are equals.
	 */
	public boolean equals(Vertex<T> v) {

		return this.value == v.value;
	}

	@Override
	public int compareTo(Vertex<T> o) {

		if (this.equals(o))
			return 0;

		else
			return -1;

	}

}
