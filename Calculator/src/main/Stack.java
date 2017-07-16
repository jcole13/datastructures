package main;

public class Stack { 
	
	//instance variables
	private Node top;
	private int length;
	
	//constructors
	public Stack(){
		length = 0;
	}
	
	//methods
	public int getLength() {
		return length;
	}
	public void join(String s){//this adds a new node to the top of the stack
		Node temp = new Node(s);
		if(isEmpty()){ //tests if need to save the top of the stack, or just add
			top = temp;
			length++;
		}else{
			temp.setNext(top); //this saves the top and moves it to the top
			top = temp;
			length++;
		}
	}
	public String leave(){// this pops off the top of the stack
		if(isEmpty()) throw new StackEmptyException();//warns if there is a critical mistake with the stack
		String temp = top.getData();
		top = top.getNext();
		length--;
		return temp;
	}
	public String look(){//this peeks at the top of the stack
		if(isEmpty()) throw new StackEmptyException();//if the top does not exist, it throws this
		return top.getData();
	}
	private boolean isEmpty(){
		return length == 0;
	}
	public String toString(){ //prints every element in the stack to the user
		String temp = "[";
		Node on = top;
		while(on != null){ //this loops through testing every next
			temp += " " + on.getData()+",";
			on = on.getNext();
		}
		return temp.substring(0, temp.length()-1) + "]";
	}
}
