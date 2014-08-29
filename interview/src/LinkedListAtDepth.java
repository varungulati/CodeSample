import java.util.ArrayList;
import java.util.LinkedList;


public class LinkedListAtDepth {

	public static ArrayList<LinkedList<Tree>> getElements(Tree tree) {
		if(tree == null) {
			return null;
		}
		ArrayList<LinkedList<Tree>> result = new ArrayList<LinkedList<Tree>>();
		LinkedList<Tree> list = new LinkedList<Tree>();
		int level = 0;
		list.add(tree);
		result.add(list);
		while(true) {
			LinkedList<Tree> newList = new LinkedList<Tree>();
			for(int i = 0; i < result.get(level).size(); i++) {
				if(result.get(level).get(i).left != null) {
					newList.add(result.get(level).get(i).left);
				}
				if(result.get(level).get(i).right != null) {
					newList.add(result.get(level).get(i).right);
				}
			}
			if(newList.size() != 0) {
				result.add(level + 1, newList);
			} else {
				break;
			}
			level++;
		}
		return result;
	}

	public static void main(String[] args) {
		Tree tree = new Tree(3);
		tree.add(4);
		tree.add(9);
		tree.add(1);
		tree.add(2);
		tree.add(0);
//		tree.inorder(tree);
		ArrayList<LinkedList<Tree>> result = getElements(tree);
		for(LinkedList<Tree> ll: result) {
			for(int i = 0; i < ll.size(); i++) {
				System.out.print(ll.get(i).getData() + " ");
			}
			System.out.println();
		}
	}

}
