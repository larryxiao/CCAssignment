/*********************************************************************************
*     File Name           :     Solution09.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-22 16:11]
*     Last Modified       :     [2015-09-22 21:37]
*     Description         :     BST Sequences 
*
*     A binary search tree was created by traversing through an array from left
*     to right and inserting each element. Given a binary search tree with
*     distinct elements, print all possible arrays that could have led to this
*     tree. 
*
*     * The array is organized as the layers of the tree, upper layer comes
*     before lower layer. What if it is not, so you follow through the array to
*     construct the BST. eg. 531879 -> 5;3,8;1,#,7,9; as the description
*     literally means.
**********************************************************************************/

import java.util.*;

// the solution searches all the
public class Solution09
{
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public ArrayList<LinkedList<Integer>> BSTSequences(TreeNode root) {
        ArrayList<LinkedList<Integer>> result = new ArrayList<LinkedList<Integer>>();
        if (root == null) {
            result.add(new LinkedList<Integer>());
            return result;
        }

        // root is the prefix of all permutations of children
        LinkedList<Integer> prefix = new LinkedList<Integer>();
        prefix.add(root.val);

        // get left and right sequences
        ArrayList<LinkedList<Integer>> sequencesLeft = BSTSequences(root.left);
        ArrayList<LinkedList<Integer>> sequencesRight = BSTSequences(root.right);

        // combine the two sequences
        // {left; children of left}, {right; children of right}
        for (LinkedList<Integer> left : sequencesLeft) {
            for (LinkedList<Integer> right : sequencesRight) {
                ArrayList<LinkedList<Integer>> weaved = 
                    new ArrayList<LinkedList<Integer>>();
                weave(left, right, prefix, weaved);
                result.addAll(weaved);
            }
        }
        return result;
    }

    // weave the left and right list
    // keeping the sequences of the left or right list
    public void weave(LinkedList<Integer> left ,
            LinkedList<Integer> right, LinkedList<Integer> prefix,
            ArrayList<LinkedList<Integer>> results) {
        // when one list is consumed, can add rest of another list to result 
        if (left.size() == 0 || right.size() == 0) {
            LinkedList<Integer> result = (LinkedList<Integer>) prefix.clone();
            result.addAll(right);
            result.addAll(left);
            results.add(result);
            return;
        }

        // left
        int head;
        head = left.removeFirst();
        prefix.addLast(head);
        weave(left, right, prefix, results);
        prefix.removeLast();
        left.addFirst(head);

        // right
        head = right.removeFirst();
        prefix.addLast(head);
        weave(left, right, prefix, results);
        prefix.removeLast();
        right.addFirst(head);
    }

    public static void main(String [] args) {
        Solution09 foo = new Solution09();

        TreeNode root = new TreeNode(5);
        TreeNode l11 = new TreeNode(3);
        TreeNode l12 = new TreeNode(8);
        TreeNode l21 = new TreeNode(1);
        TreeNode l22 = null;
        TreeNode l23 = new TreeNode(7);
        TreeNode l24 = new TreeNode(9);
        // 5;3,8
        System.out.println("5; 3,8");
        root.left = l11;
        root.right = l12;

        ArrayList<LinkedList<Integer>> ret;
        ret = foo.BSTSequences(root);
        for (LinkedList<Integer> list : ret) {
            for (Integer i : list) {
                System.out.format("%d ", i);
            }
            System.out.println();
        }

        // 5;3,8;1,#,7,9;
        System.out.println("5; 3,8; 1,#,7,9");
        l11.left = l21;
        l11.right = l22;
        l12.left = l23;
        l12.right = l24;

        ret = foo.BSTSequences(root);
        for (LinkedList<Integer> list : ret) {
            for (Integer i : list) {
                System.out.format("%d ", i);
            }
            System.out.println();
        }
    }

}

