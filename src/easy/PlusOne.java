package easy;

/**
 * Given a non-negative number represented as an array of digits,
 * <strong>plus one</strong> to the number.
 * The digits are stored such that the most significant digit is
 * at the head of the list.
 * Tags: Array, Math
 */
class PlusOne {
    public static void main(String[] args) {
        int[] result = plusOne(new int[]{9, 9, 9, 9, 8});
        System.out.print("{ ");
        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }
        System.out.println("}");

        int[] result2 = plusOnea(new int[]{9, 9, 9, 9, 9});
        System.out.print("{ ");
        for (int i = 0; i < result2.length; i++) {
            System.out.print(result2[i] + " ");
        }
        System.out.println("}");
    }

    public static int[] plusOnea(int[] digits) {
        if (digits == null || digits.length == 0)
            return digits;
        int carry = 1;
        for (int i = digits.length - 1; i >= 0; i--) {
            int digit = (digits[i] + carry) % 10;
            carry = (digits[i] + carry) / 10;
            digits[i] = digit;
            if (carry == 0)
                return digits;
        }
        int[] res = new int[digits.length + 1];
        res[0] = 1;
        return res;
    }

    /**
     * 有一个小细节就是如果到了最高位进位仍然存在，那么我们必须重新new一个数组，
     * 然后把第一个为赋成1（因为只是加一操作，其余位一定是0，否则不会进最高位）。
     * 因为只需要一次扫描，所以算法复杂度是O(n)，n是数组的长度。
     * 而空间上，一般情况是O(1)，但是如果数是全9，那么是最坏情况，需要O(n)的额外空间
     * Add 1 for the last digit
     * If carry, add one to next digit
     * If no carry, return
     * If all have carry, create a new int array
     */
    public static int[] plusOneOthers(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = 1 + digits[i];
            if (digits[i] == 10) {
                digits[i] = 0;
            } else
                return digits; // no carry for current digit
        }
        int[] ans = new int[digits.length + 1];
        ans[0] = 1;
        for (int i = 0; i < digits.length; i++)
            ans[i + 1] = digits[i];
        return ans;
    }

    public static int[] plusOne(int[] digits) {
        int count = digits.length;
        while (count > 0) {
            digits[count - 1] = digits[count - 1] + 1;
            if (digits[count - 1] > 9) {
                digits[count - 1] = 0;
            } else {
                return digits;
            }
            count--;
        }
        int[] result = new int[digits.length + 1];
        result[0] = 1;
        for (int i = 1; i < digits.length; i++) {
            result[i] = digits[i - 1];
        }
        return result;
    }


}
