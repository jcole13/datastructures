package main;

public class LList {
	//instance variables
	private GraphNode label;
	private Node header, back;
	private int length;
	//constructors
	public LList() {
		label = null;
		header = new Node();
		length = 0;
	} //end constructor
	public LList(GraphNode o) {
		label = o;
		header = new Node();
		length = 0;
	} //end constructor
	//setters and getters
	public Node getFirst() {
		return header.getNext();
	} //end getFist
	public int getLength() {
		return length;
	} //end getLength
	public GraphNode getLabel() {
		return label;
	} //end getLabel
	public boolean isEmpty(){ 
		return this.length == 0;
	} //end isEmpty
	/**
	 * 
	 * @param object which to add to the back of the list
	 */
	public void append(Object p){ //adds to the end of the list
		if(isEmpty()) {//checks if the list is empty to avoid a nullpointer
			Node temp = new Node(p);
			header.setNext(temp);//switching
			temp.setPrevious(header);
			back = header.getNext();
			length++;
			
		}/* end if*/else{
			Node temp = new Node(p);
			back.setNext(temp);
			temp.setPrevious(back);//switching the back to the 
			back = back.getNext();
			length++;
		} //end else

	}
	/**Overloaded method
	 * @param it needs a graphnode, but it is for a specific usage of the adjacency list
	 * @return returns a node within the graphnode, or a null if it cannot be found
	 */
	public Node adjfind(GraphNode n) { //use for adjacency list to find a Node that is holding the graphnode
		Node i = header.getNext();
		do{
			if(((LList) i.getData()).getLabel().equals(n)) return i;//where to break off
			i = i.getNext();
		}while((i.getData() != null) && !(((LList) i.getData()).equals(n)));
		return null; //given up, we control this though, so it shouldnt get here
	} //end adjfind
	/**Overloaded method
	 * @param String to find the specific GraphNode
	 * @return a GraphNode with the name
	 */
	public GraphNode gnFind(String s) {
		Node i = header.getNext(); //first one that is not null
		do{
			if(((LList) i.getData()).getLabel().getPerson().getName().equals(s)) {
				return ((LList) i.getData()).getLabel(); //graphnode
			}
			i = i.getNext();
		}while((i.getData() != null)); //gives graphnode from string 
		
		System.out.println("Exited Loop"); //checks if something went wrong
		
		return null; //once again, shouldnt get here
		
	} //end gnFind
	@Override
	public String toString() {
		Node temp = header.getNext();
		String result = "";
		while(temp != null) {
			result += " " + temp.toString();
			temp = temp.getNext();
		}
		//if(label != null) return label.toString();
		return result;
	} //end toString
} //end class
