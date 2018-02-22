package com.graph.java;

public class TestGraph {

	public static void main(String[] args) {
		
		Graph graph = new Graph(5);
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		
		graph.addEdge(0, 1);
		graph.addEdge(0, 4);
		graph.addEdge(1, 2);
		graph.addEdge(1, 4);
		graph.addEdge(2, 3);
		graph.addEdge(3, 4);
		
		graph.displayVertices();
		graph.displayAdjacencyMatrix();

	}

}
