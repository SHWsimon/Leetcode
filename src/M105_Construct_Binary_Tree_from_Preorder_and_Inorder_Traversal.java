/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/**
 * Implement D&C
 * preorder = [3,9,20,15,7] : find the left child, when root=3, 9 is the left child
 * inorder = [9,3,15,20,7] : find the right child, root=3, [15, 20, 7] is the right child
 *       3
 *      / \
 *     9  20
 *       /  \
 *      15   7
 *
 * @author: simonwang
 */

class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, inorder, 0, preorder.length-1, 0, inorder.length-1);
    }
    
    public TreeNode build(int[] preorder, int[] inorder, int preStart, int preEnd, int inStart, int inEnd){
        //length is 0
        if(preStart> preEnd || inStart>inEnd)
            return null;
        
        //root in preorder
        TreeNode root = new TreeNode(preorder[preStart]);
        int i=0;
        //find the root in inorder
        for(int k=inStart; k<=inEnd; k++){
            // i is root location in inorder
            if(root.val==inorder[k]){
                i=k;
                break;
            }
        }
        //preStart+1 is next root and left child in preorder, 
        //inStart to i-1 is left child of root in inorder
        root.left = build(preorder, inorder, preStart+1, preStart+(i-inStart), inStart, i-1);
                
        //preStart+(i-inStart) is next root and right child in preorder, 
        //i+1 to inEnd is right child of root in inorder
        root.right = build(preorder, inorder, preStart+(i-inStart)+1, preEnd, i+1, inEnd);
        
        return root;
    }
}
