package _scratch;

import java.util.HashSet;
import java.util.Set;

public class Palindrome {

    public boolean isPalindrome(String str) {
        int mid=str.length()/2;
        for(int i=0, j=str.length()-1; i<mid; ++i, --j) {
            if (str.charAt(i) != str.charAt(j)) 
                return false;
        }
        return true;
    }

    Set<String> setStr = new HashSet<>();

    public void palin(String str) {
        for(int i=0; i<str.length(); ++i) {
            for(int j=i+1; j<str.length(); ++j) {
                String s = str.substring(i, j);
                if (isPalindrome(s)) 
                    setStr.add(s);
            }
        }
        System.out.println(setStr);
    }

    public static void main(String[] args) {
        new Palindrome().palin("aabac");
    }
}
