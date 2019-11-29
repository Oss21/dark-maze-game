package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.Test;

class MethodsGraphsTest {

	GraphByLists<Integer, Integer> graphList;
	GraphByMatrix<Integer, Integer> graphMatrix;
	MethodsGraphs<Integer, Integer> mG;

	public void setupEscenary1() {

		mG = new MethodsGraphs<>();
		graphList = new GraphByLists<>(5);
		Integer v1 = 13;
		Integer v2 = 8;
		Integer v3 = 9;
		Integer v4 = 21;
		Integer v5 = 5;

		graphList.addVertex(v1);
		graphList.addVertex(v2);
		graphList.addVertex(v3);
		graphList.addVertex(v4);
		graphList.addVertex(v5);

		graphList.addEdge(v1, v2, false, 5, 1);
		graphList.addEdge(v1, v4, false, 4, 2);
		graphList.addEdge(v1, v5, false, 2, 3);
		graphList.addEdge(v2, v3, false, 1, 4);
		graphList.addEdge(v3, v4, false, 4, 5);
		graphList.addEdge(v4, v5, false, 3, 6);

	}

	public void setupEscenary2() {

		mG = new MethodsGraphs<>();
		graphMatrix = new GraphByMatrix<>(5);
		Integer v1 = 13;
		Integer v2 = 8;
		Integer v3 = 9;
		Integer v4 = 21;
		Integer v5 = 5;

		graphMatrix.addVertex(v1);
		graphMatrix.addVertex(v2);
		graphMatrix.addVertex(v3);
		graphMatrix.addVertex(v4);
		graphMatrix.addVertex(v5);

		graphMatrix.addEdge(v1, v2, false, 5, 1);
		graphMatrix.addEdge(v1, v4, false, 4, 2);
		graphMatrix.addEdge(v1, v5, false, 2, 3);
		graphMatrix.addEdge(v2, v3, false, 1, 4);
		graphMatrix.addEdge(v3, v4, false, 4, 5);
		graphMatrix.addEdge(v4, v5, false, 3, 6);
	}

	public void setupEscenary3() {

		mG = new MethodsGraphs<>();
		graphList = new GraphByLists<>(5);
		Integer v1 = 13;
		Integer v2 = 8;
		Integer v3 = 9;
		Integer v4 = 21;
		Integer v5 = 5;

		graphList.addVertex(v1);
		graphList.addVertex(v2);
		graphList.addVertex(v3);
		graphList.addVertex(v4);
		graphList.addVertex(v5);

		graphList.addEdge(v1, v2, false, 5, 1);
		graphList.addEdge(v1, v4, false, 4, 2);
		graphList.addEdge(v1, v5, false, 2, 3);
		graphList.addEdge(v2, v3, false, 1, 4);
		graphList.addEdge(v4, v5, false, 3, 5);

	}

	public void setupEscenary4() {

		mG = new MethodsGraphs<>();
		graphMatrix = new GraphByMatrix<>(5);
		Integer v1 = 13;
		Integer v2 = 8;
		Integer v3 = 9;
		Integer v4 = 21;
		Integer v5 = 5;

		graphMatrix.addVertex(v1);
		graphMatrix.addVertex(v2);
		graphMatrix.addVertex(v3);
		graphMatrix.addVertex(v4);
		graphMatrix.addVertex(v5);

		graphMatrix.addEdge(v1, v2, false, 5, 1);
		graphMatrix.addEdge(v1, v4, false, 4, 2);
		graphMatrix.addEdge(v1, v5, false, 2, 3);
		graphMatrix.addEdge(v2, v3, false, 1, 4);
		graphMatrix.addEdge(v4, v5, false, 3, 5);

	}

