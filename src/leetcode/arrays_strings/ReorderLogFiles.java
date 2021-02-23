package leetcode.arrays_strings;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/*
Completed: 2/22/2021
1) beats 72.71% performance
2) beats 53.27% for memory usage 
 */

/*
You are given an array of logs. Each log is a space-delimited string of words, where the first word is the identifier.
There are two types of logs:
Letter-logs: All words (except the identifier) consist of lowercase English letters.
Digit-logs: All words (except the identifier) consist of digits.
Reorder these logs so that:

The letter-logs come before all digit-logs.
The letter-logs are sorted lexicographically by their contents. If their contents are the same, then sort them lexicographically by their identifiers.
The digit-logs maintain their relative ordering.
Return the final order of the logs.

Example 1:
Input: logs = ["dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"]
Output: ["let1 art can","let3 art zero","let2 own kit dig","dig1 8 1 5 1","dig2 3 6"]
Explanation:
The letter-log contents are all different, so their ordering is "art can", "art zero", "own kit dig".
The digit-logs have a relative order of "dig1 8 1 5 1", "dig2 3 6".

Example 2:
Input: logs = ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]

Constraints:
1 <= logs.length <= 100
3 <= logs[i].length <= 100
All the tokens of logs[i] are separated by a single space.
logs[i] is guaranteed to have an identifier and at least one word after the identifier. 
 */
public class ReorderLogFiles {
	
	private boolean isFirstCharDigit(String str) {
		return ( str.charAt(0) >= '0' ) && ( str.charAt(0) <= '9' );  
	}
	
    public String[] reorderLogFiles(String[] logs) {
    	Collections.sort(Arrays.asList(logs), new Comparator<String>() {
			@Override
			public int compare(String o1, String o2) {
				if ( o1 == o2 || o1.equals(o2) ) return 0;

				String[] o1Arr = o1.split(" ", 2);
				String[] o2Arr = o2.split(" ", 2);
				
				if ( isFirstCharDigit(o1Arr[1]) && isFirstCharDigit(o2Arr[1]) )
					return 0;

				if ( isFirstCharDigit(o1Arr[1]) )
					return 1;
				
				if ( isFirstCharDigit(o2Arr[1]) )
					return -1;
				
				if ( o1Arr[1].compareTo(o2Arr[1]) < 0 )
					return -1;
				else if ( o1Arr[1].compareTo(o2Arr[1]) > 0 )
					return 1;
				else
					return o1Arr[0].compareTo( o2Arr[0] );

			}});
    	return logs;
    }
	
    public void run() {
    	System.out.println(Arrays.toString(reorderLogFiles(new String[]{"dig1 8 1 5 1","let1 art can","dig2 3 6","let2 own kit dig","let3 art zero"})));
    	System.out.println(Arrays.toString(reorderLogFiles(new String[]{"a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"})));
    	System.out.println(Arrays.toString(reorderLogFiles(new String[]{"w 7 2", "l 1 0", "6 066", "o aay", "e yal"})));
    }

    public static void main(String[] args) {
		new ReorderLogFiles().run();
	}

}
