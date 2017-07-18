package main;

public class StackEmptyException extends RuntimeException{ //this is a warning to tell if there is a severe mistake with the length of the stack
	/**
	 * 
	 */
	//instance variables
	private static final long serialVersionUID = 2685788240441941748L;

	//constructors
	public StackEmptyException(){
		super("Stack is empty"); //just throws exception
	} //end constructor
	
} //end class
