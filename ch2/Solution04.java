/*********************************************************************************
*     File Name           :     Solution04.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 10:55]
*     Last Modified       :     [2015-09-13 15:54]
*     Description         :     Partition 
**********************************************************************************/

public class Solution04
{
    public static class Node {
        Node next = null;
        int data;

        public Node() {
            data = 0;
        }

        public Node(int d) {
            data = d;
        }
    }

    // Write code to partition a linked list around a value x, such that all
    // nodes less than x come before all nodes greater that or equal to x. If x
    // is contained within the list, the values of x only need to be after the
    // elements less than x.
    public Node partition(Node head, int part) {
        if (head == null)
            return null;
        Node mid = new Node(); // anchor node
        Node left = new Node();
        left.next = mid;
        // save the 1st node left of mid, to help delete mid node
        Node prevMid = null;
        Node n = head;
        // iterate through the list, insert bigger nodes to left, smaller nodes
        // to right
        while(n != null) {
            Node next = n.next;
            if (prevMid == null)
                prevMid = n;
            if (n.data < part) {
                n.next = left.next;
                left.next = n;
            } else {
                n.next = mid.next;
                mid.next = n;
            }
            n = next;
        }
        // delete mid node
        prevMid.next = mid.next;
        // return head of list
        return left.next;
    }

    // test cases
    // only one element
}

