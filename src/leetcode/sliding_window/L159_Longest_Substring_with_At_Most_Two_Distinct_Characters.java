package leetcode.sliding_window;

/*
Given a string s, return the length of the longest 
substring that contains at most two distinct characters.

Example 1:
Input: s = "eceba"
Output: 3
Explanation: The substring is "ece" which its length is 3.

Example 2:
Input: s = "ccaabbb"
Output: 5
Explanation: The substring is "aabbb" which its length is 5.

Constraints:
1 <= s.length <= 105
s consists of English letters.
*/

public class L159_Longest_Substring_with_At_Most_Two_Distinct_Characters {

    /*
    Runtime: 4ms, beats 99.30%
    Memory: 44.21MB, beats 51.05%

    time: O(n)
    space: O(1)
    */

    public static int lengthOfLongestSubstringTwoDistinct(String s) {
        final int OFFSET = 97;

        char[] chArray = s.toCharArray();
        int longest = 0;
        int currentLength = 0;
        int[] count = new int[(int)'z' + OFFSET];
        int start = 0;
        int end = 0;
        int distinct = 0;

        while(end < s.length()) {

            if (count[chArray[end]] == 0) {
                distinct++;
            }
            count[chArray[end]]++;

            currentLength++;
            end++;
            if (distinct <= 2) {
                longest = Math.max(currentLength, longest);
            }

            while (distinct > 2) {
                count[chArray[start]]--;
                if (count[chArray[start]] == 0)
                    distinct--;
                
                currentLength--;
                start++;
            }
        }

        return longest;    
    }

    public static void main(String[] args) {
        System.out.println("eceba: " + L159_Longest_Substring_with_At_Most_Two_Distinct_Characters.lengthOfLongestSubstringTwoDistinct("eceba"));
        System.out.println("ccaabbb: " + L159_Longest_Substring_with_At_Most_Two_Distinct_Characters.lengthOfLongestSubstringTwoDistinct("ccaabbb"));
    }
}
