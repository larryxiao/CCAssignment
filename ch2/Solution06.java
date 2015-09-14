/*********************************************************************************
*     File Name           :     Solution06.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 15:09]
*     Last Modified       :     [2015-09-13 16:59]
*     Description         :     Palindrome 
**********************************************************************************/

import java.util.Stack;

public class Solution06
{
    public static class Node {
        Node next = null;
        int data;
    }

    //implement a function to check if a linked list is a palindrome
    public boolean palindrome(Node head) {
        if (head == null)
            return false;
        // construct a stack of the nodes 
        Stack<Node> nodes = new Stack<Node>();
        Node ptr = head;
        while(ptr != null) {
            nodes.push(ptr);
            ptr = ptr.next;
        }

        // check if they are the same
        ptr = head;
        int length = nodes.size();
        for (int i = 0; i < length/2; i++) {
            Node tmp = nodes.pop();
            if (tmp.data != ptr.data) 
                return false;
            ptr = ptr.next;
        }
        return true;
    }

    // improvement
    // stack + fast, slow pointer. compare first half with second half

    // alternative
    // recursive approach

    // test cases
    // [1]
    // [1, 2, 1]
    // [1, 1, 2, 1]
}

