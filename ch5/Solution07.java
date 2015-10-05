/*********************************************************************************
*     File Name           :     Solution07.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-05 09:41]
*     Last Modified       :     [2015-10-05 09:48]
*     Description         :     Pariwise Swap 
**********************************************************************************/

class Solution07
{
    static int SwapBits(int A) {
        int mask = 0xAAAAAAAA;
        int even = mask & A;
        int odd = (mask >> 1) & A;
        int result = even >> 1 | odd << 1;
        return result;
    }

    public static void main (String [] args)
    {
        int A;
        A = Integer.parseInt("101010101010101010101010101010", 2);
        assert SwapBits(A) == Integer.parseInt("010101010101010101010101010101", 2);
        A = Integer.parseInt("10", 2);
        assert SwapBits(A) == Integer.parseInt("1", 2);
        A = Integer.parseInt("01", 2);
        assert SwapBits(A) == Integer.parseInt("10", 2);
    }
}

//[java - Converting 32-bit binary string with Integer.parseInt fails - Stack Overflow](http://stackoverflow.com/questions/8888946/converting-32-bit-binary-string-with-integer-parseint-fails)
