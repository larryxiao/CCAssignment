/*********************************************************************************
*     File Name           :     Solution02.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-02 19:06]
*     Last Modified       :     [2015-10-02 19:24]
*     Description         :     Binary to String
**********************************************************************************/

import java.util.Arrays;

class Solution02
{
    static void binaryToString(double val) {
        // problem with the precision of floating point number itself?
        char [] result = new char[32];
        result[0] = '0'; result[1] = '.';
        for (int i = 1; i < 31; i++) { 
            double binaryDigitInDecimal = Math.pow(0.5, i);
            if (val >= binaryDigitInDecimal) {
                result[i+1] = '1';
                val -= binaryDigitInDecimal;
            } else {
                result[i+1] = '0';
            }
            if (val == 0) {
                break;
            }
        }
        if (val == 0) {
            String forPrint = new String(result);
            System.out.println(forPrint);
        } else {
            System.out.println("ERROR");
        }
    }
    public static void main (String [] args)
    {
        binaryToString(0.72);
        binaryToString(0.5);
        binaryToString(0.25);
        binaryToString(0.0009765625);
        binaryToString(0.000000000931323);
        binaryToString(0.000000000465661);
    }

    // improvement 0: don't compute power very time, compute the factor iteratively
}

