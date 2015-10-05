/*********************************************************************************
*     File Name           :     Solution06.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-05 09:35]
*     Last Modified       :     [2015-10-05 09:40]
*     Description         :     Conversion 
**********************************************************************************/

class Solution06
{
    static int Conversion(int A, int B) {
        int flip = 0;
        for (int i = 0; i < 32; i++) {
            int mask = 1 << i;
            if ((A & mask) != (B & mask))
                flip++;
        }
        return flip;
    }

    public static void main (String [] args)
    {
        int A = Integer.parseInt("11101", 2);
        int B = Integer.parseInt("01111", 2);
        assert Conversion(A, B) == 2;
        A = Integer.parseInt("10000", 2);
        B = Integer.parseInt("01111", 2);
        assert Conversion(A, B) == 5;
        A = Integer.parseInt("00000", 2);
        B = Integer.parseInt("00000", 2);
        assert Conversion(A, B) == 0;
    }
}

