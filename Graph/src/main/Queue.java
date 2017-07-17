package main;

public class Queue {

	Node front, back;
	int length;

	public Queue(int size) {
		length = size;

	}

	public Queue() {
		length = 0;
	}

	public void join(Object p){
		Node temp = new Node(p);
		if(isEmpty()){
			back = temp;
			front = back; 
			length++; //philosophically it feels better
		}
		else{
			back.setNext(temp); 
			back = back.getNext();
			length++;
		}
	}

	public Object leave() { // assumes unlimited data
		//System.out.println("!");
		if (isEmpty())
			throw new StackEmptyException();// TODO make a new Exception
		Object temp = null;
		try {
		temp = front.getData();
		}catch(NullPointerException npe) {
			System.out.println("Null Pointer");
		}
		front = front.getNext();
		length--;
		return temp;
	}
	
	public Object look() {
		return front;
	}

	public boolean isEmpty() {
		return length == 0;
	}
	public String toString(){
		String temp = "[";
		Node on = front;
		while(on != null){
			temp += " " + on.getData()+",";
			on = on.getNext();
		}
		return temp.substring(0, temp.length()-1) + "]";
	}

}
