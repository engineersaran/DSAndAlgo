package com.graph.java;

public class Stack {

	private final int stackSize;
	private String[] stack;
	private int top = -1;

	public Stack(int size) {
		stackSize = size;
		stack = new String[stackSize];
	}

	public void push(String itemToPush) {
		stack[++top] = itemToPush;
	}

	public String pop() {
		return stack[top--];
	}

	public String peek() {
		return stack[top];
	}

	public boolean isEmpty() {
		return (top == -1);
	}
}

