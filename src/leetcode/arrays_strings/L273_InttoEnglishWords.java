package leetcode.arrays_strings;

import java.util.HashMap;
import java.util.Map;

/////////////////////////////////////////////////////////////
// 273. Integer to English Words
// https://leetcode.com/problems/integer-to-english-words/
/////////////////////////////////////////////////////////////

/*
Completed: 2/19/2021
1) beats 31.01% performance
2) beats 35.34% for memory usage 
 */

/*
Convert a non-negative integer num to its English words representation.

Example 1:
Input: num = 123
Output: "One Hundred Twenty Three"

Example 2:
Input: num = 12,345
Output: "Twelve Thousand Three Hundred Forty Five"

Example 3:
Input: num = 1,234,567
Output: "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"

Example 4:
Input: num = 1234,567,891
Output: "One Billion Two Hundred Thirty Four Million Five Hundred Sixty Seven Thousand Eight Hundred Ninety One"

Constraints:
0 <= num <= 231 - 1
 
 */
public class L273_InttoEnglishWords {

	Map<Integer, String> numbersDict = new HashMap<>();

	public String convertNum( int numLessThousand, String marker ) {
		StringBuffer answer = new StringBuffer();
		
		boolean appendSpace = false;
		
		int hundreds = numLessThousand / 100;
		if ( hundreds > 0 ) {
			answer.append( numbersDict.get(hundreds) + " " + numbersDict.get(100));
			appendSpace = true;
		}
			
		int tens = numLessThousand % 100;
		if ( tens >=  21 ) {
			answer.append( (appendSpace ? " " : "") + numbersDict.get((tens / 10) * 10) + (( tens % 10 > 0) ? " " + numbersDict.get(tens % 10) : ""));
		} else
			if ( tens > 0 )
				answer.append( (appendSpace ? " " : "") + numbersDict.get(tens));
		
		if (!marker.equals("") && answer.length() > 0)
			answer.append(" " + marker);
		
		return answer.toString();
	}
	
	public String numberToWords(int num) {
		if ( num == 0 ) return "Zero";		
		String answer = "";

		int currentNum = num;
		int counter = 1;
		do {
			int currentRemainder = currentNum % 1000;
			currentNum /= 1000;
			String value = convertNum(currentRemainder, counter>1 ? numbersDict.get(counter) : "" );
			if ( value.length() > 0 ) {
				if ( answer.length() > 0 )
					answer = value + " " + answer;
				else 
					answer = value;
			}
			counter *= 1000;
		} while (currentNum != 0);
		
    	return answer.toString();
    }	
	
    public void run() {
    	setupMap();
    	System.out.println(numberToWords(123));
    }

    public static void main(String[] args) {
		new L273_InttoEnglishWords().run();
//		System.out.println(Integer.MAX_VALUE);
	}

	private void setupMap() {
		numbersDict.put(1, "One");
		numbersDict.put(2, "Two");
		numbersDict.put(3, "Three");
		numbersDict.put(4, "Four");
		numbersDict.put(5, "Five");
		numbersDict.put(6, "Six");
		numbersDict.put(7, "Seven");
		numbersDict.put(8, "Eight");
		numbersDict.put(9, "Nine");
		numbersDict.put(10, "Ten");
		numbersDict.put(11, "Eleven");
		numbersDict.put(12, "Twelve");
		numbersDict.put(13, "Thirteen");
		numbersDict.put(14, "Fourteen");
		numbersDict.put(15, "Fifteen");
		numbersDict.put(16, "Sixteen");
		numbersDict.put(17, "Seventeen");
		numbersDict.put(18, "Eighteen");
		numbersDict.put(19, "Nineteen");
		numbersDict.put(20, "Twenty");
		numbersDict.put(30, "Thirty");
		numbersDict.put(40, "Forty");
		numbersDict.put(50, "Fifty");
		numbersDict.put(60, "Sixty");
		numbersDict.put(70, "Seventy");
		numbersDict.put(80, "Eighty");
		numbersDict.put(90, "Ninety");
		numbersDict.put(100, "Hundred");
		numbersDict.put(1000, "Thousand");
		numbersDict.put(1000000, "Million");
		numbersDict.put(1000000000, "Billion");
	}
}
