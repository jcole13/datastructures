package main;

public class Graph {
	//instance variables
	private LList allNodes;
	private LList allEdges;
	private LList adjList;
	//constructor
	public Graph() {
		allNodes = new LList();
		allEdges = new LList();
		adjList = new LList();
	} //end constructor
	public void addNode(GraphNode n){//adds a Graphnode to all nodes and creats a new connection
		allNodes.append(n);
		adjList.append(new LList(n));
	} //end addNode
	public void addEdge(GraphNode f, GraphNode t){//finds the graphnode and connects two things
		GraphEdge temp = new GraphEdge(f, t);
		allEdges.append(temp);
		Node found = adjList.adjfind(f);
		((LList) found.getData()).append(t);
	} //end addEdge
	public LList getAdjacency() {
		return adjList;
	} //end getAdjacency
	/**This method uses stacks and searches deep
	 * @param Graphnode to search for from the first input
	 * @return true or false based on whether it could be found
	 */
	public boolean Depth(GraphNode n) {
		Stack stack = new Stack();//initiate a new stack
		GraphNode first = ((LList) adjList.getFirst().getData()).getLabel();
		
		stack.join(first);//adds to the stack to start the chain
		first.setVisited(true);
		
		while(!stack.isEmpty()) {
			GraphNode g = (GraphNode) stack.leave();//takes off the top of the stack
			System.out.println("Leave: " + g);
			if(g.equals(n)) {
				System.out.println("Found " + g);//breaks out of the program
				return true;
			}
			Node node = adjList.adjfind(g);//find the things that are adjacent to the stack
			Node gn = ((LList) node.getData()).getFirst();//finds the things in the llist
			for(int j = 0; j < ((LList) node.getData()).getLength(); j++) {
				if(!((GraphNode) gn.getData()).getVisited()) {//incase of already used
					stack.join(((GraphNode)gn.getData()));//adds to the stack that everything next to the node just removed
					System.out.println("Join: " + (GraphNode) gn.getData());
					if(((GraphNode)gn.getData()).equals(n)) {
						System.out.println("Found " + ((GraphNode)gn.getData()));
						return true;
					}
					System.out.println("After Join: " + stack);
					((GraphNode) gn.getData()).setVisited(true);//so we dont revisit
				}
				gn = gn.getNext();
			} //end for
		} //end while
		return false;//ah well i give up
	} //Depth
	/**This method uses queues and searches wide
	 * @param GraphNode to search for
	 * @return true or false to answer
	 */
	public boolean Breadth(GraphNode n) {
		//initiate a new Queue
		Queue queue = new Queue();
		GraphNode first = ((LList) adjList.getFirst().getData()).getLabel();
		//start the queue with the start of the search
		queue.join(first);
		first.setVisited(true);
		//goes to search
		while(!queue.isEmpty()) {
			GraphNode g = (GraphNode) queue.leave();//takes the top of the queue
			System.out.println("Leave: " + g);
			if(g.equals(n)) {//yay, the target was removed
				System.out.println("Found: " + g);
				return true;
			}
			Node node = adjList.adjfind(g);//find everything next to the node
			Node gn = ((LList) node.getData()).getFirst();//get everything adjacent
			for(int j = 0; j < ((LList) node.getData()).getLength(); j++) {
				if(!((GraphNode) gn.getData()).getVisited()) {//skip a place
					queue.join(((GraphNode)gn.getData()));
					System.out.println("Join: " + (GraphNode) gn.getData());
					if(((GraphNode)gn.getData()).equals(n)) {
						System.out.println("Found " + ((GraphNode)gn.getData()));//rings when it is added to the queue, checks when joined
						return true;
					}
					System.out.println("After Joined: " + queue);
					((GraphNode) gn.getData()).setVisited(true);//so there is no overlapping
				}
				gn = gn.getNext(); //next node
			}//end for
		} //end while
		return false;//givin up
	} //end Breadth	 
}
