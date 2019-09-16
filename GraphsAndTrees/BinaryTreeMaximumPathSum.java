// Binary Tree Maximum Path Sum

// Given a non-empty binary tree, find the maximum path sum.

// For this problem, a path is defined as any sequence of nodes from some starting node to any node in the tree along the parent-child connections. The path must contain at least one node and does not need to go through the root.

// Example 1:

// Input: [1,2,3]

//        1
//       / \
//      2   3

// Output: 6
// Example 2:

// Input: [-10,9,20,null,null,15,7]

//    -10
//    / \
//   9  20
//     /  \
//    15   7

// Output: 42


/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    int max_sum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        max_gain(root);
        return max_sum;
    }
    
    public int max_gain(TreeNode node) {
        //return 0 is node is null
        if(node == null) return 0;
        
        //calculate the left and right gain
        int left_gain = Math.max(max_gain(node.left), 0);
        int right_gain = Math.max(max_gain(node.right), 0);
        
        //get the price to start a new path with the node being the highest 
        int price_new_path = node.val + left_gain + right_gain;
        
        //set max_gain as the max of max_gain and price_new_path
        max_sum = Math.max(max_sum, price_new_path);
        
        //for recursion return the max_gain
        return node.val + Math.max(left_gain, right_gain);
        
    }
}