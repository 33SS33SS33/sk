package aMaz;

/**
 * HARD
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 231 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * 先做个字典
 * 然后有个函数用来构造三位数字的读法
 * 然后把输入的数字每三个分成一部分 调用之前的函数 然后加上千 百万 或者亿万
 * 右边的代码十分简洁 未实现
 */
public class IntegertoEnglishWords {
    public static void main(String[] args) {
        System.out.println(new IntegertoEnglishWords().IntegertoEnglishWords(76));
        System.out.println(new IntegertoEnglishWords().IntegertoEnglishWords(123));
        System.out.println(new IntegertoEnglishWords().IntegertoEnglishWords(12345));
        System.out.println(new IntegertoEnglishWords().IntegertoEnglishWords(1234567));
    }
    private final String[] belowTen = new String[]{"", "One", "Two", "Three", "Four", "Five", "Six", "Seven", "Eight", "Nine"};
    private final String[] belowTwenty = new String[]{"Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen", "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] belowHundred = new String[]{"", "Ten", "Twenty", "Thirty", "Forty", "Fifty", "Sixty", "Seventy", "Eighty", "Ninety"};

    public String IntegertoEnglishWords(int num) {
        if (num == 0) return "Zero";
        return helper(num);
    }

    private String helper(int num) {
        String result;
        if (num < 10) result = belowTen[num];
        else if (num < 20) result = belowTwenty[num - 10];
        else if (num < 100) result = belowHundred[num / 10] + " " + helper(num % 10);
        else if (num < 1000) result = helper(num / 100) + " Hundred " + helper(num % 100);
        else if (num < 1000000) result = helper(num / 1000) + " Thousand " + helper(num % 1000);
        else if (num < 1000000000) result = helper(num / 1000000) + " Million " + helper(num % 1000000);
        else result = helper(num / 1000000000) + " Billion " + helper(num % 1000000000);
        return result.trim();
    }
    private final String[] LESS_THAN_20 = {"", "One", "Two", "Three", "Four", "Five", "Six",
            "Seven", "Eight", "Nine", "Ten", "Eleven", "Twelve", "Thirteen", "Fourteen", "Fifteen",
            "Sixteen", "Seventeen", "Eighteen", "Nineteen"};
    private final String[] TENS = {"", "Ten", "Twenty", "Thirty", "Forty", "Fifty",
            "Sixty", "Seventy", "Eighty", "Ninety"};
    private final String[] THOUSANDS = {"", "Thousand", "Million", "Billion"};

   /* public String IntegertoEnglishWords(int num) {
        if (num == 0)
            return "Zero";
        int i = 0;
        String words = "";
        while (num > 0) {
            if (num % 1000 != 0)
                words = helper(num % 1000) + THOUSANDS[i] + " " + words;
            num /= 1000;
            i++;
        }
        return words.trim();
    }

    private String helper(int num) {
        if (num == 0)
            return "";
        else if (num < 20)
            return LESS_THAN_20[num] + " ";
        else if (num < 100)
            return TENS[num / 10] + " " + helper(num % 10);
        else
            return LESS_THAN_20[num / 100] + " Hundred " + helper(num % 100);
    }
*/
}
