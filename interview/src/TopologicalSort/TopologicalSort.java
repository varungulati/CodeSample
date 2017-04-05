package TopologicalSort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.PriorityQueue;
import java.util.Queue;
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
		StringBuffer st = new StringBuffer();
		for (int i = 0; i < V; i++) {
			if (!visited[i]) {
				topologicalSortUtil(visited, st, i);
			}
		}
		System.out.println(st.reverse());
	}

	private static void topologicalSortUtil(boolean[] visited,
			StringBuffer st, int i) {
		// TODO Auto-generated method stub
		visited[i] = true;
		for (int j = 0; j < adj.get(i).size(); j++) {
			if (!visited[adj.get(i).get(j)]) {
				topologicalSortUtil(visited, st, adj.get(i).get(j));
			}
		}
		st = st.append( Integer.valueOf(i));
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


	public static void topologicalSortFB() {
		boolean[] visited = new boolean[V];
		Arrays.fill(visited, false);
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < adj.size(); i++) {
			if(!visited[i]) {
				topologicalSortFBUtil(visited, st, i);
			}
		}
		System.out.println(st.toString());
	}
	private static void topologicalSortFBUtil(boolean[] visited, Stack<Integer> st, int v) {
		visited[v] = true;
		for(int i = 0; i < adj.get(v).size(); i++) {
			int nextNode = adj.get(v).get(i);
			if(!visited[nextNode]) {
				topologicalSortFBUtil(visited, st, nextNode);	
			}
		}
		st.push(v);
	}

	public static void topologicalSortFBNonRecursive() {
		// Populate indegree to all values = 0
		HashMap<Integer, Integer> indegree = new HashMap<>();
		for(int i = 0; i < V; i++) indegree.put(i, 0);
		// Point temp  to adj
		ArrayList<ArrayList<Integer>> temp = new ArrayList<ArrayList<Integer>>(adj);
		// Fill indegree based on values
		for(int i = 0; i < temp.size(); i++) {
			for(int j = 0; j < temp.get(i).size(); j++) {
					int nextNode = temp.get(i).get(j);
					indegree.put(nextNode, indegree.get(nextNode) + 1);
			}
		}
		// Queue to store nodes visited with no incoming edge
		Queue<Integer> q = new PriorityQueue<>();
		// First pass to get all edges with indegree = 0
		for(Integer i: indegree.keySet()) {
			if(indegree.get(i) == 0) q.add(i);
		}
		// Loop over queue and keep adding edges when indegree becomes 0
		while(!q.isEmpty()) {
			int curr = q.remove();
			System.out.println(curr);
			for(int i = 0; i < temp.get(curr).size(); i++) {
				indegree.put(temp.get(curr).get(i), indegree.get(temp.get(curr).get(i)) - 1);
				if(indegree.get(temp.get(curr).get(i)) == 0) q.add(temp.get(curr).get(i));
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TopologicalSort ts = new TopologicalSort();
		ts.addEdge(1, 3);
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
		topologicalSortFBNonRecursive();
		topologicalSortFB();
	}

}
