// Binary Tree Zigzag Level Order Traversal
// Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its zigzag level order traversal as:
// [
//   [3],
//   [20,9],
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
    List<List<Integer>> levels = new ArrayList<List<Integer>>();
    
    public void helper(TreeNode node, int level){
        //start the current level
        if(levels.size() == level) {
            levels.add(new ArrayList<Integer>());
        }
        
        //add value 
        if(level%2 == 1){
            levels.get(level).add(0,node.val);
        }
        else{
            levels.get(level).add(node.val);
        }
        
        
        
        if(node.left !=null){
            helper(node.left, level+1);
        }
        if(node.right !=null){
            helper(node.right, level+1);
        }
    }
    
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        if(root == null) return levels;
        helper(root, 0);
        return levels;
    }
}