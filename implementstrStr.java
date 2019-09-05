// Implement strStr().

// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Example 1:

// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Clarification:

// What should we return when needle is an empty string? This is a great question to ask during an interview.

// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().


// Solution 1: O(n)

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0) return 0;
        int ret=-1;
        int check = needle.length();
        for(int i=0;i<haystack.length();i++) {
            if((i+check-1)<haystack.length()) {
                if(haystack.substring(i,i+check).equals(needle)) return i;
            }
        }
        return ret;
    }
}

// Solution 2: Using indexOf   

class Solution {
    public int strStr(String haystack, String needle) {
        if(haystack == null) return -1;
        return haystack.indexOf(needle);
    }
}

//Solution 3: Without substr
class Solution {
    public int strStr(String haystack, String needle) {        
        int n = needle.length();
        if (n == 0) return 0;
        
        int threshold = haystack.length() - n;
        for (int i = 0; i <= threshold; i++) {
            int j = 0;
            if (haystack.charAt(i) == needle.charAt(j)) {
                while (j < n) {
                    if (++j == n) return i;
                    if (haystack.charAt(i + j) != needle.charAt(j)) break;
                }
            }
        }
        return -1;
    }
}


