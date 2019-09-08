// Add Two Numbers

// You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Example:

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int sum=0, carry=0, x=0,y=0;
        ListNode  dummyHead = new ListNode(0);
        ListNode curr;
        curr = dummyHead;
        while(l1!=null || l2!=null) {
            x= (l1!=null) ? l1.val : 0;
            y= (l2!=null) ? l2.val : 0;
            
            sum = x+y+carry;
            carry = sum/10;
            curr.next = new ListNode(sum%10);
            curr = curr.next;
            
            if(l1!=null) l1=l1.next;
            if(l2!=null) l2=l2.next;
            
        }
        
        if(carry!=0) {
            curr.next=new ListNode(carry);
        }
        
        return dummyHead.next;
        
    }
}

//Now for the case where 1 -> 2 -> 3 means 123 
// whe will have to reverse the reverse the linked lists first and then do the same operation

// code to reverse the linked list

// class Solution {
//     public ListNode reverseKGroup(ListNode head, int k) {
//         int count = 1;
//         ListNode first,second, temp;
        
//         first=head;
//         second= first.next;
        
//         while(second!=null) {
//             temp=second.next;
//             second.next=head;
//             head=second;
//             first.next=temp;
//             second=first.next;
//         }
//         return head;
//     }
// }