public class M236_Lowest_Common_Ancestor_of_a_Binary_Tree {
	/**
	 * Way: recursion, 10ms, O(n), space O(n)
	 *
	 * @author: simonwang
	 */


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
	        if(root == null)
				return null;
		   	if(root == p || root == q) 
		    	return root;
		    		
		    TreeNode left = lowestCommonAncestor(root.left, p, q);
		    TreeNode right = lowestCommonAncestor(root.right, p, q);
		    
	        //1) root is ancestor of p AND root is ancestor of q
		    if(left!=null && right!=null)
		    	return root;
	            
		    //2) root is p AND root is ancestor of q
	        //3) root is q AND root is ancestor of p		
		    return left!=null ? left : right;
	    }
	}
}
