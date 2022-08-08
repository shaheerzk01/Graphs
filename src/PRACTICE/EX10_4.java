package PRACTICE;

import java.io.*;

public class EX10_4 {
	
	int V = 4;
	void multiply(int A[][], int B[][], int C[][]) {
		for(int i=0; i<V; i++) {
			for(int j=0; j<V; j++) {
				C[i][j] = 0;
				for(int k=0; k<V; k++) {
					C[i][j] += A[i][k]* B[k][j];
				}
			}
		}
	}
	
	int getTrace(int graph[][]) {
		int trace = 0;
		for(int i=0; i<V; i++) {
			trace += graph[i][i];
		}
		return trace;
	}
	
	int triangleInGraph(int graph[][]) {
		// To Store graph^2
		int[][] aux2 = new int[V][V];
		
		// To Store graph^3
		int[][] aux3 = new int[V][V];
		
		// Initialising aux matrices
	    // with 0
		
		for (int i = 0; i < V; ++i) {
			for (int j = 0; j < V; ++j) {
				aux2[i][j] = aux3[i][j] = 0;
			}
		}
		
		multiply(graph, graph, aux2);
		// after this multiplication aux3
		// is graph^3 printMatrix(aux3)
		multiply(graph, aux2, aux3);
		int trace = getTrace(aux3);
		return trace / 6;
	}
	
	// Driver code
	public static void main(String args[]) {
		EX10_4 obj = new EX10_4();
		int graph[][] = { {0, 1, 1, 0},
				{1, 0, 1, 1},
				{1, 1, 0, 1},
				{0, 1, 1, 0}};
		System.out.println("Total number of Triangle in Graph : "+ obj.triangleInGraph(graph));
	}

}
