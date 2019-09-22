// Maximum Subarray

// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Follow up:

// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.


// Solution 1: Greedy approach
class Solution {
    public int maxSubArray(int[] nums) {
        int n=nums.length, curSum=nums[0], maxSum=nums[0];

        for(int i=1;i<n;i++) {
            curSum=Math.max(curSum+nums[i], nums[i]);
            maxSum=Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}


// SOlution 2: Dynamic programming (Kadanes Algorithm)

class Solution {
    public int maxSubArray(int[] nums) {
       int n=nums.length, maxSum=nums[0];

       for(int i=1;i<n;i++) {
           if(nums[i-1]>0) {
               nums[i]+=nums[i-1];
           }

           maxSum=Math.max(maxSum, nums[i]);
       }
       return maxSum;
    }
}


//solution 3: Divide an conquer

class Solution {
    public int maxSubArray(int[] nums) {
        return helper(nums, 0, nums.length-1);
    }
    
    public int helper(int[] nums, int left, int right) {
        
        if(left==right) return nums[left];
        
        int p= (left+right)/2;
        
        int leftSum=helper(nums, left, p);
        int rightSum=helper(nums, p+1, right);
        int crossSum=crossSum(nums, left, right, p);
        
        return Math.max(Math.max(leftSum, rightSum), crossSum);
    }
    
    
    public int crossSum(int[] nums, int left, int right, int p) {
        
        if(left==right) return nums[left];
        
        int leftSubSum =Integer.MIN_VALUE;
        int curSum=0;
        for(int i=p;i>left-1;i--) {
            curSum+=nums[i];
            leftSubSum=Math.max(leftSubSum, curSum);
        }
        
        
        int rightSubSum=Integer.MIN_VALUE;
        curSum=0;
        for(int i=p+1;i<right+1;i++) {
            curSum+=nums[i];
            rightSubSum=Math.max(rightSubSum, curSum);
        }
        
        return leftSubSum+rightSubSum;
        
    }
    
}