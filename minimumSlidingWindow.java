
import java.util.*;
/**
 * minimumSlidingWindow
 */
public class minimumSlidingWindow {

    public static void main(String[] args) {
        System.out.println(minWindow("aa","aa"));
    }

    public static String minWindow(String s, String t) {
        if(s.length()==0 || t.length()==0) return "";
        else if(s.length()<t.length()) return "";
        
        Map<Character, Integer> dict = new HashMap<>();
        
        //prepare a map of chars in t with their count
        for(char ch : t.toCharArray()) {
            int count = dict.getOrDefault(ch, 0);
            count++;
            dict.put(ch, count);
        }

        // System.out.println(dict);
        
        //map to maintain the character and its count in the current window
        Map<Character, Integer> window = new HashMap<>();
        
        //required unique characters to satisfy t
        int required = dict.size();
        //unique characters found in the current window
        int formed = 0;
        
        //start scanning s from index 0
        int l=0,r=0;
        int[] ans = new int[]{-1, 0, 0};
        
        while(r<s.length()) {
            char c= s.charAt(r);
            int count = window.getOrDefault(c, 0);
            count++;
            window.put(c,count);
            
            //only when the frequency of character in window matchef of that in dict increase formed value;
            if(dict.containsKey(c) &&  dict.get(c) == window.get(c)) formed++;
            
            //contract the window if formed == required
            while(l<=r && formed == required) {
                System.out.println("here");
                char lChar = s.charAt(l);
                //save the current window size and ans
                if(ans[0] == -1 || r-l+1<ans[0] ) {
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                
                //remove the removed character frequency from window
                window.put(lChar, window.get(lChar)-1);
                
                //now decrease the value of formed based on whether the frequency of removed character after sliding window has decreased 
                if(dict.containsKey(lChar)  && dict.get(lChar)>window.get(lChar)) formed--;
                
                l++;
            }
            
            r++;
        }
        System.out.println(ans[0]);
        if(ans[0] == -1) return  "";
        else return s.substring(ans[1], ans[2]+1);
    }
}