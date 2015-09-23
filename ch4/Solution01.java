/*********************************************************************************
*     File Name           :     Solution01.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-21 09:54]
*     Last Modified       :     [2015-09-21 10:23]
*     Description         :     Route Between Nodes 
*********************************************************************************/

// http://www.lintcode.com/en/problem/route-between-two-nodes-in-graph/

/**
 * Definition for Directed graph.
 * class DirectedGraphNode {
 *     int label;
 *     ArrayList<DirectedGraphNode> neighbors;
 *     DirectedGraphNode(int x) {
 *         label = x;
 *         neighbors = new ArrayList<DirectedGraphNode>();
 *     }
 * };
 */
public class Solution01 {
   /**
     * @param graph: A list of Directed graph node
     * @param s: the starting Directed graph node
     * @param t: the terminal Directed graph node
     * @return: a boolean value
     */
    public boolean hasRoute(ArrayList<DirectedGraphNode> graph,
                            DirectedGraphNode s, DirectedGraphNode t) {
        // BFS
        Queue<DirectedGraphNode> toVisit = new LinkedList<DirectedGraphNode>();
        Set<DirectedGraphNode> visitedSet = new HashSet<DirectedGraphNode>();
        toVisit.add(s);
        while (!toVisit.isEmpty()) {
            // visit current node
            DirectedGraphNode current = toVisit.poll();
            visitedSet.add(current);
            if (current == t) {
                return true;
            }
            // (if not visited before) add adjacent nodes to queue
            for (DirectedGraphNode node : current.neighbors) {
                if (!visitedSet.contains(node)) {
                    toVisit.add(node);
                }
            }
        }
        return false;
    }
    // Follow ups:
    // 1. return the path
}
