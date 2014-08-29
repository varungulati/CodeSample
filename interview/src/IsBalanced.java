// Check if a tree is balanced.
// Difference between max depth and min depth should not exceed 1.
class Trees {
	public int data;
	public Trees left;
	public Trees right;
	
	public Trees(int data) {
		this.data = data;
		this.left = this.right = null;
	}
	public Trees(int data, Trees left, Trees right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
public class IsBalanced {
	private static int maxDepth(Trees root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	private static int minDepth(Trees root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.min(maxDepth(root.left), maxDepth(root.right));
	}
	public static boolean isBalanced(Trees root) {
		System.out.println(maxDepth(root));
		System.out.println(minDepth(root));
		return 1 >= maxDepth(root) - minDepth(root);
	}
	public static void main(String[] args) {
//		Trees root = new Trees(5, new Trees(4), new Trees(
//			15, new Trees(12, new Trees(10), null), new Trees(18, new Trees(16), new Trees(20))));
		Trees root = new Trees(5, new Trees(4), null);
		System.out.println(isBalanced(root));;
	}
}