	// Stage for checked the method prim in the GraphByMatrix
	public void setupEscenary5() {
		mG = new MethodsGraphs<>();
		graphMatrix = new GraphByMatrix<>(8);
		Integer v0 = 0;
		Integer v1 = 1;
		Integer v2 = 2;
		Integer v3 = 3;
		Integer v4 = 4;
		Integer v5 = 5;
		Integer v6 = 6;
		Integer v7 = 7;

		graphMatrix.addVertex(v0);
		graphMatrix.addVertex(v1);
		graphMatrix.addVertex(v2);
		graphMatrix.addVertex(v3);
		graphMatrix.addVertex(v4);
		graphMatrix.addVertex(v5);
		graphMatrix.addVertex(v6);
		graphMatrix.addVertex(v7);

		graphMatrix.addEdge(v0, v1, false, 1, 0);
		graphMatrix.addEdge(v0, v2, false, 5, 0);
		graphMatrix.addEdge(v1, v3, false, 3, 0);
		graphMatrix.addEdge(v1, v6, false, 5, 0);
		graphMatrix.addEdge(v2, v6, false, 6, 0);
		graphMatrix.addEdge(v3, v5, false, 2, 0);
		graphMatrix.addEdge(v3, v7, false, 7, 0);
		graphMatrix.addEdge(v7, v4, false, 9, 0);
		graphMatrix.addEdge(v6, v4, false, 5, 0);
	}

	// Stage for checked the method prim in the GraphByLists
	public void setupEscenary6() {

		mG = new MethodsGraphs<>();
		graphList = new GraphByLists<>(8);
		Integer v0 = 0;
		Integer v1 = 1;
		Integer v2 = 2;
		Integer v3 = 3;
		Integer v4 = 4;
		Integer v5 = 5;
		Integer v6 = 6;
		Integer v7 = 7;

		graphList.addVertex(v0);
		graphList.addVertex(v1);
		graphList.addVertex(v2);
		graphList.addVertex(v3);
		graphList.addVertex(v4);
		graphList.addVertex(v5);
		graphList.addVertex(v6);
		graphList.addVertex(v7);

		graphList.addEdge(v0, v1, false, 1, 0);
		graphList.addEdge(v0, v2, false, 5, 0);
		graphList.addEdge(v1, v3, false, 3, 0);
		graphList.addEdge(v1, v6, false, 5, 0);
		graphList.addEdge(v2, v6, false, 6, 0);
		graphList.addEdge(v3, v5, false, 2, 0);
		graphList.addEdge(v3, v7, false, 7, 0);
		graphList.addEdge(v7, v4, false, 9, 0);
		graphList.addEdge(v6, v4, false, 5, 0);

	}
	
	// Stage for checked the method kruskal in the GraphByMatrix
	public void setupEscenary7() {
		
		mG = new MethodsGraphs<>();
		graphMatrix = new GraphByMatrix<>(8);
		Integer v0 = 0;
		Integer v1 = 1;
		Integer v2 = 2;
		Integer v3 = 3;
		Integer v4 = 4;
		Integer v5 = 5;
		Integer v6 = 6;
		Integer v7 = 7;

		graphMatrix.addVertex(v0);
		graphMatrix.addVertex(v1);
		graphMatrix.addVertex(v2);
		graphMatrix.addVertex(v3);
		graphMatrix.addVertex(v4);
		graphMatrix.addVertex(v5);
		graphMatrix.addVertex(v6);
		graphMatrix.addVertex(v7);
		
		graphMatrix.addEdge(v0, v1, false, 4, 0);
		graphMatrix.addEdge(v0, v2, false, 9, 0);
		graphMatrix.addEdge(v1, v3, false, 7, 0);
		graphMatrix.addEdge(v1, v2, false, 7, 0);
		graphMatrix.addEdge(v1, v5, false, 4, 0);
		graphMatrix.addEdge(v1, v6, false, 2, 0);
		graphMatrix.addEdge(v2, v4, false, 6, 0);
		graphMatrix.addEdge(v2, v6, false, 7, 0);
		graphMatrix.addEdge(v3, v5, false, 9, 0);
		graphMatrix.addEdge(v3, v7, false, 6, 0);
		graphMatrix.addEdge(v4, v6, false, 3, 0);
		graphMatrix.addEdge(v5, v6, false, 2, 0);
		graphMatrix.addEdge(v6, v7, false, 2, 0);
	}
	
	
	// Stage for checked the method kruskal in the GraphByLists
	
