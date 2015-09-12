/*********************************************************************************
*     File Name           :     Solution04.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-11 13:43]
*     Last Modified       :     [2015-09-11 19:07]
*     Description         :     Palindrome Permutation 
**********************************************************************************/

import java.util.Map;
import java.util.HashMap;

public class Solution04
{
    // given a string, write a function to check if it is a permutation of a palindrome
    public boolean palindromePermutation(String input) {
        input = input.toLowerCase();
        Map<Character, Integer> appearance = new HashMap<Character, Integer>();
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == ' ')
                continue;
            if (appearance.containsKey(c)) {
                int t = appearance.get(c);
                appearance.put(c, t+1);
            } else {
                appearance.put(c, 1);
            }
        }
        boolean flag = false; // can allow one odd appearance
        for (Map.Entry<Character, Integer> m : appearance.entrySet()) {
            if (m.getValue() % 2 != 0) {
                if (flag)
                    return false;
                flag = true;
            }
        }
        return true;
    }

    public static void main(String args[]) {
        Solution04 foo = new Solution04();
        assert foo.palindromePermutation("Tact Coa") == true;
        assert foo.palindromePermutation("pallap") == true;
    }
}

