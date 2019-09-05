// Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target. Return the sum of the three integers. You may assume that each input would have exactly one solution.

// Example:

// Given array nums = [-1, 2, 1, -4], and target = 1.

// The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        if(nums.length<3) throw new Error("array length is less than 3");
        //sort the array
        Arrays.sort(nums);
        int retVal=0,minDiff=Integer.MAX_VALUE;
        int j,k;
        for(int i=0;i<nums.length;i++) {
            if(i!=0 && nums[i]==nums[i-1]) continue;
            j=i+1;
            k=nums.length -1;
            while(j<k) {
                int sum = nums[i] + nums[j] +nums[k];
                if(sum == target) return sum;
                else if(sum<target) j++;
                else k--;
                if(Math.abs(sum-target)<minDiff) {
                    minDiff=Math.abs(sum-target);
                    retVal=sum;
                }
            }
        }
        return retVal;
    }
}