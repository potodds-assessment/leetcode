package leetcode.heap_priority_queue;

/////////////////////////////////////////////////////////////
// 295. Find Median from Data Stream
// https://leetcode.com/problems/find-median-from-data-stream/
/////////////////////////////////////////////////////////////

import java.util.*;

public class L295_Find_Median_from_Data_Stream {

    List<Integer> sortedList = new ArrayList<>();

    PriorityQueue<Integer> maxHeap = new PriorityQueue<>((o1, o2) -> o1 > o2 ? -1 : o1 < o2 ? 1 : 0);
    PriorityQueue<Integer> minHeap = new PriorityQueue<>((o1, o2) -> o1 > o2 ? 1 : o1 < o2 ? -1 : 0);

    public void testHeaps() {
        maxHeap.add(4);
        maxHeap.add(2);
        maxHeap.add(1);
        System.out.println(maxHeap.poll());

        minHeap.add(4);
        minHeap.add(2);
        minHeap.add(1);
        System.out.println(minHeap.poll());
    }

    public L295_Find_Median_from_Data_Stream() {
    }

    public void addNum(int num) {
        if (maxHeap.size() > 0 && num > maxHeap.peek())
            minHeap.add(num);
        else
            maxHeap.add(num);

        while (maxHeap.size() - minHeap.size() > 1) {
            minHeap.add(maxHeap.poll());
        }
        while (minHeap.size() - maxHeap.size() > 1) {
            maxHeap.add(minHeap.poll());
        }

//        sortedList.add(num);
//        Collections.sort(sortedList);
    }

    /*
    NeetCode solution.  minHeap used for large numbers. maxHeap for small numbers.  Balance sizes.
    Runtime: 86ms beats 97.06%
    Memory: 66.8mb beats 65.25%
    Time: O(n)
    Space: O(n)

     */
    public double findMedian() {
        if (maxHeap.size() == 0 && minHeap.size() == 0)
            return 0.0;

        if (maxHeap.size() > minHeap.size())
            return maxHeap.peek();
        else if (minHeap.size() > maxHeap.size())
            return minHeap.peek();

        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    /*
    Runtime: Time Limit Exceeded.  Too slow. Sorting is O(n log n) operations.
     */
    public double findMedianInitial() {
        int size = sortedList.size();

        if (size % 2 != 0)
            return sortedList.get((size/2));

        int firstValue = sortedList.get((size/2)-1);
        int secondValue = sortedList.get((size/2));

        double res = (firstValue + secondValue) / 2.0;

        return res;
    }

    public static void main(String[] args) {
        L295_Find_Median_from_Data_Stream app = new L295_Find_Median_from_Data_Stream();
//        app.testHeaps();

        app.addNum(1);
        app.addNum(2);
        System.out.println(app.findMedian());
        app.addNum(3);
        System.out.println(app.findMedian());
    }
}
