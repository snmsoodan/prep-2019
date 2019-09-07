import java.util.Arrays;

// Missing Number

// Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

// Example 1:

// Input: [3,0,1]
// Output: 2
// Example 2:

// Input: [9,6,4,2,3,5,7,0,1]
// Output: 8
// Note:

// Input: [0,1]
// Output: 2
// Note:

// Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?


// Solution 1: O(n) own solution using hashmap

class Solution {
    public int missingNumber(int[] nums) {
        int maxValue=-1;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i =0;i<nums.length;i++) {
            if(maxValue<nums[i]) maxValue=nums[i];
            int count = map.getOrDefault(nums[i], 0);
            map.put(nums[i],++count);
        }
        System.out.println(map);
        
        int missingValue = maxValue+1;
        for(int i=0;i<map.size();i++) {
            if(!map.containsKey(i)) return i;
        }
        return missingValue;
    }
}


// Solution 2 : without using Arrays  -   0ms solution 
class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length+1;
        int expected=0, actual=0;
        expected = n*(n+1)/2-n;
        for(int i=0;i<n-1;i++) {
            actual+=nums[i];
        }
        
        return expected-actual;
    }
}
