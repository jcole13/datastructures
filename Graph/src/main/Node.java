package main;

public class Node {
	//instance variables
	private Object data;
	private Node next, previous;//double linked list, knows what is before and after
	//constructors
	public Node() {
		data = null;
		next = null;
		previous = null;
	} //end constructor
	public Node(Object data) {
		this.data = data;
		next = null;
		previous = null;
	} //end constructor
	//getters and setters
	public Node getNext() {
		return next;
	} //end 
	public Node getPrevious() {
		return previous;
	} //end
	public void setNext(Node p) {
		next = p;
	} //end
	public void setPrevious(Node p) {
		previous = p;
	} //end 
	public Object getData() {
		return data;
	} //end
	@Override
	public String toString() {
		return data.toString();
	} //end toString
} //end class