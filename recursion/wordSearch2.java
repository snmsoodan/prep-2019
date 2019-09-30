// Word Search II

// Given a 2D board and a list of words from the dictionary, find all words in the board.

// Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.

 

// Example:

// Input: 
// board = [
//   ['o','a','a','n'],
//   ['e','t','a','e'],
//   ['i','h','k','r'],
//   ['i','f','l','v']
// ]
// words = ["oath","pea","eat","rain"]

// Output: ["eat","oath"]
 

// Note:

// All inputs are consist of lowercase letters a-z.
// The values of words are distinct.


class Solution {
    boolean[][] visited; 
    public List<String> findWords(char[][] board, String[] words) {
        
        Set<String> set = new HashSet<>();
        
        for(String word: words) {
            visited=new boolean[board.length][board[0].length];
            
            for(int i=0;i<board.length;i++) {
                for(int j=0;j<board[0].length;j++) {
                    
                    if(dfs(i,j,0,board, word)){
                        System.out.println(word);
                        set.add(word);   
                    }
                }
            }
        }
        
        List<String> list = new ArrayList(set);
        
        return list;
    }
    
    public boolean dfs(int row, int col, int index, char[][] board, String word) {
        
        /*
            1.checkbound
            2.already visited
            3.word doesnt match
        */
        if(!checkbound(row, col, board)||
            visited[row][col]||
           word.charAt(index)!=board[row][col]
          ){
            return false;
        }
        
        //since word matched mark visited
        visited[row][col]=true;
        
        //if whole word is matched return true
        if(index==word.length()-1) {
            return true;
        }
        
        //increase the index and search the next word
        index++;
        
        if(dfs(row+1,col,index, board, word)||
           dfs(row,col+1,index, board, word)||
           dfs(row-1,col,index, board, word)||
           dfs(row,col-1,index, board, word)){
            return true;
        }
        
        //need to mark node visited false as backtracking
        visited[row][col]=false;
        return false;
        
    }
    
    
    public boolean checkbound(int row, int col, char[][] board) {
        if(row==-1||row==board.length||col==-1||col==board[0].length) {
            return false;
        }
        
        return true;
        
    }
    
    
}