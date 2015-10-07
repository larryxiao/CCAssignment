/*********************************************************************************
*     File Name           :     Solution07.java
*     Created By          :     larryxiao
*     Creation Date       :     [2015-10-07 19:16]
*     Last Modified       :     [2015-10-07 19:19]
*     Description         :     The Apocalypse 
**********************************************************************************/

public class Solution07
{
    public static void main (String [] args)
    {
        //P=(1/2)^(n+1)
        //The number of girls G. G = sigma(P) (n = 0..infinite)
        //The number of boys B. B = sigma(P*n) (n = 0..infinite)
        float G = 0;
        float B = 0;
        for (int i = 0; i < 1000; i++) {
            G += Math.pow(0.5, i+1);
            B += Math.pow(0.5, i+1)*i;
            float ratio = G/B;
            System.out.format("Girl: %f Boy: %f Ratio: %f\n", G, B, ratio);
        }
    }
}

