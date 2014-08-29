class DoubleNode {
	public DoubleNode front;
	public DoubleNode back;
	public Tree tree;
	public DoubleNode(Tree tree) {
		this.tree = tree;
	}
}
class DoublyLinkedList {
	public DoubleNode node;
	
	public DoublyLinkedList(Tree tree) {
		this.node = new DoubleNode(tree);
		this.node.front = this.node;
		this.node.back = this.node;
	}
	public DoublyLinkedList() {
		node = null;
	}
	public DoublyLinkedList add(DoublyLinkedList result, Tree tree) {
		if(result.node == null) {
			result = new DoublyLinkedList(tree);
			return result;
		}
		DoubleNode toAdd = new DoubleNode(tree);
		toAdd.front = result.node;
		result.node.back.front = toAdd;
		toAdd.back = result.node.back;
		result.node.back = toAdd;
		result.node = toAdd;
		return result;
	}
	public void display() {
		if(this.node == null) {
			return;
		}
		DoubleNode temp = this.node.back;
		System.out.println(temp.tree.data);
		temp = temp.back;
		while(temp != this.node) {
			System.out.println(temp.tree.data);
			temp = temp.back;
		}
		System.out.println(temp.tree.data);
	}
}
public class TreeToDLL {
	public static DoublyLinkedList result = new DoublyLinkedList();
	public void inorderTreeToDLL(Tree tree) {
		if(tree == null) {
			return;
		}
		inorderTreeToDLL(tree.left);
		result = result.add(result, tree);
		inorderTreeToDLL(tree.right);
	}
	public void display() {
		result.display();
	}
	public static void main(String[] args) {
		Tree tree = new Tree(4);
		tree.add(2);
		tree.add(9);
		tree.add(0);
		TreeToDLL t = new TreeToDLL();
		t.inorderTreeToDLL(tree);
		t.display();
	}

}
