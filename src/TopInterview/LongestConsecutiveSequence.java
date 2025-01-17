package TopInterview;

import java.util.HashSet;
import java.util.Set;

class LongestConsecutiveSequence {
    public static void main(String[] args) {
        int[] a = {100, 4, 200, 1, 3, 2};
        System.out.println(longestConsecutiveSequence(a));
    }

    /**
     * use a HashSet to add and remove elements. HashSet is implemented by using a hash table.
     * Elements are not ordered. The add, remove and contains methods have constant time complexity O(1).
     * 其实这个题看起来是数字处理，排序的问题，但是如果要达到好的时间复杂度，还得从图的角度来考虑。
     * 思路是把这些数字看成图的顶点，而边就是他相邻的数字，然后进行深度优先搜索。通俗一点说就是先把数字放到一个集合中，
     * 拿到一个数字，就往其两边搜索，得到包含这个数字的最长串，并且把用过的数字从集合中移除（因为连续的关系，一个数字不会出现在两个串中）。
     * 最后比较当前串是不是比当前最大串要长，是则更新。如此继续直到集合为空。如果我们用HashSet来存储数字，则可以认为访问时间是常量的，
     * 那么算法需要一次扫描来建立集合，第二次扫描来找出最长串，所以复杂度是O(2*n)=O(n)，空间复杂度是集合的大小，即O(n)
     * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.
     * Given [100, 4, 200, 1, 3, 2], The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.
     * Your algorithm should run in O(n) complexity.
     * Tags: Array, HashTable
     */
    public static int longestConsecutiveSequence(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        int max = 1;
        for (int e : num)
            set.add(e);
        for (int e : num) {
            int left = e - 1;
            int right = e + 1;
            int count = 1;
            while (set.contains(left)) {
                count++;
                set.remove(left);
                left--;
            }
            while (set.contains(right)) {
                count++;
                set.remove(right);
                right++;
            }
            max = Math.max(count, max);
        }
        return max;
    }
}