	public void setupEscenary8() {
		
		mG = new MethodsGraphs<>();
		graphList = new GraphByLists<>(8);
		Integer v0 = 0;
		Integer v1 = 1;
		Integer v2 = 2;
		Integer v3 = 3;
		Integer v4 = 4;
		Integer v5 = 5;
		Integer v6 = 6;
		Integer v7 = 7;

		graphList.addVertex(v0);
		graphList.addVertex(v1);
		graphList.addVertex(v2);
		graphList.addVertex(v3);
		graphList.addVertex(v4);
		graphList.addVertex(v5);
		graphList.addVertex(v6);
		graphList.addVertex(v7);
		
		graphList.addEdge(v0, v1, false, 4, 0);
		graphList.addEdge(v0, v2, false, 9, 0);
		graphList.addEdge(v1, v3, false, 7, 0);
		graphList.addEdge(v1, v2, false, 7, 0);
		graphList.addEdge(v1, v5, false, 4, 0);
		graphList.addEdge(v1, v6, false, 2, 0);
		graphList.addEdge(v2, v4, false, 6, 0);
		graphList.addEdge(v2, v6, false, 7, 0);
		graphList.addEdge(v3, v5, false, 9, 0);
		graphList.addEdge(v3, v7, false, 6, 0);
		graphList.addEdge(v4, v6, false, 3, 0);
		graphList.addEdge(v5, v6, false, 2, 0);
		graphList.addEdge(v6, v7, false, 2, 0);
	}
		
	
	
	/**
	 * -------------------------------------------------------------------------------------------
	 * -------------------------------------------DFS---------------------------------------------
	 * -------------------------------------------------------------------------------------------
	 */
	// Test DFS for GraphByLists with the graph number one
		@Test
		public void testDFS() {
			setupEscenary1();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex3);
			arr.add(vertex4);
			arr.add(vertex5);

			assertEquals(vertex1.getValue(), mG.DFS(graphList, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.DFS(graphList, vertex1).get(1).getValue());
			assertEquals(vertex3.getValue(), mG.DFS(graphList, vertex1).get(2).getValue());
			assertEquals(vertex4.getValue(), mG.DFS(graphList, vertex1).get(3).getValue());
			assertEquals(vertex5.getValue(), mG.DFS(graphList, vertex1).get(4).getValue());

		}

		// Test DFS for GraphByLists with the graph number two
		@Test
		public void testDFSTwo() {
			setupEscenary3();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex3);
			arr.add(vertex4);
			arr.add(vertex5);

			assertEquals(vertex1.getValue(), mG.DFS(graphList, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.DFS(graphList, vertex1).get(1).getValue());
			assertEquals(vertex3.getValue(), mG.DFS(graphList, vertex1).get(2).getValue());
			assertEquals(vertex4.getValue(), mG.DFS(graphList, vertex1).get(3).getValue());
			assertEquals(vertex5.getValue(), mG.DFS(graphList, vertex1).get(4).getValue());

		}

		// Test DFS for GraphByMatrix with the graph number one
		@Test
		public void testDFSMatrix() {
			setupEscenary2();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex3);
			arr.add(vertex4);
			arr.add(vertex5);

			assertEquals(vertex1.getValue(), mG.DFS(graphMatrix, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.DFS(graphMatrix, vertex1).get(1).getValue());
			assertEquals(vertex3.getValue(), mG.DFS(graphMatrix, vertex1).get(2).getValue());
			assertEquals(vertex4.getValue(), mG.DFS(graphMatrix, vertex1).get(3).getValue());
			assertEquals(vertex5.getValue(), mG.DFS(graphMatrix, vertex1).get(4).getValue());

		}

		// Test DFS for GraphByMatrix with the graph number two
		@Test
		public void testDFSMatrixTwo() {
			setupEscenary4();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex3);
			arr.add(vertex4);
			arr.add(vertex5);

