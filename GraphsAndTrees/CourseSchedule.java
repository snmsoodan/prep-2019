// Course Schedule  Follow the video https://www.youtube.com/watch?v=rG2-_lgcZzo

// There are a total of n courses you have to take, labeled from 0 to n-1.

// Some courses may have prerequisites, for example to take course 0 you have to first take course 1, which is expressed as a pair: [0,1]

// Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?

// Example 1:

// Input: 2, [[1,0]] 
// Output: true
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0. So it is possible.
// Example 2:

// Input: 2, [[1,0],[0,1]]
// Output: false
// Explanation: There are a total of 2 courses to take. 
//              To take course 1 you should have finished course 0, and to take course 0 you should
//              also have finished course 1. So it is impossible.
// Note:

// The input prerequisites is a graph represented by a list of edges, not adjacency matrices. Read more about how a graph is represented.
// You may assume that there are no duplicate edges in the input prerequisites.

class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        
        //course that key is preq for
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        int[] indegree = new int[numCourses];
        int num_count = 0;
        
        
        //build adjacency map and indegree
        
        for(int[]pr : prerequisites) {
            List<Integer> l = map.getOrDefault(pr[1], new ArrayList<>());
            l.add(pr[0]);
            indegree[pr[0]]++;
            map.put(pr[1], l);
        }
        
        //add courses with indegree 0 to our queue
        Queue<Integer> q= new LinkedList<>(); 
        
        for(int i=0;i<indegree.length;i++) {
            if(indegree[i]==0) {
                q.add(i);
            }
        }
        
        while(!q.isEmpty()) {
            int cur = q.poll();
            if(indegree[cur] == 0) {
                num_count++;
            }
            if(!map.containsKey(cur)) {
                continue;
            }
            
            //check the neighbour from the map and decrease their indegree, also if neighbour indegree is 0 add neighbour to the queue.
            for(int neighbour: map.get(cur)) {
                indegree[neighbour]--;
                if(indegree[neighbour]==0) {
                    q.add(neighbour);
                }
            }
        }
        
        return numCourses == num_count;
        
    }
}