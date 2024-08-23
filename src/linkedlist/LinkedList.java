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
	
	public void append(int data) {
		if (this.head == null) {
			this.head = new Node(data);
			this.tail = this.head;
			this.length++;
			return;
		}
		
		this.tail.next = new Node(data);
		this.tail = this.tail.next;
		this.length++;
	}
	
	public void prepend(int data) {
		if (this.head == null) {
			this.head = new Node(data);
			this.tail = this.head;
			this.length++;
			return;
		}
		
		Node prev = this.head;
		this.head = new Node(data);
		this.head.next = prev;
		this.length++;
	}
	
	public Boolean insertAt(int index, int data) {
		if (index <= 0 || index > this.length + 1) return false;
		
		if (index == 1) {
			Node prev = this.head;
			this.head = new Node(data);
			this.head.next = prev;
			
			this.length++;
			return true;
		}
		
		Node current = this.head;
		int i = 1;
		
		while (i != index - 1) {
			current = current.next;
			i++;
		}
		
		Node prev = current.next;
		current.next = new Node(data);
		current = current.next;
		current.next = prev;
		
		this.length++;
		
		return true;
	}
}
