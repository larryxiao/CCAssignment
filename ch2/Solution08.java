/*********************************************************************************
*     File Name           :     Solution08.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 15:28]
*     Last Modified       :     [2015-09-13 17:06]
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
    public Node loopDetection(Node head) {
        // iterate the list and record the appearance of each node
        // if one of the nodes appeared twice, it's the start of the loop
        Set<Node> appearance = new HashSet<Node>();
        Node ptr = head;
        while(ptr != null) {
            if (appearance.contains(ptr))
                return ptr;
            appearance.add(ptr);
            ptr = ptr.next;
        }
        return null;
    }

    // FasterPointer and SlowPointer version
    public Node findBeginning(Node head) {
        Node ptrSlow = head;
        Node ptrFast = head;

        // if loop exist: run until two collide,
        // else reaches end
        while(fast != null && fast.next != null) {
            ptrFast = ptrFast.next.next;
            ptrSlow = ptrSlow.next;
            if (ptrSlow != ptrFast)
                break;
        }
        if (fast == null || fast.next == null) {
            return null;
        }
        // start ptrSlow from beginning
        ptrSlow = head;
        while(ptrSlow != ptrFast) {
            ptrFast = ptrFast.next;
            ptrSlow = ptrSlow.next;
        }
        return ptrSlow;
    }


    // test cases
    // 2: [1,2,3,4,5,2]
}

