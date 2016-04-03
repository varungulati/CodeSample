package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class DFS {
	public static final int V = 6;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public DFS() {
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
	public static void dfsUtil(boolean[] visited, int index) {
		visited[index] = true;
		for (int j : adj.get(index)) {
			if (!visited[j]) {
				dfsUtil(visited, j);
			}
		}
		System.out.print(index + " ");
	}
	public static void dfs() {
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				dfsUtil(visited, i);
			}
		}
	}


	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		DFS d = new DFS();
		 DFS.addEdge(1, 0);
		 DFS.addEdge(1, 2);
		 DFS.addEdge(2, 5);
		 DFS.addEdge(3, 4);
		 DFS.addEdge(3, 0);
		 DFS.addEdge(4, 5);
		 DFS.dfs();
	}

}
