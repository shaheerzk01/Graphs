package PROGRAMS;

import java.util.*;

public class PROGRAM5 {
	
	static void insert(Vector<Integer> adj[],int u, int v){

         // Insert a vertex v to vertex u
         adj[u].add(v);
         return;
    }

    //Function to display adjacency list
    static void printList(Vector<Integer> adj[],int V){
         for(int i = 1; i < V; i++){
             System.out.print(i);
             for(int j : adj[i])
                  System.out.print(" --> " + j);
      
             System.out.println();
         }
         System.out.println();
    }
     
     //Driver code
     public static void main(String[] args){
           int V = 6;

           Vector<Integer> []adjList = new Vector[V];
           for(int i = 1; i < adjList.length; i++)
                 adjList[i] = new Vector<Integer>();
  
           // Inserting edges
           insert(adjList, 1, 2);
           insert(adjList, 1, 5);
           insert(adjList, 2, 3);
           insert(adjList, 2, 4);
           insert(adjList, 4, 1);
           insert(adjList, 4, 3);
           insert(adjList, 4, 5);
           insert(adjList, 5, 2);
           insert(adjList, 5, 4);
           
           // Display adjacency list
           System.out.print("Adjacency List: \n");
           printList(adjList, V);
          
   }

}
