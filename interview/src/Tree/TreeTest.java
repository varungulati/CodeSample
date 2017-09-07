package Tree;

public class TreeTest {
	public static void main(String args[]) {
		Node treeRoot = new Node(10, null, null);
		Tree t = new Tree(treeRoot);
		t.add(new Node(20, null, null));
		t.add(new Node(1, null, null));
		t.add(new Node(5, null, null));
		t.add(new Node(6, null, null));
		Node node = new Node(0, null, null);
		t.add(node);
		t.add(new Node(30, null, null));
		System.out.println(t.nextInorderSuccessor(treeRoot, treeRoot).data);
		t.inorder(t.head);
		System.out.println();
		t.postorderNonRecrursive(t.head);
		System.out.println("Depth is: " + t.depth(t.head));
		System.out.println("Number of leaves: " + t.numLeaves(t.head));
		int arr[] = {1,2,3,4,5,6,7,8,9};
		Node root = Tree.minDepthTreeMaker(arr, 0, arr.length -1);
		System.out.println();
		t.pathFinder(t.head, 10);
		System.out.println(t.level(t.head, 10, 0));
//		t.mirror(t.head);
//		System.out.println(t.head.data);
//		System.out.println(t.head.left.left.data);
//		System.out.println(t.head.right.right.data);
		System.out.println(t.LCA(t.head, new Node(30, null, null), new Node(6, null,null)).data);
		System.out.println(t.diam(root));
		
	}
}
