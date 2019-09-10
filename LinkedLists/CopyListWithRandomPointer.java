// Copy List with Random Pointer

// Refernce for understanding : https://www.youtube.com/watch?v=EHpS2TBfWQg

// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.

 

// Example 1:



// Input:
// {"$id":"1","next":{"$id":"2","next":null,"random":{"$ref":"2"},"val":2},"random":{"$ref":"2"},"val":1}

// Explanation:
// Node 1's value is 1, both of its next and random pointer points to Node 2.
// Node 2's value is 2, its next pointer points to null and its random pointer points to itself.

/**
 * CopyListWithRandomPointer
 */

//  Solution 1: by modifying the original list 
public class CopyListWithRandomPointer {

    public static void main(String[] args) {
        Solution s = new Solution();
        Node n1 = new Node(1,null, null); 
        Node n2 = new Node(2,null, null);
        n1.next=n2;
        n1.random = n2;
        n2.random = n2;
        Node newList = s.copyRandomList(n1);
        while(newList!=null) {
            System.out.print("val:"+ newList.val+"\n");
            newList=newList.next;
        }
    }
}

// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
}

class Solution {
    public Node copyRandomList(Node head) {
        Node tempHead=head, clone=new Node(0,null,null), cloneHead=clone, prev;
        
        //create a clone with the same data.
        //random pointer is set to null at this point
        while(tempHead!=null) {
            Node n = new Node(tempHead.val,null, null);
            cloneHead.next = n;
            cloneHead=cloneHead.next;
            tempHead=tempHead.next;
        }
        
        //make the next pointer of original linkedList point to the respective node of the cloned linkedList
        //make the random pointer in the cloned linkedList point to the respective node in the original linkedList
        cloneHead=clone.next;
        tempHead=head;
        while(tempHead!=null){
            prev=tempHead;
            tempHead=tempHead.next;
            prev.next=cloneHead;
            cloneHead.random=prev;
            cloneHead = cloneHead.next;
        }
        
        
        cloneHead=clone.next;
        while(cloneHead!=null) {
            if(cloneHead.random.random == null) {
                cloneHead.random = cloneHead;
            }
            else {
                cloneHead.random = cloneHead.random.random.next;
            }
            cloneHead=cloneHead.next;
        }
        System.out.println(clone.val);
        
        return clone.next;
    }
}