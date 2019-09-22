// Longest Palindromic Substring

// Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.

// Example 1:

// Input: "babad"
// Output: "bab"
// Note: "aba" is also a valid answer.
// Example 2:

// Input: "cbbd"
// Output: "bb"


// Solution 1: expanding around center O(n^2)

class Solution {
    public String longestPalindrome(String s) {
        
        if(s==null || s.length()<1) return "";
        
        int start=0,end=0, len=0,len1=0,len2=0;
        
        for(int i=0;i<s.length();i++) {
            len1=expandAroundCenter(s,i,i);
            len2=expandAroundCenter(s,i,i+1);
            len=Math.max(len1,len2);
            
            if(len>end-start) {
                start=i-(len-1)/2;
                end=i+len/2;
            }
            
        }
        
        return s.substring(start, end+1);
    }
    
    
    public int expandAroundCenter(String s, int l, int r){
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)) {
            r++;
            l--;
        }
        
        return r-l-1;
    }
}