// Merge k Sorted Lists

// Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.

// Example:

// Input:
// [
//   1->4->5,
//   1->3->4,
//   2->6
// ]
// Output: 1->1->2->3->4->4->5->6

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        ListNode mergedList = lists[0];
        for(int i=1;i<lists.length;i++) {
            mergedList= mergeTwoLists(mergedList, lists[i]);
        }
        return mergedList;
    }
    
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



// Solution 2 : using Priority queue

**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode p = new ListNode(0);
        ListNode merge = p;
        int k = lists.length;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(k+1, new Comparator<ListNode>(){
            public int compare(ListNode a, ListNode b){
                return a.val - b.val;
                }
            });

        for(ListNode l:lists){
            if(l != null){
                pq.offer(l);
            }
        }

        while(!pq.isEmpty()){
            ListNode node = pq.poll();
            p.next = node;
            p = p.next;
            if(node.next != null){
                pq.offer(node.next);
            }
        }
        return merge.next;

    }
}