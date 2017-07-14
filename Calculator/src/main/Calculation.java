package main;

import java.util.InputMismatchException;

public class Calculation {
	
	public int reversePolish(String [] arr) {
		if(!checkWellFormedPolish(arr)) {
			throw new InputMismatchException("Not well formed!");
		}
		Stack reverse = new Stack();
		for(String s : arr) {
			switch(s){
				case "+": reverse.join(Integer.parseInt(reverse.leave()) + Integer.parseInt(reverse.leave()) + ""); break;
				case "*": reverse.join(Integer.parseInt(reverse.leave()) * Integer.parseInt(reverse.leave()) + ""); break;
				case "/": 
					int initial = Integer.parseInt(reverse.leave());
					int second = Integer.parseInt(reverse.leave());
					reverse.join(second/initial + "");
					break;
				case "-": reverse.join(-(Integer.parseInt(reverse.leave()) - Integer.parseInt(reverse.leave())) + ""); break;
				default : reverse.join(s); break;
					
			} // end switch
			
		}
		return Integer.parseInt(reverse.leave());
	}
	
	public int infix(String[] arr) {
		if(!checkWellFormedInfix(arr)) {
			throw new InputMismatchException("Expression not well formed!"); //change this
		}
		
		arr = fixArray(arr);
		
		Stack inf = new Stack();
		for(String s : arr) {
			switch(s) {
			case "(" : case "+" : case "-" : case "/" : case "*": inf.join(s); break;
			case ")" :
				inf = doCalculation(inf);
				break;
			default : inf.join(s); break;
			}
		}
		return Integer.parseInt(inf.leave());
		
	}
	
	public boolean checkWellFormedInfix(String [] arr) { //make sure expression is ok
		int counter = 0;
		for(String s : arr) {
			if(s.equals("(")) counter++;
			else if(s.equals(")")) counter--;
		}
		return counter==0;
	}
	public boolean checkWellFormedPolish(String [] arr) { //make sure expression is ok
		int counter = 0;
		String regex = "\\d+"; //digit
		for(String s : arr) {
			if(s.matches(regex)) counter++;
			else counter--;
			if(counter <= 0) return false;
		}
		return counter == 1;
	}
	
	private Stack doCalculation(Stack i) {
		String temp = i.leave();
		//System.out.println(temp);
		//System.out.println(i.leave());
		int first = Integer.parseInt(temp);
		while(!temp.equals("(")){
			temp = i.leave();
			//System.out.println(first + " ! " + temp);
			switch(temp) {
			case "(" : i.join(first + ""); break;
			case "+" : first = first + Integer.parseInt(i.leave()); break;
			case "*" : first = first * Integer.parseInt(i.leave()); break;
			case "-" : first = Integer.parseInt(i.leave()) - first; break;
			case "/" : first = Integer.parseInt(i.leave()) / first; break;
			default : throw new InputMismatchException(); 
			}
			
		}
		//i.join(first + "");
		return i;
	}
	
	private String[] fixArray(String[] a) { //if the first and last are not parenthesis
		if(!a[0].equals("(") || !a[a.length-1].equals(")")) {
			String[] temp = new String[a.length + 2];
			temp[0] = "(";
			for(int i = 0; i < a.length; i++) {
				temp[i+1] = a[i];
			}
			temp[temp.length-1] = ")";
			for(String s : temp) //System.out.println(s);
			return temp;
		} //end if
		return a;
	}

}
