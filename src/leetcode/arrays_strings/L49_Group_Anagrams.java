package leetcode.arrays_strings;

/////////////////////////////////////////////////////////////
// 49. Group Anagrams
// https://leetcode.com/problems/group-anagrams/
/////////////////////////////////////////////////////////////

/*
Given an array of strings strs, group the anagrams together. You can return the answer in any order.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
typically using all the original letters exactly once.

Example 1:
Input: strs = ["eat","tea","tan","ate","nat","bat"]
Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

Example 2:
Input: strs = [""]
Output: [[""]]

Example 3:
Input: strs = ["a"]
Output: [["a"]]

Constraints:
1 <= strs.length <= 104
0 <= strs[i].length <= 100
strs[i] consists of lowercase English letters.
 */

import java.util.*;

public class L49_Group_Anagrams {

    /*
    Runtime: 7ms, beats 76.82%
    Memory: 45.9MB, beats 51.98%

    time: O(m * n log n )
    space: O(n)
     */
    public List<List<String>> groupAnagramsSorted(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(String val : strs) {
            char[] t = val.toCharArray();
            Arrays.sort(t);
            String sortStr = new String(t);

            List<String> l = ans.get(sortStr);
            if ( l == null ) {
                List<String> ll = new ArrayList<>();
                ll.add(val);
                ans.put(sortStr, ll);
            } else {
                l.add(val);
            }
        }

        return getList( ans.values() );
    }

    /*
     Runtime: 22ms, beats 21.3%
     Memory: 47.4MB, beats 11.59%

     time: O(m * n)
     space: O(n)
      */
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> ans = new HashMap<>();
        for(String val : strs) {
            int[] count = new int[26];

            for(char c : val.toCharArray()) {
                count[(int)c - (int)'a']++;
            }

            String key = new String(Arrays.toString(count));
            List<String> values =  ans.get(key);
            ans.computeIfAbsent(key, k->new ArrayList<>());
            ans.get(key).add(val);
 /*
            if ( values == null ) {
                values = new ArrayList<String>();
                values.add(val);
                ans.put(count, values);
            } else {
                values.add(val);
            }
            */
        }

        return getList( ans.values() );
    }

    public List<List<String>> getList(Collection<List<String>> ans) {
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<String> l : ans ) {
            res.add(l);
        }
        return res;
    }

    public void printList(List<List<String>> val) {
        for(List<String> t : val) {
            System.out.println( Arrays.toString( t.toArray() ));
        }
    }

    public static void main(String[] args) {
        L49_Group_Anagrams app = new L49_Group_Anagrams();
        app.printList( app.groupAnagrams(new String[]{"eat", "tea", "tan", "ate", "nat", "bat"}));
        app.printList( app.groupAnagrams(new String[]{""}));
        app.printList( app.groupAnagrams(new String[]{"a"}));
    }
}
