package aMaz;


class NumberOf1Bits {
    public static void main(String[] args) {
        NumberOf1Bits nob = new NumberOf1Bits();
        int n = 111;
        System.out.println(nob.numberOf1Bits(n));
    }

    /**
     * Write a function that takes an unsigned integer and returns the number of
     * ’1' bits it has (also known as the Hamming weight).
     * For example, the 32-bit integer '11' has binary representation
     * 00000000000000000000000000001011, so the function should return 3.
     * Tags: Bit Manipulation
     * "n &= n - 1" is used to delete the right "1" of n,Stop when all 1s are deleted and n is zero
     */
    public int numberOf1Bits(int n) {
        int res = 0;
        while (n != 0) {
            res++;
            n &= n - 1;
        }
        return res;
    }

}
