package leetcode.arrays_strings;
/*
Implement the myAtoi(string s) function, which converts a string to a 32-bit signed integer (similar to C/C++'s atoi function).

The algorithm for myAtoi(string s) is as follows:

Read in and ignore any leading whitespace.
Check if the next character (if not already at the end of the string) is '-' or '+'. Read this character in if it is either. This determines if the final result is negative or positive respectively. Assume the result is positive if neither is present.
Read in next the characters until the next non-digit charcter or the end of the input is reached. The rest of the string is ignored.
Convert these digits into an integer (i.e. "123" -> 123, "0032" -> 32). If no digits were read, then the integer is 0. Change the sign as necessary (from step 2).
If the integer is out of the 32-bit signed integer range [-231, 231 - 1], then clamp the integer so that it remains in the range. Specifically, integers less than -231 should be clamped to -231, and integers greater than 231 - 1 should be clamped to 231 - 1.
Return the integer as the final result.
Note:

Only the space character ' ' is considered a whitespace character.
Do not ignore any characters other than the leading whitespace or the rest of the string after the digits.

Input: s = "42"
Output: 42

Input: s = "   -42"
Output: -42

Input: s = "4193 with words"
Output: 4193

Input: s = "words and 987"
Output: 0

Input: s = "-91283472332"
Output: -2147483648

1. performance > 24.57%
2. memory < 55.85%

 */
public class Atoi {
	
	public static boolean isSpecial(char currentChar) {
		if (( currentChar == '-' || currentChar == '+' ))
			return true;
		return false;
	}
	
	public static boolean isValid(char currentChar) {
		if (( currentChar >= '0' && currentChar <= '9' ))
			return true;
		return false;
	}
	
	public static int atoi(String intValue) {
		if ( intValue == null ) return 0;
		
		StringBuilder str = new StringBuilder();
		intValue = intValue.stripLeading();
		boolean validNumber = false;
		try {
			for(int i=0; i<intValue.length(); i++) {
				char currentChar = intValue.charAt(i);
				
				if (i==0 && isSpecial(currentChar)) {
					str.append(currentChar);
					continue;
				}
				
				if ( isValid(currentChar) ) {
					str.append(currentChar);
					validNumber = true;
				} else {
					if ( !validNumber )
						return 0;
					else
						break;
				}
			}		
			
			return Integer.parseInt(str.toString());
		} catch(NumberFormatException e) {
            if ( validNumber )
    			if ( str.toString().contains("-") )
    				return Integer.MIN_VALUE;
    			else
    				return Integer.MAX_VALUE;
            else
                return 0;
		}
	}

	public static void main(String[] args) {
//		System.out.println( atoi("-91283472332") );
//		System.out.println( atoi("91283472332") );
//		System.out.println( atoi("-912834") );
//		System.out.println( atoi("9128347") );
//		System.out.println( atoi("    -9128 347") );
		System.out.println( atoi(".1") );
	}
	
}
