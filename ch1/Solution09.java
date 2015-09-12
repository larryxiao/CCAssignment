/*********************************************************************************
*     File Name           :     Solution09.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-12 10:40]
*     Last Modified       :     [2015-09-12 10:48]
*     Description         :     String Rotation 
**********************************************************************************/


public class Solution09
{
    private boolean isSubstring(String s1, String s2) {
        return s2.indexOf(s1) != -1;
    }
    // Assume you have a method isSubstring which checks if one word is a substring of another. Given two strings, s1 and s2, write code to check if s2 is a rotation of s1 using only one call to isSubstring.
    public boolean stringRotation(String s1, String s2) {
        if (s1.length() != s2.length())
            return false;
        s2 = s2+s2;
        return isSubstring(s1, s2);
    }

    public static void main(String args[]) {
        Solution09 foo = new Solution09();
        assert foo.stringRotation("waterbottle", "erbottlewat") == true;
        assert foo.stringRotation("waterbottle", "erbottlewao") == false;
        assert foo.stringRotation("", "") == true;
        assert foo.stringRotation("1", "") == false;
    }

}


