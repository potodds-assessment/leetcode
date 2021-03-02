package leetcode.sort_search;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/*
Completed: 3/2/2021
1) beats 28.74% performance (kClosest2)
2) beats 26.04% for memory usage  (kClosest2)
 */

/*
We have a list of points on the plane.  Find the K closest points to the origin (0, 0).
(Here, the distance between two points on a plane is the Euclidean distance.)
You may return the answer in any order.  The answer is guaranteed to be unique (except for the order that it is in.)

Example 1:
Input: points = [[1,3],[-2,2]], K = 1
Output: [[-2,2]]
Explanation: 
The distance between (1, 3) and the origin is sqrt(10).
The distance between (-2, 2) and the origin is sqrt(8).
Since sqrt(8) < sqrt(10), (-2, 2) is closer to the origin.
We only want the closest K = 1 points from the origin, so the answer is just [[-2,2]].

Example 2:
Input: points = [[3,3],[5,-1],[-2,4]], K = 2
Output: [[3,3],[-2,4]]
(The answer [[-2,4],[3,3]] would also be accepted.)

Note:
1 <= K <= points.length <= 10000
-10000 < points[i][0] < 10000
-10000 < points[i][1] < 10000 
 */
public class KClosestPointsToOrigin {

	Queue<int[]> pQueue = new PriorityQueue<>(100, new Comparator<int[]>() {
		@Override
		public int compare(int[] o1, int[] o2) {
			if ( o1.length < 2 || o2.length < 2 )
				return 0;
				
			double eDistanceO1 = Math.sqrt( Math.pow(o1[0]-0, 2) + Math.pow(o1[1]-0, 2) );
			double eDistanceO2 = Math.sqrt( Math.pow(o2[0]-0, 2) + Math.pow(o2[1]-0, 2) );
			
			if ( eDistanceO1 < eDistanceO2 )
				return -1;
			else if ( eDistanceO1 > eDistanceO2 )
				return 1;
			else 
				return 0;
		}});
	
    public int[][] kClosest2(int[][] points, int K) {
    	int[][] answer = new int[K][];
    	
    	for(int[] point : points) {
    		pQueue.add(point);
    	}
    	
    	for(int i=0;i<K;i++) {
    		answer[i] = pQueue.poll();
    	}
    	
    	return answer;
    }

    /********************/
    /* fastest solution */
    public int[][] kClosest(int[][] points, int K){
        int len = points.length, l=0, r= len-1;
        while(l<=r){
            int mid = helper(points,l,r);
            if(mid==K) break;
            if(mid<K){
                l = mid+1;
            } else {
                r = mid-1;
            }
        }
        return Arrays.copyOfRange(points,0,K);
    }
    private int helper(int[][] A, int l, int r){
        int[] pivot = A[l];
        while(l<r){
            while(l<r&&compare(A[r],pivot)>=0) r--;
            A[l] = A[r];
            while(l<r&&compare(A[l],pivot)<=0) l++;
            A[r] = A[l];
        }
        A[l] = pivot;
        return l;
    }
    
    private int compare(int[] p1,int[] p2){
        return p1[0]*p1[0]+p1[1]*p1[1]-p2[0]*p2[0]-p2[1]*p2[1];
    } 
    /* fastest solution */
    /********************/
    
    public void print(int[][] answer) {
    	for(int[] row: answer) {
    		System.out.print(Arrays.toString(row) + " ");
    	}
    	System.out.println();
    }

    public void run() {
    	print(kClosest(new int[][] {{3,3},{5,-1},{-2,4}}, 2));
    	print(kClosest(new int[][] {{1,3},{-2,2}}, 1));
    	print(kClosest(new int[][] {{6,10},{-3,3},{-2,5},{0,2}}, 3));
    }

	public static void main(String[] args) {
		new KClosestPointsToOrigin().run();
	}

}
