package model;

import java.io.Serializable;

public class Path implements Comparable<Path>, Serializable{


	public enum PathType {PATH,WALL,HOLE,LAKE,QUICKSAND}

	private int value;
	private PathType pathType;


	public Path (int value, PathType pathType) {

		this.value = value;
		this.pathType = pathType;
	}



	@Override
	public int compareTo(Path o) {
		return 0;
	}


}
