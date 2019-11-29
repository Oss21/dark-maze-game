package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import model.Path;
import model.Path.PathType;

class VertexTest {

	private Path p1;
	private Path p2;
	Edge<Double> e ;
	Vertex<?> vertex ;
	
	private void setupEscenary1() {
		
		e = new Edge<Double>(false, 1.0, 1.0);
	}
	
	private void setupEscenary2() {
		e = new Edge<Double>(true, 4.0, 4.0);

	}

	
	@Test
	public void checkMethodsGet() {
		setupEscenary1();
		assertEquals(false,e.isDirected());
		assertEquals(1.0, e.getCost());
		assertEquals(1.0, e.getValue());
		setupEscenary2();
		assertEquals(true,e.isDirected());
		assertEquals(4.0, e.getCost());
		assertEquals(4.0, e.getValue());
		
		
		
		
	}
	
	@Test
	public void checkMethodSet() {
		setupEscenary1();
		e.setDirected(true);		
		e.setCost(8.0);
		assertEquals(8.0, e.getCost());
		assertEquals(true, e.isDirected());
		setupEscenary2();
		assertEquals(true,e.isDirected());
		assertEquals(4.0, e.getCost());
		assertEquals(4.0, e.getValue());
	}
	
	
	


}
