/*********************************************************************************
*     File Name           :     Solution07.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 15:23]
*     Last Modified       :     [2015-09-13 17:05]
*     Description         :     Intersection 
**********************************************************************************/

import java.util.*;

public class Solution07
{
    public static class Node {
        Node next = null;
        int data;
    }

    // Given two (singly) likned lists, determine if the two lists intersecct.
    // Return the intersecting node. Node that the intersection is defined
    // based on reference, not value.
    public Node intersection(Node list1, Node list2) {
        Map<Node, Boolean> apperance = new HashMap<Node, Boolean>();
        // record the appearance in List1
        Node ptr = list1;
        while(ptr != null) {
            apperance.put(ptr, true);
            ptr = ptr.next;
        }
        // check with list2
        ptr = list2;
        while(ptr != null) {
            if (apperance.containsKey(ptr))
                return ptr;
            ptr = ptr.next;
        }
        return null;
    }

    // test cases:
    // No intersection: [], [2]
    // 3: [1,2,3,4] , [3,4,5]
    // 3: [1,2,3,4] , [2,3,4,5]
}


