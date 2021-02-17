package leetcode.dynamic_programming;

/*
Completed: 2/17/2021
1) beats 0% performance 1433ms
2) beats 62.75% for memory usage 
 */

/*
Given a string s, return the longest palindromic substring in s.

Example 1:
Input: s = "babad"
Output: "bab"
Note: "aba" is also a valid answer.

Example 2:
Input: s = "cbbd"
Output: "bb"

Example 3:
Input: s = "a"
Output: "a"

Example 4:
Input: s = "ac"
Output: "a"

Constraints:
1 <= s.length <= 1000
s consist of only digits and English letters (lower-case and/or upper-case),
 */

public class LongestPalindromicSubstring {
	
	/*
	 * Algorithm #1
	 * for each character, check left and right characters for largest palindrome
	 * "a" = left character is null, right character is null, so "a" is largest palindrome.
	 * "z13aba79r" = for "z", left and right character don't match, go to next character. same for "1","3", "a".  
	 * for "b", left and right match "a", but next "3", "7" don't match.  largest palindrome is "aba"
	 * Analysis
	 * works well for odd length but not even length palindrome strings
	 * 
	 */
	public String longestPalindrome(String s) {
		if ( s == null || s.isEmpty() ) return "";  
		if ( s.length() == 1 ) return s;			
		
		String largestPalindrome = null;
		for(int i=0; i<s.length(); i++) {
			int leftIndex = i-1;
			int rightIndex = i+1;
			boolean continueCheck = true;
			boolean sameChar = true;
			while (continueCheck) {
				if ((leftIndex < 0 || rightIndex>s.length()-1) || 
					(s.charAt(leftIndex) != s.charAt(rightIndex))) {
					continueCheck = false;
					
					String currentPalindrome = null;
					if ( rightIndex<s.length() && sameChar && s.charAt(rightIndex) == s.charAt(rightIndex-1)) {
						currentPalindrome = s.substring(leftIndex+1, rightIndex+1);
					} else {
						currentPalindrome = s.substring(leftIndex+1, rightIndex);
					}
					
					if ( largestPalindrome == null )
						largestPalindrome =	currentPalindrome;
					else {
						if ( largestPalindrome.length() < currentPalindrome.length() )
							largestPalindrome = currentPalindrome;
					}						
				} else {
					if ( sameChar && rightIndex+1<s.length()-1 ) {
						sameChar = s.charAt(rightIndex) == s.charAt(rightIndex+1);
						rightIndex++;
					} else {
						leftIndex--;
						rightIndex++;
					}
				}
			}
		}
    	return largestPalindrome;
    }

	private boolean isPalindrome(String s) {
		if ( s == null || s.isEmpty() || s.length() == 1) 
			return true;

		int midPoint = s.length() / 2;
		
		for(int i=0; i< midPoint; i++) {
			if (!( s.charAt(i) == s.charAt( s.length()-i-1 ) ))
				return false;
		}
		
		return true;
	}
	
	/*
	 * Algorithm #2
	 * check every possible string value with double for loop
	*/
	public String longestPalindrome2(String s) {
		if ( s == null || s.isEmpty() ) return "";				
		if ( s.length() == 1 ) 	return s;
		
		String answer = null;
		for(int i=0; i<s.length(); i++) {
			for(int j=s.length(); j>i; j--) {
				if ( answer != null && answer.length() > (j-1) )
					continue;

				String str = s.substring(i,j);
				if (isPalindrome(str)) {
					answer = (answer == null ? str : str.length() > answer.length() ? str : answer);
				}
			}
		}
		
		return answer;
	}	
	
	public void run() {
		System.out.println(longestPalindrome2(""));
		System.out.println(longestPalindrome2("a"));
		System.out.println(longestPalindrome2("abc"));
		System.out.println(longestPalindrome2("bb"));
		System.out.println(longestPalindrome2("tattarrattat"));
		System.out.println(longestPalindrome2("abbcccbbbcaaccbababcbcabca"));
	}
	
	public static void main(String[] args) {
		new LongestPalindromicSubstring().run();
	}	
}
