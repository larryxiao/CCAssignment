/*********************************************************************************
*     File Name           :     Solution03.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 11:10]
*     Last Modified       :     [2015-09-29 13:03]
*     Description         :     Search in Rotated Array
*
*     Given a sorted array of n integers that has been rotated an unknown
*     number of times, write code to find an element in the array. You may
*     assume that the array was originally sorted in increasing order. 
*
*     http://www.lintcode.com/en/problem/search-in-rotated-sorted-array/
*     http://www.lintcode.com/en/problem/search-in-rotated-sorted-array-ii/
*
**********************************************************************************/

public class Solution03 {
    public boolean rotatedBinarySearch(int [] A, int left, int right, int target) {
        if (right - left < 0) return false;
        int mid = (left+right)/2;
        int midval = A[mid], leftval = A[left], rightval = A[right];
// System.out.format("%d:%d, %d:%d, %d:%d\n", left, leftval, mid, midval, right, rightval);
        if (midval == target) return true;
        if (leftval < midval && midval < rightval) {
            // the sequence is not rotated
            if (midval < target) {
                // search right
                return rotatedBinarySearch(A, mid+1, right, target);
            } else {
                // search left
                return rotatedBinarySearch(A, left, mid-1, target);
            }
        }
        if (leftval > midval && rightval > midval) {
            // break point is on left
            if (target < midval) {
                // search left
                return rotatedBinarySearch(A, left, mid-1, target);
            } else {
                // search both
                return rotatedBinarySearch(A, mid+1, right, target) 
                    || rotatedBinarySearch(A, left, mid-1, target);
            }
        }
        if (leftval < midval && rightval < midval) {
            // break point is on right
            if (target > midval) {
                // search right
                return rotatedBinarySearch(A, mid+1, right, target);
            } else {
                // search both
                return rotatedBinarySearch(A, mid+1, right, target) 
                    || rotatedBinarySearch(A, left, mid-1, target);
            }
        }
        if (leftval == rightval) // don't know break point, search both
            return rotatedBinarySearch(A, mid+1, right, target) 
                    || rotatedBinarySearch(A, left, mid-1, target);
        if (rightval == midval)
            return rotatedBinarySearch(A, left, mid-1, target); // left
        if (leftval == midval)
            return rotatedBinarySearch(A, mid+1, right, target); // right
        return false;
    }
    /** 
     * param A : an integer ratated sorted array and duplicates are allowed
     * param target :  an integer to be search
     * return : a boolean 
     */
    public boolean search(int[] A, int target) {
        return rotatedBinarySearch(A, 0, A.length-1, target);
    }

    public static void main (String [] args)
    {
        Solution03 foo = new Solution03();
        int [] A = {2,2,2,3,1};
        assert foo.search(A, 1) == true;
    }
}
