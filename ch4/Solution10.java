/*********************************************************************************
*     File Name           :     Solution10.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-22 22:11]
*     Last Modified       :     [2015-09-22 22:32]
*     Description         :     Check Subtree
*
*     T1 and T2 are two very large binary trees, with T1 much bigger than T2.
*     Create an algorithm to determine if T2 is a subtree of T1. A tree T2 is a
*     ubstree of T1 if there exists a node n in T1 such that the subtree of n
*     is identical to T2. That is, if you cut off the tree at node n, the two
*     trees would be identical. 
*
*     http://www.lintcode.com/en/problem/subtree/
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

public class Solution10 {
    // if the trees are smaller, can check the pre-order and in-order traversal
    /**
     * @param T1, T2: The roots of binary tree.
     * @return: True if T2 is a subtree of T1, or false.
     */
    public boolean isSubtree(TreeNode T1, TreeNode T2) {
        if (T2 == null) {
            return true;
        }
        return subTree(T1, T2);
    }

    public boolean subTree(TreeNode T1, TreeNode T2) {
        if (T1 == null) {
            return false;
        } else if (T1.val == T2.val && checkSubtree(T1, T2)) {
            // if there's a match, then check subtree to see if they are same
            return true;
        }
        // search down T1 and match T2
        return subTree(T1.left, T2) || subTree(T1.right, T2);
    }

    public boolean checkSubtree(TreeNode A, TreeNode B) {
        if (A == null && B == null) {
            return true;
        } else if (A == null || B == null) {
            return false;
        }
        return A.val == B.val
            && checkSubtree(A.left, B.left)
            && checkSubtree(A.right, B.right);
    }
}
