// Trapping Rain Water

// Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


// The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

// Example:

// Input: [0,1,0,2,1,0,1,3,2,1,2,1]
// Output: 6


class Solution {
    public int trap(int[] height) {
        int n=height.length,low=0, hi=n-1, leftMax=-1, rightMax=-1, capacity=0;
        
        while(low<=hi) {
            if(leftMax<rightMax) {
                leftMax=Math.max(leftMax, height[low]);
                capacity+=leftMax-height[low++];
            }
            else {
                rightMax=Math.max(rightMax,height[hi]);
                capacity+=rightMax-height[hi--];
            }
        }
        
        return capacity;
    }
}