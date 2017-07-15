package main;

public class Stack {
	
	private Node top;
	private int length;
	
	public Stack(){length = 0;}
	
	public int getLength() {
		return length;
	}
	
	
	public void join(String s){
		Node temp = new Node(s);
		if(isEmpty()){
			top = temp; length++;
			}
		else{
			temp.setNext(top);
			top = temp;
			length++;
			}
	}
	public String leave() throws StackEmptyException{
		if(isEmpty()) {
			throw new StackEmptyException();
		}
		String temp = top.getData();
		top = top.getNext();
		length--;
		//System.out.println(length);
		return temp;
	}
	
	public String look() throws StackEmptyException{
		if(isEmpty()) throw new StackEmptyException();
		return top.getData();
	}

	private boolean isEmpty(){return length == 0;}
	
	public String toString(){
		String temp = "[";
		Node on = top;
		while(on != null){
			temp += " " + on.getData()+",";
			on = on.getNext();
		}
		return temp.substring(0, temp.length()-1) + "]";
	}

}
