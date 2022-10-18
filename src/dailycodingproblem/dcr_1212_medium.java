package dailycodingproblem;

/*
This problem was asked by Amazon.

Implement a bit array.

A bit array is a space efficient array that holds a value of 1 or 0 at each index.

init(size): initialize the array with size
set(i, val): updates index at i with val where val is either 1 or 0.
get(i): gets the value at index i.
 */


public class dcr_1212_medium {
    private static final int DEFAULT_SIZE = 100;
    private int current_size = DEFAULT_SIZE;
    private int[] intArray = new int[DEFAULT_SIZE];

    public void init(int size) {
        current_size = size;
        intArray = new int[current_size];
    }
    public void set(int i, int val) {
        if (!((val == 0) || (val == 1))) {
            System.out.println("Value must be 1 or 0. Invalid input value: " + val);
            return;
        }
        if (i > (current_size-1)) {
            System.out.println("Cannot set value at index " + i + ".  Max array length is " + current_size);
            return;
        }
        intArray[i] = val;
        System.out.println("Successfully set index " + i + " with value " + val);
    }
    public int get(int i) {
        if (i > current_size-1) {
            System.out.println("Max array length is " + current_size + ".  Cannot get value at index " + i);
            return -1;
        }
        return intArray[i];
    }

    public static void main(String[] arr) {
        System.out.println("HW");
        dcr_1212_medium ba = new dcr_1212_medium();
        ba.init(20);
        ba.set(50, 4);
        ba.set(19, 0);
        System.out.println(ba.get(50));
        System.out.println(ba.get(19));
    }
}
