/*********************************************************************************
*     File Name           :     Solution03.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-21 10:21]
*     Last Modified       :     [2015-09-21 10:39]
*     Description         :     List of Depths 
*     Given a binary tree design an algorithm which creates a linked list of
*     all the nodes at each depth.
**********************************************************************************/

import java.util.LinkedList;
import java.util.Queue;

public class Solution03
{
    public static class TreeNode {
        public int val;
        public int depth;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    public void enqueueChild(Queue<TreeNode> toVisit, TreeNode node, int depth) {
        if (node != null) {
            node.depth = depth;
            toVisit.add(node);
        }
    }

    public LinkedList<LinkedList<TreeNode>> listOfDepths(TreeNode root) {
        // BFS
        Queue<TreeNode> toVisit = new LinkedList<TreeNode>();
        LinkedList<LinkedList<TreeNode>> ret = new
            LinkedList<LinkedList<TreeNode>>();
        if (root == null)
            return ret;
        root.depth = 0;
        toVisit.add(root);
        while (!toVisit.isEmpty()) {
            TreeNode current = toVisit.poll();
            // visit current node
            if (current.depth == ret.size()) {
                // first time we visit node at this depth
                // create list
                LinkedList<TreeNode> list = new LinkedList<TreeNode>();
                ret.add(list);
            }
            LinkedList<TreeNode> list = ret.get(current.depth);
            list.add(current);
            // add the child nodes to queue
            enqueueChild(toVisit, current.left, current.depth + 1);
            enqueueChild(toVisit, current.right, current.depth + 1);
        }
        return ret;
    }
    
    public static void main(String [] args) {
    }
}
