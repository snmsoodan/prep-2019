// Reverse Nodes in k-Group

// Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

// k is a positive integer and is less than or equal to the length of the linked list. If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

// Example:

// Given this linked list: 1->2->3->4->5

// For k = 2, you should return: 2->1->4->3->5

// For k = 3, you should return: 3->2->1->4->5

// Note:

// Only constant extra memory is allowed.
// You may not alter the values in the list's nodes, only nodes itself may be changed.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

/**
 * ReverseNodesKgroup
 */
public class ReverseNodesKgroup {

    public static void main(String[] args) {
        ListNode l = new ListNode(1);
        ListNode head = l;
        ListNode n= new ListNode(2); 
        l.next = n;
        l=l.next;
        System.out.println("input");
        ListNode t=head;
        while(t!=null) {
            System.out.println(t.val);
            t = t.next;
        }

        Solution rk = new Solution();
        ListNode reverseKGroupOut =  rk.reverseKGroup(head, 2);

        System.out.println("here is the output");
        while(reverseKGroupOut!=null) {
            System.out.println(reverseKGroupOut.val);
            reverseKGroupOut = reverseKGroupOut.next;
        }
        System.out.println("output ends");
    }
}

public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode lList=null,subList=head, rList=head, newHead=head, subListHead=head, end=head;
        int listlength = 0, reverseCount=0, count =0;
        
        
        if(k == 0 || k == 1) return head;
        
        //reverseCount to keep track of final list head
        //need to set head only on first reverse;
        while(end!=null) {
            if(count == k) {
                System.out.println("count == k");
                rList = subList.next;  //null
                subList.next=null;
                // System.out.println(subListHead.next.val);
                subList = reverse(subListHead);
                System.out.println("subList.next.val"+subList.next.val);  //2
                if(reverseCount == 0) {
                    //set the new Head as the first node
                    newHead = subList;
                    while(subList.next!=null) {
                        subList = subList.next;
                    }
                    //at this point the node is pointing to the end of sublist 
                    //now making this new last node as the new lList
                    lList=subList;
                    //incrementing it here as only required one time
                    reverseCount++;
                }
                else {
                    lList.next = subList;
                    //make the lList as last node 
                    while(lList.next!=null){
                        lList=lList.next;
                    }
                    //now lList is the last node
                }
                
                count=0;
                subListHead=null;
            }
            else{
                end = rList;
                if(end==null) break;
                
                listlength++;
                // System.out.println(end.val);
                // if(k > listlength && end==null) return head;
                // System.out.println(listlength);
                
                //this else keep adding to sublist
                if(count == 0) {
                    subListHead = rList;
                    subList = subListHead;
                    end=rList;
                }
                else{
                    end = subList.next;
                    subList=subList.next;
                }
                rList=rList.next;
                count++;
            }
        }
        System.out.println("listlength = "+listlength);
        System.out.println("k = "+k);
        if(k > listlength) return head;
        
        System.out.println("here");
        //end of the list with size less than k
        if(subListHead !=null) {
            System.out.println("here");
            System.out.println(k);
            //need to just add to the remaining elements
            lList.next = subListHead;
            while(lList!=null){
                lList=lList.next;
            }
        }
        
        return newHead;
    }
    
    //reverses the sublist and returns head
    public ListNode reverse(ListNode l) {
        System.out.println("reverse()");
        ListNode first, second, temp;
        first = l;
        // System.out.println(first.val);
        second=l.next;
        // System.out.println(second.val);
        
        while(second!=null) {
            temp = second.next;
            second.next=l;
            first.next=temp;
            l=second;
            second=first.next;
        }
        System.out.println("reverse l " + l.val);
        return l;
        
    }
}