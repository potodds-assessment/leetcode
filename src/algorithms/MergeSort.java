package algorithms;

import java.util.Arrays;

public class MergeSort {
    /*
     * MergeSort uses algorithm that recursively splits array in half until there is only one element in each half.  Then it merges/sort each half.
     */

    public int[] merge(int[] left, int[] right) {
        System.out.println("left:" + Arrays.toString(left) + ",right:" + Arrays.toString(right));
        int[] retArr = new int[left.length + right.length];

        int l=0;
        int r=0;
        int index=0;
        while(l<left.length && r<right.length) {
            if (left[l] > right[r]) {
                retArr[index++] = right[r++];
            } else {
                retArr[index++] = left[l++];
            }
        }
        if (l==left.length) {
            while(r<right.length) {
                retArr[index++] = right[r++];
            }
        } else if (r==right.length) {
            while(l<left.length) {
                retArr[index++] = left[l++];
            }
        }
        return retArr;
    }

    public int[] split(int[] arr, int start, int end) {
        if (start == end) {
            return new int[] {arr[start]};
        }
        int mid=(start+end)/2;

        int[] left = split(arr, start, mid);
        int[] right = split(arr, mid+1, end);
        return merge(left, right);
    }

    public int[] mergeSort(int[] arr) {
        return split(arr, 0, arr.length-1);
    }

    public static void main(String[] args) {
        MergeSort app = new MergeSort();
        int[] data = {20, 10, 30, 100, 17, 3, 85};
        int[] result = app.mergeSort(data);
        System.out.println(Arrays.toString(result));
    }
}
