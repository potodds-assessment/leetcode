package leetcode._general_solutions_;

public class substring {

    /////////////////////////////////////////////////////////////
    // Substring template explanation and solutions
    /////////////////////////////////////////////////////////////
    // https://leetcode.com/problems/minimum-window-substring/solutions/26808/here-is-a-10-line-template-that-can-solve-most-substring-problems/
    /////////////////////////////////////////////////////////////
    // For most substring problem, we are given a string and need to find a substring of it which satisfy some restrictions.
    // A general way is to use a hashmap assisted with two pointers.
    //
    // 1. Use two pointers: start and end to represent a window.
    // 2. Move end to find a valid window.
    // 3. When a valid window is found, move start to find a smaller window.
    /////////////////////////////////////////////////////////////
    // General solution template
    ////////////////////////////
    //    int findSubstring(string s){
    //        vector<int> map(128,0);
    //        int counter; // check whether the substring is valid
    //        int begin=0, end=0; //two pointers, one point to tail and one  head
    //        int d; //the length of substring
    //
    //        for() { /* initialize the hash map here */ }
    //
    //        while(end<s.size()){    //
    //            if(map[s[end++]]-- ?){  /* modify counter here */ }    //
    //            while(/* counter condition */){    //
    //                /* update d here if finding minimum*/    //
    //                //increase begin to make it invalid/valid again    //
    //                if(map[s[begin++]]++ ?){ /*modify counter here*/ }
    //            }    //
    //            /* update d here if finding maximum*/
    //        }
    //        return d;
    //    }
    /////////////////////////////////////////////////////////////


    /////////////////////////////////////////////////////////////
    // 76. Minimum Window Substring
    // https://leetcode.com/problems/minimum-window-substring/
    /////////////////////////////////////////////////////////////
    public String minWindow(String s, String t) {
        int [] map = new int[128];
        for (char c : t.toCharArray()) {
            map[c]++;
        }
        int start = 0, end = 0, minStart = 0, minLen = Integer.MAX_VALUE, counter = t.length();
        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter--;
            map[c1]--;
            end++;
            while (counter == 0) {
                if (minLen > end - start) {
                    minLen = end - start;
                    minStart = start;
                }
                final char c2 = s.charAt(start);
                map[c2]++;
                if (map[c2] > 0) counter++;
                start++;
            }
        }

        return minLen == Integer.MAX_VALUE ? "" : s.substring(minStart, minStart + minLen);
    }

    /////////////////////////////////////////////////////////////
    // LOCKED Longest Substring - at most K distinct characters
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

    /////////////////////////////////////////////////////////////
    // LOCKED Longest Substring - at most 2 distinct characters
    // https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
    /////////////////////////////////////////////////////////////
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] == 0) counter++;
            map[c1]++;
            end++;

            while (counter > 2) {
                final char c2 = s.charAt(start);
                if (map[c2] == 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    /////////////////////////////////////////////////////////////
    // 3. Longest Substring Without Repeating Characters
    // https://leetcode.com/problems/longest-substring-without-repeating-characters/
    /////////////////////////////////////////////////////////////
    public int lengthOfLongestSubstring2(String s) {
        int[] map = new int[128];
        int start = 0, end = 0, maxLen = 0, counter = 0;

        while (end < s.length()) {
            final char c1 = s.charAt(end);
            if (map[c1] > 0) counter++;
            map[c1]++;
            end++;

            while (counter > 0) {
                final char c2 = s.charAt(start);
                if (map[c2] > 1) counter--;
                map[c2]--;
                start++;
            }

            maxLen = Math.max(maxLen, end - start);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        substring app = new substring();
        System.out.println(app.minWindow("ADOBECODEBANC", "ABC").equals("BANC"));
        System.out.println(app.minWindow("a", "a").equals("a"));
        System.out.println(app.minWindow("a", "aa").equals(""));
    }
}
