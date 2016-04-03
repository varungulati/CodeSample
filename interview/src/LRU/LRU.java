package LRU;

import java.util.HashMap;

// Least recently used cache
public class LRU {
	static class Node {
		int data;
		Node next;
		Node back;
		public Node() {
			
		}
		public Node(int data, Node next, Node back) {
			this.data = data;
			this.next = next;
			this.back = back;
		}
	}
	static final int maxSize = 3;
	static int size = 0;
	static HashMap<Integer, Node> cache = new HashMap<>();
	static Node rear = null;
	static Node front = null;
	public static void add(int data) {
		if(size < maxSize) {
			Node n = new Node(data, front, rear);
			cache.put(data, n);
			if(size == 0) {
				front = n;
				rear = n;
			} else {
				front.next = n;
				rear.back = n;
				rear = n;
			}
		} else {
			cache.remove(front.data);
			front.data = data;
			rear = front;
			front = front.back;
			cache.put(data, rear);
		}
		size++;
	}
	public static void display() {
		for (int val : cache.keySet()) {
			System.out.print(val + ": " + cache.get(val).data);
			System.out.println();
		}
		System.out.println(front.data);
		System.out.println(rear.data);
	}
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LRU l = new LRU();
		l.add(4);
		l.add(1);
		l.add(6);
		l.add(7);
		l.add(8);
		l.display();
	}

}
