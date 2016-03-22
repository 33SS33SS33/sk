package easy;

/**
 * Created by GAOSHANSHAN835 on 2016/1/7.
 */

/**
 * Given a positive integer, return its corresponding column title as appear in
 * an Excel sheet.
 * For example:
 * 1 -> A
 * 2 -> B
 * 3 -> C
 * ...
 * 26 -> Z
 * 27 -> AA
 * 28 -> AB
 * Tags: Math
 */
class ExcelSheetColTitle {
    public static void main(String[] args) {
        System.out.println(convertToTitleRec(26));
        System.out.println(convertToTitle(26));
        System.out.println(convertToTitleB(26));
    }

    /**
     * Get the remainder in each loop
     * It should be the last digit
     * Note that the map shall have 1 offset
     */
    public static String convertToTitle(int n) {
        if (n <= 0)
            return "";
        StringBuilder title = new StringBuilder();
        while (n > 0) {
            n--; // note the 1 offset
            int r = n % 26;
            title.insert(0, (char) ('A' + r));
            n = n / 26;
        }
        return title.toString();
    }

    /**
     * creek
     * The key is n--. The minimum in 26-bit number is mapped to 1, not 0.
     */
    public static String convertToTitleB(int n) {
        if (n <= 0) {
            throw new IllegalArgumentException("Input is not valid!");
        }
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            n--;
            char ch = (char) (n % 26 + 'A');
            n /= 26;
            sb.append(ch);
        }
        sb.reverse();
        return sb.toString();
    }

    /**
     * Recursive version, one line
     */
    public static String convertToTitleRec(int n) {
        return n <= 0 ? "" : convertToTitleRec(--n / 26) + (char) ('A' + (n % 26));
    }
}
