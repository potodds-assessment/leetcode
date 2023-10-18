package algorithms;


/*
 * 5 Simple Steps for Solving Any Recursive Problem
 * https://www.youtube.com/watch?v=ngCos392W4w&list=WL&index=12
 * 
 * Towers of Hanoi: A Complete Recursive Visualization
 * https://www.youtube.com/watch?v=rf6uf3jNjbo&list=WL&index=8
 */
public class Recursion {

    /*
     * Write recursive function to sum all non-negative integers up to n
     * base case n == 0
     * 
     * 5 = 0 + (1 + sum(0)) + (2 + sum9(1)) + (2 + sum(2)) + (4 + sum(3)) + (5 + sum(4))
     */
    public int sum(int n) {
        if (n == 0)
            return 0;

        return n + sum(n-1);
    }

    /*
     * write function to count number of unique paths in an row x col grid.
     * base case n == 1 or m == 1
     * 
     */
    public int unique_paths(int rows, int cols) {
        if (rows == 1 || cols == 1)
            return 1;
        
        return unique_paths(rows, cols-1) + unique_paths(rows-1, cols);
    }

    /*
     * write function to count number of ways to partition values objects using parts up to part
     * base case: values == 0  
     * base case: part == 0 or values < 0 
     */
    public int count_partitions(int values, int part) {
        if (values == 0) 
            return 1;
        else if (part == 0 || values < 0)
            return 0;
                
        return count_partitions(values-part, part) + count_partitions(values, part-1);
    }

    private void pm(int start, int end) {
        System.out.println(start + "->" + end);
    }

    public void towers_hanoi(int n, int start, int end) {
        if (n == 1)
            pm(start, end);
        else {
            int other = 6 - (start + end);
            towers_hanoi(n-1, start, other);
            pm(start, end);
            towers_hanoi(n-1, other, end);
        }        
    }

    public static void main(String[] args) {
        Recursion app = new Recursion();
        System.out.println(app.sum(2) == 3);    
        System.out.println(app.sum(3) == 6);    
        System.out.println(app.sum(4) == 10);    

        System.out.println(app.unique_paths(2,2) == 2);    
        System.out.println(app.unique_paths(2, 3) == 3);    
        System.out.println(app.unique_paths(3, 3) == 6);    

        System.out.println(app.count_partitions(7, 4) == 11);    

        app.towers_hanoi(3,1,3);    
    }
}
    


