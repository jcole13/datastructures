package main;

public class Converter {
	/**@param takes in an array of strings
	 * @return a String that has the whole operation in polish notation
	 */
	public String toInfix(String[] arr) {//goes through and consolidates a postfix expression
		Stack stack = new Stack();
		for(int i = 0; i < arr.length; i++) {//goes through the array and adds to stack
			if(!isOperator(arr[i])) stack.join(arr[i]); //checks if operator, if it is number, then add to stack
			else { //if it is an operator
				String one = "";
				String two = "";
				one = stack.leave();
				two = stack.leave();
				stack.join("(" + two + arr[i] + one + ")" );//this is the way
			}
		}
		return stack.leave();
	}
	/**@param takes in an array of strings
	 * @return polish notation for the array
	 */
	public String toPolish(String[] arr) {
		Stack stack = new Stack();//initializing the stack
		String result = "";
		
		for(int i = 0; i < arr.length; i++) {//looping through the array
			if(!isOperator(arr[i])) result += " " + arr[i]; // add to the list if just an operator
			else if(arr[i].equals("(")) stack.join(arr[i]);//testing if there is a braces
			else if(isOperator(arr[i])) {//if there is an operator, then 
				while(stack.getLength() > 0 && !stack.look().equals("(")) {//look at the top of the stack and then build higher, else exit
					if(pemdas(stack.look()) >= pemdas(arr[i])) {//the order of the operation check which would be first
						result += " " + stack.leave();
					}
					else break;
				}
				stack.join(arr[i]);
			}
			else if (arr[i].equals(")")){//tests whether the parenthesis is closed
	            while ((stack.getLength() > 0) && (!stack.look().equals("("))){//look if there is a open
	                result += " " + stack.leave();//get the next number
	            }
	            if (stack.getLength() > 0)
	                stack.leave(); // popping out the left brace '('
	        }

		}
		while (stack.getLength() > 0){
	        result += " " + stack.leave();
	    }
		result = result.replace("(", ""); //cleaning
		result = result.replace(")", ""); //cleaning
		return result;
	}
			
	/**@param String, testing whether it is a operator
	 * @return true or false, depending on the operator
	 */
	private boolean isOperator(String s) {
		return (s.equals("+") || s.equals("-") || s.equals("*") || s.equals("/") || s.equals("(") ||s.equals(")"));
	}
	/**@param takes in a string as an operator
	 * @return -1 if there is an error
	 */
	private int pemdas(String s) {
		if(s.equals("(") || s.equals(")")) return 0;
		if(s.equals("+") || s.equals("-")) return 1;
		if(s.equals("*") || s.equals("/")) return 2;
		return -1;
	}

}
