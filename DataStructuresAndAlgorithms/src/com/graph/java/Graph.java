package com.graph.java;

import java.util.Arrays;

public class Graph {

	private final int maximumVertices;
	private Vertex[] vertexList;
	private int[][] adjacencyMatrix;
	private int vertexCount = 0;
	private Stack stack;
	private Queue queue;

	public Graph(int maxVertices) {

		maximumVertices = maxVertices;
		vertexList = new Vertex[maximumVertices];
		adjacencyMatrix = new int[maximumVertices][maximumVertices];
		stack = new Stack(maximumVertices);
		queue = new Queue(maximumVertices);
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
			System.exit(-1);
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

	public void breadthFirstSearch() {

		vertexList[0].wasVisited = true;
		displayVertex(0);
		queue.insert(vertexList[0].vertexLabel);

		while (!queue.isEmpty()) {

			int unVisitedVertex = 0;
			String visitedVertex = queue.remove();
			while ((unVisitedVertex = getAdjUnvisitedVertex(visitedVertex)) != -1) {

				vertexList[unVisitedVertex].wasVisited = true;
				displayVertex(unVisitedVertex);
				queue.insert(vertexList[unVisitedVertex].vertexLabel);

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
