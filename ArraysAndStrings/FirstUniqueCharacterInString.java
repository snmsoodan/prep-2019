// First Unique Character in a String

// Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.

// Examples:

// s = "leetcode"
// return 0.

// s = "loveleetcode",
// return 2.
// Note: You may assume the string contain only lowercase letters.

class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        
        for(int i=0;i<s.length();i++) {
            int count=0;
            if(map.containsKey(s.charAt(i)))
                count = map.getOrDefault(s.charAt(i),0);
            map.put(s.charAt(i),++count);
        }
        
        for(int i=0;i<s.length();i++){
            if(map.get(s.charAt(i)) == 1) return i;
        }
        
        return -1;
    }
}