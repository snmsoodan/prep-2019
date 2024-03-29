// Validate Binary Search Tree

// Given a binary tree, determine if it is a valid binary search tree (BST).

// Assume a BST is defined as follows:

// The left subtree of a node contains only nodes with keys less than the node's key.
// The right subtree of a node contains only nodes with keys greater than the node's key.
// Both the left and right subtrees must also be binary search trees.
 

// Example 1:

//     2
//    / \
//   1   3

// Input: [2,1,3]
// Output: true
// Example 2:

//     5
//    / \
//   1   4
//      / \
//     3   6

// Input: [5,1,4,null,null,3,6]
// Output: false
// Explanation: The root node's value is 5 but its right child's value is 4.


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// Solution: 1 recursive

class Solution {
    public boolean isValidBST(TreeNode root) {
        return isValidBST(root,Double.NEGATIVE_INFINITY, Double.POSITIVE_INFINITY);
    }
    
    public boolean isValidBST(TreeNode p, double min, double max){
    if(p==null) 
        return true;
 
    if(p.val <= min || p.val >= max)
        return false;
 
    return isValidBST(p.left, min, p.val) && isValidBST(p.right, p.val, max);
    }
    
}


// Solution: 2 using stacks<LinkedList> iterative

class Solution {
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> uppers = new LinkedList<>();
    LinkedList<Integer> lowers = new LinkedList<>();

    public void update(TreeNode root, Integer lower, Integer upper) {
        stack.add(root);
        lowers.add(lower);
        uppers.add(upper);
    }

    public boolean isValidBST(TreeNode root) {
        Integer upper=null, lower=null, val;
        update(root, lower, upper);

        while(!stack.isEmpty) {
            root = stack.poll();
            lower = lowers.poll();
            upper = uppers.poll();

            if(root==null) continue;
            val = root.val;
            if(lower!=null && val<=lower) return false;
            if(upper!=null && val>=upper) return false;
            update(root.left, lower, val);
            update(root.right, val, upper);
        }
        return true;
    }
}

