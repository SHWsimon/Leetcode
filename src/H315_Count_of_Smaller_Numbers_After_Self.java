
public class H315_Count_of_Smaller_Numbers_After_Self {
	/**
	 * Way: Binary Search Tree,  9ms, O(n*logn), space O(n)
	 * 1. 從nums[n]最後一個index(n-1)往回建樹, root = nums[n-1]
	 * 2. 使用BST搜尋
	 *    - 左子樹 : nums[n-2] <= nums[n-1], root左邊多一個左子樹(root.leftCount++)
	 *    - 右子樹 : nums[n-2] > nums[n-1], root右子樹大於root值(thisCount + root.leftCount + 1)
	 *      @  1: root比右子樹小, count+1
	 *      @  root.leftCount: root的左子樹(之前全部較小的值)
	 *    ex:
	 *           n-2, n-1
	 *      [5, 2, 6, 1] -> res=[0, 1, 1, 2]
	 *       1
	 *        \
	 *         6
	 *        /
	 *       2
	 *        \
	 *         5
	 *
	 * 3. 反轉res list
	 * 4. return res
	 *
	 * @author: simonwang
	 */

	class Solution {
	    class treeNode {
	        treeNode right = null;
	        treeNode left =null;
	        int value;
	        int leftCount; // count the left tree node

	        public treeNode(int value) {
	            this.value=value;
	            this.leftCount=0;
	        }
	    }
	    
	    public List<Integer> countSmaller(int[] nums) {
	        List<Integer> res = new ArrayList<>(); // the final output
	        //base
	        if(nums==null || nums.length==0)
	            return res;
	        
	        //從index n-1開始建樹         
	        treeNode root = new treeNode(nums[nums.length-1]);
	        res.add(0);
	        for(int i=nums.length-2; i>=0; i--){
	            //traversal
	            res.add(BST(root, nums[i]));
	        }
	        
	        //反轉
	        Collections.reverse(res);
	        return res;
	    }
	    
	    public int BST(treeNode root, int value) {
	        int thisCount=0;
	        while(true){
	            //root.value >= value (left subtree)
	            if(root.value >= value){
	                root.leftCount++; //add left children
	                if(root.left == null){
	                    root.left = new treeNode(value);
	                    break;
	                }
	                else{
	                    root = root.left;
	                }
	            }
	            
	            //root.value < value (right subtree)
	            else{
	                thisCount = thisCount + root.leftCount + 1; //sum all the left children
	                if(root.right == null){
	                    root.right = new treeNode(value);
	                    break;
	                }
	                else{
	                    root = root.right;
	                }    
	            }
	        }
	        return thisCount;
	    }
	}
}
