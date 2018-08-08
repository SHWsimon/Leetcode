/**
 * Way: Binary search, 6ms, O(n*logn), space O(1)
 * 1. nums[i]!=nums[i+1]
 * 2. start<end, find the peak
 * 3. mid1=(start+end)/2, mid2=mid1+1 
 * 4. nums[mid1]<nums[mid2], find mid2~end 
 * 5. nums[mid1]>nums[mid2], find start~mid1
 * 6. start=end, return start
 *
 * @author: simonwang
 */

class Solution {
    public int findPeakElement(int[] nums) {
        int start=0;
        int end=nums.length-1;
        while(start<end){
            int mid1=(start+end)/2;
            int mid2=mid1+1;
            
            if(nums[mid1]<nums[mid2])
                start=mid2;
            //nums[mid1]>nums[mid2]
            else
                end=mid1;
        }
        
        //start=end
        return start;
    }
}