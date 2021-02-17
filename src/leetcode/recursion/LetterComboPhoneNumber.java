package leetcode.recursion;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
Completed: 2/16/2021
1) beats 30.91% performance
2) beats 59.77& for memory usage 
 */

/*
Given a string containing digits from 2-9 inclusive, return all possible letter combinations that the number could represent. 
Return the answer in any order.
A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.

Example 1:
Input: digits = "23"
Output: ["ad","ae","af","bd","be","bf","cd","ce","cf"]

Example 2:
Input: digits = ""
Output: []

Example 3:
Input: digits = "2"
Output: ["a","b","c"]

Example 4:
Input: digits = "234"
Output: ["adg", "adh", "adi"]

Constraints:
0 <= digits.length <= 4
digits[i] is a digit in the range ['2', '9'].
*/

public class LetterComboPhoneNumber {	
	Map<Character, String> numberMap = new HashMap<>();

	public List<String> combine(List<String> priorValues, String values) {
    	List<String> result = new ArrayList<>();
		for(int i=0; i<values.length(); i++) {
    		char c = values.charAt(i);
    		
    		for(String value : priorValues) {
    			result.add( value + c );
    		}
		}
		return result;
	}
	
	public List<String> letterCombinations(String digits) {
    	List<String> result = new ArrayList<>();
    	result.add("");

    	for(int i=0; i<digits.length(); i++) {
    		char c = digits.charAt(i);    		
    		result = combine(result, numberMap.get(c));
    	}
    	
    	return result;
    }

    public void run() {
    	numberMap.put('2', "abc");
    	numberMap.put('3', "def");
    	numberMap.put('4', "ghi");
    	numberMap.put('5', "jkl");
    	numberMap.put('6', "mno");
    	numberMap.put('7', "pqrs");
    	numberMap.put('8', "tuv");
    	numberMap.put('9', "wxyz");

    	System.out.println(letterCombinations("23"));
    	System.out.println(letterCombinations(""));
    	System.out.println(letterCombinations("2"));
    }
	
	public static void main(String[] args) {
		new LetterComboPhoneNumber().run();
	}
}

