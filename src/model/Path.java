package model;

import java.io.Serializable;

/**
 * It is the class that represents a path in the maze.
 */
public class Path implements Comparable<Path>, Serializable{
	
	
	public static final double PATH_COST = 1.0;
	
	public static final double LAKE_COST = 2.0;
	
	public static final double HOLE_COST = 3.0;
	
	public static final double QUICKSAND_COST = 4.0;
	
	public static final double WALL_COST = 5.0;
	
	/**
	 * Represents the type of trail.
	 */
	public enum PathType {PATH,WALL,HOLE,LAKE,QUICKSAND}

	/**
	 * Represents the numerical value that the path takes.
	 */
	private double value;
	
	/**
	 * It is the type of the path.
	 */
	private PathType pathType;
	
	/**
	 * 
	 */
	private String id;
	
	/**
	 * 
	 */
	private boolean isPointLight;
	
	
	
	/**
	 * Create a path
	 * @param value - It is the value of the path.
	 * @param pathType - It is the type of the path.
	 */
	public Path (PathType pathType, String id, boolean isPointLight) {
		this.id = id;
		this.pathType = pathType;
		this.isPointLight = isPointLight;
		
		calculateValue();
	}

	
	
	/**
	 * Returns the value of the path.
	 */
	public double getValue() {
		return this.value;
	}

	/**
	 * Returns the type of the path.
	 */
	public PathType getPathType() {
		return this.pathType;
	}

	/**
	 * Change the type of the path.
	 * @param pathType - The new type. 
	 */
	public void setPathType(PathType pathType) {
		this.pathType = pathType;
	}
	
	/**
	 * 
	 */
	public boolean getIsPointLight() {
		return this.isPointLight;
	}
	
	/**
	 * 
	 */
	public String getId() {
		return this.id;
	}
	
	/**
	 * 
	 */
	private void calculateValue() {
		
		switch (this.pathType) {
			case PATH:
				this.value = PATH_COST;
				break;
				
			case LAKE:
				this.value = LAKE_COST;
				break;
				
			case HOLE:
				this.value = HOLE_COST;
				break;
				
			case QUICKSAND:
				this.value = QUICKSAND_COST;
				break;
				
			case WALL:
				this.value = WALL_COST;
				break;
		}
	}
	
	/**
	 * Compare two paths id
	 */
	@Override
	public int compareTo(Path o) {
		int value = 0;
		
		if (this.id.compareTo(o.id) == 0) {
			value = 0;
		}else if (this.id.compareTo(o.id) > 0) {
			value = 1;
		}else {
			value = -1;
		}
		return value;
	}
}
