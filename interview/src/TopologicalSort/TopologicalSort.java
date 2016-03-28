package TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Stack;

public class TopologicalSort {
	public static final int V = 6;
	public static ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();

	public TopologicalSort() {
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

	@Override
	public String toString() {
		StringBuffer sb = new StringBuffer();
		int count = 0;
		Iterator<ArrayList<Integer>> it = adj.iterator();
		while (it.hasNext()) {
			ArrayList<Integer> temp = it.next();
			sb.append(count + ": ");
			for (int i = 0; i < temp.size(); i++) {
				sb.append(temp.get(i) + " ");
			}
			sb.append("\n");
			count++;
		}
		return sb.toString();
	}

	public static void topologicalSort() {
		boolean visited[] = new boolean[V];
		Arrays.fill(visited, false);
		Stack<Integer> st = new Stack<Integer>();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(visited, st, i);
			}
		}
		System.out.println();
		while (!st.isEmpty()) {
			System.out.print(st.pop() + " ");
		}
	}

	private static void topologicalSortUtil(boolean[] visited,
			Stack<Integer> st, int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		for (int j = 0; j < adj.get(i).size(); j++) {
			if (!visited[adj.get(i).get(j)]) {
				topologicalSortUtil(visited, st, adj.get(i).get(j));
			}
		}
		st.push(i);
	}

	public static boolean allTopologicalSortUtil(int count, int i, boolean[] visited) {
		if(count == V) {
			return true;
		}
		boolean toReturn = false;
		for (int j = 0; j < adj.get(i).size(); j++) {
			if(!visited[adj.get(i).get(j)]) {
				boolean newVisited[] = new boolean[visited.length];
				newVisited = Arrays.copyOf(visited, 6);
				newVisited[i] = true;
				toReturn =allTopologicalSortUtil(count + 1, adj.get(i).get(j), newVisited); 
				if(toReturn) {
					System.out.print(adj.get(i).get(j) + " ");
				}
			}
		}
		return toReturn;
	}
	public static void allTopologicalSort() {
		allTopologicalSortUtil(0, 0, new boolean[V]);
	}



	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSort ts = new TopologicalSort();
//		ts.addEdge(1, 3);
//		ts.addEdge(2, 3);
//		ts.addEdge(4, 0);
//		ts.addEdge(4, 1);
//		ts.addEdge(5, 0);
//		ts.addEdge(5, 2);
		 TopologicalSort.addEdge(1, 0);
		 TopologicalSort.addEdge(1, 2);
		 TopologicalSort.addEdge(2, 5);
		 TopologicalSort.addEdge(3, 4);
		 TopologicalSort.addEdge(3, 0);
		 TopologicalSort.addEdge(4, 5);
		System.out.print(ts);
		topologicalSort();
	}

}
