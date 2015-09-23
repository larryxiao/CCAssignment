/*********************************************************************************
*     File Name           :     Solution02.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-21 10:05]
*     Last Modified       :     [2015-09-21 10:22]
*     Description         :     Minimal Tree 
*********************************************************************************/

// http://www.lintcode.com/en/problem/convert-sorted-array-to-binary-search-tree-with-minimal-height/

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
public class Solution02 {
    public TreeNode helper(int[] A, int start, int end) {
        int length = end - start + 1;
        if (length == 3) {
            TreeNode root = new TreeNode(A[start + 1]);
            root.left = new TreeNode(A[start]);
            root.right = new TreeNode(A[end]);
            return root;
        }
        if (length == 2) {
            TreeNode root = new TreeNode(A[end]);
            root.left = new TreeNode(A[start]);
            return root;
        }
        if (length == 1) { // careful!
            TreeNode root = new TreeNode(A[start]);
            return root;
        }
        TreeNode root = new TreeNode(A[(start + end) / 2]);
        root.left = helper(A, start, (start + end) / 2 - 1);
        root.right = helper(A, (start + end) / 2 + 1, end);
        return root;
    }
    /**
     * @param A: an integer array
     * @return: a tree node
     */
    public TreeNode sortedArrayToBST(int[] A) {
        if (A.length == 0) // careful!
            return null;
        return helper(A, 0, A.length-1);
    }
}

