/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

/*
 * BFS
 * 1. useing queue 
 * 2. a flag to detect direction
 * @author: simonwang
 */

class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root==null)
            return res;
        
        //Use Queue:FIFO
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        //detect direction
        boolean lefttoright = false;
        
        while(!queue.isEmpty()){
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            
            //travel each level
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
                 
                list.add(curr.val);
            }
            
            if(lefttoright)
                Collections.reverse(list);
            
            lefttoright=!lefttoright;
            res.add(list);
        }
        
        return res;
    }
}