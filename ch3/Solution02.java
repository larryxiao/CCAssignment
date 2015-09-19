/*********************************************************************************
*     File Name           :     Solution02.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-18 09:13]
*     Last Modified       :     [2015-09-18 09:39]
*     Description         :     Stack Min 
**********************************************************************************/

import java.util.Stack;

public class Solution02
{
    public static class StackMin<T extends Comparable<? super T>> {
        Stack<T> dataStack = new Stack<T>();
        Stack<Integer> minPointer = new Stack<Integer>();
        T min = null;
        int minIdx = -1;

        public int push(T data) {
            if (min == null) {
                min = data;
                minIdx = 0;
                dataStack.push(data);
                minPointer.push(minIdx);
            } else {
                if (data.compareTo(min) < 0) {
                    min = data;
                    minIdx = dataStack.size();
                }
                dataStack.push(data);
                minPointer.push(minIdx);
            }
            return 0;
        } 

        public T pop() {
            T data;
            if (dataStack.size() > 0) {
                data = dataStack.pop();
                minPointer.pop();
                if (data == min) {
                    if (dataStack.size() == 0) {
                        min = null;
                        minIdx = -1;
                    } else {
                        minIdx = minPointer.peek();
                        min = dataStack.elementAt(minIdx);
                    }
                }
                return data;
            } else {
                return null;
            }
        }

        public T min() {
            if (minIdx == -1)
                return null;
            else
                return dataStack.elementAt(minIdx);
        }
    }

    public static void main(String [] args) {
        StackMin<Integer> foo = new StackMin<Integer>();
        foo.push(4);        
        assert foo.min() == 4; // [4]
        foo.push(3);
        assert foo.min() == 3; // [4 3]
        foo.push(4);
        assert foo.min() == 3; // [4 3 4]
        foo.pop();
        foo.pop();
        assert foo.min() == 4; // [4]
        foo.pop();
        assert foo.min() == null; // []
        foo.pop();
        assert foo.min() == null; // []
        foo.push(6);
        assert foo.min() == 6; // [6]
        foo.push(1);
        assert foo.min() == 1; // [6 1]
    }
}

