public class Node {
	private int data;
	private Node left;
	private Node right;
	
	public Node(int data) {
		this.setData(data);
		this.setLeft(null);
		this.setRight(null);
	}
	public Node(int data, Node left, Node right) {
		this.setData(data);
		this.setLeft(left);
		this.setRight(right);
	}
	public int getData() {
		return this.data;
	}
	public Node getLeft() {
		return this.left;
	}
	public Node getRight() {
		return this.right;
	}
	public void setData(int data) {
		this.data = data;
	}
	public void setLeft(Node left) {
		this.left = left;
	}
	public void setRight(Node right) {
		this.right = right;
	}
	public boolean equals(Object o) {
		if(o instanceof Node) {
			Node temp = (Node)o;
			if(temp.getData() == this.getData()) {
				return true;
			} else {
				return false;
			}
		} else {
			throw new IllegalArgumentException();
		}
	}
}