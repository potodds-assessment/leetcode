package leetcode.dynamic_programming;

/////////////////////////////////////////////////////////////
// 5. Longest Palindromic Substring
// https://leetcode.com/problems/longest-palindromic-substring/
//
// Neetcode uses solution to expand outwards from center character, comparing characters.
/////////////////////////////////////////////////////////////

public class L5_Longest_Palindromic_Substring {

    public boolean isValidPalindrone(String s) {
        if (s == null) return false;
        if (s.length() == 1) return true;

        for(int i=0, j=s.length()-1; i<s.length()/2; i++, j--) {
            if (!(s.charAt(i) == s.charAt(j)))
                return false;
        }
        return true;
    }

    /*
    1st attempt
    Runtime: Time Limit Exceeded
    Time: O(n^2) brute force too slow

    2nd attempt - bypass str len less than max str len
    Runtime: 613ms beats 6.68% still too slow.
    Memory: 43.93mb beats 47.39%
     */
    public String longestPalindromeInitial(String s) {
        if (s == null) return null;
        if (s.length() == 1) return s;

        int maxStrLen = 0;
        String maxStr = null;

        for(int i=0; i<s.length()-1; i++) {
            for(int j=i+1; j<=s.length(); j++) {
                if ((j-i) < maxStrLen)
                    continue;

                String currStr = s.substring(i, j);
                if (isValidPalindrone(currStr)) {
                    if (currStr.length() > maxStrLen) {
                        maxStrLen = currStr.length();
                        maxStr = currStr;
                    }
                }
            }
        }
        return maxStr;
    }

    /*
    NeetCode solution. Expand outwards from center character.

    Runtime: 21ms beats 85.60%
    Memory: 44.26mb beats 37.89%
    Time: O(n^2)
    Space: O(n)
     */
    public String longestPalindrome(String s) {
        String res = "";
        int resLen = 0;

        for(int i=0; i<s.length(); i++) {
            int left = i, right = i;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resLen) {
                    res = s.substring(left, right+1);
                    resLen = right-left+1;
                }
                left--;
                right++;
            }

            left = i;
            right = i+1;
            while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                if ((right - left + 1) > resLen) {
                    res = s.substring(left, right+1);
                    resLen = right-left+1;
                }
                left--;
                right++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        L5_Longest_Palindromic_Substring app = new L5_Longest_Palindromic_Substring();

//        System.out.println(app.isValidPalindrone("abba"));
//        System.out.println(app.isValidPalindrone("zzza"));
//        System.out.println(app.isValidPalindrone("b"));
//        System.out.println(app.isValidPalindrone("babad"));

        System.out.println(app.longestPalindrome("aacabdkacaa").equals("aca"));
//        System.out.println(app.longestPalindrome("babad").equals("bab"));
//        System.out.println(app.longestPalindrome("a").equals("a"));
    }
}
