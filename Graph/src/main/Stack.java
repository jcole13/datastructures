package main;

public class Stack {
	//instance variables, holding the top of the list
	private Node top;
	private int length;
	//constructor
	public Stack(){length = 0;}
	/**
	 * @return the variable length
	 */
	public int getLength() {
		return length;
	} //end get
	/**@param Object that will be stored in a node
	 */
	public void join(Object s){
		Node temp = new Node(s);
		if(isEmpty()){//if the stack is empty
			top = temp; 
			length++;
			}
		else{//if stack isn't empty
			temp.setNext(top);
			top = temp;
			length++;
			}
	} //end join
	/**@return the top of the stack
	 * @param none
	 * @exception StackEmptyException if there are no elements in this stack
	 */
	public Object leave() throws StackEmptyException{
		if(isEmpty()) throw new StackEmptyException();
		Object temp = top.getData();//setting the second top to top and returning top
		top = top.getNext(); //second is now first
		length--;
		return temp;
	} //end leave
	/**@param none
	 * @return the header
	 * @Exception StackEmptyException if this stack is empty
	 */
	public Object look() throws StackEmptyException{ //this peeks at the top of the stack
		if(isEmpty()) throw new StackEmptyException();
		return top.getData();
	} //end look
	public boolean isEmpty(){return length == 0;}
	@Override
	public String toString(){
		String temp = "[";
		Node on = top;
		while(on != null){
			temp += " " + on.getData()+",";
			on = on.getNext();
		}
		return temp.substring(0, temp.length()-1) + "]";
	} // end toString

} //end class
