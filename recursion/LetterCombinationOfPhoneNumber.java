// Letter Combinations of a Phone Number

// Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent.

// A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.



// Example:

// Input: "23"
// Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
// Note:

// Although the above answer is in lexicographical order, your answer could be in any order you want.



class Solution {
    //create a map of numbers to the alphabet
    Map<String, String> map=new HashMap<>();

    //output list
    List<String> output=new ArrayList<>();
    
    public List<String> letterCombinations(String digits) {
        map.put("2", "abc");
        map.put("3", "def");
        map.put("4", "ghi");
        map.put("5", "jkl");
        map.put("6", "mno");
        map.put("7", "pqrs");
        map.put("8", "tuv");
        map.put("9", "wxyz");
        
        if(digits.length()!=0){
            helper("", digits);   
        }
        return output;
    }
    
    
    public void helper(String combination, String next_digits){
        
        //if there are no next_digits to check then we can add the combination to output
        if(next_digits.length()==0) {
            output.add(combination);
        }
        
        else{
            
            String digit = next_digits.substring(0,1);
            String letters= map.get(digit);
            
            for(int i=0;i<letters.length();i++) { 
                String letter=letters.substring(i,i+1);
                helper(combination+letter, next_digits.substring(1));
            }
            
        }
        
        
    }
    
    
}