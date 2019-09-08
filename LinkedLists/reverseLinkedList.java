// Reverse Linked List


// Reverse a singly linked list.

// Example:

// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// Follow up:

// A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        int count = 1;
        ListNode first,second, temp;
        if(head==null || head.next == null) return head;
        first=head;
        second= first.next;
        
        while(second!=null) {
            temp=second.next;
            second.next=head;
            head=second;
            first.next=temp;
            second=first.next;
        }
        return head;
    }
}