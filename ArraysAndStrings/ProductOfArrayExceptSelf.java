// Product of Array Except Self

// Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Example:

// Input:  [1,2,3,4]
// Output: [24,12,8,6]
// Note: Please solve it without division and in O(n).

// Follow up:
// Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)


// Solution 1: O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        
        left[0] = 1;
        for(int i=0;i<n-1;i++) {
            left[i+1] = left[i]*nums[i];
        }
        
        right[n-1] = 1;
        for(int i=n-2;i>=0;i--) {
            right[i] = right[i+1]*nums[i+1];
        }
        
        for(int i=0;i<n;i++) {
            nums[i]=left[i]*right[i];
        }
        
        return nums;
    }
}


// Solution 2: O(1) space approach
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        
        left[0]=1;
        for(int i=0;i<n-1;i++) {
            left[i+1]=left[i]*nums[i];
        }
        
        int r=1;
        for(int i=n-1;i>=0;i--) {
            int temp=nums[i];
            nums[i] = left[i]*r;
            r*=temp;
        }
        return nums;
    }
}