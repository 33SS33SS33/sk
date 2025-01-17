package aMaz;

public class ReverseString {
    public static void main(String[] args) {
        ReverseString r = new ReverseString();
        System.out.println(r.reverseStringa("tyutyu"));
    }

    /**
     * Write a function that reverses a string. The input string is given as an array of characters char[].
     * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
     * You may assume all the characters consist of printable ascii characters.
     * Input: ["h","e","l","l","o"] Output: ["o","l","l","e","h"]
     * Input: ["H","a","n","n","a","h"] Output: ["h","a","n","n","a","H"]
     */
    public String reverseStringa(String s) {
        char[] word = s.toCharArray();
        int i = 0;
        int j = s.length() - 1;
        while (i < j) {
            char temp = word[i];
            word[i] = word[j];
            word[j] = temp;
            i++;
            j--;
        }
        return new String(word);
    }

}
