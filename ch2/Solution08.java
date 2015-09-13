/*********************************************************************************
*     File Name           :     Solution08.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 15:28]
*     Last Modified       :     [2015-09-13 15:35]
*     Description         :     Loop Detection
**********************************************************************************/

import java.util.*;

public class Solution08
{
    public static class Node {
        Node next = null;
        int data;
    }

    // Loop Detection: Given a circular linked list, implement an algorithm
    // that returns the node at the beginning of the loop.
    public Node loopDetection(Node list) {
        // iterate the list and record the appearance of each node
        // if one of the nodes appeared twice, it's the start of the loop
        Set<Node> appearance = new HashSet<Node>();
        Node ptr = list;
        while(ptr != null) {
            if (appearance.contains(ptr))
                return ptr;
            appearance.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }
}

