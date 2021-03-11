package dailycodingproblem;

import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;

/*
Completed: 2/16/2021
 */

/*
This problem was asked by Twitter.
Given a list of numbers, create an algorithm that arranges them in order to form the largest possible integer. 
For example, given [10, 7, 76, 415], you should return 77641510.

https://www.geeksforgeeks.org/given-an-array-of-numbers-arrange-the-numbers-to-form-the-biggest-number/
Better algorithm
 */

public class dcr_764_medium {

	Set<String> sortedSet = new TreeSet<>( new Comparator<String>() {
		@Override
		public int compare(String o1, String o2) {
			char[] o1Array = o1.toCharArray();
			char[] o2Array = o2.toCharArray();
			
			if ( o1Array[0] > o2Array[0] )
				return -1;
			else if ( o1Array[0] < o2Array[0] )
				return 1;
			else {
				int o1Precedence = Integer.parseInt( o1 + o2 );
				int o2Precedence = Integer.parseInt( o2 + o1 );					
				
				if ( o1Precedence > o2Precedence )
					return -1;
				else if ( o1Precedence < o2Precedence )
					return 1;			
				else 
					return 0;
			}
		}} );
	
	public void run() {
//		String[] arrayNumbers = new String[] {"10", "7", "76", "415" };
		String[] arrayNumbers = new String[] {"54", "546", "548", "60" };
		for(String s : arrayNumbers) {
			sortedSet.add(s);
		}
		System.out.println(sortedSet);
	}
	
	public static void main(String[] args) {
		new dcr_764_medium().run();
	}
}
