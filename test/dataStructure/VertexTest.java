package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VertexTest {


	Vertex<String> vertex;
		
	private void setupEscenary1() {
		vertex = new Vertex<String>("V1");
	}
	
	
	private void setupEsceanry2() {
		vertex = new Vertex<String>("V2");
	}
	
	
	
		
	@Test
	public void checkGetValue() {
		
		setupEscenary1();
		assertEquals("V1", vertex.getValue());
		
		setupEsceanry2();
		assertEquals("V2", vertex.getValue());
	}

	
	@Test
	public void checkCompareTo() {
		setupEscenary1();
		Vertex v = new Vertex<String>("V1");
		Vertex v1 = new Vertex<String> ("V2");
		Vertex v2 = new Vertex<String> ("V0");
		assertEquals(0, vertex.compareTo(v));
		assertEquals(-1, vertex.compareTo(v1));
		assertEquals(-1, vertex.compareTo(v2));
		
		
	}

}
