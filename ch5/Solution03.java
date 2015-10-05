/*********************************************************************************
*     File Name           :     Solution03.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-02 19:20]
*     Last Modified       :     [2015-10-02 19:41]
*     Description         :     Flip Bit to Win 
**********************************************************************************/

class Solution03
{
    static int FlipBitToWin(int val) {
        String binary = Integer.toBinaryString(val);
        //System.out.println(binary);
        int max = 0, left = 0, right = 0;
        int idx = -1, maxidx = 0;
        for (int i = 0; i < binary.length(); i++) {
            if (binary.charAt(i) == '0') {
                int sum = left + right;
                if (sum > max) {
                    max = sum;
                    maxidx = idx == -1 ? i : idx;
                }
                left = right;
                right = 0;
                idx = i;
            } else {
                right += 1;
            }
        }
        // last digit
        int sum = left + right;
        if (sum > max) {
            max = sum;
            maxidx = idx;
        }
        //System.out.println(max+1);
        //System.out.println(maxidx);
        return max + (idx == -1? 0: 1);
    }

    public static void main (String [] args)
    {
        int N;
        N = Integer.parseInt("10000000000", 2);
        assert FlipBitToWin(N) == 2; // at 1
        N = Integer.parseInt("00000000001", 2);
        assert FlipBitToWin(N) == 1; // at -1
        N = Integer.parseInt("10101101111", 2);
        assert FlipBitToWin(N) == 7; // at 6
        N = Integer.parseInt("00000000000", 2);
        assert FlipBitToWin(N) == 1; // at 0
    }
}

