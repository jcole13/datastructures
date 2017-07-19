package main;
public class People {
	//instance variables
	public static int number_made = 0;
	private static final int STARTING_ID = 1000;
	private String name;
	private int id; // unique for each person
	//constructor
	public People(String name){ //constructor
		this.name = name;
		this.id = STARTING_ID + number_made;
		number_made++; //incrementing this static variable

	} //end constructor
	//setters and getters
	public String getName() {
		return name;
	} //end get
	public void setName(String name) {
		this.name = name;
	} //end set
	public int getId() {
		return id;
	} //end get
	@Override
	public String toString(){ //list facts about a person
		String temp = "Name: " + this.name;
		temp += "\n" + "ID: " + this.id;
		return temp;
	} //end toString
	
	public People(){
		this("Anon");
	} //end constructor


} //end class
