// Word Search


// Given a 2D board and a word, find if the word exists in the grid.

// The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

// Example:

// board =
// [
//   ['A','B','C','E'],
//   ['S','F','C','S'],
//   ['A','D','E','E']
// ]

// Given word = "ABCCED", return true.
// Given word = "SEE", return true.
// Given word = "ABCB", return false.


class Solution {
    
    boolean[][] visited;
    
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        //ensure all nodes will be searched as the begining point
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if(dfs(i,j,0,board, word)) {
                    return true;
                }
            }
        }
        return false;
        
    }
    
    public boolean dfs(int row, int col, int index, char[][] board, String word){
        
        /*
            1.check out of bound
            2. already visited
            3. not match
        */
        if(!checkBound(row, col, board) || 
            visited[row][col]||
            word.charAt(index)!=board[row][col]
          ){
            return false;
        }
        
        //since the char was matching mark node as visited
        visited[row][col]=true;
        
        //if we found the whole word return true
        if(index==word.length()-1) {
            return true;
        }
        
        /*
            continue searching the next char by increasing the index
        */
        index++;
        
        //dfs down right up left
        if(dfs(row+1, col, index, board, word)||
          dfs(row, col+1, index, board, word)||
          dfs(row-1, col, index, board, word)||
          dfs(row, col-1, index, board, word)
          ){
            return true;
        }
            
        
        //current position is wrong backtracking
        visited[row][col]=false;
        return false;
        
    }
    
    public boolean checkBound(int row, int col, char[][] board) {
        if(row == -1 || row==board.length||col==-1||col==board[0].length) {
            return false;
        }
        
        return true;
        
    }
    
    
}