/*********************************************************************************
*     File Name           :     Solution02.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-11 13:08]
*     Last Modified       :     [2015-09-11 13:22]
*     Description         :     Check Permutation 
**********************************************************************************/

import java.util.Map;
import java.util.HashMap;

public class Solution02
{
    // given two strings, write a method to decide if one is a permutation of the other
    // permutation: rearrangement of characters
    public boolean checkPermutation(String a, String b) {
        if (a.length() != b.length())
            return false;
        Map<Character, Integer> mapA, mapB;
        mapA = new HashMap<Character, Integer>();
        mapB = new HashMap<Character, Integer>();
        for (int i = 0; i < a.length(); i++) {
            char charA, charB;
            charA = a.charAt(i);
            charB = b.charAt(i);
            if (mapA.containsKey(charA)) {
                int tmp = mapA.get(charA);
                mapA.put(charA, tmp++);
            } else {
                mapA.put(charA, 1);
            }
            if (mapB.containsKey(charA)) {
                int tmp = mapB.get(charA);
                mapB.put(charB, tmp++);
            } else {
                mapB.put(charB, 1);
            }
        }
        return mapA.equals(mapB);
    }

    public static void main(String args[]) {
        Solution02 foo = new Solution02();
        assert foo.checkPermutation("abc", "bca") == true;
        assert foo.checkPermutation("", "") == true;
        assert foo.checkPermutation("ac", "bca") == false;
        assert foo.checkPermutation("aac", "bca") == false;
    }
}
