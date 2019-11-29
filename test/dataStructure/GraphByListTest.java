package dataStructure;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Path;
import model.Path.PathType;

class GraphByListTest {

	private Path path;
	private Path p1;
	private Path p2;
	private Path p3;
	private Path p4;
	private Path p5;
	private Path p6;
	private Path p7;
	private Path p8;
	private GraphByLists<Path, Double> graphByLists;
	
	
	/**
	 *  This is a stage of a directed graph and unweighted
	 */
	private	void setupEscenary1() {
		graphByLists = new GraphByLists<Path, Double>(3);		
		
		//Path type objects
		p1 = new Path(PathType.PATH,"1", false);
		p2 = new Path(PathType.PATH, "2", false);
		p3 = new Path(PathType.PATH, "3", false);
		
		// The vertices were added to the list of vertices
		graphByLists.addVertex(p1);
		graphByLists.addVertex(p2);
		graphByLists.addVertex(p3);
		

		// Graph edges are added.
		graphByLists.addEdge(p1, p2, true, 1, 1.0);
		graphByLists.addEdge(p2, p3, true, 1, 1.0);
		graphByLists.addEdge(p3, p1, true, 1, 1.0);
	
	}
	
	
	/**
	 * This is a stage of an unaddressed graph
	 */
	private	void setupEscenary2() {
		graphByLists = new GraphByLists<Path, Double>(3);		
		
		//Path type objects
		p1 = new Path(PathType.HOLE, "1", false);
		p2 = new Path(PathType.LAKE, "2", false);
		p3 = new Path(PathType.PATH, "3", false);
		
		// The vertices were added to the list of vertices
		graphByLists.addVertex(p1);
		graphByLists.addVertex(p2);
		graphByLists.addVertex(p3);
		

		//From to p1 to p2,p3
		graphByLists.addEdge(p1, p2, false, 5, 5.0);
		graphByLists.addEdge(p1, p3,false, 4, 4.0);
		//From to p2 to p1,p3
		graphByLists.addEdge(p2, p1, false, 5, 5.0);
		graphByLists.addEdge(p2, p3, false, 3, 3.0);
		//From to p3 to p1 to p2
		graphByLists.addEdge(p3, p1, false, 4, 4.0); 
		graphByLists.addEdge(p3, p2, false, 3, 3.0); 

		
	}
	
	/**
	 * Empty Stage
	 */
	private void setupEscenary3() {
		
	}
	
	/**
	 * This is a stage of a directed graph and weighted
	 */
	private void setupEscenary4() {
		graphByLists = new GraphByLists<Path, Double>(3);		
		
		//Path type objects
		p1 = new Path(PathType.HOLE, "1", false);
		p2 = new Path(PathType.LAKE, "2", false);
		p3 = new Path(PathType.PATH, "9", false);

		// The vertices were added to the list of vertices
		graphByLists.addVertex(p1);
		graphByLists.addVertex(p2);
		graphByLists.addVertex(p3);
		
		//From to p1 to p2
		graphByLists.addEdge(p1, p2, true,5,5.0);
		//From to p2 to p3
		graphByLists.addEdge(p2, p3, true, 3, 3.0);
		//From to p3 to p1 to p2
		graphByLists.addEdge(p3, p1, false, 4, 4.0); 
		
		
	}
	
	/**
	 *  Stage of a weighted and directed graph.
	 */
	private void setupEscenary5() {
		
		graphByLists = new GraphByLists<Path, Double>(8);		
		
		//Path type objects
		p1 = new Path(PathType.PATH, "1", false);
		p2 = new Path(PathType.QUICKSAND, "2", true);
		p3 = new Path(PathType.WALL, "3", false);
		p4 = new Path(PathType.HOLE, "4", true);
		p5 = new Path(PathType.QUICKSAND, "5", true);
		p6 = new Path(PathType.LAKE, "6", false);
		p7 = new Path(PathType.LAKE, "7", true);
		p8 = new Path(PathType.PATH, "8", false);
		
		// The vertices were added to the list of vertices
		graphByLists.addVertex(p1);
		graphByLists.addVertex(p2);
		graphByLists.addVertex(p3);
		graphByLists.addVertex(p4);
		graphByLists.addVertex(p5);
		graphByLists.addVertex(p6);
		graphByLists.addVertex(p7);
		graphByLists.addVertex(p8);
		
		//From to p1 to p2,p3
		graphByLists.addEdge(p1, p2,false,3,3.0);
		graphByLists.addEdge(p1, p3, true,6,6.0);
		//From to p2 to p3
		graphByLists.addEdge(p2, p3, true, 5, 5.0);
		//From to p3 to p4
		graphByLists.addEdge(p3, p4, false, 3, 3.0); 
		//From to p4 to p1,p2,p5 
		graphByLists.addEdge(p4, p1,true, 7, 7.0); 
		graphByLists.addEdge(p4, p2,true, 1, 1.0); 
		graphByLists.addEdge(p4, p5,true, 3, 3.0); 
		//From to p5 to p7,p8 
		graphByLists.addEdge(p5, p7,true, 14, 14.0); 
		graphByLists.addEdge(p5, p8,true, 8, 8.0); 
		//From to p6 to p7 
		graphByLists.addEdge(p6, p7,false, 2, 2.0); 
		//From to p7 to p8 
		graphByLists.addEdge(p7, p8,true, 4, 4.0); 
		//From to p8.
	}
	
