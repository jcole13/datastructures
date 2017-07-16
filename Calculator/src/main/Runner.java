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
		
		//start the loop to choose stuff
		while(running) {
			try {
				input.chooseInput(calculation, converter);//start the calculations
			}catch(ArithmeticException z) {
				System.out.println("\n\n\n\n\n-------------DIVIDE BY ZERO ERROR--------------");
			}catch(NumberFormatException o) {
				System.out.println("\n\n\n\n\n-----------------INVALID INPUT-----------------");
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

}//end class
