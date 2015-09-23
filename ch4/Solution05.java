/*********************************************************************************
*     File Name           :     Solution05.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-21 14:37]
*     Last Modified       :     [2015-09-21 15:22]
*     Description         :     Validate BST 
*
*     http://www.lintcode.com/en/problem/validate-binary-search-tree/
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
public class Solution05 {
    /**
     * @param root: The root of binary tree.
     * @return: True if the binary tree is BST, or false
     */
    public boolean isValidBST(TreeNode root) {
        return helper(root, -Float.MAX_VALUE, Float.MAX_VALUE);
    }
    
    public boolean helper(TreeNode root, Float min, Float max) {
        if (root == null) return true;
        if (root.val <= min || root.val >= max) return false;
        if (!helper(root.left, min, (float) root.val) ||
            !helper(root.right, (float) root.val, max))
            return false;
        return true;
    }
}

// improvement 
// 1. can't avoid the problem of data containing MIN or MAX, can use a custom value type for node value. or need extra code to take care of the special case. it's easier to limit the input data range.
