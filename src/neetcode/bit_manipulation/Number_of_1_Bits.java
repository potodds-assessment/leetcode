package neetcode.bit_manipulation;

/*
Write a function that takes the binary representation of an unsigned integer and returns the number of '1' bits it has
(also known as the Hamming weight).

Note:

Note that in some languages, such as Java, there is no unsigned integer type. In this case, the input will be given as
a signed integer type. It should not affect your implementation, as the integer's internal binary representation is the
same, whether it is signed or unsigned.
In Java, the compiler represents the signed integers using 2's complement notation. Therefore, in Example 3, the input
represents the signed integer. -3.

Example 1:
Input: n = 00000000000000000000000000001011
Output: 3
Explanation: The input binary string 00000000000000000000000000001011 has a total of three '1' bits.

Example 2:
Input: n = 00000000000000000000000010000000
Output: 1
Explanation: The input binary string 00000000000000000000000010000000 has a total of one '1' bit.

Example 3:
Input: n = 11111111111111111111111111111101
Output: 31
Explanation: The input binary string 11111111111111111111111111111101 has a total of thirty one '1' bits.

Constraints:
The input must be a binary string of length 32.
Follow up: If this function is called many times, how would you optimize it?
 */
public class Number_of_1_Bits {

    /*
    Runtime 1ms beats 42.33%
    Memory 39.5MB beats 87.8%

    Time: O(1)
    Space: O(1)
     */
    public int hammingWeight1(int n) {

        char[] binStr = Integer.toBinaryString(n).toCharArray();

        int count = 0;
        for(char c : binStr) {
            if ( c == '1' )
                count++;
        }

        return count;
    }

    /*
    Runtime 0ms beats 100%
    Memory 40.2MB beats 13.67%

    Time: O(1)
    Space: O(1)
     */

    public int hammingWeight2(int n) {
        int count = 0;

        if ( n > 0 ) {
            while (n != 0) {
                count += n % 2;
                n >>= 1;
            }
        } else {
            while ( n != 0 ) {
                if ( (n & 1) == 1 )
                    count++;
                n >>>= 1;
            }
        }
        return count;
    }

    /*
    By subtracting one, removing a bit.
    1001 (n)
    1000 (n-1)
    Then ANDing the 2 numbers to get the next number with removed bit.
     */
    public int hammingWeight(int n) {
        int count = 0;

        while ( n != 0 ) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    public static void main(String[] args) {


        Number_of_1_Bits app = new Number_of_1_Bits();

        int n = 0b00000000000000000000000000001011;
        System.out.println(n + ", " + Integer.toBinaryString(n));
        System.out.println(app.hammingWeight( n));

        n = 0b00000000000000000000000010000000;
        System.out.println(n + ", " + Integer.toBinaryString(n));
        System.out.println(app.hammingWeight( n));

        n = 0b11111111111111111111111111111101;
        System.out.println(n + ", " + Integer.toBinaryString(n));
        System.out.println(app.hammingWeight( n));

    }
}
