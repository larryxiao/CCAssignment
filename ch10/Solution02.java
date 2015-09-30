/*********************************************************************************
*     File Name           :     Solution02.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 10:51]
*     Last Modified       :     [2015-09-29 11:13]
*     Description         :     Group Anagrams
*
*     Write a method to sort an array of strings so that all the anagrams are
*     next to each other.
**********************************************************************************/

import java.util.Arrays;
import java.util.Comparator;
import java.lang.String;

public class Solution02
{
    public static class AnagramComparator implements Comparator<String> {
        public int compare(String s1, String s2) {
            char [] c1 = s1.toCharArray();
            char [] c2 = s2.toCharArray();
            Arrays.sort(c1);
            Arrays.sort(c2);
            String tmp1 = new String(c1);
            String tmp2 = new String(c2);
            return tmp1.compareTo(tmp2); 
        }
    }
    public static void main (String [] args)
    {
        String [] a1 = {"abc", "bca", "cba", "caa", "ac"};
        System.out.println(Arrays.asList(a1));
        Arrays.sort(a1, new Solution02.AnagramComparator());
        System.out.println(Arrays.asList(a1));
    }

    // improve:
    // 0. bucket sort
    // http://www.lintcode.com/en/problem/anagrams/
}
