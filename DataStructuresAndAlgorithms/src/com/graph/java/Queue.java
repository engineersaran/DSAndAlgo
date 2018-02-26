package com.graph.java;

public class Queue {

	private final int queueSize;
	private String[] queue;
	private int front = 0;
	private int rear = -1;

	public Queue(int size) {
		queueSize = size;
		queue = new String[queueSize];
	}

	public void insert(String itemToAdd) {
		queue[++rear] = itemToAdd;
	}

	public String remove() {
		String itemRemoved = null;
		itemRemoved = queue[front++];
		return itemRemoved;
	}

	public boolean isEmpty() {
		if (rear + 1 == front || front + queueSize - 1 == rear) {
			return true;
		}
		return false;
	}
}
