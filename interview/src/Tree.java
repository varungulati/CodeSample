import java.util.ArrayList;
import java.util.Stack;


public class Tree {
	public int data;
	public Tree left;
	public Tree right;
	public Tree(int data, Tree left, Tree right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
	public Tree(int data) {
		this.data = data;
		this.left = this.right = null;
	}
	public int getData() {
		return this.data;
	}
	public Tree getLeft() {
		return this.left;
	}
	public Tree getRight() {
		return this.right;
	}
	public void add(int data) {
		if(this == null) {
			this.data = data;
			this.left = this.right = null;
			return;
		}
		Tree current = this;
		Tree prev = this;
		while(current != null) {
			prev = current;
			if(data > current.getData()) {
				current = current.getRight();
			} else {
				current = current.getLeft();
			}
		}
		if(data > prev.getData()) {
			prev.right = new Tree(data);
		} else {
			prev.left = new Tree(data);
		}
	}
	public void preorder(Tree root) {
		if (root == null) {
			return;
		}
		System.out.println(root.getData());
		preorder(root.getLeft());
		preorder(root.getRight());
	}
	public void inorder(Tree tree) {
		if (tree == null) {
			return;
		}
		inorder(tree.getLeft());
		System.out.println(tree.getData());
		inorder(tree.getRight());
	}
	public void inorderWithoutRecursion(Tree tree) {
		Stack<Tree> s = new Stack<Tree>();
		Tree current = tree;
		boolean done = false;
		while(!done) {
			if(current != null) {
				s.push(current);
				current = current.getLeft();
			} else {
				if(!s.isEmpty()) {
					current = s.peek().getRight();
					System.out.println(s.pop().getData());
				} else {
					done = true;
				}
			}
		}
	}
	public void postorder(Node root) {
		if (root == null) {
			return;
		}
		postorder(root.getLeft());
		postorder(root.getRight());
		System.out.println(root.getData());
	}
	public void levelOrder(Tree root) {
		ArrayList<ArrayList<Tree>> top = new ArrayList<ArrayList<Tree>>();
		ArrayList<Tree> inner = new ArrayList<Tree>();
		inner.add(root);
		top.add(inner);
		for(int i = 0; i < top.size(); i++) {
			ArrayList<Tree> list = new ArrayList<Tree>();
			for(int j = 0; j < top.get(i).size(); j++) {
				if(top.get(i).get(j).left != null) {
					list.add(top.get(i).get(j).left);
				}
				if(top.get(i).get(j).right != null) {
					list.add(top.get(i).get(j).right);
				}
			}
			if(list.size() != 0){
				top.add(list);
			}
		}
		for(ArrayList<Tree> t: top) {
			for(Tree r: t) {
				System.out.println(r.getData());
			}
		}
	}

	public Tree commonAncestorBST(Tree root, int foo, int bar) {
		if(root == null) {
			return null;
		}
		if(root.getData() > foo && root.getData() > bar) {
			return commonAncestorBST(root.getLeft(), foo, bar);
		} else if(root.getData() < foo && root.getData() < bar) {
			return commonAncestorBST(root.getRight(), foo, bar);
		}
			return root;
	}
	public Tree commonAncestorTree(Tree root, int foo, int bar) {
		if(root == null) {
			return null;
		}
		if(covers(root.getLeft(), foo) && covers(root.getLeft(), bar)) {
			return commonAncestorTree(root.getLeft(), foo, bar);
		} else if(covers(root.getRight(), foo) && covers(root.getRight(), bar)) {
			return commonAncestorTree(root.getRight(), foo, bar);
		} else {
			return root;
		}
	}
	public boolean covers(Tree root, int foo) {
		if(root == null) {
			return false;
		}
		if(root.getData() == foo) {
			return true;
		}
		return covers(root.getLeft(), foo) || covers(root.getRight(), foo);
	}
	public int numLeaves(Tree root) {
		if(root == null) {
			return 0;
		}
		if(root.left == null && root.right == null) {
			return 1;
		}
		return numLeaves(root.left) + numLeaves(root.right);
	}
	public int depth(Tree root) {
		if(root == null) {
			return 0;
		}
		return 1 + Math.max(depth(root.left), depth(root.right));
	}
}