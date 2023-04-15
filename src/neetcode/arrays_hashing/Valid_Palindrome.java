package neetcode.arrays_hashing;
/*
A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters,
it reads the same forward and backward. Alphanumeric characters include letters and numbers.

Given a string s, return true if it is a palindrome, or false otherwise.

Example 1:
Input: s = "A man, a plan, a canal: Panama"
Output: true
Explanation: "amanaplanacanalpanama" is a palindrome.

Example 2:
Input: s = "race a car"
Output: false
Explanation: "raceacar" is not a palindrome.

Example 3:
Input: s = " "
Output: true
Explanation: s is an empty string "" after removing non-alphanumeric characters.
Since an empty string reads the same forward and backward, it is a palindrome.

Constraints:
1 <= s.length <= 2 * 105
s consists only of printable ASCII characters.
 */
public class Valid_Palindrome {

        public String cleanString(String s) {
            String str = s.toLowerCase().trim();
            if ( str.length() == 0 )
                return str;

            StringBuffer sb = new StringBuffer();
            for( char x : str.toCharArray() ) {
                if(( x >= 'a' && x <= 'z' ) || ( x >= '0' && x <= '9'))
                    sb.append(x);
            }

            System.out.println(sb);

            return sb.toString();
        }

    public boolean isPalindrome(String s) {
        String str = cleanString(s);
        if ( str.length() == 0 )
            return true;

        int midpt = str.length()/2;
        for(int x=0; x<midpt; x++) {
            char a = (char) str.charAt(x);
            char b = (char) str.charAt(str.length()-x-1);

            if ( str.charAt(x) != str.charAt(str.length()-x-1) )
                return false;
        }

        return true;
    }

    public static void main(String[] args) {
        System.out.print(new Valid_Palindrome().isPalindrome("0P"));
    }
}
