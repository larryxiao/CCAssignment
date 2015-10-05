/*********************************************************************************
*     File Name           :     Solution04.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-02 19:41]
*     Last Modified       :     [2015-10-05 15:17]
*     Description         :     Next Number
*
*     Careful: boundary +1 / -1, check if bit is zero or one
**********************************************************************************/

class Solution04
{
    static int nextNumber(int val) {
        // find the first rightmost zero that is not trailing
        // set the bit to one, and move all ones in the following to the bottom
        boolean trailing = true, one = false;
        int i;
        int ones = 0;
        for (i = 0; i < 32; i++) {
            if ((val & (1 << i)) == 0) {
                if (one) {
                    trailing = false;
                }
                if (!trailing) {
                    val |= 1 << i;
                    break;
                }
            }
            //System.out.format("%d", (val & (1<<i)) != 0 ? 1 : 0);
            if ((val & (1 << i)) != 0) {
                one = true;
                ones++;
            }
        }
        // already the biggest "No next number!"
        if (trailing) {
            return -1;
        }
        int trailingOnes;
        if (ones != 0)
            trailingOnes = (1 << (ones - 1)) - 1;
        else
            trailingOnes = 0;
        int ret = (val >> i << i) | trailingOnes;
        return ret;
    }

    static int prevNumber(int val) {
        // find the first rightmost one that is not trailing
        // set the bit to zero, and move all right side ones after the zero
        boolean trailing = true, zero = false;
        int i;
        int ones = 0;
        for (i = 0; i < 32; i++) {
            if ((val & (1 << i)) != 0) {
                ones++;
                if (zero) {
                    trailing = false;
                }
                if (!trailing) {
                    val &= ~ (1 << i);
                    break;
                }
            }
            if ((val & (1 << i)) == 0) {
                zero = true;
            }
        }
        // already the smallest "No prev number!"
        if (trailing) {
            return -1;
        }
        int trailingOnes;
        if (ones != 0)
            trailingOnes = (1 << (ones)) - 1;
        else
            trailingOnes = 0;
        int ret = (val >> i << i) | trailingOnes << (i-ones);
        return ret;
    }

    public static void main (String [] args)
    {
        int a, result;
        a = 0xFFFFFFFF; 
        assert nextNumber(a) == -1;
        a = 0x80000000; 
        assert nextNumber(a) == -1;
        a = Integer.parseInt("0", 2);
        assert nextNumber(a) == -1;
        a = Integer.parseInt("1000", 2);
        assert nextNumber(a) == Integer.parseInt("10000", 2);
        a = Integer.parseInt("1000101100101110", 2);
        assert nextNumber(a) == Integer.parseInt("1000101100110011", 2);
        a = Integer.parseInt("1000101100101110", 2);
        assert prevNumber(nextNumber(a)) == a;
        a = Integer.parseInt("00000001", 2);
        assert prevNumber(a) == -1;
    }
}

