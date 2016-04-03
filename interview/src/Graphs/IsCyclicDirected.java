package Graphs;

import java.util.ArrayList;
import java.util.Arrays;

public class IsCyclicDirected {
	public static final int V = 3;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public IsCyclicDirected() {
		for (int i = 0; i < V; i++) {
			adj.add(new ArrayList<Integer>());
		}
	}

	public static void addEdge(int vertex, int edge) {
		if (vertex > V - 1) {
			return;
		}
		adj.get(vertex).add(edge);
	}
	public static boolean isCyclic() {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		boolean[] rec = new boolean[V];
		Arrays.fill(rec, false);
		
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				if (isCyclicUtil(visited, rec, i)) {
					return true;
				}
			}
		}
		return false;
	}
	private static boolean isCyclicUtil(boolean[] visited, boolean[] rec, int i) {
		visited[i] = true;
		rec[i] = true;
		for(int val: adj.get(i)) {
			if (!visited[val] && isCyclicUtil(visited, rec, val)) {
				return true;
			}
			if(rec[val]) {
				return true;
			}
		}
		rec[i] = false;
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		IsCyclicDirected d = new IsCyclicDirected();
		 IsCyclicDirected.addEdge(1, 1);
		 IsCyclicDirected.addEdge(0, 2);
		 IsCyclicDirected.addEdge(1, 2);
//		 IsCyclicDirected.addEdge(2, 3);
//		 IsCyclicDirected.addEdge(3, 3);
//		 IsCyclicDirected.addEdge(2, 0);
		 System.out.println(d.isCyclic());
	}

}
