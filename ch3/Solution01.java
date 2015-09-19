/*********************************************************************************
*     File Name           :     Solution01.java
*     Created By          :     xiaodi
*     Creation Date       :     [2015-09-18 08:37]
*     Last Modified       :     [2015-09-18 09:39]
*     Description         :     Three in One 
**********************************************************************************/

public class Solution01
{
    public static class ThreeInOneStack {
        int[] container;
        int[] ptr = new int[3];
        int[] max = new int[3];
        int[] offset = new int[3];
        int maxIdx = 0;
        
        public ThreeInOneStack(int size) {
            if (size < 3)
                size = 3;
            container = new int[size];
            ptr[0] = 0;
            ptr[1] = 0;
            ptr[2] = 0;
            offset[0] = 0;
            offset[1] = size/3;
            offset[2] = size/3*2;
            max[0] = size/3-1;
            max[1] = size/3*2-1;
            max[2] = size-1;
            maxIdx = size/3 - 1;
        }

        public int push(int stack, int data) {
            if (ptr[stack] <= maxIdx) {
                container[ptr[stack]++ + offset[stack]] = data;
                return 0;
            }
            return -1; // error: no space left for stack
        }

        public int pop(int stack, Integer data) {
            if (ptr[stack] > 0) {
                data = container[ptr[stack-1]-- + offset[stack]];
                return 0;
            }
            return -1; // error: no element in stack
        }

        public int peak(int stack, Integer data) {
            if (ptr[stack] > 0) {
                data = container[ptr[stack-1] + offset[stack]];
                return 0;
            }
            return -1; // error: no element in stack
        }

        // test cases
        // 0. push till one stack is full, check data integrity on all stacks
        // 1. pop on empty stack

        // improvement: resize if the stack can't hold the data
    }
}


