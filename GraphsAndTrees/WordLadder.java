// Word Ladder

// Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

// Only one letter can be changed at a time.
// Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
// Note:

// Return 0 if there is no such transformation sequence.
// All words have the same length.
// All words contain only lowercase alphabetic characters.
// You may assume no duplicates in the word list.
// You may assume beginWord and endWord are non-empty and are not the same.
// Example 1:

// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]

// Output: 5

// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
// Example 2:

// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]

// Output: 0

// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.


import javafx.util.Pair;

class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        
        //find the length, all lengths are same as beginWord
        int L = beginWord.length();
        
        //define a Hashmap allcombDict which contains key: generic word(words with *) and Value: List of words from wordlist
        Map<String, ArrayList<String>> allComboDict = new HashMap<>();
        
        //populate allComboDict by looping through wordList
            
        wordList.forEach(
        word -> {
            //create generic words by looping through the word string
            for(int i=0;i<L;i++) {
                String newWord = word.substring(0,i)+'*'+word.substring(i+1,L);
                
                //now get all the transformations fo this generic word from the allComboDict and add the current word
                ArrayList<String> transformations = allComboDict.getOrDefault(newWord, new ArrayList<String>());
                //add the current word to transformation
                transformations.add(word);
                //put the transformation back to the  allComboDict Hashmap
                allComboDict.put(newWord, transformations);
            }
            
        });
        
            
        //make the BFS Queue with tuples of word and level
        Queue<Pair<String, Integer>> Q = new LinkedList<Pair<String, Integer>>();
        //put the begin word inside the Q and set the level as 1
        Q.add(new Pair(beginWord, 1));
        
        
        //make a Visited HashMap with Key: word and Value: Boolean
        Map<String, Boolean> visited = new HashMap<>();
        //add the beginWord to the visited HashMap
        visited.put(beginWord, true);
        
        
        //now we will go through the Queue until its empty
        while(!Q.isEmpty()) {
            //we remove an element from the queue(the element will be in the form of a tuple(word, level))
            Pair<String, Integer> node = Q.remove();
            //fetch the word and the level from the tuple
            String word = node.getKey();
            int level = node.getValue();
            
            //now within the for loop go through all the transformations
            for(int i=0;i<L;i++) {
                String newWord = word.substring(0,i)+'*'+word.substring(i+1, L);
                
                //now get the adjacentWords from the allComboDict
                //loop through, 
                //if the adjacent word is the endWord return the level +1
                //if the adjacent word is not in visited HashMap, add  it to the visited HashMap and to the Q
                
                for(String adjacentWord: allComboDict.getOrDefault(newWord, new ArrayList<String>())) {
                    //check if the adjacent word is the endWord return the level+1
                    if(adjacentWord.equals(endWord)) {
                        return level+1;
                    }
                    
                    //check if the adjacent word is not in visited HashMap, add  it to the visited HashMap and to the Q
                    if(!visited.containsKey(adjacentWord)) {
                        visited.put(adjacentWord, true);
                        Q.add(new Pair(adjacentWord, level+1));
                    }
                    
                }
                
            }
        }
        
        return 0;
    }
}