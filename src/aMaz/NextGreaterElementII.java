package aMaz;

import java.util.Arrays;
import java.util.Stack;

/**
 * Created by shanshan on 2/7/19.
 */
public class NextGreaterElementII {
    /**
     * Given a circular array (the next element of the last element is the first element of the array),
     * print the Next Greater Number for every element.
     * The Next Greater Number of a number x is the first greater number to
     * its traversing-order next in the array,
     * which means you could search circularly to find its next greater number.
     * If it doesn't exist, output -1 for this number.
     * Input: [1,2,1] Output: [2,-1,2]
     * Explanation: The first 1's next greater number is 2;
     * The number 2 can't find next greater number;
     * The second 1's next greater number needs to search circularly, which is also 2.
     * Note: The length of given array won't exceed 10000. 可以循环查找
     */
    public int[] nextGreaterElementsII(int[] nums) {
        int n = nums.length, next[] = new int[n];
        Arrays.fill(next, -1);
        Stack<Integer> stack = new Stack<>(); // index stack
        for (int i = 0; i < n * 2; i++) {
            int num = nums[i % n];
            while (!stack.isEmpty() && nums[stack.peek()] < num)
                next[stack.pop()] = num;
            if (i < n) stack.push(i);
        }
        return next;
    }
}
