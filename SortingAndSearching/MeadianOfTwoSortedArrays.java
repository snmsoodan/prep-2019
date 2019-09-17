// Median of Two Sorted Arrays

// There are two sorted arrays nums1 and nums2 of size m and n respectively.

// Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).

// You may assume nums1 and nums2 cannot be both empty.

// Example 1:

// nums1 = [1, 3]
// nums2 = [2]

// The median is 2.0
// Example 2:

// nums1 = [1, 2]
// nums2 = [3, 4]

// The median is (2 + 3)/2 = 2.5

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        
        int m = nums1.length;
        int n = nums2.length;
        
        //check if m<=n ,continue if true else swap the arrays and the lengths
        if(m>n) {
            int[] temp = nums1;nums1=nums2;nums2=temp;
            int tmp=m;m=n;n=tmp;
        }
        
        //now start the while loop till iMin<=iMax
        int iMin=0,iMax=m, halfLength=(m+n+1)/2;
        while(iMin<=iMax) {
            //initialize i and j
            int i = (iMin+iMax)/2;
            int j = halfLength-i;
            
            //check if i is too small
            if(i<iMax && nums2[j-1]>nums1[i]) {
                iMin = i+1;
            }
            //check if i is too big
            else if(i>iMin && nums1[i-1]>nums2[j]) {
                iMax=i-1;
            }
            
            //when i is perfect
            else{
                //initialise maxLeft
                int maxLeft=0;
                if(i==0) maxLeft=nums2[j-1];
                else if(j==0) maxLeft=nums1[i-1];
                else maxLeft=Math.max(nums1[i-1], nums2[j-1]);
                System.out.println(maxLeft);
                //if sum of arrayLengths is odd;
                if((m+n)%2 == 1) return maxLeft;
                
                //initialise minRight
                int minRight=0;
                if(i==m) minRight=nums2[j];
                else if(j==n) minRight=nums1[i];
                else minRight=Math.min(nums1[i], nums2[j]);
                System.out.println(maxLeft + " " +minRight);
                return (maxLeft+minRight)/2.0;
                
            }
            
        }
        
        return 0.0;
        
    }
}