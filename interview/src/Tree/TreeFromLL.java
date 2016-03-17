package Tree;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class TreeFromLL {
	static class Node{
		public int data;
		public Node left;
		public Node right;
		public Node(int data) {
			this.data = data;
			this.left = null;
			this.right = null;
		}
	}

	public Node root;
	public static Node createTree(LinkedList<Node> ll) {
		if(ll.size() == 0) return null;
		if(ll.size() == 1) return ll.get(0);
		Queue<Node> queue = new LinkedList<>();
		Node toReturn = new Node(ll.get(0).data);
		Node currNode = toReturn;
		int i = 1;
		queue.add(currNode);
		while(!queue.isEmpty()) {
			currNode = queue.remove();
			if(i < ll.size()) {
				currNode.left = ll.get(i);
				queue.add(ll.get(i));
				i++;
				if(i < ll.size()) {
					currNode.right = ll.get(i);
					queue.add(ll.get(i));
					i++;
				}
			}
		}
		return toReturn;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList<Node> ll = new LinkedList<Node>();
		ll.add(new Node(10));
		ll.add(new Node(12));
		ll.add(new Node(15));
		ll.add(new Node(25));
		ll.add(new Node(30));
		ll.add(new Node(36));
		for (int i = 0; i < ll.size(); i++) {
			System.out.print(ll.get(i).data + " ");
		}
		Node root = createTree(ll);
		System.out.println();
		System.out.print(root.data + " ");
		System.out.print(root.left.data + " ");
		System.out.print(root.right.data + " ");
		System.out.print(root.left.left.data + " ");
		System.out.print(root.left.right.data + " ");
		System.out.print(root.right.left.data + " ");
	}

}
