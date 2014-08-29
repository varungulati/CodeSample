
public class CousinsCheck {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t = new Tree(6, 
			new Tree(3,
				new Tree(7, null, null), new Tree(8, null, null)), 
			new Tree(5, new Tree(1, null, null), new Tree(3, null, null))
		);
		System.out.println(t.inOrder(t));
		System.out.println(Tree.getTreeHeight(t));
	}

}
