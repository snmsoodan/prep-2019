// Top K Frequent Elements

// Given a non-empty array of integers, return the k most frequent elements.

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]
// Note:

// You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
// Your algorithm's time complexity must be better than O(n log n), where n is the array's size.

class Solution {
    public List<Integer> topKFrequent(int[] nums, int k) {
        //put every num in hashmap num, count
        Map<Integer, Integer> map=new HashMap<>();
        
        for(int num : nums) {
            map.put(num,map.getOrDefault(num, 0)+1);
        }
        
        //init heap the less frequent element first
        PriorityQueue<Integer> pq=new PriorityQueue<>((n1, n2) -> map.get(n1)-map.get(n2));
        
        //keep the k top elements in the heap
        for(int n: map.keySet()) {
            pq.add(n);
            if(pq.size()>k) {
                pq.poll();
            }
        }
        
        //build the output list
        List<Integer> list= new LinkedList<>();
        while(!pq.isEmpty()) {
            list.add(pq.poll());
        }
        Collections.reverse(list);
        return list;
        
    }
}