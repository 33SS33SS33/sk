package top50Google;

import java.util.*;

public class CountWordsObtainedAfterAddingaLetter {
    /**
     * You are given two 0-indexed arrays of strings startWords and targetWords. Each string consists of lowercase English letters only.
     * For each string in targetWords, check if it is possible to choose a string from startWords and perform a conversion operation on it to be equal to that from targetWords.
     * The conversion operation is described in the following two steps:
     * Append any lowercase letter that is not present in the string to its end.
     * For example, if the string is "abc", the letters 'd', 'e', or 'y' can be added to it, but not 'a'. If 'd' is added, the resulting string will be "abcd".
     * Rearrange the letters of the new string in any arbitrary order.
     * For example, "abcd" can be rearranged to "acbd", "bacd", "cbda", and so on. Note that it can also be rearranged to "abcd" itself.
     * Return the number of strings in targetWords that can be obtained by performing the operations on any string of startWords.
     * Note that you will only be verifying if the string in targetWords can be obtained from a string in startWords by performing the operations.
     * The strings in startWords do not actually change during this process.
     * Input: startWords = ["ant","act","tack"], targetWords = ["tack","act","acti"]
     * Output: 2
     */
    public int wordCount(String[] startWords, String[] targetWords) {
        int n = startWords.length;
        int count = 0;
        Set<String> set = new HashSet<>();
        //1. store lexicographically sorted letters of startword in set
        for (String start : startWords) {
            char[] sAr = start.toCharArray();
            Arrays.sort(sAr);
            set.add(new String(sAr));
        }
        int m = targetWords.length;
        boolean ans = false;
        for (int i = 0; i < m; i++) {
            //2. sort lexicographically letters of targetword and store in new string s
            char[] tAr = targetWords[i].toCharArray();
            Arrays.sort(tAr);
            int k = tAr.length;
            String s = String.valueOf(tAr);
            ans = false;
            for (int j = 0; j < k; j++) {
                //3. make a new string by omitting one letter from word and check if it is present in set than increase count value
                String str = s.substring(0, j) + s.substring(j + 1);
                if (set.contains(str)) {
                    count++;
                    break;
                }
            }
        }
        return count;
    }
}
