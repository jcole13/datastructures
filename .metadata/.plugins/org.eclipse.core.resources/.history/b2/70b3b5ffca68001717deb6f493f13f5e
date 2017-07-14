package main;

public class Stack {
	
	Node top;
	int length;
	
	public Stack(){length = 0;}
	
	public void join(String s){
		Node temp = new Node(s);
		if(isEmpty()){
			top = temp; length++;
			}
		else{
			temp.setNext(top);
			top = temp;
			}
	}
	public String leave() throws StackEmptyException{
		if(isEmpty()) throw new StackEmptyException();
		String temp = top.getData();
		top = top.getNext();
		length--;
		return temp;
	}

	private boolean isEmpty(){return length == 0;}

}
