package model;

import java.io.Serializable;

/**
 * It is the class that represents a path in the maze.
 */
public class Path implements Comparable<Path>, Serializable{

	/**
	 * Represents the type of trail.
	 */
	public enum PathType {PATH,WALL,HOLE,LAKE,QUICKSAND}

	/**
	 * Represents the numerical value that the path takes.
	 */
	private int value;
	
	/**
	 * It is the type of the path.
	 */
	private PathType pathType;

	/**
	 * Create a path
	 * @param value - It is the value of the path.
	 * @param pathType - It is the type of the path.
	 */
	public Path (int value, PathType pathType) {

		this.value = value;
		this.pathType = pathType;
	}

	/**
	 * Returns the value of the path.
	 */
	public int getValue() {
		return value;
	}

	/**
	 * Change the value of the path.
	 * @param value - The new value.
	 */
	public void setValue(int value) {
		this.value = value;
	}

	/**
	 * Returns the type of the path.
	 */
	public PathType getPathType() {
		return pathType;
	}

	/**
	 * Change the type of the path.
	 * @param pathType - The new type. 
	 */
	public void setPathType(PathType pathType) {
		this.pathType = pathType;
	}


	/**
	 * Compare two paths
	 */
	@Override
	public int compareTo(Path otherPath) {
		return (int)(this.value-otherPath.getValue());
	}



}
