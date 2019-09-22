// Word Break

// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note:

// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.
// Example 1:

// Input: s = "leetcode", wordDict = ["leet", "code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple", "pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//              Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output: false


// solution 1: BFS  O(n^2)

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //convert wordDict to set
        Set<Integer> wordDictSet = new HashSet(wordDict);
        
        //create visited int array to store the indexes visit value for input string
        int[] visited =  new int[s.length()];

        //create a queue of integers and add index 0 in the queue
        Queue<Integer> q=new LinkedList<>();
        q.add(0);
        
        //process untill queue empty
        while(!q.isEmpty()) {

            //poll the start element from the queue
            int start = q.poll();

            //check if the start index is visited, if not process
            if(visited[start] == 0) {

                //check the substring from start and end in wordDictSet
                for(int end=start+1;end<=s.length();end++) {
                    if(wordDictSet.contains(s.substring(start,end))) {
                        //if there is a match add end index to the queue
                        q.add(end);
                        // also if end is the last element of string return true
                        if(end==s.length()) {
                            return true;
                        } 

                    }
                }

                //make the index visited at the end of process
                visited[start]=1;
            }


        }

        return false;
        
    }
}


// solution 2: dynamic programming

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        //convert wordDict to set
        Set<Integer> wordDictSet = new HashSet(wordDict);
        
        //create boolean array of length s.length()+1
        boolean[] dp=new boolean[s.length()+1];
        
        //make the first element in dp as true
        dp[0]=true;
        
        for(int i=1;i<=s.length();i++){
            for(int j=0;j<i;j++) {
                
                if(dp[j] && wordDictSet.contains(s.substring(j,i))) {
                    //make i as visited and break;
                    dp[i]=true;
                    break;
                }
                
            }
        }
        
        return dp[s.length()];
        
    }
}