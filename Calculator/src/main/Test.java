package main;

public class Test {

	public static void main(String[] args) {
		Calculation lator = new Calculation();
		System.out.println(lator.reversePolish(Parser.parse("14 4 + 18 /")));
		//for(String s:Parser.parse("23 4 +"))System.out.println(s);
		/*
		for(String s:Parser.parse("23*56--24*(69+8)"))
			work.join(s);
		System.out.println(work);*/
	}

}
