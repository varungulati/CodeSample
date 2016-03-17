package Tree;

public class TreeTest {
	public static void main(String args[]) {
		Tree t = new Tree(new Node(10, null, null));
		t.add(new Node(20, null, null));
		t.add(new Node(1, null, null));
		t.inorder(t.head);
		System.out.println("Depth is: " + t.depth(t.head));
		System.out.println("Number of leaves: " + t.numLeaves(t.head));
	}
}
