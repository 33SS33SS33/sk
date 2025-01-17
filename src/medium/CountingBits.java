package medium;

/**
 * Created by shanshan on 16/6/17.
 * Follow up:
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */

public class CountingBits {
    public static void main(String[] args) {
        int[] res = countBits(5);
        for (int i = 0; i < res.length; i++) {

            System.out.print(res[i] + ",");
        }
    }

    /**
     * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
     * calculate the number of 1's in their binary representation and return them as an array.
     * For num = 5 you should return [0,1,1,2,1,2].
     */
    public static int[] countBits(int num) {
        int[] f = new int[num + 1];
        for (int i = 1; i <= num; i++)
            f[i] = f[i >> 1] + (i & 1);
        return f;
    }

}
