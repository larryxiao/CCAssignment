/*********************************************************************************
*     File Name           :     Solution11.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 20:21]
*     Last Modified       :     [2015-09-29 21:59]
*     Description         :     Peaks and Valleys
*
*     In an array of integers, a "peak" is an element which is greater than or
*     equal to the adjacent integers and a "valley" is an element which is less
*     than or equal to the adjacent integers. For example. in the array
*     {5,8,6,2,3,4,6}, {8,6} are peaks and {5,2} are valleys.
*
*     Given an array of integers, sort the array into an alternating sequence
*     of peaks and valleys. 
*
*     0. sort the array first, then interleave the elements O(nlogn)
*     1. unsorted array. use a sliding window of 3, search for max in the three
*     elements, swap with middle. (you always have the largest number in the
*     middle) O(n)
**********************************************************************************/

import java.util.Arrays;

public class Solution11
{
    public static void main (String [] args)
    {
        int [] A = {0,1,4,7,8,9};
        Arrays.sort(A);
        for (int i = 1; i < A.length; i+= 2) {
            int tmp = A[i];
            A[i] = A[i-1];
            A[i-1] = tmp;
        }
        System.out.println(Arrays.toString(A));
    }
}

