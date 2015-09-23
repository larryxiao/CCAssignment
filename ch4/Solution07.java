/*********************************************************************************
 *     File Name           :     Solution07.java
 *     Created By          :     xiaodi
 *     Creation Date       :     [2015-09-21 19:21]
 *     Last Modified       :     [2015-09-21 19:52]
 *     Description         :     Build Order
 *
 *     You are given a list of projects and a list of dependencies (which is a
 *     list of pairs of projects, where the first project is dependent on the
 *     second project). All of a project's dependencies must be built before the
 *     project is. Find a build order that will allow the projects to be build.
 *     If there is no valid build order, return an error. 
 **********************************************************************************/

import java.util.*;


public class Solution07
{
    // Definition of DirectedGraphNode (DependencyGraphNode):
    public static class DirectedGraphNode {
        public String name;
        public LinkedList<DirectedGraphNode> dependencies;
        public DirectedGraphNode(String name) {
            this.name = name;
            this.dependencies = new LinkedList<DirectedGraphNode>();
        }
    }
    private static StringBuffer result;
    private void buildProject(Set<DirectedGraphNode> finished, 
            DirectedGraphNode Node) {
        result.append(Node.name + " ");
        finished.add(Node);
    }

    private boolean buildDependencies(DirectedGraphNode node, 
            Set<DirectedGraphNode> finished,
            Set<DirectedGraphNode> visited) {
        // if there's no more dependency, build the project
        if (node.dependencies.size() == 0) {
            buildProject(finished, node);
            finished.add(node);
            return true;
        }
        // if there's a loop, then there's no solution
        if (visited.contains(node))
            return false;
        visited.add(node);
        // build each dependency
        for (DirectedGraphNode dependency : node.dependencies) {
            boolean ret = buildDependencies(dependency, finished, visited);
            if (!ret)
                return false;
        }
        return true;
    }

    // nodes stores all the projects
    public void buildOrder(LinkedList<DirectedGraphNode> nodes) {
        result = new StringBuffer();
        boolean validSolutionExist = true;
        Set<DirectedGraphNode> finished = new HashSet<DirectedGraphNode>();
        for (DirectedGraphNode node : nodes) {
            if (!finished.contains(node)) {
                validSolutionExist = buildDependencies(node, finished, 
                        new HashSet<DirectedGraphNode>());
                if (!validSolutionExist)
                    break;
            }
        }
        if (validSolutionExist)
            System.out.println(result.toString());
        else
            System.out.println("no valid result");
    }
}

