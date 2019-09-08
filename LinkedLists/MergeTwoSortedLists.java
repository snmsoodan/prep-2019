// Merge Two Sorted Lists

// Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

// Example:

// Input: 1->2->4, 1->3->4
// Output: 1->1->2->3->4->4


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        //made dummy head for simplicity
        ListNode dummyHead = new ListNode(0);
        ListNode curr = dummyHead;
        
        while(l1!=null && l2!=null) {
            if(l1.val == l2.val) {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                curr.next = new ListNode(l2.val);
                curr = curr.next;
                l1=l1.next;
                l2=l2.next;
            }
            else if(l1.val < l2.val) {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1=l1.next;
            }
            else {
                curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2=l2.next;
            }
        }
        
        if(l1!=null) {
            while(l1!=null) {
                curr.next = new ListNode(l1.val);
                curr = curr.next;
                l1=l1.next;   
            }
        }
        
        if(l2!=null) {
            while(l2!=null) {
                curr.next = new ListNode(l2.val);
                curr = curr.next;
                l2=l2.next;
            }
        }
        
        return dummyHead.next;
    }
}