/*********************************************************************************
*     File Name           :     Solution05.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 11:34]
*     Last Modified       :     [2015-09-13 12:03]
*     Description         :     Sum Lists 
**********************************************************************************/

public class Solution05
{
    public static class Node {
        Node next = null;
        int data;

        public Node() {
        }

        public Node(int d) {
            data = d;
        }

        public void appendTail(int d) {
            Node p = this;
            Node n = new Node(d);
            while (p.next != null)
                p = p.next;
            p.next = n;
        }
    }

    // Example
    // Input: (7->1->6) + (5->9->2)
    // Output: (2->1->9)
    public Node sumLists(Node first, Node second) {
        int carry = 0;
        Node ret = new Node();
        while((first != null) || (second != null)) {
            int digit1 = first == null ? 0 : first.data;
            int digit2 = first == null ? 0 : second.data;
            int result = digit1+digit2+carry;
            if (result > 10)
                carry = 1;
            else
                carry = 0;
            ret.appendTail(result % 10);
        }
        if (carry == 1)
            ret.appendTail(1);
        return ret.next;
    }

    // Example
    // Input: (7->1->6) + (5->9->2)
    // Output: (1->3->0->8)
    public Node sumLists2(Node first, Node second) {
        Node ret = new Node();
        long num1 = 0;
        long num2 = 0;
        // parse number
        while (first != null) {
            num1 = num1*10 + first.data;
            first = first.next;
        }
        while (second != null) {
            num2 = num2*10 + second.data;
            second = second.next;
        }
        // calculate
        long result = num1 + num2;
        // construct result list
        if (result == 0)
            return new Node(0);

        while (result > 0) {
            ret.appendTail((int) result % 10);
            result /= 10;
        }      
        return ret.next;
    }
    
    // special case: the list is very long
}
