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
 */
public class Top_K_Frequent_Elements {
    public int[] topKFrequent(int[] nums, int k) {
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

    public static void main(String[] args) {
        Top_K_Frequent_Elements app = new Top_K_Frequent_Elements();
        System.out.println(app.topKFrequent(new int[] {1,1,1,2,2,3}, 2));
        System.out.println(app.topKFrequent(new int[] {-1,-1}, 1));
    }
}
