package Graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class BFS {
	public static final int V = 4;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
	public BFS() {
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
	public static void bfs() {
		Queue<Integer> q = new PriorityQueue<Integer>();
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		q.add(0);
		visited[0] = true;
		while(!q.isEmpty()) {
			System.out.print(q.peek() + " ");
			ArrayList<Integer> neighbors = adj.get(q.peek());
			for (Integer value : neighbors) {
				if(!visited[value]) {
					visited[value] = true;
					q.add(value);
				}
			}
			q.remove();
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BFS bfs = new BFS();
		bfs.addEdge(0, 1);
		bfs.addEdge(0, 2);
		bfs.addEdge(1, 2);
		bfs.addEdge(2, 3);
		bfs.addEdge(2, 0);
		bfs.addEdge(3, 3);
		bfs.bfs();
	}

}
