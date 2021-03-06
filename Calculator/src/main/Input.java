package main;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Input {
	public void chooseInput(Calculation calculation, Converter converter){//chooses how choose the program
		//Use input from keyboard
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);

		
		System.out.println("Which method of input would you prefer? [keyboard/file]");//out to user
		//only two options
		String answer = null;
		do{//looping through until a sufficient answer is given
			System.out.print(">>>");
			try {
				answer = grab.readLine();//reading from the user's input
			} catch (IOException e) {
				e.printStackTrace();
			} //end catch
		}while(!answer.toLowerCase().equals("keyboard") && !answer.toLowerCase().equals("file"));
		if(answer.toLowerCase().equals("keyboard")) keyboardIn(calculation, converter); //choice of what to give
		else fileIn(calculation, converter);
	}//end chooseInput
		
	/*
	 * 
	 */
	private void keyboardIn(Calculation calculation, Converter converter){
		//Use input from keyboard
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		//keyboard input, user inputs everything on spot
	
		//String number = "a"; //arbitrary
		
		System.out.println("Would you like to input an expression in postfix or infix notation? [postfix/infix]");
		//only two options
		String answer = null;
		do{
			System.out.print(">>>");
			try {
				answer = grab.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!answer.toLowerCase().equals("postfix") && !answer.toLowerCase().equals("infix"));
		if(answer.toLowerCase().equals("postfix")) {
			System.out.println("Would you like to calculate the expression or convert the expression to infix notation? [calculate/convert]");
			//only two options
			String s = null;
			do{
				System.out.print(">>>");
				try {
					s = grab.readLine();
				} catch (IOException io) {
					io.printStackTrace();
				}
			}while(!s.toLowerCase().equals("calculate") && !s.toLowerCase().equals("convert"));
			System.out.println("Enter the postfix expression");
			System.out.println("Please put a space between every number");
			System.out.print(">>>");
			if(s.toLowerCase().equals("calculate")) {
				String d = null;
				try {
					d = grab.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				} //end catch
				System.out.println(calculation.reversePolish(Parser.parse(d)));
			}
			else {
				String e = null;
				try {
					e = grab.readLine();
				} catch (IOException n) {
					n.printStackTrace();
				} //end catch
				System.out.println(converter.toInfix(Parser.parse(e)));
				
			}
		} //end first if
		else {
			System.out.println("Would you like to calculate the expression or convert the expression to postfix notation? [calculate/convert]");
			//only two options
			String c = null;
			do{
				System.out.print(">>>");
				try {
					c = grab.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}while(!c.toLowerCase().equals("calculate") && !c.toLowerCase().equals("convert"));
			System.out.println("Enter the infix expression");
			System.out.println("Please insert spaces where you can");
			System.out.print(">>>");
			if(c.toLowerCase().equals("calculate")) {
				String d = null;
				try {
					d = grab.readLine();
				} catch (IOException e) {
					e.printStackTrace();
				} //end catch
				System.out.println(calculation.infix(Parser.parse(d)));
			} //end if
			else {
				String e = null;
				try {
					e = grab.readLine();
				} catch (IOException n) {
					n.printStackTrace();
				} //end catch
				System.out.println(converter.toPolish(Parser.parse(e)));
				
			} //end else
			
		} //end else
	}//end keyBoardin
	private void fileIn(Calculation calculation, Converter converter){
		//Use input from file
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		String fileName = null;
		do{
			System.out.println("Enter a valid text file");
			//only txt accepted, turned down otherwise
			System.out.print(">>>");
			try {
				fileName = grab.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			if(fileName.length() < 4){
				fileName += "aaaa";
				//add this so out of bounds exception is not thrown
				//the file is not valid if it is less than 4 characters anyways
				//so the string added is arbitrary
			}
		}while(!fileName.substring(fileName.length()-4).equals(".txt"));
		//Checks if last 4 chars are ".txt"
		//System.out.println(fileName);
		System.out.println("Entering data from file...");
		FileReader fr  = null;
		try {
			fr = new FileReader(fileName);
		} catch (FileNotFoundException e) {
			System.out.println("Sorry, that file is not found");
			return;
		} 
		BufferedReader br = null; //needs to be initialized
		
		try{
			
		br = new BufferedReader(fr);
		} catch(NullPointerException npe){ // in case the file that is entered is not there
			System.out.println("Nothing in that file...");
		}
		
		String value = null;//Initialized
			try{
			value = br.readLine();
			//if(value == null) break; //necessary to stop crash. loop does not terminate on right term
			//checks if multiple numbers in one line
			}catch(NullPointerException n){
				//System.out.println("Something went wrong");
			}catch(IOException e){
				e.printStackTrace();
			} //end catch
			
		
		System.out.println("Is the expression in postfix or infix notation? [postfix/infix]");
		//only two options
		String answer = null;
		do{
			System.out.print(">>>");
			try {
				answer = grab.readLine(); //reading info again
			} catch (IOException e) {
				e.printStackTrace();
			}
		}while(!answer.toLowerCase().equals("postfix") && !answer.toLowerCase().equals("infix"));
		if(answer.toLowerCase().equals("postfix")) {
			System.out.println("Would you like to calculate the expression or convert the expression to infix notation? [calculate/convert]");
			//only two options
			String s = null;
			do{
				System.out.print(">>>");
				try {
					s = grab.readLine();
				} catch (IOException io) {
					io.printStackTrace();
				}
			}while(!s.toLowerCase().equals("calculate") && !s.toLowerCase().equals("convert"));
			if(s.toLowerCase().equals("calculate")){
				System.out.println(calculation.reversePolish(Parser.parse(value)));
			}
			else {
				System.out.println(converter.toInfix(Parser.parse(value)));
			} // end else

		}//end if
		else {
			System.out.println("Would you like to calculate the expression or convert the expression to postfix notation? [calculate/convert]");
			//only two options
			String s = null;
			do{
				System.out.print(">>>");
				try {
					s = grab.readLine();
				} catch (IOException io) {
					io.printStackTrace();
				}
			}while(!s.toLowerCase().equals("calculate") && !s.toLowerCase().equals("convert"));
			if(s.toLowerCase().equals("calculate")){
				System.out.println(calculation.infix(Parser.parse(value)));
			}
			else {
				System.out.println(converter.toPolish(Parser.parse(value)));
			}
			
		} // nd else
		try {
			fr.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}//end catch
	} //end filein
} //end class
