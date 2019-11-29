package dataStructure;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import model.Path;
import model.Path.PathType;

class GraphByMatrixTest {

	private Path path;
	private Path p1;
	private Path p2;
	private Path p3;
	private Path p4;
	private Path p5;
	private Path p6;
	private Path p7;
	private Path p8;
	private GraphByMatrix<Path, Double> graphByMatrix;
	
	
	/**
	 *  This is a stage of a directed graph and unweighted
	 */
	private	void setupEscenary1() {
		graphByMatrix = new GraphByMatrix<Path, Double>(3);		
		
		//Path type objects
		p1 = new Path(PathType.PATH,"1", false);
		p2 = new Path(PathType.PATH, "2", false);
		p3 = new Path(PathType.PATH, "3", false);
		
		// The vertices were added to the list of vertices
		graphByMatrix.addVertex(p1);
		graphByMatrix.addVertex(p2);
		graphByMatrix.addVertex(p3);
		

		// Graph edges are added.
		graphByMatrix.addEdge(p1, p2, true, 1, 1.0);
		graphByMatrix.addEdge(p2, p3, true, 1, 1.0);
		graphByMatrix.addEdge(p3, p1, true, 1, 1.0);
	
	}
	
	
	
	/**
	 * This is a stage of an unaddressed graph
	 */
	private	void setupEscenary2() {
		graphByMatrix = new GraphByMatrix<Path, Double>(3);		
		
		//Path type objects
		p1 = new Path(PathType.HOLE, "1", false);
		p2 = new Path(PathType.LAKE, "2", false);
		p3 = new Path(PathType.PATH, "3", false);
		
		// The vertices were added to the list of vertices
		graphByMatrix.addVertex(p1);
		graphByMatrix.addVertex(p2);
		graphByMatrix.addVertex(p3);
		

		//From to p1 to p2,p3
		graphByMatrix.addEdge(p1, p2, false, 5, 5.0);
		graphByMatrix.addEdge(p1, p3,false, 4, 4.0);
		//From to p2 to p1,p3
		graphByMatrix.addEdge(p2, p1, false, 5, 5.0);
		graphByMatrix.addEdge(p2, p3, false, 3, 3.0);
		//From to p3 to p1 to p2
		graphByMatrix.addEdge(p3, p1, false, 4, 4.0); 
		graphByMatrix.addEdge(p3, p2, false, 3, 3.0); 

		
	}
	
	/**
	 * Empty Stage
	 */
	private void setupEscenary3() {
		graphByMatrix = new GraphByMatrix<Path, Double>(4);
	}
	
	/**
	 * This is a stage of a directed graph and weighted
	 */
	private void setupEscenary4() {
		graphByMatrix = new GraphByMatrix<Path, Double>(3);		
		
		//Path type objects
		p1 = new Path(PathType.HOLE, "1", false);
		p2 = new Path(PathType.LAKE, "2", false);
		p3 = new Path(PathType.PATH, "9", false);

		// The vertices were added to the list of vertices
		graphByMatrix.addVertex(p1);

		graphByMatrix.addVertex(p2);
	
		graphByMatrix.addVertex(p3);
		
		//From to p1 to p2
		graphByMatrix.addEdge(p1, p2, true,5,5.0);
		//From to p2 to p3
		graphByMatrix.addEdge(p2, p3, true, 3, 3.0);
		//From to p3 to p1 to p2
		graphByMatrix.addEdge(p3, p1, false, 4, 4.0); 
		
		
	}
	
