package main;

public class LList {
	private GraphNode label;
	private Node header, back;
	private int length;
	
	public LList() {
		label = null;
		header = new Node();
		length = 0;
	}
	
	public LList(GraphNode o) {
		label = o;
		header = new Node();
		length = 0;
	}
	public Node getFirst() {
		return header.getNext();
	}
	
	public void append(Object p){
		if(isEmpty()) {
			Node temp = new Node(p);
			header.setNext(temp);
			temp.setPrevious(header);
			back = header.getNext();
			length++;
			
		}
		else{
			Node temp = new Node(p);
			back.setNext(temp);
			temp.setPrevious(back);
			back = back.getNext();
			length++;
		}

	}
	
	public GraphNode getLabel() {
		return label;
	}
	public boolean isEmpty(){ 
		return this.length == 0;
	}
	
	public Node adjfind(GraphNode n) { //use for adjacency list
		Node i = header.getNext();
		do{
			if(((LList) i.getData()).getLabel().equals(n)) {
				return i;
			}
			i = i.getNext();
		}while((i.getData() != null) && !(((LList) i.getData()).equals(n)));
		
		//System.out.println("Exited Loop");
		
		return null;
	}
	
	public GraphNode gnFind(String s) {
		Node i = header.getNext();
		do{
			if(((LList) i.getData()).getLabel().getPerson().getName().equals(s)) {
				return ((LList) i.getData()).getLabel();
			}
			i = i.getNext();
		}while((i.getData() != null)); //gives graphnode from string 
		
		System.out.println("Exited Loop");
		
		return null;
		
	}
	
	public String toString() {
		Node temp = header.getNext();
		String result = "";
		while(temp != null) {
			result += " " + temp.toString();
			temp = temp.getNext();
		}
		//if(label != null) return label.toString();
		return result;
	}
	
	public int getLength() {
		return length;
	}
	
	
	
}
