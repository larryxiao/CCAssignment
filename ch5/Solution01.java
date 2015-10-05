/*********************************************************************************
*     File Name           :     Solution01.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-02 18:55]
*     Last Modified       :     [2015-10-02 19:06]
*     Description         :     Insertion 
**********************************************************************************/

class Solution01
{
    static int insertion(int N, int M, int i, int j) {
        // starts at bit j, ends at bit i
        int length = Integer.toBinaryString(M).length();
        int mask = (~0<<(j+1)) | ((1<<i) - 1);
        return N & mask | M << i; 
    }
    public static void main (String [] args)
    {
        int N = Integer.parseInt("10000000000", 2);
        int M = Integer.parseInt("10011", 2);
        int result = insertion(N, M, 2, 6);
        System.out.println(Integer.toBinaryString(result));
    }

}


