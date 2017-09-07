package Djixtra;

import java.util.Arrays;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Djixtra {
	private Map<Integer, Map<Integer, Integer>> graph = new TreeMap<Integer, Map<Integer, Integer>>();
	
	public String printer(Map<Integer, Map<Integer, Integer>> graph) {
		for(int i: graph.keySet()) {
			for(int j: graph.get(i).keySet())
				System.out.println(i + " " + j + " " + graph.get(i).get(j));
		}
		return "";
	}
	
	public void djixtra(int src) {
		int[] dist = new int[graph.size()];
		Arrays.fill(dist, Integer.MAX_VALUE);
		
		dist[src] = 0;
		
		boolean[] visited = new boolean[graph.size()];
		Arrays.fill(visited, false);
		
		int least = src;
		
		for(int i = 0; i < graph.size() - 1; i++) {
			least = leastNotVisitedEdge(visited, dist);
			visited[least] = true;
			
		}
	}
	private int leastNotVisitedEdge(boolean[] visited, int[] dist) {
		int min = Integer.MAX_VALUE, toReturn = -1;
		
		for(int i = 0; i < graph.size(); i++) {
			if(!visited[i] && min > dist[i]) {
				toReturn = i;
				min = dist[i];
			}
		}
		return toReturn;
	}

	public static void main(String args[]) {
		Djixtra dj = new Djixtra();
		Map<Integer, Integer> temp = new TreeMap<>();
		temp.put(1, 4);
		temp.put(7, 8);
		dj.graph.put(0, temp);
		Map<Integer, Integer> temp1 = new TreeMap<>();
		temp1.put(2, 8);
		temp1.put(7, 11);
		temp1.put(0, 4);
		dj.graph.put(1, temp1);
		Map<Integer, Integer> temp2 = new TreeMap<>();
		temp2.put(8, 2);
		temp2.put(3, 7);
		temp2.put(1, 8);
		dj.graph.put(2, temp2);
		Map<Integer, Integer> temp3 = new TreeMap<>();
		temp3.put(2, 7);
		temp3.put(4, 9);
		temp3.put(5, 14);
		dj.graph.put(3, temp3);
		Map<Integer, Integer> temp4 = new TreeMap<>();
		temp4.put(3, 9);
		temp4.put(5, 10);
		dj.graph.put(4, temp4);
		Map<Integer, Integer> temp5 = new TreeMap<>();
		temp5.put(2, 4);
		temp5.put(6, 2);
		temp5.put(3, 14);
		temp5.put(4, 10);
		dj.graph.put(5, temp5);
		Map<Integer, Integer> temp6 = new TreeMap<>();
		temp6.put(5, 2);
		temp6.put(7, 1);
		temp6.put(8, 6);
		dj.graph.put(6, temp6);
		Map<Integer, Integer> temp7 = new TreeMap<>();
		temp7.put(0, 8);
		temp7.put(1, 11);
		temp7.put(8, 7);
		dj.graph.put(7, temp7);
		Map<Integer, Integer> temp8 = new TreeMap<>();
		temp8.put(2, 2);
		temp8.put(7, 7);
		temp8.put(6, 6);
		dj.graph.put(8, temp8);
		System.out.println(dj);
	}
}
