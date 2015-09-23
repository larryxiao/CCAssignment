/*********************************************************************************
*     File Name           :     Solution04.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-21 10:39]
*     Last Modified       :     [2015-09-21 14:37]
*     Description         :     Check Balanced
*     Implement a function to check if a binary tree is balanced. For the
*     purposes of this question, a balanced tree is defined to be a tree such
*     that the heights of the two subtrees of any node never differ by more
*     than one. 
*     
*     http://www.lintcode.com/en/problem/balanced-binary-tree/
**********************************************************************************/

/**
 * Definition of TreeNode:
 * public class TreeNode {
 *     public int val;
 *     public TreeNode left, right;
 *     public TreeNode(int val) {
 *         this.val = val;
 *         this.left = this.right = null;
 *     }
 * }
 */
public class Solution04 {
    public int helper(TreeNode root) {
        if (root == null)
            return 0;
        // check left child
        int heightLeft = helper(root.left);
        if (heightLeft == -1)
            return -1;
        // check right child
        int heightRight = helper(root.right);
        if (heightRight == -1)
            return -1;
        // compare height of two children
        if (Math.abs(heightLeft - heightRight) > 1)
            return -1;
        return Math.max(heightLeft, heightRight) + 1;
    }
    /**
     * @param root: The root of binary tree.
     * @return: True if this Binary tree is Balanced, or false.
     */
    public boolean isBalanced(TreeNode root) {
        return helper(root) != -1;
    }
}
