/**
 * Way: 4ms, O(n), space O(1)
 * 1. Max( Max(min*nums[i], max*nums[i]), nums[i] )
 * 2. res=Max(res, max)
 * 3. return res
 *
 * @author: simonwang
 */

class Solution {
    public int maxProduct(int[] nums) {
        if(nums.length==0 || nums==null)
            return 0;
        int max=nums[0];
        int min=nums[0];
        int res=nums[0];
        int preMax=nums[0];
        int preMin=nums[0];
        for(int i=1; i<nums.length; i++){
            max=Math.max(Math.max(preMax*nums[i], preMin*nums[i]), nums[i]);
            min=Math.min(Math.min(preMax*nums[i], preMin*nums[i]), nums[i]);
            res=Math.max(max, res);
            preMax=max;
            preMin=min;
        }
        
        return res;
    }
}