			assertEquals(vertex1.getValue(), mG.DFS(graphMatrix, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.DFS(graphMatrix, vertex1).get(1).getValue());
			assertEquals(vertex3.getValue(), mG.DFS(graphMatrix, vertex1).get(2).getValue());
			assertEquals(vertex4.getValue(), mG.DFS(graphMatrix, vertex1).get(3).getValue());
			assertEquals(vertex5.getValue(), mG.DFS(graphMatrix, vertex1).get(4).getValue());

		}
		/**
		 * -------------------------------------------------------------------------------------------
		 * -------------------------------------------BFS---------------------------------------------
		 * -------------------------------------------------------------------------------------------
		 */
		// Test BFS for GraphByLists with the graph number one
		@Test
		public void testBFS() {
			setupEscenary1();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex4);
			arr.add(vertex5);
			arr.add(vertex3);

			assertEquals(vertex1.getValue(), mG.BFS(graphList, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.BFS(graphList, vertex1).get(1).getValue());
			assertEquals(vertex4.getValue(), mG.BFS(graphList, vertex1).get(2).getValue());
			assertEquals(vertex5.getValue(), mG.BFS(graphList, vertex1).get(3).getValue());
			assertEquals(vertex3.getValue(), mG.BFS(graphList, vertex1).get(4).getValue());

		}

		// Test BFS for GraphByLists with the graph number two
		@Test
		public void testBFSTwo() {
			setupEscenary3();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex4);
			arr.add(vertex5);
			arr.add(vertex3);

			assertEquals(vertex1.getValue(), mG.BFS(graphList, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.BFS(graphList, vertex1).get(1).getValue());
			assertEquals(vertex4.getValue(), mG.BFS(graphList, vertex1).get(2).getValue());
			assertEquals(vertex5.getValue(), mG.BFS(graphList, vertex1).get(3).getValue());
			assertEquals(vertex3.getValue(), mG.BFS(graphList, vertex1).get(4).getValue());

		}

		// Test BFS for GraphByMatrix with the graph number one
		@Test
		public void testBFSMatrix() {
			setupEscenary2();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex4);
			arr.add(vertex5);
			arr.add(vertex3);

			assertEquals(vertex1.getValue(), mG.BFS(graphMatrix, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.BFS(graphMatrix, vertex1).get(1).getValue());
			assertEquals(vertex4.getValue(), mG.BFS(graphMatrix, vertex1).get(2).getValue());
			assertEquals(vertex5.getValue(), mG.BFS(graphMatrix, vertex1).get(3).getValue());
			assertEquals(vertex3.getValue(), mG.BFS(graphMatrix, vertex1).get(4).getValue());

		}

		// Test BFS for GraphByMatrix with the graph number two
		@Test
		public void testBFSMatrixTwo() {
			setupEscenary4();

			ArrayList<Vertex<Integer>> arr = new ArrayList<>();
			Integer v1 = 13;
			Integer v2 = 8;
			Integer v3 = 9;
			Integer v4 = 21;
			Integer v5 = 5;

			Vertex<Integer> vertex1 = new Vertex<>(v1);
			Vertex<Integer> vertex2 = new Vertex<>(v2);
			Vertex<Integer> vertex3 = new Vertex<>(v3);
			Vertex<Integer> vertex4 = new Vertex<>(v4);
			Vertex<Integer> vertex5 = new Vertex<>(v5);

			arr.add(vertex1);
			arr.add(vertex2);
			arr.add(vertex4);
			arr.add(vertex5);
			arr.add(vertex3);

			assertEquals(vertex1.getValue(), mG.BFS(graphMatrix, vertex1).get(0).getValue());
			assertEquals(vertex2.getValue(), mG.BFS(graphMatrix, vertex1).get(1).getValue());
			assertEquals(vertex4.getValue(), mG.BFS(graphMatrix, vertex1).get(2).getValue());
			assertEquals(vertex5.getValue(), mG.BFS(graphMatrix, vertex1).get(3).getValue());
			assertEquals(vertex3.getValue(), mG.BFS(graphMatrix, vertex1).get(4).getValue());

		}
		
		
		
		/**
		 * -------------------------------------------------------------------------------------------
		 * -------------------------------------------Dijkstra----------------------------------------
		 * -------------------------------------------------------------------------------------------
		 */
		
		
		
