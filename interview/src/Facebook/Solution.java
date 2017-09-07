package Facebook;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class Solution {
	static class TreeNode {
		public TreeNode(int val, TreeNode left, TreeNode right) {
			this.val = val;
			this.left = left;
			this.right = right;
		}
		int val;
		TreeNode left;
		TreeNode right;
		public TreeNode getLeft() {
			return this.left;
		}
		public TreeNode getRight() {
			return this.right;
		}
		public int getVal() {
			return this.val;
		}
	}
	static class ABC {
		int level;
		String val;
		public ABC(int level, String val) {
			this.level = level;
			this.val = val;
		}
	}
	private static int helper(int n, String[] tree) {
		Queue<ABC> q = new LinkedList<>();
		int sumEven = 0, i = 1, sumOdd = 0;
		q.add(new ABC(0, tree[0]));
		while(!q.isEmpty()) {
			ABC temp = q.remove();
			if(temp.val.equals("#")) continue;
			if(i < tree.length) q.add(new ABC(temp.level + 1, tree[i++]));
			if(i < tree.length) {
				q.add(new ABC(temp.level + 1, tree[i]));
				i++;
			}
			if(temp.level % 2 == 0) {
				sumEven += Integer.valueOf(temp.val);
			}
			if(temp.level % 2 != 0) {
				sumOdd += Integer.valueOf(temp.val);
			}
		}
		return Math.max(sumEven,sumOdd);
	}
    private static int findMax(int n, String tree) {
    	if(tree.length() == 0) return 0;
    	TreeNode root = buildTree(n, tree.split(" "));
    	return getSum(root, new HashMap<TreeNode, Integer>());
    }
    private static TreeNode buildTree(int n, String[] tree) {
		Queue<TreeNode> q = new LinkedList<>();
		TreeNode toReturn = new TreeNode(Integer.valueOf(tree[0]), null, null);
		q.add(toReturn);
		int i = 1;
		while(!q.isEmpty()) {
			TreeNode temp = q.remove();
			if(i < tree.length && !tree[i++].equals("#")) {
				TreeNode lefty = new TreeNode(Integer.valueOf(tree[i-1]), null, null);
				q.add(lefty);
				temp.left = lefty;
			}
			if(i < tree.length && !tree[i++].equals("#")) {
				TreeNode righty = new TreeNode(Integer.valueOf(tree[i-1]), null, null);
				q.add(righty);
				temp.right = righty;
			}
			
		}
		return toReturn;
	}
    private static int getSum(TreeNode curr, Map<TreeNode, Integer> memoizedSum) {
    	 
        int incl = Integer.MIN_VALUE;
        int excl = Integer.MIN_VALUE;
 
        if (curr == null) {
            return 0;
        }
 
        // Calculate sum when exluding current node
        excl = getSum(curr.getLeft(), memoizedSum) + getSum(curr.getRight(), memoizedSum);
 
        // Calculate sum when including current node
        incl = curr.getVal();
        if (curr.getLeft() != null) {
            incl += getSum(curr.getLeft().getLeft(), memoizedSum) + getSum(curr.getLeft().getRight(), memoizedSum);
        }
        if (curr.getRight() != null) {
            incl += getSum(curr.getRight().getLeft(), memoizedSum) + getSum(curr.getRight().getRight(), memoizedSum);
        }
 
        int currMax = Math.max(incl, excl);
        memoizedSum.put(curr, currMax);
        return currMax;
    }
	public static void main(String[] args) {
    	String tree = "3 4 5 1 3 # 1";
    	System.out.println(findMax(6, tree));
    }
}
