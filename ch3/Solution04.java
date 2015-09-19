/*********************************************************************************
*     File Name           :     Solution04.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-18 15:31]
*     Last Modified       :     [2015-09-18 15:38]
*     Description         :     Queue via Stack 
**********************************************************************************/

import java.util.Stack;

public class Solution04
{
    public static class MyQueue<T> {
        Stack<T> data, helper;
        public MyQueue() {
            data = new Stack<T>();
            helper = new Stack<T>();
        }

        public boolean add(T item) {
            data.push(item);
            return true;
        }

        public T poll() {
            T ret = null;
            if (data.isEmpty())
                return null;
            while(! data.isEmpty()) {
                T tmp = data.pop();
                helper.push(tmp);
            }
            ret = helper.pop();
            while(! helper.isEmpty()) {
                T tmp = helper.pop();
                data.push(tmp);
            }
            return ret;
        }
    }

    // improvement: use two staks in turn
}

