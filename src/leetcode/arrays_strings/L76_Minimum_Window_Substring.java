package leetcode.arrays_strings;

import java.util.HashMap;
import java.util.Map;

public class L76_Minimum_Window_Substring {
    /////////////////////////////////////////////////////////////
    // 76. Minimum Window Substring
    // Category: Sliding Windows
    // https://leetcode.com/problems/minimum-window-substring/
    // 1st pointer starts from beginning to end.  2nd pointer starts from beginning to end, removing the slack from behind, creating smaller window.
    // Map maintains count. Check running count versus target count.  Whenever counts match, possible solution.  When counts diverge, move pointers to reduce characters left.
    /////////////////////////////////////////////////////////////
    public String minWindow1(String s, String t) {
        int[] map = new int[128];
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

    public String minWindow(String s, String t) {
        if (t == null || t.equals("")) return t;

        Map<Character, Integer> countT = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        for(Character c : t.toCharArray()) {
            countT.merge(c, 1, Integer::sum);
        }

//        countT.forEach((key, value) -> System.out.println(key + " " + value));

        int have = 0;
        int need = countT.size();

        record Result(int left, int right){}
        
        Result res = new Result(-1,-1);
        int resLen = Integer.MAX_VALUE;
        int l = 0;

        for(int r=0; r<s.length(); r++) {
            Character c = s.charAt(r);
            window.merge(c, 1, Integer::sum);

            if (countT.containsKey(c) && (window.get(c) == countT.get(c)))
                have += 1;

            while (have == need) {
                if ((r - l + 1) < resLen) {
                    res = new Result(l, r);
                    resLen = r - l + 1;
                }
                // int z = window.get(s.charAt(l));
                // window.put(s.charAt(l), --z);
                window.merge(s.charAt(l), 1, (prev, one)->prev-1);
                if (countT.containsKey(s.charAt(l)) && (window.get(s.charAt(l)) < countT.get(s.charAt(l))))
                    have -= 1;

                l++;
            }
        }

        return resLen != Integer.MAX_VALUE ? s.substring(res.left, res.right+1) : "";
    }

    public static void main(String[] args) {
        L76_Minimum_Window_Substring app = new L76_Minimum_Window_Substring();
        System.out.println(app.minWindow("ADOBECODEBANC", "ABC")/*.equals("BANC")*/);
        // System.out.println(app.minWindow("a", "a").equals("a"));
        // System.out.println(app.minWindow("a", "aa").equals(""));
    }
}