		// Test Dijkstra for GraphByLists with the graph number one
		@Test
		public void testDijkstra() {
			setupEscenary1();

			double v1 = 0.0;
			double v2 = 5.0;
			double v3 = 6.0;
			double v4 = 4.0;
			double v5 = 2.0;

			Integer ve1 = 13;

			Vertex<Integer> vert1 = new Vertex<>(ve1);

			assertEquals(v1, mG.Dijkstra(graphList, vert1)[0]);
			assertEquals(v2, mG.Dijkstra(graphList, vert1)[1]);
			assertEquals(v3, mG.Dijkstra(graphList, vert1)[2]);
			assertEquals(v4, mG.Dijkstra(graphList, vert1)[3]);
			assertEquals(v5, mG.Dijkstra(graphList, vert1)[4]);

		}

		// Test Dijkstra for GraphByLists with the graph number two
		@Test
		public void testDijkstraTwo() {
			setupEscenary3();

			double v1 = 0.0;
			double v2 = 5.0;
			double v3 = 6.0;
			double v4 = 4.0;
			double v5 = 2.0;

			Integer ve1 = 13;

			Vertex<Integer> vert1 = new Vertex<>(ve1);

			assertEquals(v1, mG.Dijkstra(graphList, vert1)[0]);
			assertEquals(v2, mG.Dijkstra(graphList, vert1)[1]);
			assertEquals(v3, mG.Dijkstra(graphList, vert1)[2]);
			assertEquals(v4, mG.Dijkstra(graphList, vert1)[3]);
			assertEquals(v5, mG.Dijkstra(graphList, vert1)[4]);

		}

		// Test Dijkstra for GraphByMatrix with the graph number one
		@Test
		public void testDijkstraMatrix() {
			setupEscenary2();

			double v1 = 0.0;
			double v2 = 5.0;
			double v3 = 6.0;
			double v4 = 4.0;
			double v5 = 2.0;

			Integer ve1 = 13;

			Vertex<Integer> vert1 = new Vertex<>(ve1);

			assertEquals(v1, mG.Dijkstra(graphMatrix, vert1)[0]);
			assertEquals(v2, mG.Dijkstra(graphMatrix, vert1)[1]);
			assertEquals(v3, mG.Dijkstra(graphMatrix, vert1)[2]);
			assertEquals(v4, mG.Dijkstra(graphMatrix, vert1)[3]);
			assertEquals(v5, mG.Dijkstra(graphMatrix, vert1)[4]);

		}

		// Test Dijkstra for GraphByMatrix with the graph number two
		@Test
		public void testDijkstraMatrixTwo() {
			setupEscenary4();

			double v1 = 0.0;
			double v2 = 5.0;
			double v3 = 6.0;
			double v4 = 4.0;
			double v5 = 2.0;

			Integer ve1 = 13;

			Vertex<Integer> vert1 = new Vertex<>(ve1);

			assertEquals(v1, mG.Dijkstra(graphMatrix, vert1)[0]);
			assertEquals(v2, mG.Dijkstra(graphMatrix, vert1)[1]);
			assertEquals(v3, mG.Dijkstra(graphMatrix, vert1)[2]);
			assertEquals(v4, mG.Dijkstra(graphMatrix, vert1)[3]);
			assertEquals(v5, mG.Dijkstra(graphMatrix, vert1)[4]);

		}

