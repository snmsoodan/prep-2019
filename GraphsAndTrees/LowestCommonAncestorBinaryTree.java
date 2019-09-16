// Lowest Common Ancestor of a Binary Tree

// Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]


 

// Example 1:

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
// Output: 3
// Explanation: The LCA of nodes 5 and 1 is 3.
// Example 2:

// Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
// Output: 5
// Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to the LCA definition.
 

// Note:

// All of the nodes' values will be unique.
// p and q are different and both values will exist in the binary tree.

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
    
    private TreeNode ans;
    
    public Solution() {
        //variable to store lowest common node
        this.ans = null;
    }
    
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        this.recurseTree(root, p, q);
        return this.ans;
    }
    
    private boolean recurseTree(TreeNode currentNode, TreeNode p, TreeNode q) {
        
        //if reached the end of the branch
        if(currentNode == null) {
            return false;
        }
        
        //if the left recursion returns true set left as 1 ,otherwise 0
        int left = recurseTree(currentNode.left, p, q) ? 1 : 0;
        
        //If the rught recursion returns true set right as 1 otherwise 0
        int right = recurseTree(currentNode.right, p, q) ? 1 : 0;
        
        //if current node is one of the p or q
        int mid = (currentNode == p || currentNode == q) ? 1 : 0;
        
        //set ans if any two flags become true
        if(mid+left+right > 1) {
            this.ans = currentNode;
        }
        
        
        //return true if any of the flag is true
        return (mid+left+right > 0);
        
    }
    
}