/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */

/**
 * Way1 : Using hashMap, 5ms, O(2n), space O(n)
 * 1. copy old node to new list
 * 2. travel in new list
 * 
 * Way2 : no extra space, 2ms, O(3n), space O(1)
 * 1. copy new node to old node's next
 *    1-> 2-> 3-> null
 *    1-> 1-> 2-> 2-> 3-> 3-> null
 * 2. copy old node's random to new node's random
 *    (oldNode.next=newNode).random=(oldNode).random.next
 * 3. take out new list
 *    like delete
 *
 * @author: simonwang
 */

public class Solution {
    // Way1 : Hashmap
    public RandomListNode copyRandomList(RandomListNode head) {
        HashMap<RandomListNode, RandomListNode> map = new HashMap<>();
        RandomListNode curr = head;
        
        //copy old node to new list
        while(curr!=null){
            map.put(curr, new RandomListNode(curr.label));
            curr=curr.next;
        }
        
        //travel in new list 
        curr=head;
        while(curr!=null){
            map.get(curr).next=map.get(curr.next);
            map.get(curr).random=map.get(curr.random);
            curr=curr.next;
        }
        
        return map.get(head);
    }
    
    // Way2 : no extra space
    public RandomListNode copyRandomList(RandomListNode head) {
         if(head == null)  
              return head;
        //1. copy new node to old node's next
        RandomListNode curr=head;
        while(curr!=null){
            RandomListNode newNode=new RandomListNode(curr.label);
            newNode.next=curr.next;
            curr.next=newNode;
            curr=newNode.next;
        }
        
        //2. copy old node's random to new node's random 
        curr=head;
        while(curr!=null){
            //new node's random = old node random's next
            if(curr.random!=null)
                (curr.next).random=(curr).random.next;
            curr=curr.next.next;
        }
        
        //3. tear down the new list, like delete
        RandomListNode newHead=head.next;
        curr=head;
        while(curr!=null){
            RandomListNode newNode= curr.next;
            curr.next=newNode.next;
            if(newNode.next!=null){
                newNode.next=newNode.next.next;
            }
            curr=curr.next;
        }
        
        return newHead;
    }
}