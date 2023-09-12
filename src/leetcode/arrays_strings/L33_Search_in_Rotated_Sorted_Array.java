package leetcode.arrays_strings;

/////////////////////////////////////////////////////////////
// 33. Search in Rotated Sorted Array
// https://leetcode.com/problems/search-in-rotated-sorted-array/
/////////////////////////////////////////////////////////////

public class L33_Search_in_Rotated_Sorted_Array {

//    public int binary_search(int[] nums, int target) {
//        int left = 0;
//        int right = nums.length - 1;
//        int mid = (left + right) / 2;
//
//        while (left < right) {
//            if (nums[mid] == target)
//                return mid;
//            else if (nums[mid-1] < target) {
//                left = mid+1;
//            } else
//                right = mid-1;
//
//            mid = (left + right) / 2;
//        }
//
//        if (nums[left] == target)
//            return left;
//
//        return -1;
//    }

    /*
    Runtime: -ms beats 100%
    Memory: 41.3mb beats 31.23%
    Time: O(log n)
    Space: O(1)
     */
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;

        while (left <= right) {
            int mid = (left+right)/2;
            if (target == nums[mid])
                return mid;

            //left side
            if (nums[left] <= nums[mid]) {
                if (target > nums[mid] || target < nums[left])
                    left = mid+1;
                else
                    right = mid-1;
            }
            // right side
            else {
                if (target < nums[mid] || target > nums[right])
                    right = mid-1;
                else
                    left = mid+1;
            }
        }

        return -1;
    }


//    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0)
//            return -1;
//        if (nums.length < 2) {
//            if (nums[0] == target) return 0;
//            if (nums[1] == target) return 1;
//            return -1;
//        }
//
//
//        int left = 0;
//        int right = nums.length - 1;
//        int mid = (left + right) / 2;
//
//        while (left < right) {
//            if (nums[mid] == target)
//                return mid;
//            else if ((nums[mid] < nums[mid-1]) && (nums[mid] < nums[right]) ||
//                    (nums[mid] > nums[mid-1]) && (nums[mid] > nums[right])) {
//                left = mid + 1;
//            } else if (nums[mid] < target) {
//                left = mid+1;
//            } else
//                right = mid-1;
//
//            mid = (left + right) / 2;
//        }
//
//        if (nums[left] == target)
//            return left;
//
//        return -1;
//    }


    //    public int search(int[] nums, int target) {
//        if (nums == null || nums.length == 0)
//            return -1;
//
//        boolean done = false;
//        int left_start = 0;
//        int right_end = nums.length-1;
//        int mid = (left_start + right_end) / 2;
//        int left_end = mid-1;
//        int right_start = mid+1;
//
//        while (!done) {
//            if (nums[mid] == target)
//                return mid;
//            else if (target <= nums[left_end] && target > nums[right_end]) {
//                right_end = left_end;
//                mid = (left_start + right_end) / 2;
//                left_end = mid - 1;
//                right_start = mid + 1;
//            } else if (target <= nums[right_end] && target > nums[left_end]) {
//                left_start = right_start;
//                mid = (left_start + right_end) / 2;
//                left_end = mid - 1;
//                right_start = mid + 1;
//            } else {
//            }
//        }
//
//        return -1;
//    }

    public static void main(String[] args) {
        L33_Search_in_Rotated_Sorted_Array app = new L33_Search_in_Rotated_Sorted_Array();
        System.out.println(app.search(new int[]{1,3}, 0) == -1);
        System.out.println(app.search(new int[]{4,5,6,7,0,1,2}, 0) == 4);
        System.out.println(app.search(new int[]{4,5,6,7,0,1,2}, 3) == -1);
        System.out.println(app.search(new int[]{1}, 0) == -1);
        System.out.println(app.search(new int[]{0,1,2,4,5,6,7}, 0) == 0);
        System.out.println(app.search(new int[]{0,1,2,4,5,6,7}, 1) == 1);
        System.out.println(app.search(new int[]{0,1,2,4,5,6,7}, 2) == 2);
        System.out.println(app.search(new int[]{0,1,2,4,5,6,7}, 3) == -1);
        System.out.println(app.search(new int[]{0,1,2,4,5,6,7}, 4) == 3);
        System.out.println(app.search(new int[]{0,1,2,4,5,6,7}, 5) == 4);
    }
}
