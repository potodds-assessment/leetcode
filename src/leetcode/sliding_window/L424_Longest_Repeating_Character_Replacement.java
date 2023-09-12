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
        int longestCount = 0;

        int lIndex = 0;
        int mostFreqChar = 0;

        for(int rIndex=0; rIndex<s.length(); rIndex++) {
            count.merge(s.charAt(rIndex), 1, Integer::sum);
            mostFreqChar = Math.max(mostFreqChar, count.get(s.charAt(rIndex)));

            //rIndex - lIndex + 1 == window
            while (((rIndex - lIndex + 1) - mostFreqChar) > k) {
                count.merge(s.charAt(lIndex), 1, (prev, one)-> prev - 1);
                lIndex++;
            }
            longestCount = Math.max(longestCount, rIndex-lIndex+1);
        }

        return longestCount;  
    }

    public static void main(String[] args) {
        L424_Longest_Repeating_Character_Replacement app = new L424_Longest_Repeating_Character_Replacement();
        System.out.println(app.characterReplacement("ABCDABA", 1) == 3);
        System.out.println(app.characterReplacement("ABAB", 4) == 4);
        System.out.println(app.characterReplacement("ABABBACDEFGHZYHHH", 2) == 6);
    }
}