	/**
	 *  Stage of a weighted and directed graph.
	 */
	private void setupEscenary5(int size) {
		
		graphByMatrix = new GraphByMatrix<Path, Double>(size);		
		
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
		graphByMatrix.addVertex(p1);
		graphByMatrix.addVertex(p2);
		graphByMatrix.addVertex(p3);
		graphByMatrix.addVertex(p4);
		graphByMatrix.addVertex(p5);
		graphByMatrix.addVertex(p6);
		graphByMatrix.addVertex(p7);
		graphByMatrix.addVertex(p8);
		
		//From to p1 to p2,p3
		graphByMatrix.addEdge(p1, p2,false,3,3.0);
		graphByMatrix.addEdge(p1, p3, true,6,6.0);
		//From to p2 to p3
		graphByMatrix.addEdge(p2, p3, true, 5, 5.0);
		//From to p3 to p4
		graphByMatrix.addEdge(p3, p4, false, 3, 3.0); 
		//From to p4 to p1,p2,p5 
		graphByMatrix.addEdge(p4, p1,true, 7, 7.0); 
		graphByMatrix.addEdge(p4, p2,true, 1, 1.0); 
		graphByMatrix.addEdge(p4, p5,true, 3, 3.0); 
		//From to p5 to p7,p8 
		graphByMatrix.addEdge(p5, p7,true, 14, 14.0); 
		graphByMatrix.addEdge(p5, p8,true, 8, 8.0); 
		//From to p6 to p7 
		graphByMatrix.addEdge(p6, p7,false, 2, 2.0); 
		//From to p7 to p8 
		graphByMatrix.addEdge(p7, p8,true, 4, 4.0); 
		//From to p8.
	}
	
	
	
	
	/**
	 * Verify that the get Index Vertex 
	 * method returns the index where the vertex is stored in the vertex list.
	 */
	@Test
	public void checkgetIndexOfVertex() {
		setupEscenary1();
		//
		assertEquals(0, graphByMatrix.getIndexVertex(p1));
		assertEquals(1, graphByMatrix.getIndexVertex(p2));
		assertEquals(2, graphByMatrix.getIndexVertex(p3));
		
		setupEscenary5(8);
		assertEquals(6, graphByMatrix.getIndexVertex(p7));
		
	}
	
	
	/**
	 * Verify that the addEdge method 
	 * correctly adds a directed and weighted edge to the graph
	 */
	@Test
	public void checkAddEdge() {
		setupEscenary3();
		Path p4 = new Path(PathType.HOLE,"4", false);
		Path p5 = new Path(PathType.HOLE,"5", false);
		Path p20 = new Path(PathType.HOLE,"20", false);
		
		// The vertices were added to the list of vertices
		graphByMatrix.addVertex(p4);
		graphByMatrix.addVertex(p5);
		graphByMatrix.addVertex(p20);
		//From p4 to p5
		graphByMatrix.addEdge(p4, p5, true, 2, 2.0);
		//From p5 to p20			
		graphByMatrix.addEdge(p5, p20, true, 23, 23.0);

		assertEquals(2, graphByMatrix.getEdges().size());
		
		Path p10 = new Path(PathType.HOLE,"10", false);
		Path p11 = new Path(PathType.HOLE,"11", false);
		Path p12 = new Path(PathType.HOLE,"12", false);
		
		setupEscenary5(11);
		// The vertices were added to the list of vertices
		graphByMatrix.addVertex(p10);
		graphByMatrix.addVertex(p11);
		graphByMatrix.addVertex(p12);
		
		graphByMatrix.addEdge(p10, p11, true, 2, 2.0);
		graphByMatrix.addEdge(p12, p11, true, 4, 4.0);
		
		assertEquals(13,graphByMatrix.getEdges().size());
		assertEquals(11, graphByMatrix.getNumVertex());
		
		
	}
	
	/**
	 * Verify that the is Adjacent
	 * method returns a Boolean if two vertices are adjacent in the graph.
	 */
	@Test 
	public void checkIsAdjacent() {
		setupEscenary5(8);
		//p1 and p2
		assertTrue(graphByMatrix.isAdjacent(p1, p2)) ;
		//p1 and p4 are not adjacent
		assertTrue(graphByMatrix.isAdjacent(p1, p4)) ;
		setupEscenary2();
		//p1 and p2
		assertTrue(graphByMatrix.isAdjacent(p1, p2)) ;
		
		
	}
	
	
	/**
	 * Verify that the is Adjacent
	 * method returns a Boolean if two vertices are adjacent in the graph.
	 */
	@Test
	public void checkGetNumberOfVertices() {
		// The number of vertex are 8
		setupEscenary5(8);
		assertEquals(8, graphByMatrix.getNumVertex());
		
		// The number of vertex are 3
		setupEscenary4();
		assertEquals(3, graphByMatrix.getNumVertex());
		
		// The number of vertex are 3
		setupEscenary1();
		assertEquals(3, graphByMatrix.getNumVertex());
		
	}
	
	/**
	 * 
	 */
	@Test
	public void checkGetAdjList() {
	
		
		
	}
	
	
	@Test	
	public void checkEdgesBetween() {
		setupEscenary5(8);
		ArrayList<Edge<Double>> a = new ArrayList<Edge<Double>>();
		a.add(new Edge<Double>(false, 3.0, 3.0));
		a.add(new Edge<Double>(false, 6.0, 6.0));
		assertEquals(a.get(0).getValue(), graphByMatrix.edgesBetween(p1, p2).get(0).getValue());
		assertEquals(a.get(1).getValue(), graphByMatrix.edgesBetween(p1, p3).get(0).getValue());
	}
	
	
	
	
	
	
	

}
