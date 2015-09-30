/*********************************************************************************
*     File Name           :     Solution09.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 20:18]
*     Last Modified       :     [2015-09-29 21:44]
*     Description         :     Sorted Matrix
*
*     Search Given an M x N matrix in which each row and each column is sorted
*     in ascending order, write a method to find an element. 
*
*     improvement 0: binary search
**********************************************************************************/

public class Solution09
{
    public boolean linearSearch(int [][] A, int target) {
        // search from right to left, top to bottom
        int m = A.length;
        int n = A[0].length;
        int row = 0;
        int column = n-1;
        while (row <= m-1 && column >= 0) {
            int val = A[row][column];
            if (val == target)
                return true;
            if (val > target)
                column--;
            else
                row++;
        }
        return false;
    }
    
    public static void main (String [] args)
    {
        int [][] A = {{1,2,3}, {2,3,4}, {3,4,5}};
        Solution09 foo = new Solution09();
        assert foo.linearSearch(A, 3) == true;
        assert foo.linearSearch(A, 0) == false;
        assert foo.linearSearch(A, 6) == false;
    }
}

