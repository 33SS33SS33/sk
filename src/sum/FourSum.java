package sum;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by GAOSHANSHAN835 on 2016/1/12.
 * Given an array S of n integers, are there elements a, b, c, and d in S such
 * that a + b + c + d = target? Find all unique quadruplets in the array which
 * gives the sum of target.
 * Note:
 * Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤
 * b ≤ c ≤ d)
 * The solution set must not contain duplicate quadruplets.
 * For example, given array S = {1 0 -1 0 -2 2}, and target = 0.
 * A solution set is:
 * (-1,  0, 0, 1)
 * (-2, -1, 1, 2)
 * (-2,  0, 0, 2)
 * Tags: Array, HashTable, Two pointers
 */
public class FourSum {
    public static void main(String[] args) {
        int[] num = {1, 0, -1, 0, -2, 2};
        System.out.println(new FourSum().fourSum(num, 0).toString());
    }

    /**
     * 最好的
     * Four pointers, O(n^3) time
     * First pointer i starts from 1 to num.length - 4, 3 indices remain
     * Second pointer j starts from i + 1 to num.length - 3, 2 indices remain
     * Then get newTarget and search from both ends of the remaining numbers
     * Skip duplicate every time
     * http://blog.csdn.net/linhuanmars/article/details/24826871
     */
    public List<List<Integer>> fourSum(int[] num, int target) {
        ArrayList<List<Integer>> ans = new ArrayList<List<Integer>>();
        if (num == null || num.length < 4)
            return ans;
        Arrays.sort(num);
        for (int i = 0; i < num.length - 3; i++) {
            if (i > 0 && num[i] == num[i - 1])
                continue;
            for (int j = i + 1; j < num.length - 2; j++) {
                if (j > i + 1 && num[j] == num[j - 1])
                    continue;
                int low = j + 1, high = num.length - 1;
                while (low < high) {
                    int sum = num[i] + num[j] + num[low] + num[high];
                    if (sum == target) {
                        ans.add(Arrays.asList(num[i], num[j], num[low], num[high]));
                        while (low < high && num[low] == num[low + 1])
                            low++;
                        while (low < high && num[high] == num[high - 1])
                            high--;
                        low++;
                        high--;
                    } else if (sum < target)
                        low++;
                    else
                        high--;
                }
            }
        }
        return ans;
    }

}
