package Kruskal;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

class Graph {
	int E, V;

	public Graph(int v, int e) {
		this.V = v;
		this.E = e;
		edge = new Edge[e];
		for(int i = 0; i < e; i++) {
			edge[i] = new Edge();
 		}
	}

	public Edge[] edge;
	

	public void KruskalMST() {
		if(edge.length == 0) return;
		Arrays.sort(edge, new Comparator<Edge>() {
			@Override
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});
		
		Subset[] subset = new Subset[V];
		for(int i = 0; i < V; i++) {
			subset[i] = new Subset();
			subset[i].parent = i;
			subset[i].rank = 0;
		}
		
		List<Edge> toReturn = new ArrayList<Edge>();
		for(int i = 0; i < edge.length && toReturn.size() < V; i++) {
			int x = find(edge[i].src, subset);
			int y = find(edge[i].dest, subset);
			
			if(x != y) {
				toReturn.add(edge[i]);
				union(x, y, subset);
			}
		}
		for(Edge e: toReturn) {
			System.out.println(e.src + " " + e.dest + " " + e.weight);
		}
	}


	private void union(int x, int y, Subset[] subset) {
		int xroot = find(x, subset);
		int yroot = find(y, subset);
		
		if(subset[xroot].rank < subset[yroot].rank){
			subset[xroot].parent = yroot;
		} else if(subset[xroot].rank > subset[yroot].rank) {
			subset[yroot].parent = xroot;
		} else {
			subset[xroot].parent = yroot;
			subset[yroot].rank++;
		}
	}


	private int find(int node, Subset[] subset) {
		if(subset[node].parent != node) {
			subset[node].parent = find(subset[node].parent, subset);
		}
		return subset[node].parent;
	}

}
