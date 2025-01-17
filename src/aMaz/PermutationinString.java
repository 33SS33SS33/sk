package aMaz;

/**
 * Created by shanshan on 2/11/19.
 * https://leetcode.com/problems/permutation-in-string/discuss/102588/Java-Solution-Sliding-Window
 */
public class PermutationinString {
    /**
     * Given two strings s1 and s2, write a function to return true if s2 contains the permutation of s1.
     * In other words, one of the first string's permutations is the substring of the second string.
     * Input:s1 = "ab" s2 = "eidbaooo" Output:True
     * Explanation: s2 contains one permutation of s1 ("ba").
     * Input:s1= "ab" s2 = "eidboaoo" Output: False
     * Note: The input strings only contain lower case letters.
     * The length of both given strings is in range [1, 10,000].
     */
    public boolean permutationinString(String s1, String s2) {
        int len1 = s1.length(), len2 = s2.length();
        if (len1 > len2) return false;
        int[] count = new int[26];
        for (int i = 0; i < len1; i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }
        if (allZero(count))
            return true;
        for (int i = len1; i < len2; i++) {
            count[s2.charAt(i) - 'a']--;
            count[s2.charAt(i - len1) - 'a']++;
            if (allZero(count))
                return true;
        }
        return false;
    }

    private boolean allZero(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
}
