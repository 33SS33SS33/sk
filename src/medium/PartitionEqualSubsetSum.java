package medium;

/**
 * Created by shanshan on 7/1/17.
 */
public class PartitionEqualSubsetSum {
    //https://discuss.leetcode.com/topic/62312/java-solution-similar-to-backpack-problem-easy-to-understand


    /**
     * Given a non-empty array containing only positive integers, find if the array can
     * be partitioned into two subsets such that the sum of elements in both subsets is equal.
     * Note:Each of the array element will not exceed 100.The array size will not exceed 200.
     * Input: [1, 5, 11, 5] Output: true Explanation: The array can be partitioned as [1, 5, 5] and [11].
     */
    public boolean partitionEqualSubsetSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return true;
        }
        int volumn = 0;
        for (int num : nums) {
            volumn += num;
        }
        if (volumn % 2 != 0) {
            return false;
        }
        volumn /= 2;
        // dp def
        boolean[] dp = new boolean[volumn + 1];
        // dp init
        dp[0] = true;
        // dp transition
        for (int i = 1; i <= nums.length; i++) {
            for (int j = volumn; j >= nums[i - 1]; j--) {
                dp[j] = dp[j] || dp[j - nums[i - 1]];
            }
        }
        return dp[volumn];
    }
}
