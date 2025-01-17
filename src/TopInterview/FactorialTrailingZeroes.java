package TopInterview;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * Tag: Math
 * 一个更聪明的解法是：考虑n!的质数因子。后缀0总是由质因子2和质因子5相乘得来的。如果我们可以计数2和5的个数，问题就解决了。考虑下面的例子：
 * n = 5: 5!的质因子中 (2 * 2 * 2 * 3 * 5)包含一个5和三个2。因而后缀0的个数是1。
 * n = 11: 11!的质因子中(2^8 * 3^4 * 5^2 * 7)包含两个5和三个2。于是后缀0的个数就是2。
 * 我们很容易观察到质因子中2的个数总是大于等于5的个数。因此只要计数5的个数就可以了。
 * 那么怎样计算n!的质因子中所有5的个数呢？一个简单的方法是计算floor(n/5)。
 * 例如，7!有一个5，10!有两个5。除此之外，还有一件事情要考虑。诸如25，125之类的数字有不止一个5。
 * 例如，如果我们考虑28!，我们得到一个额外的5，并且0的总数变成了6。
 * 处理这个问题也很简单，首先对n÷5，移除所有的单个5，然后÷25，移除额外的5，以此类推。
 * 下面是归纳出的计算后缀0的公式。
 */
class FactorialTrailingZeroes {
    public static void main(String[] args) {
        System.out.println(trailingZeroes(1025));
    }

    /**
     * O(log5-n)
     */
    public static int trailingZeroes(int n) {
        int r = 0;
        while (n > 0) {
            n /= 5;
            r += n; // add # of 5 in n
        }
        return r;
    }

}