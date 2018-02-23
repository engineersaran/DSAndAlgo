package com.graph.java;

import java.util.Arrays;

public class Graph {

	private final int maximumVertices;
	private Vertex[] vertexList;
	private int[][] adjacencyMatrix;
	private int vertexCount = 0;
	private Stack stack;

	public Graph(int maxVertices) {

		maximumVertices = maxVertices;
		vertexList = new Vertex[maximumVertices];
		adjacencyMatrix = new int[maximumVertices][maximumVertices];
		stack = new Stack(maximumVertices);
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
			System.out.print("AdjacencyList of Vertex : " + vertexList[i].vertexLabel + " --> ");
			for (int j = 0; j < maximumVertices; j++) {
				System.out.print(adjacencyMatrix[i][j] + " ");
			}
			System.out.println("");
		}
	}

	public int getAdjUnvisitedVertex(String vertex) {

		int vertexIndex = searchVertex(vertex);
		for (int i = 0; i < maximumVertices; i++) {
			if (adjacencyMatrix[vertexIndex][i] == 1 && vertexList[i].wasVisited == false) {
				return i;
			}
		}
		return -1;
	}

	private int searchVertex(String vertex) {

		Vertex searchedVertex = Arrays.asList(vertexList).stream().filter(t -> t.vertexLabel.equals(vertex)).findFirst()
				.get();
		return Arrays.asList(vertexList).indexOf(searchedVertex);
	}

	public void depthFirstSearch() {

		vertexList[0].wasVisited = true;
		displayVertex(0);
		stack.push(vertexList[0].vertexLabel);

		while (!stack.isEmpty()) {
			int unVisitiedVertex = getAdjUnvisitedVertex(stack.peek());
			if (unVisitiedVertex == -1) {
				stack.pop();
			} else {

				vertexList[unVisitiedVertex].wasVisited = true;
				displayVertex(unVisitiedVertex);
				stack.push(vertexList[unVisitiedVertex].vertexLabel);
			}

		}

		resetVertices();
	}

	public void resetVertices() {
		for (int i = 0; i < maximumVertices; i++) {
			vertexList[i].wasVisited = false;
		}
	}
}
