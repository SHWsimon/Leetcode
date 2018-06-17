/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */

/**
 * perfect binary tree
 * 1. travel in tree level
 * 2. travel in each tree level from left child to right child
 *
 *        1 -> NULL
 *      /  \
 *     2 -> 3 -> NULL
 *    / \  / \
 *   4->5->6->7 -> NULL
 *
 * @author: simonwang
 */

public class Solution {
    public void connect(TreeLinkNode root) {
        //tree level
        TreeLinkNode level=root;
        while(level!=null){
            //travel from left child to right child
            TreeLinkNode curr=level;
            while(curr!=null){
                //left child
                if(curr.left!=null)
                    curr.left.next=curr.right;
                //right child
                if(curr.right!=null && curr.next!=null)
                    curr.right.next=curr.next.left;

                //curr shift from left to right
                curr=curr.next;
            }
            //next level
            level=level.left;
        }
        
    }
}
