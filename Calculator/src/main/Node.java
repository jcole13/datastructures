package main;

public class Node {
	
	//variables
	private Node next;
	private String data;
	
	//constructors
	public Node(String s){//defaulting next to null
		data = s;
		next = null;
	}
	
	public Node(){//default next and data to null
		next = null;
		data = null;
	}
	public Node(String s, Node n){
		data = s;
		next = n;
	}
	
	//methods(getters and setters)
	public Node getNext(){
		return next;
	}
	public void setNext(Node n){
		next = n;
	}
	public String getData(){
		return data;
	}
	public void setData(String s){
		data = s;
	}

}
