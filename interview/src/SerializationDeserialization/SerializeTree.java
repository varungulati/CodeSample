package SerializationDeserialization;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class SerializeTree {
	Node root = null;
	static class Node {
		int data;
		Node left;
		Node right;
		public Node(int data, Node left, Node right) {
			this.data = data;
			this.left = left;
			this.right = right;
		}
	}
	static class ABC {
		int index;
		Node node;
		public ABC(Node node, int index) {
			this.index  = index;
			this.node = node;
		}
	}
	
	public SerializeTree(Node root) {
		this.root = root;
	}
	public static int depth(Node root) {
		if(root == null) {
			return -1;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
	public static String serialize(Node root) {
		if(root == null) {
			return "";
		}
		Queue<ABC> q = new LinkedList<ABC>();
		int arr[] = new int[(int)Math.pow(2, depth(root) +1) - 1];
		Arrays.fill(arr, -1);
		q.add(new ABC(root, 0));
		while(!q.isEmpty()) {
			ABC temp = q.remove();
			if(temp.node == null) {
				arr[temp.index] = -1;
				continue;
			}
			arr[temp.index] = temp.node.data;
			if(2*temp.index + 2 < arr.length) {
				q.add(new ABC(temp.node.left, 2*temp.index + 1));
				q.add(new ABC(temp.node.right, 2*temp.index + 2));
			}
		}
		return Arrays.toString(arr);
	}
	public static Node deserialize(String ser) {
		if(ser.length() == 0) return null;
		int arr[] = new int[ser.split(",", 20).length];
		int j = 0;
		for (int i = 0; i < ser.length(); i++) {
			if(ser.charAt(i) == ',' || ser.charAt(i) == '[' || ser.charAt(i) == ']' || ser.charAt(i) == ' ') {
				continue;
			} if(ser.charAt(i) == '-') {
				arr[j++] = -1;
				i++;
			} else {
				arr[j++] = Integer.valueOf(Character.toString(ser.charAt(i)));
			}
		}
		Node toReturn = new Node(arr[0], null, null);
		Node temp = null;
		int p = 0;
		Queue<ABC> q = new LinkedList<ABC>();
		q.add(new ABC(toReturn, 0));
		while(!q.isEmpty()) {
			ABC del = q.remove();
			p = del.index;
			temp = del.node;
			if(2*p + 2 < arr.length) {
				temp.left = new Node(arr[2*p + 1], null, null);
				temp.right = new Node(arr[2*p + 2], null, null);
				q.add(new ABC(temp.left, 2*p + 1));
				q.add(new ABC(temp.right, 2*p + 2));
			}
		}
		return toReturn;
	}
	public static String display(Node root) {
		Queue<Node> q = new LinkedList<Node>();
		q.add(root);
		StringBuffer sb = new StringBuffer();
		while(!q.isEmpty()) {
			Node temp = q.remove();
			if(temp != null) {
				sb.append(temp.data + ", ");
				q.add(temp.left);
				q.add(temp.right);
			} else {
				sb.append(" -1, ");
			}
		}
		return sb.toString();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node root = new Node(1, new Node(2, new Node(4, new Node(6, null, null), null), null), new Node(3, null, new Node(5, null, null)));
		SerializeTree t = new SerializeTree(root);
		System.out.println(t.depth(root));
		System.out.println(t.serialize(root));
		System.out.println(display(deserialize(t.serialize(root))));
	}

}
