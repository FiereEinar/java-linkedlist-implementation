package main;

import linkedlist.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		list.append(0);
		list.append(1);
		list.append(2);
		
		System.out.println(list.toString());		// (0) -> (1) -> (2) -> (null)
		
		list.prepend(3);
		
		System.out.println(list.toString());		// (3) -> (0) -> (1) -> (2) -> (null)
		
		System.out.println(list.length());			// 4
		System.out.println(list.insertAt(1, 4));	// true
		System.out.println(list.length());			// 5

		System.out.println(list.toString());		// (4) -> (3) -> (0) -> (1) -> (2) -> (null)
	}

}
