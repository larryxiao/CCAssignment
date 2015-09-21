/*********************************************************************************
*     File Name           :     Solution03.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-18 09:38]
*     Last Modified       :     [2015-09-19 15:46]
*     Description         :     Stack of Plates 
**********************************************************************************/

import java.util.ArrayList;
import java.util.Stack;

public class Solution03
{
    public static class SetOfStacks<T> {
        int threshold;
        ArrayList<Stack<T>> stacks;

        public SetOfStacks(int threshold) {
            stacks = new ArrayList<Stack<T>>();
            this.threshold = threshold;
            Stack<T> stack = new Stack<T>();
            stacks.add(stack);
        }

        public T push(T item) {
            T ret;
            if (stacks.size() == 0) {
                Stack<T> stack = new Stack<T>();
                stacks.add(stack);
            }

            Stack<T> tailStack = stacks.get(stacks.size()-1);
            ret = tailStack.push(item);
            if (tailStack.size() == threshold) {
                Stack<T> stack = new Stack<T>();
                stacks.add(stack);
            }
            return ret;
        }

        public T pop() {
            T ret;
            if (stacks.size() == 0)
                return null;
            Stack<T> tailStack = stacks.get(stacks.size()-1);
            ret = tailStack.pop();
            if (tailStack.size() == 0) {
                stacks.remove(stacks.size()-1);
            }
            return ret;
        }

        public T popAt(int index) {
            T ret;
            if (index > stacks.size()-1)
                return null;
            Stack<T> stack = stacks.get(index);
            ret = stack.pop();
            if (stack.size() == 0) {
                stacks.remove(index);
            }
            return ret;
        }

        public void print() {
            for (Stack<T> stack : stacks) {
                for (T t : stack) {
                    System.out.println(t);
                }
                System.out.println();
            }
        }
    }

    public static void main(String [] args) {
        SetOfStacks<Integer> foo = new SetOfStacks<Integer>(3);
        foo.push(1);
        foo.push(1);
        foo.push(1);
        foo.push(2);
        foo.push(2);
        assert foo.popAt(0) == 1; // [1,1,1; 2,2]
        assert foo.pop() == 2; // [1,1; 2,2]
        assert foo.pop() == 2; // [1,1; 2]
        assert foo.pop() == 1; // [1,1]
        assert foo.pop() == 1; // [1]
        assert foo.pop() == null; // []
        assert foo.popAt(3) == null; // []

        foo.push(1);
        foo.push(1);
        foo.push(1);
        foo.push(2);
        foo.push(2);
        assert foo.popAt(0) == 1; // [1,1,1; 2,2]
        assert foo.popAt(0) == 1; // [1,1; 2,2]
        assert foo.popAt(0) == 1; // [1; 2,2]
        assert foo.popAt(0) == 2; // [2,2]
    }
}

// variation 1:
// rollover the items to make sure previous stacks are full
//
