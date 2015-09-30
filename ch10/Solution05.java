/*********************************************************************************
*     File Name           :     Solution05.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 19:52]
*     Last Modified       :     [2015-09-29 20:05]
*     Description         :     Sparse Search
*
*     Given a sorted array of strings that is interspersed with empty strings,
*     write a method to find the location of a given string. 
**********************************************************************************/

public class Solution05
{
    public int sparseSearch(String [] ss, String target) {
        int left = 0;
        int right = ss.length - 1;
        
        while (left <= right) {
            int mididx = (left + right) / 2;
            String midval = ss[mididx];
            // find mid, if not found return -1
            if (midval == "") {
                int idxleft = mididx - 1;
                int idxright = mididx + 1;
                while (true) {
                    if (idxleft < left && idxright > right)
                        break;
                    if (ss[idxleft] != "") {
                        mididx = idxleft;
                        midval = ss[idxleft];
                        break;
                    }
                    if (ss[idxright] != "") {
                        mididx = idxright;
                        midval = ss[idxright];
                        break;
                    }
                    if (idxleft >= left) idxleft++;
                    if (idxright <= right) idxright--;
                }
                if (midval == "")
                    return -1;
            }
            if (midval.compareTo(target) == 0) 
                return mididx;
            if (midval.compareTo(target) > 0) {
                right = mididx - 1;
            } else {
                left = mididx + 1;
            }
        }
        return -1;
    }

    public static void main (String [] args)
    {
        Solution05 foo = new Solution05();
        String [] in = {"at", "", "", "", "ball", "", "", "car", "", "", "dad", "", ""};
        String target = "ball";
        assert foo.sparseSearch(in, target) == 4;
        target = "at";
        assert foo.sparseSearch(in, target) == 0;
        target = "dad";
        assert foo.sparseSearch(in, target) == 10;
    }
}

