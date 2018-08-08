
public class M215_Kth_Largest_Element_in_an_Array {
	// Kth largest = n-k+1 smallest
	/**
	 * Way1 : recursion, 37 ms, O(n), space O(1)
	 * 1. QuickSelect
	 * 2. Partition
	 * 3. Swap
	 *
	 * @author: simonwang
	 */

	//way 1: QuickSelect recursion
	class Solution {
	    public int findKthLargest(int[] nums, int k) {
	        int n = nums.length;
	        return quickSelect(nums, 0, n-1, n-k+1);
	    }
	    
	    // use quick sort's idea
	    int quickSelect(int[] nums, int p, int r, int k) {
	        int q = partition(nums, p, r);
	        
	        // put nums that are < pivot to the left
	        // put nums that are  > pivot to the right
	        int left = q-p;
	        int right = r-q;
	        
	        // pivot is the one!
	        if (left+1 == k)     
	            return nums[q];
	        // pivot is too big, so it must be on the left
	        else if (left >= k) 
	            return quickSelect(nums, p, q-1, k);
	        // pivot is too small, so it must be on the right
	        else            
	            return quickSelect(nums, q+1, r, k-(left+1));
	    }
	    
	    public int partition(int[] nums, int left, int right) {
	        int l = left;
	        int r = right-1;
	        int pivot = nums[right];
	        while (l <= r) {
	            if(nums[l]>pivot && nums[r]<pivot) {
	                swap(nums, l++, r--);
	            }
	            if(nums[l]<=pivot)
	                l++;
	            if(nums[r]>=pivot)
	                r--;
	              
	        }
	        swap(nums, l, right);
	        
	        return l;
	    }
	    
	    public void swap(int[] nums, int i, int j) {
	        int temp = nums[i];
	        nums[i] = nums[j];
	        nums[j] = temp;
	    }
	}

}
