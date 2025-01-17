package medium;

/**
 * Created by shanshan on 16/6/18.
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10n.
 * Example:
 * Given n = 2, return 91. (The answer should be the total numbers
 * in the range of 0 ≤ x < 100, excluding [11,22,33,44,55,66,77,88,99])
 */

public class CountNumberswithUniqueDigits {
    public static void main(String[] args) {
        System.out.println(countNumbersWithUniqueDigits(2));
    }

    //https://discuss.leetcode.com/topic/47983/java-dp-o-1-solution
    public static int countNumbersWithUniqueDigits(int n) {
        if (n == 0)
            return 1;
        int res = 10;
        int uniqueDigits = 9;
        int availableNumber = 9;
        while (n-- > 1 && availableNumber > 0) {
            uniqueDigits = uniqueDigits * availableNumber;
            res += uniqueDigits;
            availableNumber--;
        }
        return res;
    }

}
