/*********************************************************************************
*     File Name           :     Solution04.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 13:07]
*     Last Modified       :     [2015-09-29 19:52]
*     Description         :     Sorted Search, No Size 
*
*     You are given an array-like data structure Listy which lacks a size
*     method. It does, however, have an elementAt(i) method that returns the
*     element at index i in O(1) time. If i is beyond the bounds of the data
*     structure, it returns -1. (For this reason, the data structure only
*     supports positive integers.) Given a Listy which contains sorted,
*     positive integers, find the index at which an element x occus. If x
*     occurs multiple times, you may return any index. 
**********************************************************************************/

public class Solution04
{
    // search exponentially to get range
    // then search within range linearly
    public int search(Listy A, int target) {
        int cursor = 1;
        while (A.elementAt(cursor) != -1 && A.elementAt(cursor) < target) {
            cursor *= 2;
        }
        int left = cursor/2, right = cursor;
        while (left <= right) {
            int mid = (left + right) / 2;
            int val = A.elementAt(mid);
            if (val == -1)
                break;
            if (val == target)
                return mid;
            if (val < target) {
                left = mid+1;
            } else {
                right = mid-1;
            }
        }
        return -1;
    }
}
