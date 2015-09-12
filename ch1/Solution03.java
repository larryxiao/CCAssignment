/*********************************************************************************
*     File Name           :     Solution03.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-11 13:25]
*     Last Modified       :     [2015-09-11 14:02]
*     Description         :     URLify
**********************************************************************************/

public class Solution03
{
    // Write a method to replace all spaces in a string with "%20"
    public String URLify(String input, int length) {
        String ret;
        int truncate = input.length();
        int nspaces = 0;
        int cursor = 0;
        // if input is blank, return
        if (input.length() == 0)
            return "";
        // truncate trailing zeros 
        for (int i = input.length()-1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c == ' ')
                truncate = i;
            else
                break;
        }
        input = input.substring(0, truncate);
        // count spaces in remaining string, allocate char array
        for (int i = truncate - 1; i >= 0; i--) {
            char c = input.charAt(i);
            if (c == ' ')
                nspaces++;
        }
        char[] charArray = new char[truncate+nspaces*2+1];
        // intepret the input string
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ') {
                charArray[cursor++] = '%';
                charArray[cursor++] = '2';
                charArray[cursor++] = '0';
            } else {
                charArray[cursor++] = c;
            }
        }
        ret = new String(charArray, 0, cursor);
        return ret;
    }

    public static void main(String args[]) {
        Solution03 foo = new Solution03();
        assert foo.URLify("Mr John Smith    ", 13).equals("Mr%20John%20Smith");
        assert foo.URLify("a a", 5).equals("a%20a");
        // special cases
        assert foo.URLify("", 3).equals("");
        assert foo.URLify(" ", 3).equals("");
        // trailing space
        assert foo.URLify(" aaa ", 9).equals("%20aaa");
        // give more than enough space
        assert foo.URLify(" aaa ", 10).equals("%20aaa");
        assert foo.URLify(" aaa", 10).equals("%20aaa");
    }
}