	/**
	 *  Tree stage
	 */
	private void setupEscenary6() {
		graphByLists = new GraphByLists<Path, Double>(3);		
		
		//Path type objects
		p1 = new Path(PathType.LAKE, "1", false);
		p2 = new Path(PathType.LAKE, "2", false);
		p3 = new Path(PathType.LAKE, "3", false);

		// The vertices were added to the list of vertices
		graphByLists.addVertex(p1);
		graphByLists.addVertex(p2);
		graphByLists.addVertex(p3);
		
		//From to p1 to p2
		graphByLists.addEdge(p1, p2, false,1,1.0);
		//From to p2 to p1
		graphByLists.addEdge(p2, p1, false, 1, 1.0);
		//From to p3 to p1 
		graphByLists.addEdge(p3, p1, false, 1, 1.0); 
	}
	
	
	
	/**
	 * Verify that the get Index Vertex 
	 * method returns the index where the vertex is stored in the vertex list.
	 */
	@Test
	public void checkgetIndexOfVertex() {
		setupEscenary1();
		//
		assertEquals(0, graphByLists.getIndexVertex(p1));
		assertEquals(1, graphByLists.getIndexVertex(p2));
		assertEquals(2, graphByLists.getIndexVertex(p3));
		
		setupEscenary5();
		assertEquals(6, graphByLists.getIndexVertex(p7));
		
	}
	
	
	/**
	 * Verify that the addEdge method 
	 * correctly adds a directed and weighted edge to the graph
	 */
	@Test
	public void checkAddEdge() {
		setupEscenary4();
		Path p4 = new Path(PathType.HOLE,"4", false);
		Path p5 = new Path(PathType.HOLE,"5", false);
		Path p20 = new Path(PathType.HOLE,"20", false);
		
		// The vertices were added to the list of vertices
		graphByLists.addVertex(p4);
		graphByLists.addVertex(p5);
		graphByLists.addVertex(p20);
		
		//From p4 to p5
		graphByLists.addEdge(p4, p5, true, 2, 2.0);
		//From p5 to p20			
		graphByLists.addEdge(p5, p20, true, 23, 23.0);

		assertEquals(5, graphByLists.getEdges().size());
		
		Path p10 = new Path(PathType.HOLE,"10", false);
		Path p11 = new Path(PathType.HOLE,"11", false);
		Path p12 = new Path(PathType.HOLE,"12", false);
		
		setupEscenary5();
		// The vertices were added to the list of vertices
		graphByLists.addVertex(p10);
		graphByLists.addVertex(p11);
		graphByLists.addVertex(p12);
		
		graphByLists.addEdge(p10, p11, true, 2, 2.0);
		graphByLists.addEdge(p12, p11, true, 4, 4.0);
		
		assertEquals(13,graphByLists.getEdges().size());
		assertEquals(11, graphByLists.getNumVertex());
		
		
	}
	
	/**
	 * Verify that the is Adjacent
	 * method returns a Boolean if two vertices are adjacent in the graph.
	 */
	@Test 
	public void checkIsAdjacent() {
		setupEscenary5();
		//p1 and p2
		assertTrue(graphByLists.isAdjacent(p1, p2)) ;
		//p1 and p4 are not adjacent
		assertFalse(graphByLists.isAdjacent(p1, p4)) ;
		setupEscenary2();
		//p1 and p2
		assertTrue(graphByLists.isAdjacent(p1, p2)) ;
		
		
	}
	
	
	/**
	 * Verify that the is Adjacent
	 * method returns a Boolean if two vertices are adjacent in the graph.
	 */
	@Test
	public void checkGetNumberOfVertices() {
		// The number of vertex are 8
		setupEscenary5();
		assertEquals(8, graphByLists.getNumVertex());
		
		// The number of vertex are 3
		setupEscenary4();
		assertEquals(3, graphByLists.getNumVertex());
		
		// The number of vertex are 3
		setupEscenary1();
		assertEquals(3, graphByLists.getNumVertex());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void checkGetAdjList() {
		
		setupEscenary4();
		//From to p1 to p2
		assertEquals("2",graphByLists.getAdjList().get(0).get(0).getValue().getId());
	    //From to p2 to p3
		assertEquals("9",graphByLists.getAdjList().get(1).get(0).getValue().getId());	
		//From to p3 to p1 to p2
		assertEquals("1",graphByLists.getAdjList().get(2).get(0).getValue().getId());	
		
		
	}
	
	
	@Test	
	public void checkEdgesBetween() {
		setupEscenary5();
		ArrayList<Edge<Double>> a = new ArrayList<Edge<Double>>();
		a.add(new Edge<Double>(false, 3.0, 3.0));
		a.add(new Edge<Double>(false, 6.0, 6.0));
		assertEquals(a.get(0).getValue(), graphByLists.edgesBetween(p1, p2).get(0).getValue());
		assertEquals(a.get(1).getValue(), graphByLists.edgesBetween(p1, p3).get(0).getValue());
	}
	
	
	
	
}
