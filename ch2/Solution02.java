/*********************************************************************************
*     File Name           :     Solution02.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 10:36]
*     Last Modified       :     [2015-09-13 17:06]
*     Description         :     Return Kth to Last 
**********************************************************************************/

public class Solution02
{
    public static class Node {
        Node next = null;
        int data;
    }

    // Implement an algorithm to find the kth to last element of a singly
    // linked list
    public Node kthToLast(Node head, int k) {
        if (head == null || k < 1)
            return null;
        Node p1, p2;
        p1 = head;
        p2 = head;
        // advance p2 by k
        for (int i = 0; i < k-1; i++) {
            p2 = p2.next;
            if (p2 == null)
                return null;
        }
        // iterate the list until p2 reaches end, then p1 is the required
        // element
        while (p2.next != null) {
            p2 = p2.next;
            p1 = p1.next;
        }
        return p1;
    }

    // test cases
    // list length < k
    // list head is null
}
