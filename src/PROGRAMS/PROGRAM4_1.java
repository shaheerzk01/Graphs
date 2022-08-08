package PROGRAMS;

import java.util.Scanner;

public class PROGRAM4_1{

    private final int vertices;
    private int[][] adjacency_matrix;
 
    public PROGRAM4_1(int v) 
    {
        vertices = v;
        adjacency_matrix = new int[vertices + 1][vertices + 1];
    }
 
    public void makeEdge(int to, int from, int edge) {
    	 adjacency_matrix[to][from] = edge;     
    }
    public int getEdge(int to, int from) {
    	return adjacency_matrix[to][from];
    }
 
    public static void main(String args[]) 
    {
        int v, e, count = 1, to = 0, from = 0;
        Scanner sc = new Scanner(System.in);
        PROGRAM4_1 graph;
       
            System.out.println("Enter the number of vertices: ");
            v = sc.nextInt();
            System.out.println("Enter the number of edges: ");
            e = sc.nextInt();
 
            graph = new PROGRAM4_1(v);
 
            System.out.println("Enter the edges: <to> <from>");
            while (count <= e) 
            {
                to = sc.nextInt();
                from = sc.nextInt();
 
                graph.makeEdge(to, from, 1);
                count++;
            }
 
            System.out.println("The adjacency matrix for the given graph is: ");

 
            for (int i = 1; i <= v; i++) 
            {
                System.out.print(i + " : ");
                for (int j = 1; j <= v; j++) 
                    System.out.print(graph.getEdge(i, j) + " ");
                System.out.println();
            }
 
        }
        
    }


