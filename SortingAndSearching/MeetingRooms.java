// Meeting Rooms II

// Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei), find the minimum number of conference rooms required.

// Example 1:

// Input: [[0, 30],[5, 10],[15, 20]]
// Output: 2
// Example 2:

// Input: [[7,10],[2,4]]
// Output: 1
// NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature.


class Solution {
    public int minMeetingRooms(int[][] intervals) {
        
        Arrays.sort(intervals, (int[] a, int[] b) -> a[0]-b[0]);
        
        LinkedList<int[]> list = new LinkedList<>();
        int count = 0;
        for(int i=0;i<intervals.length;i++) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }
        
        for(int[] interval : intervals) {
            if(list.isEmpty() || list.getLast()[1]>=interval[0]) {
                // System.out.println(list.getLast()[1]);
                // System.out.println(interval[0]);
                count++;
            }
            list.add(interval);
        }
     
        return count;
    }
}