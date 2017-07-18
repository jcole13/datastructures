package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
	//the main method for running the program
	public static void main(String [] args) {
		//initializing variables
		Calculation calculation = new Calculation();
		Converter converter = new Converter();
		Input input = new Input();
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		boolean running = true;
		intro();
		
		//start the loop to choose stuff
		while(running) {
			try {
				input.chooseInput(calculation, converter);//start the calculations
			}catch(ArithmeticException z) {
				System.out.println("\n\n\n\n\n-------------DIVIDE BY ZERO ERROR--------------");
			}catch(NumberFormatException o) {
				System.out.println("\n\n\n\n\n-----------------INVALID INPUT-----------------");
				System.out.println("         (Possibly using the wrong calculator)");
			}catch(StackEmptyException e) {
				System.out.println("\n\n\n\n\n----------SOMETHING SEVERE HAS HAPPENED!-------");
			}
			
		
			System.out.println("Run again? [y/n]");
		//only two options
			String answer = null;
			System.out.print(">>>");
			try {
			answer = grab.readLine();
			} catch (IOException e) {
				e.printStackTrace();
				}
			if(!answer.toLowerCase().equals("y")) running = false;
		}
		System.out.println("Thank you for participating!");
	}//end main 
	
	public static void intro() { //just some introductory statements
		System.out.println("############################################################################################");
		System.out.println("             			Welcome to the calculator!");
		System.out.println("This calculator can take input in either infix notation or reverse polish(postfix) notation");
		System.out.println("   and either calculate the expression or convert the expression to the other notation");
		System.out.println();
		System.out.println("Sample Infix notation: ((4 * -3) - 3)");
		System.out.println();
		System.out.println("Sample Postfix notation: 5 -4 + 6 -");
		System.out.println();
		System.out.println();
		System.out.println("	This calculator utilizes stacks to solve both types of calculations, ");
		System.out.println("  and actually uses two separate calculators depending on the inputted notation ");
		System.out.println(" 			    We hope you enjoy!");
		System.out.println("############################################################################################");
		
	} //end intro

}//end class
