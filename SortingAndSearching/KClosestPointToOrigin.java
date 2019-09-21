// K Closest Points to Origin

// We have a list of points on the plane.  Find the K closest points to the origin (0, 0).

// (Here, the distance between two points on a plane is the Euclidean distance.)

// You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

 

// Example 1:

// Input: points = [[1,3],[-2,2]], K = 1
// Output: [[-2,2]]
// Explanation: 
// The distance between (1, 3) and the origin is sqrt(10).
// The distance between (-2, 2) and the origin is sqrt(8).
// Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
// We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].
// Example 2:

// Input: points = [[3,3],[5,-1],[-2,4]], K = 2
// Output: [[3,3],[-2,4]]
// (The answer [[-2,4],[3,3]] would also be accepted.)
 

// Note:

// 1 <= K <= points.length <= 10000
// -10000 < points[i][0] < 10000
// -10000 < points[i][1] < 10000


class Solution {
    public int[][] kClosest(int[][] points, int K) {
        
        int n = points.length;
        int[] dists = new int[n];
        
        //populate dists array
        for(int i=0;i<n;i++) {
            dists[i] = dist(points[i][0], points[i][1]);
        }
        
        //sort dists array
        Arrays.sort(dists);
        
        //initialize the return array
        int[][] ans= new int[K][2];
        
        //fetch the distance value of element at k-th position
        int distK = dists[K-1];
        
        
        int t=0;
        for(int i=0;i<n;i++) {
            if(dist(points[i][0], points[i][1]) <= distK) {
                ans[t] = points[i];
                t++;
            }
        }
        
        return ans;
            
    }
    
    
    public int dist(int a, int b) {
        return (a*a) +(b*b);
    }
}