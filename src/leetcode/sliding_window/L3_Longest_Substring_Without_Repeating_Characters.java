package leetcode.sliding_window;

import java.util.HashSet;
import java.util.Set;

/*
Given a string s, find the length of the longest substring without repeating characters. 

Example 1:
Input: s = "abcabcbb"
Output: 3
Explanation: The answer is "abc", with the length of 3.

Example 2:
Input: s = "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.

Example 3:
Input: s = "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3.
Notice that the answer must be a substring, "pwke" is a subsequence and not a substring.

Constraints:
0 <= s.length <= 5 * 104
s consists of English letters, digits, symbols and spaces.
*/

public class L3_Longest_Substring_Without_Repeating_Characters {

    /*
     * Runtime: ms, beats %
     * Memory: MB, beats %
     * 
     * time: O()
     * space: O()
     */
    public int lengthOfLongestSubstring(String s) {
        Set<Character> temp = new HashSet<>();
        int left = 0;
        int res = 0;

        for(int i=0; i< s.length(); i++) {
            while (temp.contains(s.charAt(i))) {
                temp.remove(s.charAt(left));
                left++;
            }
            temp.add(s.charAt(i));
            res = Math.max(res, i - left + 1);
        }
        return res;
    }

    public static void main(String[] args) {
        L3_Longest_Substring_Without_Repeating_Characters app = new L3_Longest_Substring_Without_Repeating_Characters();
        System.out.println(app.lengthOfLongestSubstring("abcabcbb") == 3);
        System.out.println(app.lengthOfLongestSubstring("bbbbb") == 1);
        System.out.println(app.lengthOfLongestSubstring("pwwkew") == 3);
    }
}
