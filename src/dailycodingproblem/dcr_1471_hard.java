package dailycodingproblem;

import java.util.ArrayList;
import java.util.List;

/*
This problem was asked by Netflix.

Given a sorted list of integers of length N, determine if an element x is in the list without performing any
multiplication, division, or bit-shift operations.

Do this in O(log N) time.
 */
public class dcr_1471_hard {

    /*
    We can find the index of x if it exists by constructing the index bit-by-bit:

    def find_idx_sorted(arr, x):
    powers_of_two = [1]
    while powers_of_two[-1] < len(arr):
        powers_of_two.append(powers_of_two[-1] + powers_of_two[-1])

    idx = 0
    for pot in reversed(powers_of_two):
        if idx + pot < len(arr) and x >= arr[idx + pot]:
           idx += pot

    return idx

    def contains_sorted(arr, x):
    return arr[find_idx_sorted(arr, x)] == x
     */


    /*
    Do it in O(logN) time, binary search must be used. So, the key point here is to find a way to do division by 2
    without multiplication, division, and bit-shift. Here is a function to do in constant time:
     */
    int divideTwo(int x) {
        int[] bit = new int[] {
                0x1, 0x2, 0x4, 0x8,
                0x10, 0x20, 0x40, 0x80,
                0x100, 0x200, 0x400, 0x800,
                0x1000, 0x2000, 0x4000, 0x8000,
                0x10000, 0x20000, 0x40000, 0x80000,
                0x100000, 0x200000, 0x400000, 0x800000,
                0x1000000, 0x2000000, 0x4000000, 0x8000000,
                0x10000000, 0x20000000, 0x40000000, 0
        };

        int v = 0;
        for (int i = 1; i < bit.length - 1 && x > 0; ++i) {
            if ((x & bit[i]) > 0)
            {
                v += bit[i - 1];
                x -= bit[i];
            }
        }
        return v;
    }

    public static void main(String[] args) {

    }
}
