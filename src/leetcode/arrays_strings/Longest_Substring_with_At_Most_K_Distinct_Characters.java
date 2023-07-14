package leetcode.arrays_strings;

public class Longest_Substring_with_At_Most_K_Distinct_Characters {
    /////////////////////////////////////////////////////////////
    // 340. Longest Substring - at most K distinct characters
    // https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
    /////////////////////////////////////////////////////////////
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int[] map = new int[256];
        int start = 0, end = 0, maxLen = Integer.MIN_VALUE, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > k) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    public static void main(String[] args) {

    }
}
