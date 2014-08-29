public class TreeTester {
	public static void main(String[] args) {
		Tree tree = new Tree(1);
		tree.add(5);
		tree.add(2);
		tree.add(9);
		tree.add(0);
//		System.out.println(tree.commonAncestorBST(tree, 12, -9).getData());
//		tree.levelOrder(tree);
//		tree.inorder(tree.getRoot());
//		tree.inorderWithoutRecursion(tree);
		System.out.println(tree.depth(tree));
	}
}