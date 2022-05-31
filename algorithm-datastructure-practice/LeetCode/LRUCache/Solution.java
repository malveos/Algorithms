/***
@Author Omkar Malve

146. LRU Cache

Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.
Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
The functions get and put must each run in O(1) average time complexity.


***/
class LRUCache {
   //private final Queue<Integer> cache;
    private final Map<Integer, Integer> map;
    private final int sz;
    public LRUCache(int capacity) {
        //cache = new ArrayDeque<>();
        sz = capacity;
        map = new LinkedHashMap<>(16, 0.75f, true) {
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > sz;
            }
        };
    }
    
    public int get(int key) {
        if (map.containsKey(key)) {
            // cache.remove(key);
            // cache.offer(key);
            return map.get(key);    
        }
        return -1;        
    }
    
    public void put(int key, int value) {
        // if (map.containsKey(key)) {
        //     cache.remove(key);
        //     cache.offer(key);
        //     map.put(key, value);
        // } else {
        //     if (cache.size() == sz)
        //         map.remove(cache.poll());
        //     cache.offer(key);
            map.put(key, value);
        //}
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */