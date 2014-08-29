
public class InsertSortedMinDepth {
	public static Tree insertTree(int[] arr, int lo, int hi) {
		if(lo > hi) {
			return null;
		}
		int mid = (lo+hi)/2;
		Tree tree = new Tree(arr[mid]);
		tree.left = insertTree(arr, lo, mid - 1);
		tree.right = insertTree(arr, mid + 1, hi);
		return tree;
	}
	public static int maxDepth(Tree root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
	}
	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6};
		Tree tree = insertTree(arr, 0, arr.length - 1);
		System.out.println(maxDepth(tree));
		tree.inorder(tree);
	}
}
