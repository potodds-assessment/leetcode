package leetcode.sorting;

/////////////////////////////////////////////////////////////
// 56. Merge Intervals
// https://leetcode.com/problems/merge-intervals/
/////////////////////////////////////////////////////////////
// First attempt:
// merge 2 rows at a time until end of array. Add new merged list or non merged lists to merged list output
// Keep doing until no merging happens.
/////////////////////////////////////////////////////////////

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class L56_Merge_Intervals {

    /*
    First attempt: does not handle [[2,3],[4,5],[6,7],[8,9],[1,10]]
    Second attempt: sort first. does not handle [[5,5],[1,3],[3,5],[4,6],[1,1],[3,3],[5,6],[3,3],[2,4],[0,0]] Expected: [[0,0],[1,6]] Output: [[0,0],[1,1],[1,6]]
     */
    public int[][] mergeOld(int[][] intervals) {

        List<int[]> origList = Arrays.asList(intervals);
        Arrays.sort(intervals, (a,b) -> a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : 0  );
        boolean done = false;

        while(!done) {
            List<int[]> tempList = new ArrayList<>();
            done = true;
            for (int i = 0; i < origList.size(); i++, i++) {
                int[] list1 = origList.get(i);

                if (i+1 >= origList.size()) {
                    tempList.add(list1);
                    continue;
                }

                int[] list2 = origList.get(i + 1);

                if ((list1[1] < list2[0]) || (list1[0] > list2[1])) { // no overlap ie lowest value in array is higher than highest value in the other arrray
                    tempList.add(list1);
                    tempList.add(list2);
                } else { // overlap
                    done = false;
                    int lowest = list1[0] <= list2[0] ? list1[0] : list2[0];
                    int highest = list1[1] >= list2[1] ? list1[1] : list2[1];
                    tempList.add(new int[]{lowest, highest});
                }
            }
            origList = tempList;
        }

        int[][] ans = new int[origList.size()][];
        for(int i=0; i<origList.size(); i++) {
            ans[i] = origList.get(i);
        }

        return ans;
    }

    /*
    NeetCode solution
    Runtime: 9ms beats 82.10%
    Memory: 45.68mb beats 52.11%
    Time: O(n)
    Space: O(n)
     */
    public int[][] merge(int[][] intervals) {

        Arrays.sort(intervals, (a,b) -> a[0] < b[0] ? -1 : a[0] > b[0] ? 1 : a[1] < b[1] ? -1 : a[1] > b[1] ? 1 : 0  );
        List<int[]> output = new ArrayList<>();
        output.add(intervals[0]);

        for(int i=1; i<intervals.length; i++) {
            int[] value = intervals[i];
            int[] prev = output.get(output.size()-1);

            if (value[0] <= prev[1])
                prev[1] = Math.max(prev[1], value[1]);
            else
                output.add(new int[]{value[0], value[1]});
        }

        int[][] ans = new int[output.size()][];
        for(int i=0; i<output.size(); i++) {
            ans[i] = output.get(i);
        }

        return ans;
    }

    public static void main(String[] args) {
        L56_Merge_Intervals app = new L56_Merge_Intervals();
        System.out.println(Arrays.deepToString(app.mergeOld(new int[][] {{1,3},{2,6},{8,10},{15,18}})));
        System.out.println(Arrays.deepToString(app.mergeOld(new int[][] {{1,4},{4,5}})));
        System.out.println(Arrays.deepToString(app.mergeOld(new int[][] {{2,3},{4,5},{6,7},{8,9},{1,10}})));
    }
}