		/**
		 * -------------------------------------------------------------------------------------------
		 * -------------------------------------------FloydWarshall-----------------------------------
		 * -------------------------------------------------------------------------------------------
		 */
		
		
		// Test floydWarshall for GraphByLists with the graph number one
		@Test
		public void testFloydWarshall() {
			setupEscenary1();

			String fila1 = (Arrays.toString(mG.floydWarshall(graphList)[0]));
			String fila2 = (Arrays.toString(mG.floydWarshall(graphList)[1]));
			String fila3 = (Arrays.toString(mG.floydWarshall(graphList)[2]));
			String fila4 = (Arrays.toString(mG.floydWarshall(graphList)[3]));
			String fila5 = (Arrays.toString(mG.floydWarshall(graphList)[4]));

			String a = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(13)));
			String b = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(8)));
			String c = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(9)));
			String d = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(21)));
			String e = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(5)));

			assertEquals(fila1, a);
			assertEquals(fila2, b);
			assertEquals(fila3, c);
			assertEquals(fila4, d);
			assertEquals(fila5, e);
		}

		// Test floydWarshall for GraphByLists with the graph number two
		@Test
		public void testFloydWarshallTwo() {
			setupEscenary3();

			String fila1 = (Arrays.toString(mG.floydWarshall(graphList)[0]));
			String fila2 = (Arrays.toString(mG.floydWarshall(graphList)[1]));
			String fila3 = (Arrays.toString(mG.floydWarshall(graphList)[2]));
			String fila4 = (Arrays.toString(mG.floydWarshall(graphList)[3]));
			String fila5 = (Arrays.toString(mG.floydWarshall(graphList)[4]));

			String a = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(13)));
			String b = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(8)));
			String c = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(9)));
			String d = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(21)));
			String e = Arrays.toString(mG.Dijkstra(graphList, new Vertex<Integer>(5)));

			assertEquals(fila1, a);
			assertEquals(fila2, b);
			assertEquals(fila3, c);
			assertEquals(fila4, d);
			assertEquals(fila5, e);
		}

		
		// Test floydWarshall for GraphByMatrix with the graph number one
		@Test
		public void testFloydWarshallMatrix() {
			setupEscenary2();

			String fila1 = (Arrays.toString(mG.floydWarshall(graphMatrix)[0]));
			String fila2 = (Arrays.toString(mG.floydWarshall(graphMatrix)[1]));
			String fila3 = (Arrays.toString(mG.floydWarshall(graphMatrix)[2]));
			String fila4 = (Arrays.toString(mG.floydWarshall(graphMatrix)[3]));
			String fila5 = (Arrays.toString(mG.floydWarshall(graphMatrix)[4]));

			String a = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(13)));
			String b = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(8)));
			String c = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(9)));
			String d = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(21)));
			String e = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(5)));

			assertEquals(fila1, a);
			assertEquals(fila2, b);
			assertEquals(fila3, c);
			assertEquals(fila4, d);
			assertEquals(fila5, e);
		}

		// Test floydWarshall for GraphByMatrix with the graph number one
		@Test
		public void testFloydWarshallMatrixTwo() {
			setupEscenary4();

			String fila1 = (Arrays.toString(mG.floydWarshall(graphMatrix)[0]));
			String fila2 = (Arrays.toString(mG.floydWarshall(graphMatrix)[1]));
			String fila3 = (Arrays.toString(mG.floydWarshall(graphMatrix)[2]));
			String fila4 = (Arrays.toString(mG.floydWarshall(graphMatrix)[3]));
			String fila5 = (Arrays.toString(mG.floydWarshall(graphMatrix)[4]));

			String a = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(13)));
			String b = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(8)));
			String c = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(9)));
			String d = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(21)));
			String e = Arrays.toString(mG.Dijkstra(graphMatrix, new Vertex<Integer>(5)));

			assertEquals(fila1, a);
			assertEquals(fila2, b);
			assertEquals(fila3, c);
			assertEquals(fila4, d);
			assertEquals(fila5, e);
		}
		
		
		
		
		
	/**
	 * -------------------------------------------------------------------------------------------
	 * ---------------------------------------------PRIM------------------------------------------
	 * -------------------------------------------------------------------------------------------
	 */
		
		
	
		
		
		// Test prim for GraphByMatrix
		@Test
		public void testPrim() {

			setupEscenary5();

			assertEquals(28, mG.prim(graphMatrix, new Vertex<Integer>(0)));
		}
		
		//Test prim for GraphByLists
		@Test
		public void testPrimTwo() {
			
			setupEscenary6();
			
			assertEquals(28, mG.prim(graphList, new Vertex<Integer>(0)));
		}
		
		// Test Kruskal for GraphByMatrix
		@Test
		public void testKruskal() {
			
			setupEscenary7();
			
			assertEquals(25, mG.kruskal(graphMatrix));
		}
		
		
		// Test Kruskal for GraphByMatrix
		@Test
		public void testKruskalTwo() {
			
			setupEscenary8();
			
			assertEquals(25, mG.kruskal(graphList));
		}
	
}


