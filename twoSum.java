// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:

// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

//Solution 1: brute force
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i=0;i<nums.length;i++) {
            for(int j=i;j<nums.length;j++) {
                if(nums[i]+nums[j] == target) {
                    return new int[] {i,j};
                }
            }
        }
        throw new Error("no match found");
    }
}


//Solution 2: two pass hashtable

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        //create HashMap with (key,value) = (number, index)
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i],i);
        }
        
        for(int i=0;i<nums.length;i++) {
            int compliment = target-nums[i];
            if(map.containsKey(compliment) && map.get(compliment) != i) {
                return new int[] {i, map.get(compliment)};
            }
        }
        
        throw new Error("no match found");
        
    }
}


//Solution 3: One pass HashTable

class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        for(int i=0; i<nums.length;i++) {
            int compliment = target - nums[i];
            if(map.containsKey(compliment) && map.get(compliment) != i) {
                return new int[] {map.get(compliment), i};
            }
            map.put(nums[i], i);
        }
        throw new Error("no match found");
    }
}