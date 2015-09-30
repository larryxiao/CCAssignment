/*********************************************************************************
*     File Name           :     Solution10.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-29 20:21]
*     Last Modified       :     [2015-09-29 22:23]
*     Description         :     Rank from Stream 
*
*     Imagine you are reading in a stream of integers. Periodically, you wish
*     to be able to look up the rank of a number x (the number of values less
*     that or equal to x). Implement the data structures and algorithms to
*     support these operations. That is, implement the method track(int x),
*     which is called when each number is generated, and the method of
*     getRankofNumber(int x), which returns the number of values less than or
*     equal to x (not including x itself). 
*
*     0. use linked list to track rank
*     1. use BST to track rank
**********************************************************************************/

public class Solution10
{
    public static class RankNode {
        int left_rank = 0;
        RankNode left, right;
        int data = 0;
        public RankNode(int d) {
            data = d;
        }
        public void insert(int d) {
            if (d <= data) {
                if (left != null) left.insert(d);
                else left = new RankNode(d);
                left_rank++;
            } else {
                if (right != null) right.insert(d);
                else right = new RankNode(d);
            }
        }
        public int getRank(int d) {
            if (d == data) {
                return left_rank;
            } else if (d < data) {
                return left == null ? -1 : left.getRank(d);
            } else {
                int right_rank = right == null ? -1 : right.getRank(d);
                if (right_rank == -1) return -1;
                else return left_rank + 1 + right_rank;
            }
        }
    }

    RankNode root = null;
    void track(int number) {
        if (root == null) {
            root = new RankNode(number);
        } else {
           root.insert(number); 
        }
    }

    int getRankofNumber(int number) {
        if (root == null)
            return -1;
        return root.getRank(number);
    }

    public static void main (String [] args)
    {
        Solution10 foo = new Solution10();
        foo.track(8);
        assert foo.getRankofNumber(1) == -1;
        foo.track(2);
        assert foo.getRankofNumber(2) == 0;
        foo.track(2);
        foo.track(3);
        assert foo.getRankofNumber(3) == 2;
        foo.track(9);
        foo.track(10);
        foo.track(12);
        foo.track(11);
        assert foo.getRankofNumber(8) == 3;
        assert foo.getRankofNumber(12) == 7;
    }
}

