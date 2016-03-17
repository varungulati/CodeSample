package Tree;

public class Tree {
	Node head;
	
	public Tree() {
		this.head = null;
	}
	public Tree(Node node) {
		this.head = node;
	}
	
	public void inorder(Node node) {
		if(node == null) {
			return;
		}
		inorder(node.left);
		System.out.println(node.data);
		inorder(node.right);
	}
	
	public void preorder(Node node) {
		if(node == null) {
			return;
		}
		System.out.println(node.data);
		preorder(node.left);
		preorder(node.right);
	}
	
	public void postorder(Node node) {
		if(node == null) {
			return;
		}
		postorder(node.left);
		postorder(node.right);
		System.out.println(node.data);
	}
	
	public void add(Node node) {
		if(this.head == null) {
			this.head = node;
			return;
		}
		Node temp = this.head;
		while(true) {
			if(node.data > temp.data) {
				if(temp.right == null) {
					temp.right = node;
					break;
				}
				temp = temp.right;
			} else {
				if(temp.left == null) {
					temp.left = node;
					break;
				}
				temp = temp.left;
			}
		}
	}
	
	public int numLeaves(Node node) {
		if(node == null) {
			return 0;
		}
		if(node.left == null && node.right == null) {
			return 1;
		}
		return numLeaves(node.left) + numLeaves(node.right);
	}
	
	public int depth(Node node) {
		if(node == null) {
			return -1;
		}
		return 1 + Math.max(depth(node.left), depth(node.right));
	}
}
