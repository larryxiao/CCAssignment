/*********************************************************************************
*     File Name           :     Solution01.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-24 11:55]
*     Last Modified       :     [2015-09-29 10:51]
*     Description         :     Sorted Merge 
*
*     You are given two sorted arrays, A and B, where A has a large enough
*     buffer at the end to hold B. Write a method to merge B into A in sorted
*     order. 
**********************************************************************************/

public class Solution01
{
    // sort from end to beginning, using the space at back
    public void sortedMerge(int [] A, int [] B, int lastA, int lastB) {
        int indexA = lastA - 1;
        int indexB = lastB - 1;
        int indexSorted = lastA + lastB - 1;
        while(true){
            if (indexA == -1 || indexB == -1) break;
            if (A[indexA] > B[indexB]) {
                A[indexSorted--] = A[indexA--];
            } else {
                A[indexSorted--] = B[indexB--];
            }
        }
        for (; indexA >= 0; indexA--)
            A[indexSorted--] = A[indexA];
        for (; indexB >= 0; indexB--)
            A[indexSorted--] = A[indexB];
    }

    public static void main(String [] args) {
        int [] A = {1,3,4,6,7,0,0,0};
        int [] B = {2,5,8};
        Solution01 foo = new Solution01();
        foo.sortedMerge(A, B, 5, 3);
        for (int i=0; i < A.length ; i++)
           System.out.println(A[i]); 
    }
}

