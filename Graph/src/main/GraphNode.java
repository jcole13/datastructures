package main;

public class GraphNode {
	//instance variables
	private People label;
	private boolean visited; //check if search reached it
	//constructor
	public GraphNode(People p) {
		label = p;
		visited = false;
		
	}//end constructor
	//getters and setters
	public People getPerson() {
		return label;
	} //end
	public boolean getVisited() {
		return visited;
	} //end 
	public void setVisited(boolean visited) { //used in search if it has already been seen
		this.visited = visited;
	}
	/**An incorrect override
	 * @param Takes a graphnode to compare this to
	 * @return true or false based on the name
	 */
	public boolean equals(GraphNode n) {
		return this.label.getName().equals(n.getPerson().getName());
	} //checks if names are equal
	@Override
	public String toString() {
		return label.getName();
	} //end toString
} //end clas
