// Binary Tree Level Order Traversal

// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]


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
    //make a ArrayList to return 
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public void helper(TreeNode node,int level) {
        //start the current level
        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        
        //insert the value 
        levels.get(level).add(node.val);
        
        //now insert child nodes
        if(node.left != null) {
            helper(node.left, level+1);
        }
        if(node.right !=null) {
            helper(node.right, level+1);
        }
        
    }
    
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) return levels;
        helper(root, 0);
        return levels;
    }
}