/*********************************************************************************
*     File Name           :     Solution12.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-23 10:07]
*     Last Modified       :     [2015-09-23 10:37]
*     Description         :     Paths with Sum
*
*     You are given a binary tree in which each node contains an integer value
*     (which might be positive or negative). Design an algorithm to count the
*     number of paths that sum to a given value. The path does not need to
*     start or end at the root or a leaf, but it must go downwards (traveling
*     only from parent nodes to child nodes) 
*
*     Related:
*     https://leetcode.com/problems/path-sum/
*     https://leetcode.com/problems/path-sum-ii/
*     (record the paths)
**********************************************************************************/

public class Solution12
{
    public static class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public int pathsWithSum(TreeNode root, int targetSum) {
        if (root == null) return 0;

        int pathsFromRoot = pathsWithSumFromNode(root, targetSum, 0);
        int pathsFromLeftChild = pathsWithSum(root.left, targetSum);
        int pathsFromRightChild = pathsWithSum(root.right, targetSum);

        return pathsFromRoot + pathsFromLeftChild + pathsFromRightChild;
    }

    public int pathsWithSumFromNode(TreeNode root, int targetSum, int currentSum) {
        if (root == null) return 0;
        int result = 0;

        currentSum += root.val;
        if (currentSum == targetSum) result++;

        int pathsFromLeftChild = pathsWithSumFromNode(root.left, targetSum,
                currentSum);
        int pathsFromRightChild = pathsWithSumFromNode(root.right, targetSum,
                currentSum);

        result += pathsFromLeftChild + pathsFromRightChild;
        return result;
    }

    public static void main (String [] args)
    {
        Solution12 foo = new Solution12();

        TreeNode root = new TreeNode(2);
        TreeNode l11 = new TreeNode(1);
        TreeNode l12 = new TreeNode(3);
        TreeNode l21 = new TreeNode(-1);
        TreeNode l22 = null;
        TreeNode l23 = new TreeNode(-1);
        TreeNode l24 = new TreeNode(0);
        TreeNode l31 = new TreeNode(1);
        TreeNode l32 = new TreeNode(1);
        // 2;1,3;-1,#,-1,0; 1 1
        root.left = l11;
        root.right = l12;
        l11.left = l21;
        l11.right = l22;
        l12.left = l23;
        l12.right = l24;
        l21.left = l31;
        l21.right = l32;

        assert foo.pathsWithSum(root, 3) == 5;

    }
}
