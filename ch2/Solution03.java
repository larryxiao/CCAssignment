/*********************************************************************************
*     File Name           :     Solution03.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 10:52]
*     Last Modified       :     [2015-09-13 11:00]
*     Description         :     Delete Middle Node 
**********************************************************************************/

public class Solution03
{
    public static class Node {
        Node next = null;
        int data;
    }

    // Implement a algorithm to delete a node in the middle of a singly linked
    // list given only access to that node
    public int deleteMiddleNode(Node d) {
        if (d == null || d.next == null)
            return -1;
        d.data = d.next.data;
        d.next = d.next.next;
        return 0;
    }
}

