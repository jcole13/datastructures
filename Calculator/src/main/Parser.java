package main;

import java.util.InputMismatchException;

public class Parser {
	
	//do not instantiate this class!
	private Parser() {}
	
	//the following are the static methods that are global
	public static String[] parse(String s){
		String [] temp=new String[0]; //this allows a blank array that will be filled
		String work="";//this is to hold forming numbers as the for each goes through the string
		for(char c: s.toCharArray()){//reads every char in an the string
			/*The following is a switch that does things depending on the character it is on
			 * the first line is the operators it checks
			 * the second line adds the number to a temporary string that holds the temporary numbers
			 * the third line allows to ignore spacing
			 */
			switch(c){
			case '-' : if(work.length()>0) {}else {work+=c;break;}
			case '(':case')':case '*':case '/':case '+':temp = addElement(temp,work);work="";temp=addElement(temp,c+"");break;//these are the operators we are going to use, i was thinging about the bigger braces, but then I thought against using those
			case '1':case'2':case'3':case'4':case'5':case '6':case'7':case'8':case'9':case'0':work+=c;break;// adds to the total String
			case ' ': temp = addElement(temp, work); work="";break;
			default:throw new InputMismatchException();//throws if not a space number or operation
			} //end switch
		}
		temp=addElement(temp,work);//final check to know that the stack is clear of only one
		return temp;
	} //end parse
	private static String[] addElement(String[] target, String add){//this is a helper method to help me add an element to an array
		try {
			if(add.charAt(0)==' ')add=add.substring(1);//checks if the first is a space
		}catch(StringIndexOutOfBoundsException n) {//this gets hit whenever it is a blank string 
			//System.out.println("index check");
		}
		if(add.length()==0||add.equals(" "))return target;//if it is a blank string, don't do anything
		String [] temp=target;//saving the old
		target=new String[target.length+1];//making a longer array
		for(int i=0;i<temp.length;i++)target[i]=temp[i];//storing back old values
		target[target.length-1]=add;//save the new value
		return target;
	} //end addElement
} //end class
