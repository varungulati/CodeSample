package SerializationDeserialization;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
     TreeNode(int x) { val = x; }
 }

public class SerializeDesrializeTreePreorder {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        if(root == null) return "x";
        return root.val + "|" + serialize(root.left) + "|" +  serialize(root.right);
    }

    private TreeNode helper(List<String> arr, TreeNode root)  {
    	if(arr.size() == 0) return null;
     	if(arr.get(0).equals("x")) {
     	    arr.remove(0);
     		return null;
     	}
     	int num = Integer.parseInt(arr.remove(0));
     	root = new TreeNode(num);
     	root.left = helper(arr, root);
     	root.right = helper(arr, root);
    	return root;
    }
    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
    	List<String> arr = new ArrayList();
    	arr.addAll(Arrays.asList(data.split("\\|")));
    	TreeNode root = null;
    	if(arr.size() == 0) return root;
    	return helper(arr, root);
}
    public static void main(String args[]) {
    	SerializeDesrializeTreePreorder s = new SerializeDesrializeTreePreorder();
    	TreeNode root = new TreeNode(1);
    	root.left = new TreeNode(2);
    	root.left.left = null;
    	root.left.right = null;
    	root.right = new TreeNode(1);
    	root.right.left = null;
    	root.right.right = null;
    	System.out.println(s.serialize(root));
    	s.deserialize(s.serialize(root));
    	System.out.println(root.right.val);
    }
}
