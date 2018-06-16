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
 * @author: simonwang
 */

class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
       
        //BFS
        List<List<Integer>> res = new ArrayList<>();
        if(root==null)
            return res;
        
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        while(!queue.isEmpty()){
            int size=queue.size();
            List<Integer> list = new ArrayList<>();
            
            //travel each level
            for(int i=0; i<size; i++){
                TreeNode curr = queue.poll();
                if(curr.left!=null)
                    queue.offer(curr.left);
                if(curr.right!=null)
                    queue.offer(curr.right);
                list.add(curr.val);
            }
            res.add(list);
        }
        
        return res;
    }
}