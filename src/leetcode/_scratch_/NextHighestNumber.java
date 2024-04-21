package leetcode._scratch_;

import java.util.Arrays;

public class NextHighestNumber {

    public int nextHighestNumber(int value) {
        char[] numArray = Integer.toString(value).toCharArray();
        for(int i=numArray.length-1; i>0; i--) {
            try {
                int currNo = Integer.parseInt(Character.toString(numArray[i]));
                int nextNo = Integer.parseInt(Character.toString(numArray[i-1]));

                if (nextNo < currNo) {
                    char temp = numArray[i-1];
                    numArray[i-1] = numArray[numArray.length-1]; 
                    numArray[numArray.length-1] = temp;
                    Arrays.sort(numArray, i, numArray.length);

                    break;
                }
            } catch(NumberFormatException e) {
                e.printStackTrace();
            }
        }
        return Integer.parseInt(new String(numArray));
    }

    public static void main(String[] args) {
        NextHighestNumber app = new NextHighestNumber();
        System.out.println(app.nextHighestNumber(218765)/* == 2567889*/);
    }    
}
