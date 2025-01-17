package medium;

/**
 * Given a range [m, n] where 0 <= m <= n <= 2147483647, return the bitwise AND of all numbers in this range, inclusive
 * 如果两个数字在某个范围 其实总会有左半边的数字是相同的 这道题其实就是求出来这些相同的部分 比如 11200--- 11456
 * 其实就是要找出来11000(因为只有这两位是相同 所以相与才会有1)
 * 循环里就是找出来要到这个相同的部分 一共需要移动几位
 * 当m和n相等时候 就是两个数现在都只有公共部分(m=11 n=11)  需要把小的n右移回去 就是结果
 */
public class BitwiseANDofNumbersRange {
    public static void main(String[] args) {
        System.out.println(rangeBitwiseAndB(5, 7));
        System.out.print(rangeBitwiseAndB(2, 3));
    }

    /**
     * creek
     */
    public static int rangeBitwiseAndB(int m, int n) {
        while (n > m) {
            n = n & n - 1;
        }
        return m & n;
    }

}
