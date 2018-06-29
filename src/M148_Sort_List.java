/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * Way: Using MegeSort(Divide & conquer), 7ms, O(n*logn), space O(1)
 * 1. find median 
 * 2. divide to left and right part
 * 3. merge left and right in ascending order
 * 4. return head
 *
 * @author: simonwang
 */

class Solution {
    public ListNode sortList(ListNode head) {
        if(head==null || head.next==null)
            return head;
        
        //Divide
        ListNode median=findMedian(head);
        //right half
        ListNode right=sortList(median.next);
        //left half
        median.next=null;
        ListNode left = sortList(head);
        
        //Merge
        return merge(left, right);
        
    }
    
    //1.find median
    private ListNode findMedian(ListNode head){
        // fast goes 2 step, slow goes 1 step
        ListNode fast = head;
        ListNode slow = head;
        
        while(fast.next!=null && fast.next.next!=null){
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return slow;
    }
    
    //2.merge sort
    private ListNode merge(ListNode left, ListNode right){
        ListNode newHead=new ListNode(0);
        ListNode tail=newHead;
        
        //merge
        while(left!=null && right!=null){
            if(left.val<right.val){
                tail.next=left;
                left=left.next;
            }
            else{
                tail.next=right;
                right=right.next;
            }
            
            tail=tail.next;
        }
        
        //Copy rest of left half
        while(left!=null){
            tail.next=left;
            left=left.next;
            tail=tail.next;
        }
        //Copy rest of right half
        while(right!=null){
            tail.next=right;
            right=right.next;
            tail=tail.next;
        }
        
        
        return newHead.next;
    }
}