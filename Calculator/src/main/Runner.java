package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Runner {
	public static void main(String [] args) {
		Calculation calculation = new Calculation();
		Converter converter = new Converter();
		Input input = new Input();
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		boolean running = true;
		
		
		while(running) {
			input.chooseInput(calculation, converter);
		
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
