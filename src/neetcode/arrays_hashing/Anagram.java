package neetcode.arrays_hashing;

/*
Given two strings s and t, return true if t is an anagram of s, and false otherwise.

An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

Example 1:
Input: s = "anagram", t = "nagaram"
Output: true

Example 2:
Input: s = "rat", t = "car"
Output: false

Constraints:
1 <= s.length, t.length <= 5 * 104
s and t consist of lowercase English letters.
 */

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Anagram {
    public boolean isAnagram1(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        for(char x : s.toCharArray()) {
            if (!t.contains("" + x))
                return false;
        }

        return true;
    }

    public int checksum(String str) {
        int value = 0;

        for (int x : str.toCharArray()) {
            value += x;
        }
        return value;
    }

    public boolean isAnagram2(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        if (checksum(s) == checksum(t))
            return true;

        return false;
    }

    /*
    time: O(n log n)
    space: O(S + T)
     */
    public boolean isAnagramSort(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();

        Arrays.sort(s1);
        Arrays.sort(t1);

        if ( Arrays.equals(s1, t1) )
            return true;

        return false;
    }

    /*
    Use case is not working
     */
    public boolean isAnagram(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) {
            return false;
        }

        Map<Character, Integer> sMap = new HashMap();
        Map<Character, Integer> tMap = new HashMap();

        for(char x : s.toCharArray()) {
            Integer value = sMap.get(x) == null ? 0 : sMap.get(x);
            sMap.put(Character.valueOf(x), value + 1);
        }

        for(char x : t.toCharArray()) {
            Integer value = tMap.get(x) == null ? 0 : tMap.get(x);
            tMap.put(Character.valueOf(x), value + 1);
        }

        for( Character x : sMap.keySet()) {
            if ( sMap.get(x) != tMap.get(x) )
                return false;
        }

        return true;
    }


    public static void main(String[] args) {
        Anagram a = new Anagram();
        System.out.println(a.isAnagram("one", "two"));
        System.out.println(a.isAnagram("one", "noe"));
    }
}
