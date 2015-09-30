/*********************************************************************************
*     File Name           :     Solution07.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 20:08]
*     Last Modified       :     [2015-09-29 21:20]
*     Description         :     Missing Int 
*
*     Given an input file with four billion non-negative integers, provide an
*     algorithm to generate an integer that is not contained in the file.
*     Assume you have 1 GB of memory available for this task. 
*
*     0. 2^32 bits can encode four billion integers, which is 512 MB of memory,
*     can use the bitmap to save the appearances and return the one that's not
*     appeared.
*
*     Follow Up 
*
*     What if you have only 10 MB of memory?  Assume that all the values are
*     distinct and we now have no more than one billion non-negative integers. 
*
*     1. use two passes, first pass to store the numbers in a fixed size rance,
*     and figure out the range that some integers are missing. then in the
*     second pass look for the exact missing integer
**********************************************************************************/

import java.util.Scanner;
import java.io.FileReader;
import java.io.FileNotFoundException;

public class Solution07
{
    public static class BitSet {
        byte [] bitset;
        BitSet() {
            bitset = new byte[1<<28]; 
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
        //if (args.length < 1) return;
        //System.out.println(args[0]);
        //String filename = args[0];
        // test BitSet
        BitSet bs = new BitSet();
        assert bs.get(0) == false;
        bs.set(1, true);
        assert bs.get(1) == true;
        bs.set(1, false);
        assert bs.get(1) == false;

        String filename = "Solution07.input";
        Scanner sc = new Scanner(new FileReader(filename));
        while (sc.hasNextInt()) {
            int n = sc.nextInt();
            bs.set(n, true);
        }
        for (long i=0; i < 1L<<31; i++) {
            if (bs.get(i) == false) {
                System.out.println(i);
                break;
            }
        }
    }
}
