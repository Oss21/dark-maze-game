package model;

public class Path implements Comparable<Path> {


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
