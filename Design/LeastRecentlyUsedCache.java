// https://www.youtube.com/watch?v=S6IfqDXWa10

// LRU Cache

// Design and implement a data structure for Least Recently Used (LRU) cache. It should support the following operations: get and put.

// get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
// put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.

// The cache is initialized with a positive capacity.

// Follow up:
// Could you do both operations in O(1) time complexity?

// Example:

// LRUCache cache = new LRUCache( 2 /* capacity */ );

// cache.put(1, 1);
// cache.put(2, 2);
// cache.get(1);       // returns 1
// cache.put(3, 3);    // evicts key 2
// cache.get(2);       // returns -1 (not found)
// cache.put(4, 4);    // evicts key 1
// cache.get(1);       // returns -1 (not found)
// cache.get(3);       // returns 3
// cache.get(4);       // returns 4


class LRUCache {
    
    class DLinkedList {
        int key;
        int value;
        DLinkedList next;
        DLinkedList prev;
    }
    
    private void addNode(DLinkedList node) {
        node.prev=head;
        node.next=head.next;
        
        head.next.prev=node;
        head.next=node;
    }
    
    private void removeNode(DLinkedList node) {
        DLinkedList prev= node.prev;
        DLinkedList next= node.next;
        
        
        next.prev=prev;
        prev.next=next;
    }
    
    private void moveToHead(DLinkedList node) {
        removeNode(node);
        addNode(node);
    }
    
    private DLinkedList popTail() {
        DLinkedList node = tail.prev;
        removeNode(node);
        return node;
    }
    
    
    private int size;
    private int capacity;
    private Map<Integer, DLinkedList> map= new HashMap<>();
    private DLinkedList head, tail;

    public LRUCache(int capacity) {
        this.capacity=capacity;
        this.size=0;
        
        head=new DLinkedList();
        tail= new DLinkedList();
        head.next=tail;
        tail.prev=head;
    }
    
    public int get(int key) {
        DLinkedList node = map.get(key);
        if(node == null){
            return -1;
        }
        else{
            moveToHead(node);
            return node.value;
        }
        
    }
    
    public void put(int key, int value) {
        DLinkedList node= map.get(key);
        if(node ==null) {
            //new val
            DLinkedList newNode= new DLinkedList();
            newNode.key=key;
            newNode.value=value;
            map.put(key, newNode);
            //addNode to head
            addNode(newNode);
            
            size++;
            
            //check size
            if(size > capacity) {
                //popTail
                DLinkedList poppedTail=popTail();
                size--;
                //remove from cache
                map.remove(poppedTail.key);
            }
        }
        else{
            //node already exists update value
            node.value=value;
            map.put(key, node);
            moveToHead(node);
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */