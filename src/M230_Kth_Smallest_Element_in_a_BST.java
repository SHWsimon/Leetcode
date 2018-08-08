
public class M230_Kth_Smallest_Element_in_a_BST {
	/**
	 * Way1 : Inorder traversal, 26 ms, O(n), space O(n)
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
	    
	    private List<Integer> res = new ArrayList<>();
	    public int kthSmallest(TreeNode root, int k) {
	        if(k==0 || root == null)
	            return 0;
	        Inorder(root, k);
	        return res.get(k-1);
	    }
	    
	    public void Inorder(TreeNode root, int k) {
	        if(root == null)
	            return ;
	        if(res.size() == k)
	            return ;
	        Inorder(root.left, k);
	        res.add(root.val);
	        Inorder(root.right, k);
	    }
	}
}
