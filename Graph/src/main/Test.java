package main;

public class Test {
	
	public static void main(String [] args) {
		
		Graph g = new Graph();
		GraphNode A = new GraphNode(new People("A"));
		GraphNode B = new GraphNode(new People("B"));
		GraphNode C = new GraphNode(new People("C"));
		GraphNode D = new GraphNode(new People("D"));
		GraphNode E = new GraphNode(new People("E"));
		GraphNode F = new GraphNode(new People("F"));
		g.addNode(A);
		g.addNode(B);
		g.addNode(C);
		g.addNode(D);
		g.addNode(E);
		g.addNode(F);
		g.addEdge(A, B);
		g.addEdge(A, C);
		g.addEdge(C, D);
		g.addEdge(B, E);
		g.addEdge(E, F);
		g.addEdge(D, F);
		//g.addEdge(B, D);
		g.Breadth(D);
		//System.out.println(g.allEdges);
		//g.adjList.adjfind(C);
		
	}

}
