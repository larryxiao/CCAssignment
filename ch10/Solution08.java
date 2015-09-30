/*********************************************************************************
*     File Name           :     Solution08.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 20:16]
*     Last Modified       :     [2015-09-29 21:24]
*     Description         :     Find Duplicates
*
*     You have an array with all the numbers from 1 to N, where N is at most
*     32,000. The array may have duplicate entries and you do not know that N
*     is. With only 4 kilobytes of memory available, how would you print all
*     duplicate elements in the array? 
*
*     0. use a bit vector to record the apperances of 1-N numers, which takes
*     at most 3.91 KB of memory. 
**********************************************************************************/

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Solution08
{
    public static class BitSet {
        byte [] bitset;
        BitSet() {
            bitset = new byte[1<<14]; 
        }
        boolean get(long idx) {
            return ((bitset[(byte) idx/8]) & (1<<(idx%8))) > 0;
        }
        void set(long idx, boolean flag) {
            if (flag)
                bitset[(byte) idx/8] |= 1<<idx%8;
            else
                bitset[(byte) idx/8] &= ~(1<<idx%8);
        }
    }

    public static void main (String [] args) throws FileNotFoundException
    {
        Scanner sc = new Scanner(new FileReader("Solution08.input"));
        BitSet bs = new BitSet();
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            if (bs.get(n) == true)
                System.out.println(n);
            else
                bs.set(n, true);
        }

    }
}

