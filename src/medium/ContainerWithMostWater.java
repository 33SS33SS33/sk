package medium;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two
 * endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together
 * with x-axis forms a container, such that the container contains the most
 * water.
 * <p/>
 * Note: You may not slant the container.
 * <p/>
 * Tags: Array, Two pointers
 */
class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] height = { 2, 4, 3, 2 };
        System.out.println(new ContainerWithMostWater().maxArea(height));
        System.out.println(new ContainerWithMostWater().maxAreaB(height));
        System.out.println(new ContainerWithMostWater().maxAreaC(height));
    }

    /**
     * 2 pointers, low and high
     * curArea = (high - low) * min(height[high], height[low])
     * maxArea = max(maxArea, curArea)
     * Move lower pointer towards center for the next loop
     * Stop when two pointers meet, cause one line can form a container
     * Different from block
     */
    public int maxArea(int[] height) {
        if (height == null || height.length == 0)
            return 0;
        int ans = 0;
        int low = 0, high = height.length - 1;
        while (low < high) { // note low < high, not <=
            // update answer
            ans = Math.max(ans, (high - low) * Math.min(height[low], height[high]));
            // move lower pointer towards center
            if (height[low] < height[high])
                low++;
            else
                high--;
        }
        return ans;
    }

    public int maxAreaB(int[] height) {
        if (height.length <= 1)
            return 0;
        int st = 0;
        int ed = height.length - 1;
        int max = Integer.MIN_VALUE;
        while (st < ed) {
            int current = Math.min(height[st], height[ed]) * (ed - st);
            if (current > max)
                max = current;
            if (height[st] <= height[ed]) {
                st++;
            } else {
                ed--;
            }
        }
        return max;
    }

    /**
     * creek
     */
    public int maxAreaC(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            max = Math.max(max, (right - left) * Math.min(height[left], height[right]));
            if (height[left] < height[right])
                left++;
            else
                right--;
        }
        return max;
    }

}
