// Roman to Integer
// Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

// Symbol       Value
// I             1
// V             5
// X             10
// L             50
// C             100
// D             500
// M             1000
// For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.

// Roman numerals are usually written largest to smallest from left to right. However, the numeral for four is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it making four. The same principle applies to the number nine, which is written as IX. There are six instances where subtraction is used:

// I can be placed before V (5) and X (10) to make 4 and 9. 
// X can be placed before L (50) and C (100) to make 40 and 90. 
// C can be placed before D (500) and M (1000) to make 400 and 900.
// Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.

// Example 1:

// Input: "III"
// Output: 3
// Example 2:

// Input: "IV"
// Output: 4
// Example 3:

// Input: "IX"
// Output: 9
// Example 4:

// Input: "LVIII"
// Output: 58
// Explanation: L = 50, V= 5, III = 3.
// Example 5:

// Input: "MCMXCIV"
// Output: 1994
// Explanation: M = 1000, CM = 900, XC = 90 and IV = 4.


import java.util.*;

class Solution {

    public static void main(String[] args) {
        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        Map<String, Integer> map = new HashMap<>();
        map.put("I",1);
        map.put("IV",4);
        map.put("V",5);
        map.put("IX",9);
        map.put("X",10);
        map.put("XL",40);
        map.put("L",50);
        map.put("XC",90);
        map.put("C",100);
        map.put("CD",400);
        map.put("D",500);
        map.put("CM",900);
        map.put("M",1000);
        int i=0,res=0;
        String k="";
        if(s.length()==1) {
            return map.get(s);
        }
        while(i < s.length()){
            System.out.println("k-Length "+k.length());
            if((i+1)<s.length() && k.length()==0 && (map.get(Character.toString(s.charAt(i+1))) > map.get(Character.toString(s.charAt(i))) )){
                k+=Character.toString(s.charAt(i));
                System.out.println("1 "+k);
            }
            else{
                if(k.length()==1) {
                    System.out.println("2 "+k);
                    res+=map.get(k+Character.toString(s.charAt(i)));
                    k="";
                } else {
                    System.out.println("3 "+Character.toString(s.charAt(i)));
                    res+=map.get(Character.toString(s.charAt(i)));
                }
            }
            i++;
        }
        return res;
            
    }
}