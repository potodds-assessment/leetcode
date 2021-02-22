package leetcode.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
There are 8 prison cells in a row, and each cell is either occupied or vacant.
Each day, whether the cell is occupied or vacant changes according to the following rules:
If a cell has two adjacent neighbors that are both occupied or both vacant, then the cell becomes occupied.
Otherwise, it becomes vacant.
(Note that because the prison is a row, the first and the last cells in the row can't have two adjacent neighbors.)
We describe the current state of the prison in the following way: cells[i] == 1 if the i-th cell is occupied, else cells[i] == 0.
Given the initial state of the prison, return the state of the prison after N days (and N such changes described above.)

Example 1:
Input: cells = [0,1,0,1,1,0,0,1], N = 7
Output: [0,0,1,1,0,0,0,0]
Explanation: 
The following table summarizes the state of the prison on each day:
Day 0: [0, 1, 0, 1, 1, 0, 0, 1]
Day 1: [0, 1, 1, 0, 0, 0, 0, 0]
Day 2: [0, 0, 0, 0, 1, 1, 1, 0]
Day 3: [0, 1, 1, 0, 0, 1, 0, 0]
Day 4: [0, 0, 0, 0, 0, 1, 0, 0]
Day 5: [0, 1, 1, 1, 0, 1, 0, 0]
Day 6: [0, 0, 1, 0, 1, 1, 0, 0]
Day 7: [0, 0, 1, 1, 0, 0, 0, 0]

Example 2:
Input: cells = [1,0,0,1,0,0,1,0], N = 1000000000
Output: [0,0,1,1,1,1,1,0]

Note:
cells.length == 8
cells[i] is in {0, 1}
1 <= N <= 10^9 
 */
public class PrisonCellsAfterNDays {
	
	List<int[]> lookupList = new ArrayList<>();
	
	public boolean doesArrayRepeat(int[] compareArray) {		
		for(int[] currArr : lookupList) {
			if (Arrays.compare(compareArray, currArr) == 0) {
				return true;
			}
		}		
		return false;		
	}
	
	public int[] getAnswer(int numRepeat) {
		return lookupList.get(numRepeat % lookupList.size());
	}
	
    public int[] prisonAfterNDays(int[] cells, int N) {
    	if ( N == 0 || cells == null || cells.length == 0 )
    		return null;
    	
    	boolean leftCellOccupied = false;
    	boolean rightCellOccupied = false;

    	int[] answer = null; 
    	for(int i=0; i<N; i++) {
    		for(int y=1; y<(cells.length-1); y++) {
    			answer = new int[cells.length];
    			
    			leftCellOccupied = cells[y-1] == 1 ? true : false ;
    			rightCellOccupied = cells[y+1] == 1 ? true : false ;
    		
    			if (( leftCellOccupied && rightCellOccupied ) || ( !leftCellOccupied && !rightCellOccupied ))
    				answer[y] = 1;
    			else
    				answer[y] = 0;
    			
    			if ( doesArrayRepeat(answer) ) {
    				return getAnswer(N);
    			} else
    				lookupList.add(answer);
    		}
    	}
    	return cells;
    }
	
	public void run() {
//		System.out.println(Arrays.toString(prisonAfterNDays(new int[] {0, 1, 0, 1, 1, 0, 0, 1}, 7)));
		System.out.println(Arrays.toString(prisonAfterNDays(new int[] {1,0,0,1,0,0,1,0}, 1000000000)));
	}

	public static void main(String[] args) {
		new PrisonCellsAfterNDays().run();
	}

}
