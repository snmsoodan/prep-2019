// Container With Most Water
// Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

// Note: You may not slant the container and n is at least 2.

// Example:

// Input: [1,8,6,2,5,4,8,3,7]
// Output: 49


// solution 1: brute force

class Solution {
    public int maxArea(int[] height) {
        int maxArea=0;
        for(int i=0;i<height.length;i++) {
            for(int j=i+1;j<height.length;j++) {
                maxArea = Math.max(maxArea, Math.min(height[i], height[j])*(j-i));
            }
        }
        return maxArea;
        
    }
}


// solution 2: Two Pointer Approach
class Solution {
    public int maxArea(int[] height) {
        int l=0, maxArea=0, r=height.length -1;
        while(r>l) {
            maxArea = Math.max(maxArea, Math.min(height[l], height[r])*(r-l));
            if(height[l]>height[r]) r--;
            else l++;
        }
        return maxArea;
    }
}