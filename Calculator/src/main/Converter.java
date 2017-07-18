package main;

import java.util.InputMismatchException;

public class Converter {
	/**@param takes in an array of strings
	 * @return a String that has the whole operation in polish notation
	 */
	public String toInfix(String[] arr) {//goes through and consolidates a postfix expression
		if(!checkWellFormedPolish(arr)) throw new InputMismatchException("Expression not well formed!");
		Stack stack = new Stack();
		for(int i = 0; i < arr.length; i++) {//goes through the array and adds to stack
			if(!isOperator(arr[i])) stack.join(arr[i]); //checks if operator, if it is number, then add to stack
			else { //if it is an operator
				String one = "";
				String two = "";
				one = stack.leave();
				two = stack.leave();
				stack.join("(" + two + " " + arr[i] + " " + one + ")" );//this is the way
			} //end else
		} //end loop
		return stack.leave();
	} //end toInfix
	/**@param takes in an array of strings
	 * @return polish notation for the array
	 */
	public String toPolish(String[] arr) {
		Stack stack = new Stack();//initializing the stack
		String result = "";
		//dont check for well formed because it does not really effect the outcome in terms of errors
		for(int i = 0; i < arr.length; i++) {//looping through the array
			if(!isOperator(arr[i])) result += " " + arr[i]; // add to the list if just an operator
			else if(arr[i].equals("(")) stack.join(arr[i]);//testing if there is a braces
			else if(isOperator(arr[i])) {//if there is an operator, then 
				while(stack.getLength() > 0 && !stack.look().equals("(")) {//look at the top of the stack and then build higher, else exit
					if(pemdas(stack.look()) >= pemdas(arr[i])) {//the order of the operation check which would be first
						result += " " + stack.leave();
					}
					else break;
				} //end loop
				stack.join(arr[i]);
			} //end else if
			else if (arr[i].equals(")")){//tests whether the parenthesis is closed
	            while ((stack.getLength() > 0) && (!stack.look().equals("("))){//look if there is a open
	                result += " " + stack.leave();//get the next number
	            } //end loop
	            if (stack.getLength() > 0)
	                stack.leave(); // popping out the left brace '('
	        } //end else if

		} //end for loop
		while (stack.getLength() > 0){
	        result += " " + stack.leave();
	    } //end loop
		result = result.replace("(", ""); //cleaning
		result = result.replace(")", ""); //cleaning
		return result;
	} //end toPolish
			
	/**@param String, testing whether it is a operator
	 * @return true or false, depending on the operator
	 */
	private boolean isOperator(String s) { //checks if operator
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") ||s.equals(")"));
	} //end isOperator
	/**@param takes in a string as an operator
	 * @return -1 if there is an error
	 */
	private int pemdas(String s) { //checks precedence of operator
		if(s.equals("(") || s.equals(")")) return 0;
		if(s.equals("+") || s.equals("-")) return 1;
		if(s.equals("*") || s.equals("/")) return 2;
		return -1;
	} //end pemdas
	private boolean checkWellFormedPolish(String [] arr) { // CHECKME make sure expression is ok
		int counter = 0;
		String regex = "\\d+"; //digit
		for(String s : arr) {
			//going thorugh the parsed array, if there is a number, which is written by the regex, then the counter goes up, if there is a operation then it goes down
			if(s.matches(regex)) counter++;
			else if(s.length() > 1) counter++;
			else counter--;
			if(counter <= 0) return false;//if there is more operations than numbers
		} //end loop
		return counter == 1;
	}//end CWFP

} //end class
