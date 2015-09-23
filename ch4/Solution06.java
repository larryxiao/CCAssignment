/*********************************************************************************
*     File Name           :     Solution06.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-21 15:22]
*     Last Modified       :     [2015-09-21 19:21]
*     Description         :     Successor  
*
*     Write an algorithm to find the "next" node (i.e., in-order successor) of
*     a given node in a binary serach tree. You may assume that each node has a
*     link to its parent.
**********************************************************************************/

public class Solution06
{
    public static class TreeNode {
        public int val;
        public int depth;
        public TreeNode left, right, parent;
        public TreeNode(int val) {
            this.val = val;
            this.parent = this.left = this.right = null;
        }
    }

    public TreeNode leftMostChild(TreeNode node) {
        if (node == null)
            return null;
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }

    public TreeNode successor(TreeNode node) {
        if (node == null)
            return null;
        // if has right child, go to the left most child of the right child
        if (node.right != null)
            return leftMostChild(node.right);
        // if doesn't have right child
        // 1. if it is the left child, return parent
        if (node == node.parent.left)
            return node.parent;
        // 2. if it is the right child, return the parent of the node that is
        // not a right child
        while (node.parent != null && node.parent != node.parent.left)
            node = node.parent;
        return node.parent;
    }
}

