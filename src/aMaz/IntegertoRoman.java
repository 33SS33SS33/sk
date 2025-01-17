package aMaz;

class IntegertoRoman {
    public static void main(String[] args) {
        System.out.println(new IntegertoRoman().intToRomanA(3));
        System.out.println(new IntegertoRoman().intToRoman(3));
        // System.out.println(new IntegertoRoman().intToRomanB(3));
    }

    public static final int[] intDict = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    public static final String[] romanDict = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V",
            "IV", "I"};

    //https://leetcode.com/problems/integer-to-roman/discuss/6310/My-java-solution-easy-to-understand

    /**
     * Given an integer, zigZagConversion it to a roman numeral.
     * Input is guaranteed to be within the range from 1 to 3999.
     * Tags: Math, String
     */
    public String intToRomanA(int num) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < intDict.length; i++) {
            while (num >= intDict[i]) {
                num -= intDict[i];
                sb.append(romanDict[i]);
            }
        }
        return sb.toString();
    }

    /**
     * Recursion
     * Go through the dict, if num >= dict, insert it to head
     * Pass rest of the integer to next recursion
     */
    public String intToRoman(int num) {
        for (int i = 0; i < intDict.length; i++) {
            if (intDict[i] <= num) {
                return romanDict[i] + intToRoman(num - intDict[i]);
            }
        }
        return ""; // Note the return statement
    }

    /**
     * While loop
     * Go through the dict, if num >= intDict[i], append roman integer
     * num -= intDict[i]
     * if num < intDict[i], i++
     */
/*    public String intToRomanB(int num) {
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (num > 0 && i < intDict.length) {
            if (num >= intDict[i]) {
                sb.append(romanDict[i]);
                num -= intDict[i]; // update num
            }
            else {
                i++; // move to next roman
            }
        }
        return sb.toString();
    }*/

}