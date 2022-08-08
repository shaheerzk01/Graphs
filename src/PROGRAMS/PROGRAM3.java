package PROGRAMS;

import java.util.Iterator;
import java.util.Scanner;
import java.util.LinkedList;

public class PROGRAM3 {
	
	static class Graph
    {
        // vertices and edges
        int v, e;
        int[][] dir;
  
        //Graph Constructor
        Graph(int v, int e) {
            this.v = v;
            this.e = e;
            dir = new int[v][];
            for (int i = 0; i < v; i++)
                dir[i] = new int[v];
        }
    }
	
	    // No. of vertices
		private int V;
		
	    // Adjacency List Representation
		private LinkedList<Integer> adj[];
		
		//constructor
		PROGRAM3(int v){
			V = v;
			adj = new LinkedList[v];
			for(int i=0; i< v; i++) {
				adj[i] = new LinkedList();
			}
		}
		
		// Function to add an edge
	    // into the graph
		void addEdge(int v, int w) {
			adj[v].add(v);
			adj[w].add(w);
		}
			
		static Graph createGraph(int v, int e) 
	    {
	        Graph G = new Graph(v, e);
	  
	        G.dir[1][2] = 1;
	        G.dir[1][3] = 1;
	        G.dir[2][7] = 1;
	        G.dir[2][6] = 1;
	        G.dir[2][8] = 1;
	        G.dir[3][4] = 1;
	        G.dir[3][5] = 1;
	        G.dir[6][8] = 1;
	        G.dir[6][10] = 1;
	        G.dir[6][9] = 1;
	        G.dir[7][9] = 1;
	        G.dir[10][11] = 1;
	        return G;
	    }
		
		// A recursive function that uses visited[] and parent to detect cycle in subgraph reachable
	    // from vertex v.
		
		boolean isCyclicUtil(int v, Boolean visited[], int parent) {
			// Mark the current node as visited
			visited[v] = true;
			Integer i;
			
			// Recur for all the vertices adjacent to this vertex
			Iterator<Integer> it = adj[v].iterator();
			while(it.hasNext()) {
				i = it.next();
				// If an adjacent is not
				// visited, then recur for that
				// adjacent
				if(!visited[i]) {
					if(isCyclicUtil(i, visited, v)) {
						return true;
					}
				}
				// If an adjacent is visited and not parent of current vertex,then there is a cycle.
				else if (i != parent) {
					return true;
				}
				return false;
				
			}
			return false;
			
		}
		// Returns true if the graph contains a cycle, else false.
		boolean isCyclic() {
			// Mark all the vertices as not visited and not part of recursion stack
			Boolean visited[] = new Boolean[V];
			for (int i = 0; i < V; i++) {
				visited[i] = false;
			}
			// Call the recursive helper function to detect cycle in different DFS tree.
			for(int u=0; u<V; u++) {
				 // Don't recur for u if already visited
				if(!visited[u]) {
					if(isCyclicUtil(u, visited, -1)) {
						return true;
					}
				}
			}
			return false;
		}
		
		public int countEdges()
		{
			int sum = 0;
			
	        for (int i = 0; i < V; i++)
	            sum += adj[i].size();
			return sum/2;
		}
		
		public int countVertices() {
			return V;
		}
		
		static int findDegree(Graph G, int ver) 
	    {
	        int degree = 0;
	        int d = 0;
	        for (int i = 0; i < G.v; i++) {
	            if (G.dir[ver][i] == 1)
	                degree++;
	        }
	            for(int j=0; j<G.v; j++) {
	            	if (G.dir[j][ver] == 1)
		                d++;
	            }
	        if(G.dir[ver][ver] == 1) degree++;
	        System.out.println("indegree of verteice is " + d);
	        System.out.println("outdegree of verteice is " + degree);
	        return degree;
	    }

		public static void main(String[] args)
		{
			PROGRAM3 g = new PROGRAM3(12);
			
			g.addEdge(1, 2);
			g.addEdge(1, 3);
			g.addEdge(3, 4);
			g.addEdge(3, 5);
			g.addEdge(2, 6);
			g.addEdge(2, 7);
			g.addEdge(2, 8);
			g.addEdge(6, 9);
			g.addEdge(6, 8);
			g.addEdge(6, 10);
			g.addEdge(7, 9);
			g.addEdge(10, 11);
			if (g.isCyclic())
		           System.out.println("Graph contains cycle");
		    else
		           System.out.println("Graph doesn't contains cycle");
			
			System.out.println("number of edges in graph is "+ g.countEdges());
			System.out.println("number of vertices in graph is "+ g.countVertices());
			int vertices = g.countVertices() + 1;;
	        int edges = g.countEdges();;
	        Graph G = createGraph(vertices, edges);
	        Scanner input = new Scanner(System.in);
	        System.out.println("Degree of which verteice?");
	        int x = input.nextInt();
	        int ver = x;
	        findDegree(G, ver);
		}
	}


