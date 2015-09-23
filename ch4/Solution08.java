/*********************************************************************************
*     File Name           :     Solution08.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-21 19:53]
*     Last Modified       :     [2015-09-22 16:10]
*     Description         :     First Common Ancestor 
*
*     Design an algorithm and write code to find the first common ancestor of
*     two nodes in a binary tree. Avoid storing additional nodes in a data
*     structure. NOTE: This is not necessarily a binary search tree. 
*
*     http://www.lintcode.com/en/problem/lowest-common-ancestor/
*     http://www.geeksforgeeks.org/lowest-common-ancestor-binary-tree-set-1/
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

public class Solution08 {
    // find and build the path for given node A from root
    public boolean findPath(TreeNode root, LinkedList<TreeNode> path, TreeNode A) {
        if (root == null)
            return false;
            
        path.add(root);
        
        // if A is found
        if (root == A)
            return true;
        
        // check if child exist, then find A in subtree
        if ((root.left != null && findPath(root.left, path, A)) 
        || (root.right != null && findPath(root.right, path, A)))
            return true;
        
        // the subtree of this node doesn't contain node A
        path.removeLast();
        
        return false;
    }
    /**
     * @param root: The root of the binary search tree.
     * @param A and B: two nodes in a Binary.
     * @return: Return the least common ancestor(LCA) of the two nodes.
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode A, TreeNode B) {
        LinkedList<TreeNode> pathA = new LinkedList<TreeNode>();
        LinkedList<TreeNode> pathB = new LinkedList<TreeNode>();
        
        // find the path of A and B, if not found then no answer
        if (!findPath(root, pathA, A) || !findPath(root, pathB, B))
            return null;
        
        // check the path and find the diverged node
        int i;
        for (i = 0; i < pathA.size() && i < pathB.size(); i++)
            if (pathA.get(i) != pathB.get(i))
                break;
        return pathA.get(i-1);
    }
}
