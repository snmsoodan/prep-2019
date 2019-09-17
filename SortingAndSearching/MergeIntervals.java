// Merge Intervals

// Given a collection of intervals, merge all overlapping intervals.

// Example 1:

// Input: [[1,3],[2,6],[8,10],[15,18]]
// Output: [[1,6],[8,10],[15,18]]
// Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
// Example 2:

// Input: [[1,4],[4,5]]
// Output: [[1,5]]
// Explanation: Intervals [1,4] and [4,5] are considered overlapping.
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


import java.util.*;

class Solution {
    public int[][] merge(int[][] intervals) {
        
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0] );
        
        LinkedList<int[]> list = new LinkedList<>();
        
        for(int[] interval : intervals) {
            //if list is empty or end of previous element in list is < the start of the current element
            //simply add to the list
            if(list.isEmpty() || list.getLast()[1] < interval[0]) {
                list.add(interval);                
            }
            
            //else there is overlap and merge the previous with the current element by setting the index [2] of 
            //previous element in list as the max of prv[1] or current[1];
            else {
                list.getLast()[1] = Math.max(list.getLast()[1], interval[1]);   
            }
        }
        
        //convert list to array and return 
        return list.toArray(new int[list.size()][]);
        
    }
}