package leetcode.arrays_strings;

/*
Completed: 2/17/2021
1) beats 95.89% performance
2) beats 67.27% for memory usage 
 */

/*
Given a string, find the first non-repeating character in it and return its index. If it doesn't exist, return -1.

Examples:
s = "leetcode"
return 0.

s = "loveleetcode"
return 2.

Note: You may assume the string contains only lowercase English letters.
*/
public class FirstUniqCharInString {

    public int firstUniqChar(String s) {
    	int[] trackingArray = new int[26];
    	for(int i=0;i<trackingArray.length;i++) {
    		trackingArray[i] = -1;
    	}
    	
    	for(int i=0;i<s.length();i++) {
    		int c = s.charAt(i) - 97;
    		
    		if (trackingArray[c] == -1)
    			trackingArray[c] = i;
    		else if (trackingArray[c] > -1)
    			trackingArray[c] = -2;    		
    		else if (trackingArray[c] > -2)
    			continue;
    	}
    	
    	int indexFirstUniq = -1;
    	for(int z : trackingArray) {
    		if ( z > -1 ) {
    			if ( indexFirstUniq == -1 || z < indexFirstUniq ) 
    				indexFirstUniq = z;
    		}
    	}
    	
        return indexFirstUniq;
    }	

    /*
     * Optimal.
     * 
     * 1. iter through alphabet a to z
     * 2. check to see if indexOf == lastIndexOf, if so, unique otherwise not unique
     * 3. int result holds smallest index
     */
    public int firstUniqChar1(String s) {        
        if(s == null || s.length() == 0)
            return -1;
        
        int result = s.length();
        
        for(char c='a'; c <='z'; ++c) {
            int firstIdx = s.indexOf(c);
            if(firstIdx != -1 && firstIdx == s.lastIndexOf(c))
                result = Math.min(result, firstIdx);
        }
        
        return result == s.length()? -1 : result;
    }    
    
	public void run() {
		System.out.println(firstUniqChar1("leetcode"));
	}
	
	public static void main(String[] args) {
		new FirstUniqCharInString().run();
	}

}
