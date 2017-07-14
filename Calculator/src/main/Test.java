package main;

public class Test {

	public static void main(String[] args) {
		Stack work=new Stack();
		for(String s:Parser.parse("23*56--24*(69+8)"))
			work.join(s);
		System.out.println(work);
	}

}
