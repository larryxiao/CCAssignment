/*********************************************************************************
*     File Name           :     Solution08.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-11 22:38]
*     Last Modified       :     [2015-09-13 11:04]
*     Description         :     Zero Matrix 
**********************************************************************************/

import java.util.ArrayList;
import java.util.Arrays;

public class Solution08
{
    // Write an algorithm such that if an element in an MxN matrix is 0, its
    // entire row and column are set to 0.
    public int zeroMatrix(int[][] matrix, int M, int N) {
        // search for zeros and record rows and columns to be zeroed
        ArrayList<Integer> rows = new ArrayList<Integer>();
        ArrayList<Integer> columns = new ArrayList<Integer>();
        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    columns.add(j);
                }
            }
        }
        // zero out the row and columns
        for (Integer r : rows) {
            for (int i = 0; i < N; i++) {
                matrix[r][i] = 0;
            }
        }
        for (Integer c : columns) {
            for (int i = 0; i < M; i++) {
                matrix[i][c] = 0;
            }
        }
        return 0;
    }

    public static void main(String args[]) {
        Solution08 foo = new Solution08();
        int[][] matrix = {
            {1,2,3,0},
            {0,2,3,4},
            {1,2,3,4}
        };
        int[][] target = {
            {0,0,0,0},
            {0,0,0,0},
            {0,2,3,0}
        };
        foo.zeroMatrix(matrix, 3, 4);
        assert Arrays.deepEquals(matrix, target);

        int [][] matrix2 = {
            {0}
        };
        int [][] target2 = {
            {0}
        };
        foo.zeroMatrix(matrix2, 1, 1);
        assert Arrays.deepEquals(matrix2, target2);
    }
}

