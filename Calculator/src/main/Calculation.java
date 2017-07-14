package main;

import java.util.InputMismatchException;

public class Calculation {
	
	public int reversePolish(String [] arr) {
		Stack reverse = new Stack();
		for(String s : arr) {
			//System.out.println(reverse);
			switch(s){
				case "+": reverse.join(Integer.parseInt(reverse.leave()) + Integer.parseInt(reverse.leave()) + ""); break;
					/*int temp1 = Integer.parseInt(reverse.leave());
					int temp2 = Integer.parseInt(reverse.leave());
					int temp3 = temp1 + temp2;
					reverse.join("" + temp3);break;*/
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
		if(!checkWellFormed(arr)) {
			System.out.println("Expression not well formed!");
			throw new InputMismatchException(); //change this
		}
		return 0;
		
	}
	
	public boolean checkWellFormed(String [] arr) {
		int counter = 0;
		for(String s : arr) {
			if(s.equals("(")) counter++;
			else if(s.equals(")")) counter--;
		}
		return counter==0;
	}

}
