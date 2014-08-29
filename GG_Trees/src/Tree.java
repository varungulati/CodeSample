
public class Tree {
	int data;
	Tree left;
	Tree right;
	public Tree(int data, Tree left, Tree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public static int getTreeHeight(Tree root) {
		if(root == null) {
			return -1;
		}
		return 1 + Math.max(getTreeHeight(root.left), getTreeHeight(root.right));
	}
	public String inOrder(Tree root) {
		if(root == null) {
			return "";
		}
		return inOrder(root.left) + " " + root.data + " "  + inOrder(root.right);
	}
	public String preOrder(Tree root) {
		if(root == null) {
			return "";
		}
		return root.data + " "  + preOrder(root.left) + " " + preOrder(root.right);
	}
	public String postOrder(Tree root) {
		if(root == null) {
			return "";
		}
		return postOrder(root.left) + " "  + postOrder(root.right) + " " + root.data;
	}
}
