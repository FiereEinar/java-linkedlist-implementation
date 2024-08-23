package linkedlist;

import node.Node;

public class LinkedList {
	public Node head;
	public Node tail;
	
	private int length;
	
	public LinkedList() {
		this.head = null;
		this.tail = null;
		this.length = 0;
	}
	
	public int length() {
		return this.length;
	}
	
	public String toString() {
		String output = "";
		
		Node current = this.head;
		
		while (current != null) {
			output += "(" + current.data + ") -> ";
			current = current.next;
		}
		
		output += "(null)";
		
		return output;
	}
	
	/**
	 * Appends an item at the end of the list
	 */
	public void append(int data) {
		// if its the first item to be inserted, add it directly to the head
		if (this.head == null) {
			this.head = new Node(data);
			this.tail = this.head;
			this.length++;
			return;
		}
		
		// otherwise go to the tail and add it there
		this.tail.next = new Node(data);
		this.tail = this.tail.next;
		this.length++;
	}
	
	/**
	 * Appends an item at the front of the list
	 */
	public void prepend(int data) {
		// if its the first item to be inserted, add it directly to the head
		if (this.head == null) {
			this.head = new Node(data);
			this.tail = this.head;
			this.length++;
			return;
		}
		
		// otherwise, we need to create a new Node and set that as the head
		
		// but first we need to keep a pointer to the previous head
		Node prev = this.head;
		this.head = new Node(data);
		
		// so the we can attach the previous head next to the new head
		this.head.next = prev;
		this.length++;
	}
	
	/**
	 * Inserts an item at a given index, 
	 * Indexing starts at 1
	 */
	public Boolean insertAt(int index, int data) {
		// if the given index is out of bounds, we can't proceed
		if (index <= 0 || index > this.length + 1) return false;
		
		// if they try to insert it at first, we need to do the same logic on prepend method
		if (index == 1) {
			this.prepend(data);
			return true;
		}
		
		// otherwise, we need to traverse the Node before the given index
		Node current = this.head;
		int i = 1;
		
		while (i != index - 1) {
			current = current.next;
			i++;
		}
		
		// the (current.next) is where the item will be inserted
		// so we keep a pointer to it so it doesn't disappear when we write the inserted data into it
		Node prev = current.next;
		
		// insert the data
		current.next = new Node(data);
		
		// after that we attach the previous items back
		current = current.next;
		current.next = prev;
		
		// if the inserted item is at the end, set the tail pointer to it
		if (index == this.length + 1) {
			this.tail = current;
		}
		
		this.length++;
		
		return true;
	}
	
	/**
	 * Removes an item at the end
	 */
	public void popBack() {
		if (this.head == null) return;
		
		Node current = this.head;
		
		// if there's only 1 item, then just set the head and tail to null
		if (this.length == 1) {
			this.head = null;
			this.tail = null;
			this.length--;
			return;
		}
		
		// otherwise, traverse the Node before the tail
		while (current.next.next != null) {
			current = current.next;
		}
		
		// the current.next will then be the tail
		
		// so we simply just overwrite the current.next to point to null
		current.next = null;
		this.tail = current;
		
		this.length--;
	}
	
	/**
	 * Removes an item at the front
	 */
	public void popFront() {
		if (this.head == null) return;
		
		// if there's only 1 item
		if (this.head.next == null) {
			this.head = null;
			this.tail = null;
			this.length--;
			return;
		}
		
		// simply shift the head pointer to point to the next item
		this.head = this.head.next;
		this.length--;
	}
	
	/**
	 * Deletes an item at a given index
	 */
	public Boolean deleteAt(int index) {
		// if out of bounds, we can't proceed
		if (index <= 0 || index > this.length) return false;
		
		// if removing the first item, simply call the popFront method
		if (index == 1) {
			this.popFront();
			return true;
		}
		
		// traverse the Node before the deleted item
		Node current = this.head;
		int i = 1;
		
		while (i != index - 1) {
			current = current.next;
			i++;
		}
		
		// the item to delete is (current.next)
		// we keep a pointer to items next to it so we don't loose it
		Node deletedNext = current.next.next;
		
		// simply overwrite the deleted item to point to the item next to it
		current.next = deletedNext;
		
		// this the deleted item was the tail, set a new tail
		if (deletedNext == null) {
			this.tail = current;
		}
		
		this.length--;
		
		return true;
	}
	
	/**
	 * Checks if an item exists
	 */
	public Boolean contains(int data) {
		Node current = this.head;
		
		while (current != null) {
			if (current.data == data) return true;
			current = current.next;
		}
		
		return false;
	}
	
	/**
	 * Finds the index of an item, returns -1 if not found
	 * Indexing starts at 1
	 */
	public int find(int data) {
		Node current = this.head;
		int i = 1;
		
		while (current != null) {
			if (current.data == data) return i;
			current = current.next;
			i++;
		}
		
		return -1;
		
	}
}
