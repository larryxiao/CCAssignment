/*********************************************************************************
*     File Name           :     Solution01.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-11 11:33]
*     Last Modified       :     [2015-09-11 13:15]
*     Description         :     Is Unique
**********************************************************************************/

//package CCAssignment.ch1;

import java.lang.String;
import java.util.HashMap;
import java.util.Map;

public class Solution01
{
    // implement an algorithm to determine if a string has all unique character
    public boolean isUnique(String input) {
        // the input string is not specified, so it can be arbitrary character
        Map<Character, Boolean> appearance = new HashMap<Character, Boolean>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (appearance.containsKey(c))
                return false;
            else
                appearance.put(c, true);
        }
        return true;
    }

    // what if you cannot use additional data structure
    public boolean isUnique2(String input) {
        for (int i = 0; i < input.length(); i++) {
            for (int j = i+1; j < input.length(); j++) {
                if (input.charAt(i) == input.charAt(j))
                    return false;
            }
        } 
        return true;
    }

    public static void main(String args[]) {
        // tests
        Solution01 foo = new Solution01();
        // isUnique
        assert foo.isUnique("abc") == true;
        assert foo.isUnique("abca") == false;
        assert foo.isUnique("19@#abc") == true;
        assert foo.isUnique("") == true;
        // isUnique2
        assert foo.isUnique2("abc") == true;
        assert foo.isUnique2("abca") == false;
        assert foo.isUnique2("19@#abc") == true;
        assert foo.isUnique2("") == true;
    }
}
