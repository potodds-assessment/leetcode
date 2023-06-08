package neetcode.arrays_hashing;

import java.util.*;
import java.util.stream.Collectors;

/*
Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

Example 1:
Input: nums = [1,1,1,2,2,3], k = 2
Output: [1,2]

Example 2:
Input: nums = [1], k = 1
Output: [1]

Constraints:

1 <= nums.length <= 105
-104 <= nums[i] <= 104
k is in the range [1, the number of unique elements in the array].
It is guaranteed that the answer is unique.

Follow up: Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 */
public class Top_K_Frequent_Elements {

    public int[] topKFrequent1(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();

        for(int val : nums) {
            Integer value = count.get( val );
            if ( value == null ) {
                count.put(val, 1);
            } else {
                count.put(val, ++value);
            }
        }

        TreeSet<Integer> sort = new TreeSet<>();
        for(Integer i : count.values()) {
            sort.add(i);
        }

        List<Integer> list = sort.stream().limit(k).collect(Collectors.toList());
        System.out.println(Arrays.toString( list.toArray() ));

        return list.stream().mapToInt(i -> i).toArray();
    }

    /*
    Optimal solution is Bucket Sort
    Time O(n)
    Space O(n)

    Runtime 11ms beats 94.75%
    Memory 47.6MB beats 5.35%

    1. HashMap to count number of each integer
    2. Use integer count as index for array.   Array size is nums.length as that is largest possible.
    3. Iterate from last to first on array to get final array.  One tricky part was iterating through index list to get all values.
     */

    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] ct = new List[nums.length+1];
        int[] result = new int[k];

        for(int val : nums) {
            Integer value = count.get( val );
            if ( value == null ) {
                count.put(val, 1);
            } else {
                count.put(val, ++value);
            }
        }

        Iterator<Integer> z = count.keySet().iterator();
        while (z.hasNext()) {
            int key = z.next();
            int value = count.get(key);

            if (ct[value] == null) {
                ct[value] = new ArrayList<>();
            }
            ct[value].add(key);
        }

        int current_index = 0;
        for(int i=nums.length; i>0; i--) {
            if (ct[i] != null) {
                while ( ct[i].size() != 0 ) {
                    result[current_index] = ct[i].get(0);
                    ct[i].remove(0);
                    if (current_index + 1 == k)
                        return result;
                    current_index++;
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Top_K_Frequent_Elements app = new Top_K_Frequent_Elements();
        System.out.println(Arrays.toString(app.topKFrequent(new int[] {1,1,1,2,2,3}, 2)));
        System.out.println(Arrays.toString(app.topKFrequent(new int[] {1,2}, 2)));
    }
}

class Val {
    int value;
    int count;

}
