/*********************************************************************************
*     File Name           :     Solution11.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-22 22:32]
*     Last Modified       :     [2015-09-22 23:25]
*     Description         :     Random Node
*
*     You are implementing a binary tree class from scratch which, in addition
*     to insert, find, and delete, has a method getRandomNode() which returns a
*     random node from the tree. All nodes should be equally likely to be
*     chosen. Design and implement an algorithm for getRandomNode, and explain
*     how you would implement the rest of the methods. 
**********************************************************************************/

import java.util.*;

public class Solution11
{
    // a random binary tree class that uses array to store the binary tree
    // with fast getRandomNode, insert, and delete
    public static class RandomBinaryTree<T> {
        private ArrayList<T> data;

        public RandomBinaryTree() {
            data = new ArrayList<T>();
        }

        public RandomBinaryTree(ArrayList<T> d) {
            data = (ArrayList<T>) d.clone();
        }

        public Integer insert(T t) {
            data.add(t);
            return data.size()-1;
        }

        public T get(Integer idx) {
            return data.get(idx);
            // Throws IndexOutOfBoundsException
        }

        public T remove(Integer idx) {
            if (data.size() == 0) {
                return null;
            }   
            if (idx == data.size() - 1) {
                return data.remove(data.size() - 1);
            } else {
                T ret = data.get(data.size()-1);
                data.set(idx, ret);
                data.remove(data.size() - 1);
                return ret;
            }
        }

        public Integer find(T t) {
            return data.indexOf(t);
        }

        public T getRandomNode() {
            int range = data.size() - 1;
            int idx = (int) (Math.random() * range);
            return get(idx);
        }

        public Integer getParentIdx(Integer idx) {
            if (idx == 0)
                return -1;
            else
                return (idx-1) / 2;
        }

        public T getParent(Integer idx) {
            return get(getParentIdx(idx));
        }

        public Integer getLeftChildIdx(Integer idx) {
            return idx*2+1;
        }

        public T getLeftChild(Integer idx) {
            return get(getLeftChildIdx(idx));
        }

        public Integer getRightChildIdx(Integer idx) {
            return idx*2+2;
        }

        public T getRightChild(Integer idx) {
            return get(getRightChildIdx(idx));

        }
    }

    public static void main (String [] args)
    {
        ArrayList<Integer> test = new ArrayList<Integer>(
                Arrays.asList(1, 2, 3, 4, 5, 6));
        RandomBinaryTree<Integer> tree = new RandomBinaryTree<Integer>(test);
        Integer root = 0;
        for (int i = 0; i < 10; i++) {
            System.out.println(tree.getRandomNode());
        }
        assert tree.get(root) == 1;
        assert tree.getLeftChildIdx(root) == 1;
        assert tree.getRightChildIdx(root) == 2;
        assert tree.getLeftChild(root) == 2;
        assert tree.getRightChild(root) == 3;
   }
}

// design 0
// implement the binary tree in an array
// generate a random number x between 0 and number of nodes - 1, and
// return the element in array
//
// insert append to last in array
// delete replace the current node with the last node
// find is O(n)

// design 1
// implement the binary tree as a complete binary tree.
// generate a random number x between 0 and number of nodes - 1, and
// traverse the tree to get the xth node.
// 
// insert 
// delete replace the current node with the last node
// find is O(n)

// design 2
// implement a binary search tree in an array
// generate a random number x between 0 and number of nodes - 1, and
// return the element in array
//
// insert: follow the bst rule
// delete: follow the bst rule
// find is O(logn)
// * takes more space than design 0

// design x
// something to do with probability, but not simple
