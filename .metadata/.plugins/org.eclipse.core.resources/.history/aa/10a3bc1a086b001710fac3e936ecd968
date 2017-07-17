package main;

public class Graph {
	LList allNodes;
	LList allEdges;
	LList adjList;
	
	public Graph() {
		allNodes = new LList();
		allEdges = new LList();
		adjList = new LList();
	}
	public void addNode(GraphNode n){
		allNodes.append(n);
		adjList.append(new LList(n));
	}
	public void addEdge(GraphNode f, GraphNode t){
		GraphEdge temp = new GraphEdge(f, t);
		allEdges.append(temp);
		Node found = adjList.adjfind(f);
		((LList) found.getData()).append(t);

	}
	
	public boolean Depth(GraphNode n) {
		Stack stack = new Stack();
		GraphNode first = ((LList) adjList.getFirst().getData()).getLabel();
		
		stack.join(first);
		first.setVisited(true);
		
		while(!stack.isEmpty()) {
			//System.out.println(first);
			GraphNode g = (GraphNode) stack.leave();
			System.out.println("Leave: " + g);
			//System.out.println(g);
			if(g.equals(n)) {
				System.out.println("Found " + g);
				return true;
			}
			Node node = adjList.adjfind(g);
			Node gn = ((LList) node.getData()).getFirst();
			for(int j = 0; j < ((LList) node.getData()).getLength(); j++) {
				if(!((GraphNode) gn.getData()).getVisited()) {
					//System.out.println("Richard");
					stack.join(((GraphNode)gn.getData()));
					System.out.println("Join: " + (GraphNode) gn.getData());
					System.out.println("After Join: " + stack);
					((GraphNode) gn.getData()).setVisited(true);
				}
				gn = gn.getNext();
				
			}
			
		}
		return false;
	}
	
	public boolean Breadth(GraphNode n) {
		Queue queue = new Queue();
		
		GraphNode first = ((LList) adjList.getFirst().getData()).getLabel();
		
		queue.join(first);
		first.setVisited(true);
		
		while(!queue.isEmpty()) {
			GraphNode g = (GraphNode) queue.leave();
			System.out.println("Leave: " + g);
			//System.out.println(g);
			if(g.equals(n)) {
				System.out.println("Found: " + g);
				return true;
			}
			Node node = adjList.adjfind(g);
			Node gn = ((LList) node.getData()).getFirst();
			for(int j = 0; j < ((LList) node.getData()).getLength(); j++) {
				if(!((GraphNode) gn.getData()).getVisited()) {
					queue.join(((GraphNode)gn.getData()));
					System.out.println("Join: " + (GraphNode) gn.getData());
					System.out.println("After Joined: " + queue);
					((GraphNode) gn.getData()).setVisited(true);
				}
				gn = gn.getNext();
				
			}
			
		}
		return false;
	}	
	
	



	

}
