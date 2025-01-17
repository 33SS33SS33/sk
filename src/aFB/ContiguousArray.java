package aFB;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by krystal on 5/4/17.
 * Given a binary array, find the maximum length of a contiguous subarray with equal number of 0 and 1.
 * Input: [0,1]
 * Output: 2
 * Explanation: [0, 1] is the longest contiguous subarray with equal number of 0 and 1.
 * Input: [0,1,0]
 * Output: 2
 * Explanation: [0, 1] (or [1, 0]) is a longest contiguous subarray with equal number of 0 and 1.
 * Similar idea to solve LC 325 : Maximum Size Subarray Sum Equals k
 */

public class ContiguousArray {
    public static void main(String[] args) {
        int[] prices = {1, 3, 2};
        System.out.println(ContiguousArray(prices));
    }

    /**
     * The idea is to change 0 in the original array to -1. Thus, if we find SUM[i, j] == 0
     * then we know there are even number of -1 and 1 between index i and j.
     * Also put the sum to index mapping to a HashMap to make search faster.
     */
    public static int ContiguousArray(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0)
                nums[i] = -1;
        }
        Map<Integer, Integer> sumToIndex = new HashMap<>();
        sumToIndex.put(0, -1);//
        int sum = 0, max = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumToIndex.containsKey(sum)) {
                max = Math.max(max, i - sumToIndex.get(sum));
            } else {
                sumToIndex.put(sum, i);
            }
        }
        return max;
    }

}
