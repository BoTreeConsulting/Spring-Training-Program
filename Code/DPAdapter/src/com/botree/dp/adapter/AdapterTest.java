package com.botree.dp.adapter;

public class AdapterTest {
	
	public static void main(String[] args) {
		ListToStackAdapter stack = new ListToStackAdapter();
		stack.push(10);
		stack.push(20);
		stack.push(30);
		stack.push(40);
		stack.push(50);
		stack.push(60);
		System.out.println("Top => " + stack.top());
		System.out.println("Popped Element => " + stack.pop());
		System.out.println("Top => " + stack.top());
		System.out.println("Popped Element => " + stack.pop());
		System.out.println("Popped Element => " + stack.pop());
		System.out.println("Top => " + stack.top());
	}

}
