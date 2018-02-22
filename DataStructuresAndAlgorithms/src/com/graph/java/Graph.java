package com.graph.java;

public class Graph {

	private final int maximumVertices;
	private Vertex[] vertexList;
	private int[][] adjacencyMatrix;
	private int vertexCount = 0;

	public Graph(int maxVertices) {

		maximumVertices = maxVertices;
		vertexList = new Vertex[maximumVertices];
		adjacencyMatrix = new int[maximumVertices][maximumVertices];
		initializeAdjacencyMatrix();
	}

	private void initializeAdjacencyMatrix() {

		for (int i = 0; i < maximumVertices; i++) {
			for (int j = 0; j < maximumVertices; j++) {
				adjacencyMatrix[i][j] = 0;
			}
		}
	}

	public void addVertex(String vertexLabel) {

		if (vertexCount != maximumVertices) {
			vertexList[vertexCount++] = new Vertex(vertexLabel);
		} else {
			System.out.println("Graph reaches its maximum capacity to add Vertex : " + vertexLabel);
			System.exit(0);
		}
	}

	public void addEdge(int start, int end) {
		adjacencyMatrix[start][end] = 1;
		adjacencyMatrix[end][start] = 1;
	}

	public void displayVertex(int vertexPosition) {
		System.out.println("Vertex:" + vertexList[vertexPosition].vertexLabel);
	}

	public void displayVertices() {

		for (int i = 0; i < maximumVertices; i++) {
			if (null != vertexList[i]) {
				System.out.println("Vertex " + i + ":" + vertexList[i].vertexLabel);
			}
		}
	}

	public void displayAdjacencyMatrix() {

		for (int i = 0; i < maximumVertices; i++) {
			System.out.print("AdjacencyList of Vertex : " + vertexList[i].vertexLabel +" --> ");
			for (int j = 0; j < maximumVertices; j++) {
				System.out.print(adjacencyMatrix[i][j]+" ");
			}
			System.out.println("");
		}
	}
}
