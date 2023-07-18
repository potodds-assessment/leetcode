package leetcode.graphs;

/////////////////////////////////////////////////////////////
// 207. Course Schedule
// https://leetcode.com/problems/course-schedule/
/////////////////////////////////////////////////////////////

import java.util.*;

public class L207_Course_Schedule {
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Set<Integer>> map = new HashMap<>();

//    public boolean dfs(Integer key, Set<Integer> values) {
//
//        if (values == null) {
//            visited.add(key);
//            return true;
//        }
//
//        ig
//
//        Iterator<Integer> iter = values.iterator();
//        while (iter.hasNext()) {
//            Integer k = iter.next();
//            if (!dfs(k, map.get(k)))
//                return false;
//            iter.remove();
//        }
//
//        for(Integer value : values) {
//            if (!dfs(value, map.get(value)))
//                return false;
//        }
//
//        return true;
//    }
//
//    public boolean canFinish(int numCourses, int[][] prerequisites) {
//        if (numCourses == 0)
//            return false;
//
//        if (prerequisites == null || prerequisites.length == 0)
//            return true;
//
//        for(int[] row : prerequisites) {
//            map.computeIfAbsent(row[0], HashSet::new);
//            map.get(row[0]).add(row[1]);
//        }
//
//        System.out.println(map.toString());
//
//        for(Integer key : map.keySet()) {
//            if (!dfs(key, map.get(key)))
//                return false;
//        }
//
//        return true;
//    }

    public boolean dfs(Integer crs) {
        if (visited.contains(crs)) return false;
        if (map.get(crs) == null || map.get(crs).isEmpty()) return true;

        visited.add(crs);
        for(Integer pre : map.get(crs)) {
            if (!dfs(pre)) return false;
        }
        visited.remove(crs);
        map.put(crs, null);

        return true;
    }

    /*
    Runtime: 24 ms beats 7.54%
    Memory: 62.16 mb beats 5.81%
     */
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int[] row : prerequisites) {
            map.computeIfAbsent(row[0], HashSet::new);
            map.get(row[0]).add(row[1]);
        }

        for(int crs=1; crs<=numCourses; crs++) {
            if (!dfs(crs)) return false;
        }

        return true;
    }

    public static void main(String[] args) {
        L207_Course_Schedule app = new L207_Course_Schedule();
        System.out.println(app.canFinish(2, new int[][] {{1,0}}));
        app = new L207_Course_Schedule();
        System.out.println(app.canFinish(2, new int[][] {{1,5}, {1,0}, {0, 1}}));
        app = new L207_Course_Schedule();
        System.out.println(app.canFinish(5, new int[][] {{1,4}, {2,4}, {3, 1}, {3,2}}));
    }
}
