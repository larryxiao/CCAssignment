/*********************************************************************************
*     File Name           :     Solution08.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-10-05 09:48]
*     Last Modified       :     [2015-10-05 10:34]
*     Description         :     Draw Line 
**********************************************************************************/

class Solution08
{
    static void drawLine(byte[] screen, int width, int x1, int x2, int y) {
        int bytesPerRow = width / 8;
        int startByte = x1/8;
        int endByte = x2/8;
        for (int i = startByte; i < endByte + 1; i++) {
            int leftBound = i == startByte? x1%8 : 0;
            int rightBound = 7 - (i == endByte? x2%8 : 7);
            int maskLeft = 0xFF >> leftBound;
            int maskRight = 0xFF >>> rightBound << rightBound;
            //int mask = 0xF << leftBound >>> leftBound >>> rightBound << rightBound;
            int mask = maskLeft & maskRight;
            System.out.format("%d: %d %d [%x]\t", i, leftBound, rightBound, mask);
            screen[y*bytesPerRow + i] |= mask;
        }
        for (int i = 0; i < screen.length; i++) {
            if (i % bytesPerRow == 0)
                System.out.println();
            System.out.format("%02x", screen[i]);
        }
        System.out.println();
    }

    public static void main (String [] args)
    {
        byte [] screen = new byte[100];
        drawLine(screen, 80, 0, 79, 0);
        drawLine(screen, 80, 1, 78, 1);
        drawLine(screen, 80, 2, 77, 2);
        drawLine(screen, 80, 2, 3, 3);
        drawLine(screen, 80, 2, 4, 4);
        //ffffffffffffffffffff
        //7ffffffffffffffffffe
        //3ffffffffffffffffffc
        //30000000000000000000
        //38000000000000000000
        //00000000000000000000
        //00000000000000000000
        //00000000000000000000
        //00000000000000000000
        //00000000000000000000
    }
}



