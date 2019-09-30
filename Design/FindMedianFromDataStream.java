// Find Median from Data Stream

// Median is the middle value in an ordered integer list. If the size of the list is even, there is no middle value. So the median is the mean of the two middle value.

// For example,
// [2,3,4], the median is 3

// [2,3], the median is (2 + 3) / 2 = 2.5

// Design a data structure that supports the following two operations:

// void addNum(int num) - Add a integer number from the data stream to the data structure.
// double findMedian() - Return the median of all elements so far.
 

// Example:

// addNum(1)
// addNum(2)
// findMedian() -> 1.5
// addNum(3) 
// findMedian() -> 2
 

// Follow up:

// If all integer numbers from the stream are between 0 and 100, how would you optimize it?
// If 99% of all integer numbers from the stream are between 0 and 100, how would you optimize it?


class MedianFinder {
    
    private PriorityQueue<Integer> maxheap;
    private PriorityQueue<Integer> minheap;
    
    /** initialize your data structure here. */
    public MedianFinder() {
        maxheap=new PriorityQueue<>(Collections.reverseOrder());
        minheap=new PriorityQueue<>(Integer::compareTo);
    }
    
    public void addNum(int num) {
        //if maxheap is empty or top element in maxheap(max value) is greater than the number add to maxheap
        if(maxheap.isEmpty()||maxheap.peek()>num) {
            maxheap.offer(num);
        }
        else{
            minheap.offer(num);
        }
        
        int size1=maxheap.size();
        int size2=minheap.size();
        
        //if size of maxheap > size of minheap
        //move the max element from maxheap to minheap
        if(size1-size2 > 1){
            minheap.offer(maxheap.poll());
        }
        //minheap size is greater than maxheap size
        //move the top element from minheap(smallest value) to maxheap
        else if(size2-size1 > 1) {
            maxheap.offer(minheap.poll());
        }
        
    }
    
    public double findMedian() {
        int size1=maxheap.size();
        int size2=minheap.size();
        
        return size1==size2 ? ((maxheap.peek()+minheap.peek())*1.0)/2
            : size1>size2 ? maxheap.peek() : minheap.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */