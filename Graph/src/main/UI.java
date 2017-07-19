package main;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UI {
	
	public void UserInput() {
		//initiate the graph
		Graph g = new Graph();
		//These are the the initiation for all the nodes. 
		GraphNode A = new GraphNode(new People("A"));
		GraphNode B = new GraphNode(new People("B"));
		GraphNode C = new GraphNode(new People("C"));
		GraphNode D = new GraphNode(new People("D"));
		GraphNode E = new GraphNode(new People("E"));
		GraphNode F = new GraphNode(new People("F"));
		GraphNode G = new GraphNode(new People("G"));
		GraphNode H = new GraphNode(new People("H"));
		GraphNode I = new GraphNode(new People("I"));
		GraphNode J = new GraphNode(new People("J"));
		GraphNode K = new GraphNode(new People("K"));
		GraphNode L = new GraphNode(new People("L"));
		GraphNode M = new GraphNode(new People("M"));
		GraphNode N = new GraphNode(new People("N"));
		GraphNode O = new GraphNode(new People("O"));
		GraphNode P = new GraphNode(new People("P"));
		GraphNode Q = new GraphNode(new People("Q"));
		GraphNode R = new GraphNode(new People("R"));
		GraphNode S = new GraphNode(new People("S"));
		GraphNode T = new GraphNode(new People("T"));
		GraphNode U = new GraphNode(new People("U"));
		GraphNode V = new GraphNode(new People("V"));
		GraphNode W = new GraphNode(new People("W"));
		GraphNode X = new GraphNode(new People("X"));
		GraphNode Y = new GraphNode(new People("Y"));
		GraphNode Z = new GraphNode(new People("Z"));
		//these add all of the nodes to the graph
		g.addNode(A);
		g.addNode(B);
		g.addNode(C);
		g.addNode(D);
		g.addNode(E);
		g.addNode(F);
		g.addNode(G);
		g.addNode(H);
		g.addNode(I);
		g.addNode(J);
		g.addNode(K);
		g.addNode(L);
		g.addNode(M);
		g.addNode(N);
		g.addNode(O);
		g.addNode(P);
		g.addNode(Q);
		g.addNode(R);
		g.addNode(S);
		g.addNode(T);
		g.addNode(U);
		g.addNode(V);
		g.addNode(W);
		g.addNode(X);
		g.addNode(Y);
		g.addNode(Z);
		//these add random nodes. starting from a --Richard; not random, Richard --Jared
		g.addEdge(A, B);
		g.addEdge(A, C);
		g.addEdge(C, D);
		g.addEdge(B, E);
		g.addEdge(E, F);
		g.addEdge(D, F); //ADD EDGES
		g.addEdge(F, Z);
		g.addEdge(E, G);
		g.addEdge(B, X);
		g.addEdge(D, P);
		g.addEdge(S, C);
		g.addEdge(G, I);
		g.addEdge(H, Y);
		g.addEdge(I, J);
		g.addEdge(J, Z);
		g.addEdge(K, L);
		g.addEdge(L, O);
		g.addEdge(M, V);
		g.addEdge(N, A);
		g.addEdge(O, Q);
		g.addEdge(P, Z);
		g.addEdge(Q, X);
		g.addEdge(R, B);
		g.addEdge(S, H);
		g.addEdge(T, D);
		g.addEdge(U, E);
		g.addEdge(V, U);
		g.addEdge(W, Y);
		g.addEdge(X, G);
		g.addEdge(Y, I);
		g.addEdge(Z, K);
		g.addEdge(Q, W);
		g.addEdge(W, M);
		g.addEdge(M, N);
		g.addEdge(N, R);
		g.addEdge(X, S);
		g.addEdge(S, T);
		g.addEdge(K, U);
		//taking in the information from the user
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		//prompt to ask user what type of search that one would like to search for
		System.out.println("Nodes(People) in the graph are labelled A - Z for convenience");//it truly is
		System.out.println("Enter the Node you would like to search for: ");
		//this is a temporary variable to hold what the user would like to search for
		String answer = null;
		try {
			System.out.print(">>>");
			answer = grab.readLine();
		} catch(IOException io) {}
		//prompt to ask user to enter choice of type of search
		System.out.println("What type of search: Depth First Search(DFS) or Breadth First Search(BFS): [DFS/BFS]");
		String type = null;
		//looping until the user has given a satisfactory answer
		do {
			try {
				System.out.print(">>>");
				type = grab.readLine();
			} catch (IOException e) {
				e.printStackTrace();
			}
			
		}while(!type.toLowerCase().equals("bfs") && !type.toLowerCase().equals("dfs"));//searching whether the user had inputted correctly
		//the two options of breadth first or width first
		if(type.equals("bfs")){
			System.out.println("Breadth First Search (Queue):  \n");
			System.out.println("Starting with root node A...  \n");
			try {
			g.Breadth(g.getAdjacency().gnFind(answer.toUpperCase()));//calls the Breadth search in the graph class
			runAgain();
			} catch(NullPointerException npe) {
				System.out.println("Please enter a letter");
				runAgain();
			} //end catch
		} //end if
		else {
			System.out.println("Depth First Search (Stack):  \n");
			System.out.println("Starting with root node A...  \n");
			try {
			g.Depth(g.getAdjacency().gnFind(answer.toUpperCase()));//calls the depth search in the graph class
			runAgain();
			}catch(NullPointerException npe) {
				System.out.println("Please enter a letter");//this means that the user has attempted to troll us.
				runAgain();
			} //end catch
		} //end else
	}//end userinput
	
	public void runAgain() { //checks if user wants to search again
		InputStreamReader nab = new InputStreamReader(System.in);
		BufferedReader grab = new BufferedReader(nab);
		//input
		String answer = null; //arbitrary
		System.out.println("Run again? [y/n]");
		try {
			System.out.print(">>>");
			answer = grab.readLine();
		} catch (IOException e) {
			e.printStackTrace();
		}
		if(answer.toLowerCase().equals("y")) UserInput();
		else System.out.println("Okay, have a nice day");
		
	} //end runagain

}//end class
