package leetcode.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], 
return the minimum number of conference rooms required.

Example 1:
Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2

Example 2:
Input: intervals = [[7,10],[2,4]]
Output: 1

Constraints:
1 <= intervals.length <= 104
0 <= starti < endi <= 106
*/

public class L253_Meeting_Rooms_II {

    /*
    Runtime: 10ms, beats 19.11%
    Memory: 43.87MB, beats 97.17%

    time: O(n log n)
    space: O(n)
    */
    public int minMeetingRooms(int[][] intervals) {
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        
        for(int[] meeting : intervals) {
            start.add(meeting[0]);
            end.add(meeting[1]);
        }

        Collections.sort(start);
        Collections.sort(end);

        int result = 0;
        int count = 0;
        int s = 0;
        int e = 0;

        while (s < intervals.length) {
            if (start.get(s) < end.get(e)) {
                s++;
                count++;
            } else {
                e++;
                count--;
            }
            result = Math.max(result, count);
        }

        return result;
    }

    public static void main(String[] args) {
        L253_Meeting_Rooms_II app = new L253_Meeting_Rooms_II();
        System.out.println(app.minMeetingRooms(new int[][]{{0,30},{5,10},{15,20}}));
        System.out.println(app.minMeetingRooms(new int[][]{{7,10},{2,4}}));
    }
}