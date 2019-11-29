package model;

import static org.junit.jupiter.api.Assertions.*;

import java.io.IOException;

import org.junit.jupiter.api.Test;

class MazeTest {

	
	String[][] matriz =  {{"#","-","#"},{"#","-","-"},{"#","#","#"}};
	Maze maze ;
	private void setupEscenary1() {
		
		
	}
	
	
	private void setupEscenary2() {
		maze = new Maze(true);
	}
	
	
	
	@Test
	public void checkFillMatrix() throws IOException {
		maze.fillMatrix();
		
		assertTrue(CompareFileWithArray.assertEqualsCompareFileWithArrangement(maze.getMatriz(), "resourses/data/laberinto_1.csv"));
	}
	
	
	
	
}
