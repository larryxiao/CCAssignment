/*********************************************************************************
 *     File Name           :     Solution06.java
 *     Created By          :     xiaodi
 *     Creation Date       :     [2015-09-11 19:33]
 *     Last Modified       :     [2015-09-11 19:46]
 *     Description         :     String Compression 
 **********************************************************************************/

public class Solution06
{
    public String stringCompression(String input) {
        if (input.length() == 0)
            return input;
        StringBuffer buf = new StringBuffer();
        // head
        char currentCharacter = input.charAt(0);
        int repeatCount = 1;
        // construct the compressed string
        for (int i = 1; i < input.length(); i++) {
            char c = input.charAt(i);
            if (currentCharacter == c) {
                repeatCount++;
            } else {
                buf.append(currentCharacter);
                buf.append(repeatCount);
                currentCharacter = c;
                repeatCount = 1;
            }
        }
        // tail
        buf.append(currentCharacter);
        buf.append(repeatCount);
        // check if the compressed string is shorter than input
        String ret = buf.toString();
        if (ret.length() < input.length())
            return ret;
        else
            return input;
    }

    public static void main(String args[]) {
        Solution06 foo = new Solution06();
        assert foo.stringCompression("aabcccccaaa").equals("a2b1c5a3");
        assert foo.stringCompression("").equals("");
        assert foo.stringCompression("abca").equals("abca");
    }
}

