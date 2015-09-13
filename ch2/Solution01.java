/*********************************************************************************
*     File Name           :     Solution01.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-12 10:49]
*     Last Modified       :     [2015-09-13 10:35]
*     Description         :     Remove Dups
**********************************************************************************/

import java.util.*;

public class Solution01
{
    public static class Node {
        Node next = null;
        int data;

        public Node(int d) {
            data = d;
        }

        public int appendToTail(int d) {
            Node end = new Node(d);
            Node n = this;
            while (n.next != null) 
                n = n.next;
            n.next = end;
            return 0;
        }

        public int deleteNode(Node head, Node d) {
            Node n = head;
            // delete head node
            if (n == d) {
                head = n.next;
                return 0;
            }
            while (n != null) {
                if (n.next == d) {
                    n.next = d.next;
                    return 0;
                }
                n = n.next;
            }
            return -1;
        }

        // Write code to remove duplicates from an unsorted linked list.
        public int removeDuplicate() {
            Map<Integer, Boolean> appearance = new HashMap<Integer, Boolean>();
            // record appearance & delete node if appeared
            Node n = this;
            while (n != null) {
                if (appearance.containsKey(n.data)) {
                    deleteNode(this, n);
                } else {
                    appearance.put(n.data, true);
                }
                n = n.next;
            }
            return 0;
        }

        // Follow-up How would you solve this problem if a temporary buffer is not allowed
        public int removeDuplicate2() {
            Node n = this;
            while (n != null) {
                Node m = n.next;
                while (m != null) {
                    if (n.data == m.data) {
                        deleteNode(this, m);
                    }
                    m = m.next;
                }
                n = n.next;
            }
            return 0; 
        }

        public void addList(List<Integer> l) {
            for (Integer i : l) {
                this.appendToTail(i);
            }
        }

        public String toString() {
            Node n = this;
            StringBuffer buf = new StringBuffer();
            while(n != null) {
                if (n.next == null)
                    buf.append(n.data + "");
                else
                    buf.append(n.data + ",");
                n = n.next;
            }
            return buf.toString();
        }
        public void print() {
            Node n = this;
            while(n != null) {
                if (n.next == null)
                    System.out.format("%d", n.data);
                else
                    System.out.format("%d,", n.data);
                n = n.next;
            }
            System.out.println();
        }
    }

    public static void main(String args[]) {
        // single element
        Node n = new Node(0);
        assert n.toString().equals("0");
        n.removeDuplicate();
        assert n.toString().equals("0");

        // dups in head, mid, tail
        Integer[] array = {0,1,2,3,2,1};
        n.addList(Arrays.asList(array));
        assert n.toString().equals("0,0,1,2,3,2,1");
        n.removeDuplicate();
        assert n.toString().equals("0,1,2,3");

        // space = O(1)
        // single element
        n = new Node(0);
        assert n.toString().equals("0");
        n.removeDuplicate2();
        assert n.toString().equals("0");

        // dups in head, mid, tail
        n.addList(Arrays.asList(array));
        assert n.toString().equals("0,0,1,2,3,2,1");
        n.removeDuplicate2();
        assert n.toString().equals("0,1,2,3");
    }
}

