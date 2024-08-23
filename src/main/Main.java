package main;

import linkedlist.LinkedList;

public class Main {

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		
		System.out.println("\nAppending 3 items");
		list.append(0);
		list.append(1);
		list.append(2);
		
		System.out.println(list.toString());					// (0) -> (1) -> (2) -> (null)
		
		System.out.println("\nPrepending 1 item");
		list.prepend(3);
		
		System.out.println("Length: " + list.length());			// 4
		System.out.println(list.toString());					// (3) -> (0) -> (1) -> (2) -> (null)
		
		System.out.println("\nInserting 4 at position 1");
		System.out.println(list.insertAt(1, 4));				// true

		System.out.println("Length: " + list.length());			// 5
		System.out.println(list.toString());					// (4) -> (3) -> (0) -> (1) -> (2) -> (null)

		System.out.println("\nRemoving item at the end");
		list.popBack();
		
		System.out.println("Length: " + list.length());			// 4
		System.out.println(list.toString());					// (4) -> (3) -> (0) -> (1) -> (null)
		
		System.out.println("\nRemoving item at the front");
		list.popFront();
		
		System.out.println("Length: " + list.length());			// 3
		System.out.println(list.toString());					// (3) -> (0) -> (1) -> (null)
		
		System.out.println("\nAppending 3 items");
		list.append(2);
		list.append(3);
		list.append(4);
		
		System.out.println("Length: " + list.length());			// 6
		System.out.println(list.toString());					// (3) -> (0) -> (1) -> (2) -> (3) -> (4) -> (null)
		
		System.out.println("\nRemoving item at position 1");
		list.deleteAt(1);
		
		System.out.println("Length: " + list.length());			// 5
		System.out.println(list.toString());					// (0) -> (1) -> (2) -> (3) -> (4) -> (null)
		
		System.out.println("\nRemoving item at position 3");
		list.deleteAt(3);
		
		System.out.println("Length: " + list.length());			// 4
		System.out.println(list.toString());					// (0) -> (1) -> (3) -> (4) -> (null)
		
		System.out.println("\nRemoving item at position 4 (end)");
		list.deleteAt(4);
		
		System.out.println("Length: " + list.length());			// 3
		System.out.println(list.toString());					// (0) -> (1) -> (3) -> (null)
		
		System.out.println("\nAppending an item to check if tail still has correct pointer");
		list.append(6);
		
		System.out.println("Length: " + list.length());			// 4
		System.out.println(list.toString());					// (0) -> (1) -> (3) -> (6) -> (null)
		
		System.out.println("\nChecking if an item is in the list");
		System.out.println(list.toString());					// (0) -> (1) -> (3) -> (6) -> (null)
		System.out.println("List has 1 - " + list.contains(1));	// true
		System.out.println("List has 2 - " + list.contains(2));	// false
		
		System.out.println("\nFinding the index of an item");
		System.out.println(list.toString());					// (0) -> (1) -> (3) -> (6) -> (null)
		System.out.println("Idx of 1 - " + list.find(1));		// 2
		System.out.println("Idx of 2 - " + list.find(2));		// -1
	}

}
