package aMaz;


class InterleavingString {
    public static void main(String[] args) {
        String s1 = "aabcc";
        String s2 = "dbbca";
        String s3 = "aadbbcbcac";
        //        String s3 = "aadbbbaccc";
        System.out.println(interleavingString(s1, s2, s3));
//        System.out.println(interleavingStringb(s1, s2, s3));
    }

    /**
     * DP,
     * bottom-up, Time: O(nm), and Space: O(nm)
     * quick check, length of s3 should be the sum of s1 and s2
     * 1. i == 0 && j == 0, dp[i][j] is true initially
     * 2. first row, i == 0, dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1)== s3.charAt(j - 1)
     * 3. first col, j == 0, dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1)== s3.charAt(i - 1)
     * 4. dp[i][j] = (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j- 1))||(dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
     * final result should dp[a][b]
     * <p>
     * Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2. HARD
     * For example,
     * s1 = "aabcc", s2 = "dbbca",
     * When s3 = "aadbbcbcac", return true.
     * When s3 = "aadbbbaccc", return false.
     * Tags: DP, String
     * 使用dp 动态规划  还可以用DFS BFS 未实现
     * 通项公式为
     * dp[i][j] = (dp[i-1][j] and s1[i-1] == s3[i+j-1]) or \
     * (dp[i][j-1] and s2[j-1] == s3[i+j-1])
     * dp[i][j] 表示的是当前长度为i的s1和长度为j的s2能否是长度为i+j的s3的穿插
     */
    public static boolean interleavingString(String s1, String s2, String s3) {
        if (s1 == null || s2 == null || s3 == null)
            return false;
        if ((s1.length() + s2.length()) != s3.length())
            return false;
        boolean[][] matrix = new boolean[s2.length() + 1][s1.length() + 1];
        matrix[0][0] = true;
        for (int i = 1; i < matrix[0].length; i++) {
            matrix[0][i] = matrix[0][i - 1] && (s1.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i < matrix.length; i++) {
            matrix[i][0] = matrix[i - 1][0] && (s2.charAt(i - 1) == s3.charAt(i - 1));
        }
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 1; j < matrix[0].length; j++) {
                matrix[i][j] = (matrix[i - 1][j] && (s2.charAt(i - 1) == s3.charAt(i + j - 1))) || (
                        matrix[i][j - 1] && (s1.charAt(j - 1) == s3.charAt(i + j - 1)));
            }
        }
        return matrix[s2.length()][s1.length()];
    }

    /**
     * better
     */
/*    public static boolean interleavingStringb(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length())
            return false;
        String minWord = s1.length() > s2.length() ? s2 : s1;
        String maxWord = s1.length() > s2.length() ? s1 : s2;
        boolean[] res = new boolean[minWord.length() + 1];
        res[0] = true;
        for (int i = 0; i < minWord.length(); i++) {
            res[i + 1] = res[i] && minWord.charAt(i) == s3.charAt(i);
        }
        for (int i = 0; i < maxWord.length(); i++) {
            res[0] = res[0] && maxWord.charAt(i) == s3.charAt(i);
            for (int j = 0; j < minWord.length(); j++) {
                res[j + 1] = res[j + 1] && maxWord.charAt(i) == s3.charAt(i + j + 1)
                        || res[j] && minWord.charAt(j) == s3.charAt(i + j + 1);
            }
        }
        return res[minWord.length()];
    }*/

}
