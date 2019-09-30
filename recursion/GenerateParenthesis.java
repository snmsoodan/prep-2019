// Generate Parentheses

// Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

// For example, given n = 3, a solution set is:

// [
//   "((()))",
//   "(()())",
//   "(())()",
//   "()(())",
//   "()()()"
// ]


class Solution {
    List<String> ans= new ArrayList<>();
    
    public List<String> generateParenthesis(int n) {
        helper("", 0,0,n);
        return ans;
    }
    
    public void helper(String cur, int open, int close, int max) {
        
        if(cur.length()==max*2) {
            ans.add(cur);
            return;
        }
        
        if(open<max) {
            helper(cur+"(",open+1, close, max);
        }
        
        if(close<open) {
            helper(cur+")", open, close+1, max);
        }
        
    }
    
}