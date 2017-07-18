package main;

import java.util.InputMismatchException;

public class Calculation {
	
	public int reversePolish(String [] arr) {
		if(!checkWellFormedPolish(arr)) {//this checks if the given was good or bad
			throw new InputMismatchException("Not well formed!");
		} // end if
		Stack reverse = new Stack();//this initiates the new stack where we shall add new elements
		System.out.println();
		System.out.println("States of the stack after each calculation (Left is top): ");
		for(String s : arr) {//this loops through every element in the parsed array
			/*the switch statement does through every operation
			 * the default would mean that it is a number (parenthesis are excepted)
			 */
			switch(s){
				case "+": reverse.join(Integer.parseInt(reverse.leave()) + Integer.parseInt(reverse.leave()) + ""); System.out.println(reverse); break;
				case "*": reverse.join(Integer.parseInt(reverse.leave()) * Integer.parseInt(reverse.leave()) + "");System.out.println(reverse);  break;
				case "/": //this was awfully hard to program
					int initial = Integer.parseInt(reverse.leave());
					int second = Integer.parseInt(reverse.leave());
					reverse.join(second/initial + "");
					System.out.println(reverse);
					break;
				case "-": reverse.join(-(Integer.parseInt(reverse.leave()) - Integer.parseInt(reverse.leave())) + ""); System.out.println(reverse); break; //math for the win
				default : reverse.join(s); System.out.println(reverse); break;
					
			} // end switch
			
		} //end loop
		return Integer.parseInt(reverse.leave());//prints out the last element in the stack, which there should be 1 and then parses it
	} //end reversePolish
	public int infix(String[] arr) { //these are the calculations for 
		if(!checkWellFormedInfix(arr)) throw new InputMismatchException("Expression not well formed!"); //we were planning on making separate Exceptions
		arr = fixArray(arr);
		Stack inf = new Stack();//initiation
		System.out.println();
		System.out.println("States of the stack after each step: (Top is at the left)" );
		System.out.println("Extra Parenthesis added around entire expression if not inputted that way" );
		
		for(String s : arr) {
			/*adding the things to the list if not the calculation braces
			 * if close braces, do the calculation of the top of the stack
			 * numbers, by default, are added
			 */
			switch(s) {
			case "(" : case "+" : case "-" : case "/" : case "*": inf.join(s); System.out.println(inf); break;
			case ")" :inf = doCalculation(inf);break;
			default : inf.join(s); System.out.println(inf); break;
			} //end switch
		} //end loop
		return Integer.parseInt(inf.leave());//should parse the last member of the stack
		
	} //end infix
	private boolean checkWellFormedInfix(String [] arr) { //  FIXME there is a problem where one adds more numbers than operators
		int counter = 0;
		for(String s : arr) {//counts if the number of open braces is equal to the number of the close braces
			if(s.equals("(")) counter++;
			else if(s.equals(")")) counter--;
		} //end loop
		return counter==0;
	} //end CWFI
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
	} //end CWFP
	private Stack doCalculation(Stack i) {//this calculates for infix
		String temp = i.leave();//pops off the top of the list
		int first = Integer.parseInt(temp);//has to be, as we checked
		while(!temp.equals("(")){//this is the break
			temp = i.leave();
			/*the switch goes through the stack and sees the next number before the operation(before the operator)
			 *
			*/
			switch(temp) {
			case "(" : i.join(first + ""); break;
			case "+" : first = first + Integer.parseInt(i.leave()); System.out.println(i); break;
			case "*" : first = first * Integer.parseInt(i.leave()); System.out.println(i); break;
			case "-" : first = Integer.parseInt(i.leave()) - first; System.out.println(i); break;
			case "/" : first = Integer.parseInt(i.leave()) / first; System.out.println(i); break;
			default : throw new InputMismatchException(); //whoops
			} //end switch
			
		} //end loop
		return i;
	} //end doCalculation
	private String[] fixArray(String[] a) { //if the first and last are not parenthesis
		if(!a[0].equals("(") || !a[a.length-1].equals(")")) {
			String[] temp = new String[a.length + 2];
			temp[0] = "(";
			for(int i = 0; i < a.length; i++) {//looping through each element of the array
				temp[i+1] = a[i];
			} //end loop
			temp[temp.length-1] = ")";
			return temp;
		} //end if
		return a;
	} //end fixArray

} //end class
