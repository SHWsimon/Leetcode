
public class E235_Lowest_Common_Ancestor_of_a_Binary_Search_Tree {
	/**
	 * Definition for a binary tree node.
	 * public class TreeNode {
	 *     int val;
	 *     TreeNode left;
	 *     TreeNode right;
	 *     TreeNode(int x) { val = x; }
	 * }
	 */
	class Solution {
	    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
	        //compared the value to the root and move the root
	        while(true) {
	            //move left
	            if(root.val > Math.max(p.val, q.val))
	                root=root.left;
	            //move right
	            else if(root.val < Math.min(p.val, q.val))
	                root=root.right;
	            //find the parent
	            else
	                return root;
	        }
	        
	    }
	}

}
