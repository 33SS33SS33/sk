package hard;

/**
 * "Given two arrays of length m and n with digits 0-9 representing two numbers.
 * Create the maximum number of length k <= m + n from digits of the two.
 * The relative order of the digits from the same array must be preserved.
 * Return an array of the k digits. You should try to optimize your time and space complexity.
 * Example 1:
 * nums1 = [3, 4, 6, 5]
 * nums2 = [9, 1, 2, 5, 8, 3]
 * k = 5
 * return [9, 8, 6, 5, 3]"
 * Example 2:
 * nums1 = [6, 7]
 * nums2 = [6, 0, 4]
 * k = 5
 * return [6, 7, 6, 0, 4]
 * Example 3:
 * nums1 = [3, 9]
 * nums2 = [8, 9]
 * k = 3
 * return [9, 8, 9]
 * 问题可以转化为这样的两个子问题：
 * 1. 从数组nums中挑选出t个数，在保持元素相对顺序不变的情况下，使得选出的子数组最大化。
 * 2. 在保持元素相对顺序不变的前提下，将数组nums1与数组nums2合并，使合并后的数组最大化。
 * Prep是用来解决第1个子问题  merge用来解决第2个子问题 解法可以看第二个链接
 * python是可以直接比较两个数组的大小的
 * https://leetcode.com/discuss/75756/share-my-greedy-solution
 * http://algobox.org/2015/12/24/create-maximum-number/
 * Many of the posts have the same algorithm. In short we can first solve 2 simpler problem
 * Create the maximum number of one array
 * Create the maximum number of two array using all of their digits.
 * For an long and detailed explanation see my blog here.
 * The algorithm is O((m+n)^3) in the worst case. It runs in 22 ms. 贪心算法
 */
public class CreateMaximumNumber {
    public static void main(String[] args) {
        int[] nums1 = {3, 4, 6, 5};
        int[] nums2 = {9, 1, 2, 5, 8, 3};
        int[] res = new CreateMaximumNumber().maxNumber(nums1, nums2, 5);
        for (int i : res) {
            System.out.print(i + ",");
        }
    }

    public int[] maxNumber(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        int m = nums2.length;
        int[] ans = new int[k];
        for (int i = Math.max(0, k - m); i <= k && i <= n; ++i) {
            int[] candidate = merge(maxArray(nums1, i), maxArray(nums2, k - i), k);
            if (greater(candidate, 0, ans, 0))
                ans = candidate;
        }
        return ans;
    }

    private int[] merge(int[] nums1, int[] nums2, int k) {
        int[] ans = new int[k];
        for (int i = 0, j = 0, r = 0; r < k; ++r)
            ans[r] = greater(nums1, i, nums2, j) ? nums1[i++] : nums2[j++];
        return ans;
    }

    public boolean greater(int[] nums1, int i, int[] nums2, int j) {
        while (i < nums1.length && j < nums2.length && nums1[i] == nums2[j]) {
            i++;
            j++;
        }
        return j == nums2.length || (i < nums1.length && nums1[i] > nums2[j]);
    }

    public int[] maxArray(int[] nums, int k) {
        int n = nums.length;
        int[] ans = new int[k];
        for (int i = 0, j = 0; i < n; ++i) {
            while (n - i + j > k && j > 0 && ans[j - 1] < nums[i])
                j--;
            if (j < k)
                ans[j++] = nums[i];
        }
        return ans;
    }

}
