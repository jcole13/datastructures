package main;

public class Test {

	public static void main(String[] args) {
		Calculation lator = new Calculation();
		//System.out.println(Parser.parse("84 + 23"));
		System.out.println(lator.infix(Parser.parse("(((84 + 2) * 3) + 4)")));
		//for(String s:Parser.parse("23 4 +"))System.out.println(s);
		/*
		for(String s:Parser.parse("23*56--24*(69+8)"))
			work.join(s);
		System.out.println(work);*/
	}

}
