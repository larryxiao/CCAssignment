/*********************************************************************************
*     File Name           :     Solution05.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-11 19:07]
*     Last Modified       :     [2015-09-11 19:32]
*     Description         :     One Away 
**********************************************************************************/

public class Solution05
{
    // check if two strings are one/zero edit away
    public boolean oneAway(String a, String b) {
        boolean edit = false;
        if (Math.abs(a.length() - b.length()) > 1)
            return false;
        if (Math.abs(a.length() - b.length()) == 0) {
            for (int i = 0; i < a.length(); i++ ) {
                if (a.charAt(i) != b.charAt(i)) {
                    if (edit)
                        return false;
                    edit = true;
                }
            }
            return true;
        }
        String tmp;
        // make a the longer one
        if (a.length() - b.length() == -1) {
            tmp = a;
            a = b;
            b = tmp;
        }
        for (int i = 0; i < a.length(); i++ ) {
            if (!edit) {
                if (i == a.length() - 1)
                    return true;
                if (a.charAt(i) == b.charAt(i))
                    continue;
                else
                    edit = true;
            } else {
                if (a.charAt(i) == b.charAt(i-1))
                    continue;
                else
                    return false;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution05 foo = new Solution05();
        assert foo.oneAway("pale", "ple") == true;
        assert foo.oneAway("pales", "pale") == true;
        assert foo.oneAway("pale", "bale") == true;
        assert foo.oneAway("lll", "llla") == true;
        assert foo.oneAway("pale", "bake") == false;
        assert foo.oneAway("", "b") == true;
        assert foo.oneAway("", "") == true;
    }
}

