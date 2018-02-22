package com.graph.java;

public class Vertex {
	
	public String vertexLabel;
	public boolean wasVisited;
	
	public Vertex(String vertexLabel) {
		this.vertexLabel = vertexLabel;
		this.wasVisited = false;
	}
}
