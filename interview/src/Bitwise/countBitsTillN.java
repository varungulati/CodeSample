package Bitwise;

import java.util.LinkedList;
import java.util.Queue;

public class countBitsTillN {
	static class ABC {
		public int data;
		public int count;
		public ABC(int data, int count) {
			this.data = data;
			this.count = count;
		}
	}
	public static int count(int n) {
		if(n <= 0) return 0;
		if(n == 1) return 1;
		Queue<ABC> queue = new LinkedList<ABC>();
		queue.add(new countBitsTillN.ABC(0,1));
		int total = 0;
		for (int i = 0; i < n; i++) {
			ABC temp = queue.remove();
			total += temp.count;
			queue.add(new ABC(2*temp.data + 1, temp.count));
			queue.add(new ABC(2*temp.data + 2, temp.count + 1));
		}
		return total;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(count(3));
		System.out.println(count(6));
		System.out.println(count(7));
	}

}
