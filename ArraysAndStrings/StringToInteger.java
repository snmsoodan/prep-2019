// Implement atoi which converts a string to an integer.

// The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

// The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

// If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

// If no valid conversion could be performed, a zero value is returned.

// Note:

// Only the space character ' ' is considered as whitespace character.
// Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. If the numerical value is out of the range of representable values, INT_MAX (231 − 1) or INT_MIN (−231) is returned.
// Example 1:

// Input: "42"
// Output: 42
// Example 2:

// Input: "   -42"
// Output: -42
// Explanation: The first non-whitespace character is '-', which is the minus sign.
//              Then take as many numerical digits as possible, which gets 42.
// Example 3:

// Input: "4193 with words"
// Output: 4193
// Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
// Example 4:

// Input: "words and 987"
// Output: 0
// Explanation: The first non-whitespace character is 'w', which is not a numerical 
//              digit or a +/- sign. Therefore no valid conversion could be performed.
// Example 5:

// Input: "-91283472332"
// Output: -2147483648
// Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
//              Thefore INT_MIN (−231) is returned.



class Solution {
    
    public int myAtoi(String str) {
        
        // empty string
        if(str.length() == 0)
            return 0;
        
        // iterate over to first non-white space character
        int index = 0;
        while(index < str.length() && str.charAt(index) == ' '){
            index += 1;
        }
        
        // return 0 if it turns out this whole string was nothing but white spaces.
        if(index == str.length())
            return 0;
        
        // make sure that the first character is +, -, or a number
        int digit = Character.getNumericValue(str.charAt(index));
        if(index == str.length() || ((str.charAt(index) != '-' && str.charAt(index) != '+') && (digit < 0 || digit > 9)) ){
            return 0;
        }
        
        // if there was a sign character, set the sign integer to 1 or -1, and increment index by 1.
        long sign = 1;
        if(str.charAt(index) == '-'){
            index += 1;
            sign = -1;
        } else if(str.charAt(index) == '+'){
            index += 1;
        }
         
        // read in the number.
        long ret = 0;
        while(index < str.length()){
            
            digit = Character.getNumericValue(str.charAt(index));   
            
            // you've hit a non-digit character
            if(digit < 0 || digit > 9){
                return (int) ret;
            }
            
            ret *= 10;
            if(sign == 1){
                ret += digit;
            } else {
                ret -= digit;
            }
            
            // overflow 
            if(ret > Integer.MAX_VALUE)
                return Integer.MAX_VALUE;
            if(ret < Integer.MIN_VALUE)
                return Integer.MIN_VALUE;
            
            index += 1;
            
        }
        
        return (int)ret;
        
    }
}