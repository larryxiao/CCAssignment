/*********************************************************************************
*     File Name           :     Solution04.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 10:55]
*     Last Modified       :     [2015-09-13 15:54]
*     Description         :     Partition 
**********************************************************************************/

public class Solution04
{
    public static class ListNode {
        ListNode next = null;
        int val;

        public ListNode() {
            val = 0;
        }

        public ListNode(int d) {
            val = d;
        }
    }

    // Write code to partition a linked list around a value x, such that all
    // nodes less than x come before all nodes greater that or equal to x. If x
    // is contained within the list, the values of x only need to be after the
    // elements less than x.
    public ListNode partition(ListNode head, int part) {
        if (head == null)
            return null;
        ListNode mid = new ListNode(-1); // anchor node
        ListNode left = new ListNode(-1);
        left.next = mid;
        // save the 1st node left of mid, to help delete mid node
        ListNode prevMid = null;
        ListNode n = head;
        // iterate through the list, insert bigger nodes to left, smaller nodes
        // to right
        while(n != null) {
            ListNode next = n.next;
            if (n.val < part) {
                if (prevMid == null)
                    prevMid = n;
                n.next = left.next;
                left.next = n;
            } else {
                n.next = mid.next;
                mid.next = n;
            }
            n = next;
        }
        // if left don't exist, return mid.next
        // else delete mid node
        if (prevMid == null)
            return mid.next;
        else
            prevMid.next = mid.next;
        // return head of list
        return left.next;
    }

    // test cases
    // only one element
}