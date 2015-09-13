/*********************************************************************************
*     File Name           :     Solution06.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-13 15:09]
*     Last Modified       :     [2015-09-13 15:22]
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
    public boolean palindrome(Node list) {
        // construct a stack of the nodes 
        Stack<Node> nodes = new Stack<Node>();
        Node ptr = list;
        while(ptr != null) {
            nodes.push(ptr);
            ptr = ptr.next;
        }
        // check if they are the same
        ptr = list;
        for (int i = 0; i < nodes.size()/2; i++) {
            Node tmp = nodes.pop();
            if (tmp.data != ptr.data) 
                return false;
        }
        return true;
    }
}

