package leetcode.design;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.concurrent.atomic.AtomicLong;

/*
Completed: 2/21/2021
1) beats 12.79% performance
2) beats 95.72% for memory usage 
 */

/*
Design a data structure that follows the constraints of a Least Recently Used (LRU) cache.

Implement the LRUCache class:

LRUCache(int capacity) Initialize the LRU cache with positive size capacity.
int get(int key) Return the value of the key if the key exists, otherwise return -1.
void put(int key, int value) Update the value of the key if the key exists. Otherwise, add the key-value pair to the cache. If the number of keys exceeds the capacity from this operation, evict the least recently used key.
Follow up:
Could you do get and put in O(1) time complexity?

Example 1:
Input
["LRUCache", "put", "put", "get", "put", "get", "put", "get", "get", "get"]
[[2], [1, 1], [2, 2], [1], [3, 3], [2], [4, 4], [1], [3], [4]]
Output
[null, null, null, 1, null, -1, null, -1, 3, 4]

Explanation
LRUCache lRUCache = new LRUCache(2);
lRUCache.put(1, 1); // cache is {1=1}
lRUCache.put(2, 2); // cache is {1=1, 2=2}
lRUCache.get(1);    // return 1
lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
lRUCache.get(2);    // returns -1 (not found)
lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
lRUCache.get(1);    // return -1 (not found)
lRUCache.get(3);    // return 3
lRUCache.get(4);    // return 4

Constraints:
1 <= capacity <= 3000
0 <= key <= 3000
0 <= value <= 104
At most 3 * 104 calls will be made to get and put. 
 */
public class LRUCache {
	
	AtomicLong counter = new AtomicLong(); 

	PriorityQueue<LRKey> pq = new PriorityQueue<>(new Comparator() {
		@Override
		public int compare(Object o1, Object o2) {
			if ( o1 == o2 ) return 0;
			LRUCache.LRKey o1Key = (LRUCache.LRKey)o1;
			LRUCache.LRKey o2Key = (LRUCache.LRKey)o2;
			
			if ( o1Key.lastUsed > o2Key.lastUsed )
				return 1;
			else if ( o1Key.lastUsed < o2Key.lastUsed )
				return -1;
			else 
				return 0;
			
		}});

	Map<Integer, LRKey> keyMapLookup = new HashMap<>();
	Map<LRKey, Integer> keyValueLookup = new HashMap<>();
	int capacity;
	
    public LRUCache(int capacity) {
        this.capacity = capacity;
    }
    
    public int get(int key) {
    	LRKey specialKey = keyMapLookup.get(key);
    	if ( specialKey == null )
    		return -1;
    	else {
    		pq.remove(specialKey);
    		specialKey.updateTimestamp();
    		pq.add(specialKey);
    		
    		return keyValueLookup.get( specialKey );
    	}
    }
    
    public void put(int key, int value) {
    	LRKey specialKey = keyMapLookup.get(key);
    	if ( specialKey == null ) {
    		specialKey = new LRKey(key);

    		pq.add(specialKey);
    		keyValueLookup.put(specialKey, value);
    		keyMapLookup.put(key, specialKey);
    		
       		if ( keyMapLookup.size() > capacity ) {
       			LRKey lruKey = pq.poll();
       			keyValueLookup.remove(lruKey);
       			keyMapLookup.remove(lruKey.key);    			
       		}
    	} else {
    		pq.remove(specialKey);
    		specialKey.updateTimestamp();
    		pq.add(specialKey);

    		keyValueLookup.put(specialKey, value);
    	}

    }

    public static void main(String[] args) {
//    	LRUCache lRUCache = new LRUCache(2);
//    	lRUCache.put(1, 1); // cache is {1=1}
//    	lRUCache.put(2, 2); // cache is {1=1, 2=2}
//    	System.out.println(lRUCache.get(1));    // return 1
//    	lRUCache.put(3, 3); // LRU key was 2, evicts key 2, cache is {1=1, 3=3}
//    	System.out.println(lRUCache.get(2));    // returns -1 (not found)
//    	lRUCache.put(4, 4); // LRU key was 1, evicts key 1, cache is {4=4, 3=3}
//    	System.out.println(lRUCache.get(1));    // return -1 (not found)
//    	System.out.println(lRUCache.get(3));    // return 3
//    	System.out.println(lRUCache.get(4));    // return 4

    	LRUCache lRUCache = new LRUCache(2);
    	lRUCache.put(2, 1); 
    	lRUCache.put(1, 1); 
    	lRUCache.put(2, 3); 
    	lRUCache.put(4, 1); 
    	System.out.println(lRUCache.get(1));
    	System.out.println(lRUCache.get(2));
    }

    class LRKey {
    	int key;
    	long lastUsed;
    	
    	LRKey(int key) {
    		this.key = key;
    		lastUsed = counter.getAndIncrement();
    	}

    	public void updateTimestamp() {
    		lastUsed = counter.getAndIncrement();
    	}
    	
    	@Override
    	public int hashCode() {
    		return key;
    	}

    	@Override
    	public boolean equals(Object o) {
    		if ( o == this )
    			return true;
    		
    		if (!(o instanceof LRKey))
    			return false;
    		
    		LRKey other = (LRKey)o;
    		if ( other.key == this.key )
    			return true;
    		
    		return false;
    	}
    }

}

