package SerializationDeserialization;

class Node {
	public int data;
	public Node left;
	public Node right;
}

class Tree {
	public Node tree;
	public Tree() {
		this.tree = null;
	}
}

public class SerializationDeserialization {
	public static int preIndex = 0;
	public String preorder(Node tree) {
		if(tree == null) {
			return "";
		}
		return tree.data + preorder(tree.left) + preorder(tree.right);
	}
	public String inorder(Node tree) {
		if(tree == null) {
			return "";
		}
		return inorder(tree.left) + tree.data + inorder(tree.right);
	}
	public String serialize(Node tree) {
		if(tree == null) {
			return "";
		}
		return preorder(tree) + ":" + inorder(tree);
	}
	public Node deserializeHelper(String pre, String in, int strt, int end) {
		if(strt > end) {
			return null;
		}
		Node n = new Node();
		System.out.println("pre: " + preIndex);
		n.data = pre.charAt(preIndex);
		preIndex++;

		if(strt == end) {
			return n;
		}

		int indexIn = in.indexOf(n.data, strt);
		n.left = deserializeHelper(pre, in, strt, indexIn - 1);
		n.right = deserializeHelper(pre, in, indexIn + 1, end);
		return n;
	}
	public Node deserialize(String preorder) {
		String[] arr = preorder.split(":");
		return deserializeHelper(arr[0], arr[1], 0, arr[0].length() - 1);
	}
	public static void main(String[] args) {
		Tree t = new Tree();
		t.tree = new Node();
		t.tree.data = 1;
		t.tree.left = new Node();
		t.tree.left.data = 2;
		t.tree.left.left = new Node();
		t.tree.left.left.data = 3;
		t.tree.right = new Node();
		t.tree.right.data = 5;
		String pre = "";
		SerializationDeserialization obj = new SerializationDeserialization();
		pre = obj.serialize(t.tree);
		System.out.println(pre);
		Node n = obj.deserialize(pre);
		System.out.println(n.data);
		System.out.println(n.left.data);
		System.out.println(n.right.data);
	}

}
