package dataStructure;

import java.util.ArrayList;

/**
 * A class that represents a path.
 * 
 * 
 *
 * @param <T> The vertex type.
 * @param <E> The edge type.
 */
public class Path<T extends Comparable<T>, E extends Comparable<E>> implements Comparable<Path<T, E>> {

	/**
	 * The graph by lists that the path uses.
	 */
	private GraphByLists<T, E> list;

	/**
	 * The graph by matrix that the path uses.
	 */
	private GraphByMatrix<T, E> matrix;

	/**
	 * A list where this class make the path.
	 */
	private ArrayList<Vertex<T>> vertices;

	/**
	 * A integer array representation of each path of each vertex in the original
	 * graph vertices list. (The integers represents the postions of each vertices
	 * in the original graph)
	 */
	private int[] path;

	/**
	 * The constructor of a Path. (If you use a type of graph the other will be null
	 * !!!)
	 * 
	 * @param list   The graph the Path uses.
	 * @param matrix The graph that the path uses.
	 * @param path   The integers given by the method prim.
	 */
	public Path(GraphByLists<T, E> list, GraphByMatrix<T, E> matrix, int[] path) {

		this.list = list;
		this.matrix = matrix;
		this.path = path;
		vertices = new ArrayList<>();

	}

	/**
	 * A method to get the integers path.
	 * 
	 * @return Returns the array of this integers.
	 */
	public int[] getPath() {
		return path;
	}

	/**
	 * A method to modify the current integer path array.
	 * 
	 * @param path The new integer path array.
	 */
	public void setPath(int[] path) {
		this.path = path;
	}

	public ArrayList<Vertex<T>> getVertices() {
		return vertices;
	}

	public void setVertices(ArrayList<Vertex<T>> vertices) {
		this.vertices = vertices;
	}

	@Override
	public int compareTo(Path<T, E> o) {
		return 0;
	}

	/**
	 * A method that create the path from one vertex to another.
	 * 
	 * @param from        The vertex where the path starts.
	 * @param destination The vertex where the path ends.
	 * @return Returns a list in order that how the path should be done.
	 */
	public ArrayList<Vertex<T>> creatingPath(Vertex<T> from, Vertex<T> destination) {

		ArrayList<Vertex<T>> verticesDef = new ArrayList<>();
		ArrayList<Vertex<T>> r = new ArrayList<>();

		if (list != null) {

			int destIndex = list.getIndexVertex(destination.getValue());

			verticesDef.add(destination);

			while (path[destIndex] != -1) {

				verticesDef.add(list.getVertices().get(path[destIndex]));

				destIndex = path[destIndex];

			}
		}

		if (matrix != null) {

			int destIndex = matrix.getIndexVertex(destination.getValue());

			verticesDef.add(destination);

			while (path[destIndex] != -1) {

				verticesDef.add(matrix.getVertices().get(path[destIndex]));

				destIndex = path[destIndex];

			}

		}

		for (int i = verticesDef.size() - 1; i >= 0; i--) {

			r.add(verticesDef.get(i));

		}

		this.vertices = r;

		return r;

	}

	@Override

	public String toString() {

		String path = "";

		if (matrix == null) {

			for (int i = 0; i < vertices.size() - 1; i++) {

				Vertex<T> a = vertices.get(i);
				Vertex<T> b = vertices.get(i + 1);

				path += a.toString() + " -- " + list.edgesBetween(a.getValue(), b.getValue()) + "--> " + b.toString()
						+ "\n";

			}
		} else {

			for (int i = 0; i < vertices.size() - 1; i++) {

				Vertex<T> a = vertices.get(i);
				Vertex<T> b = vertices.get(i + 1);

				path += a.toString() + " -- " + matrix.edgesBetween(a.getValue(), b.getValue()) + "--> " + b.toString()
						+ "\n";

			}

		}

		return path;

	}

}
