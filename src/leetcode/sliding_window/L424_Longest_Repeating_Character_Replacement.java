package leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

/*
You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character. 
You can perform this operation at most k times.
Return the length of the longest substring containing the same letter you can get after performing the above operations.

Example 1:
Input: s = "ABAB", k = 2
Output: 4
Explanation: Replace the two 'A's with two 'B's or vice versa.

Example 2:
Input: s = "AABABBA", k = 1
Output: 4
Explanation: Replace the one 'A' in the middle with 'B' and form "AABBBBA".
The substring "BBBB" has the longest repeating letters, which is 4.
There may exists other ways to achive this answer too.

Constraints:
1 <= s.length <= 105
s consists of only uppercase English letters.
0 <= k <= s.length
*/

public class L424_Longest_Repeating_Character_Replacement {

    /*
     * Runtime: 18ms, beats 36.95%
     * Memory: 43.46MB, beats 27.32%
     * 
     * time: O(n)
     * space: O(n)
     */
    public int characterReplacement(String s, int k) {
        Map<Character, Integer> count = new HashMap<>();
        int res = 0;

        int l = 0;
        int maxf = 0;

        for(int r=0; r<s.length(); r++) {
            count.merge(s.charAt(r), 1, Integer::sum);
            maxf = Math.max(maxf, count.get(s.charAt(r)));

            while (((r - l + 1) - maxf) > k) {
                count.merge(s.charAt(l), 1, (prev, one)-> prev - 1);
                l++;
            }
            res = Math.max(res, r-l+1);
        }

        return res;  
    }

    public static void main(String[] args) {
        L424_Longest_Repeating_Character_Replacement app = new L424_Longest_Repeating_Character_Replacement();
        System.out.println(app.characterReplacement("ABAB", 4) == 4);
        System.out.println(app.characterReplacement("ABCDABA", 1) == 3);
    }
}