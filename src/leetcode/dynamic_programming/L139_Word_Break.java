package leetcode.dynamic_programming;

/////////////////////////////////////////////////////////////
// 139. Word Break
// https://leetcode.com/problems/word-break/
/////////////////////////////////////////////////////////////
// First attempt:
// from left to right, create new word adding one character at a time. word sequence needs to exist using String.startsWith, other fail
// if word sequence is found, then start new word sequence
// if new word sequence fails, go back to last found word and start adding new characters
/////////////////////////////////////////////////////////////
// 2nd attempt:
// Used NeetCode DP solution
/////////////////////////////////////////////////////////////

import java.util.List;

public class L139_Word_Break {

    /*
    Runtime: 5ms beats 70.1%
    Memory: 41.42mb beats 80.37%
    Time: O(n * n)
    Space: O(s length)
     */
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[s.length()] = true;

        for(int i=s.length()-1; i>=0; i--) {
            for(String w : wordDict) {
                if (((i + w.length()) <= s.length()) && (s.substring(i, i+w.length())).equals(w)) {
                    dp[i] = dp[i + w.length()];
                }

                if (dp[i])
                    break;
            }
        }
        return dp[0];
    }


    public static void main(String[] args) {
        L139_Word_Break app = new L139_Word_Break();
        System.out.println(app.wordBreak("leetcode", List.of("leet", "code")));
//        System.out.println(app.wordBreak("applepenapple", List.of("apple", "pen")));
//        System.out.println(app.wordBreak("catsandog", List.of("cats", "dog", "sand", "and", "cat")));
    }
}
