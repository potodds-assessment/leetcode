package dailycodingproblem;

/*
This problem was asked by Google.

You are given an N by M 2D matrix of lowercase letters. Determine the minimum number of columns that can be removed to ensure
that each row is ordered from top to bottom lexicographically. That is, the letter at each column is lexicographically later
as you go down each row. It does not matter whether each row itself is ordered lexicographically.

For example, given the following table:

cba
daf
ghi
This is not ordered because of the a in the center. We can remove the second column to make it ordered:

ca
df
gi
So your function should return 1, since we only needed to remove 1 column.
 */

import java.util.Arrays;

public class dcr_1216_medium {

    private final char[][] lcaseMatrix;
    private int rows;
    private int columns;

    public dcr_1216_medium(int n, int m) {
        lcaseMatrix = new char[n][m];
        rows = n;
        columns = m;
    }

    public dcr_1216_medium(char[][] mLC) {
        lcaseMatrix = mLC;
        rows = lcaseMatrix.length;
        columns = lcaseMatrix[0].length;
    }

    private int minimumColToRemove() {
        int colsToRemove = 0;
        int trackCols[] = new int[columns];

        for (int n = 0; n < rows; n++) {
            for (int m = 0; m < columns; m++) {
                if (trackCols[m] == -1) continue;

                if ((int)lcaseMatrix[n][m] > trackCols[m])
                    trackCols[m] = (int)lcaseMatrix[n][m];
                else
                    trackCols[m] = -1;
            }
        }

        System.out.println(Arrays.toString(trackCols));

        for(int i : trackCols) {
            if (i == -1) colsToRemove++;
        }

        return colsToRemove;
    }

    private void printMatrix() {
        for (int n = 0; n < rows; n++) {
            for (int m = 0; m < columns; m++) {
                System.out.print(lcaseMatrix[n][m] + " ");
            }
            System.out.println();
        }
    }

    private void printMatrixInt() {
        for (int n = 0; n < rows; n++) {
            for (int m = 0; m < columns; m++) {
                System.out.print((int)lcaseMatrix[n][m] + " ");
            }
            System.out.println();
        }
    }

    public void runTest() {
        printMatrixInt();
        System.out.println();

        System.out.println("Columns to remove: " + minimumColToRemove());

        System.out.println(lcaseMatrix.length);
        System.out.println(lcaseMatrix[0].length);
    }

    public static void main(String[] arr) {
        char[][] nMatrix = new char[3][];
        nMatrix[0] = new char[]{'z','y'};
        nMatrix[1] = new char[]{'w','v'};
        nMatrix[2] = new char[]{'t','s'};

        new dcr_1216_medium(nMatrix).runTest();
    }
}
