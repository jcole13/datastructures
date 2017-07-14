package main;

import java.util.InputMismatchException;

public class Parser {
	public static String[] parse(String s){
		String [] temp=new String[0];
		String work="";
		for(char c: s.toCharArray()){//reads every char in an the string
			switch(c){
			case '(':case')':case '*':case '/':case '+':case'-':temp = addElement(temp,work);work="";temp=addElement(temp,c+"");break;//these are the operators we are going to use, i was thinging about the bigger braces, but then I thought against using those
			case '1':case'2':case'3':case'4':case'5':case '6':case'7':case'8':case'9':case'0':work+=c;break;// adds to the total String
			case ' ':break;
			default:throw new InputMismatchException();//throws if not a space number or operation
			}
		}
		return temp;
	}
	private static String[] addElement(String[] target, String add){//this is a helper method to help me add an element to an array
		if(add.length()==0)return target;
		String [] temp=target;
		target=new String[target.length+1];
		for(int i=0;i<temp.length;i++)target[i]=temp[i];
		target[target.length-1]=add;
		return target;
	}
}
