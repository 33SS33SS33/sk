package aaMSsssssss;

import java.util.Arrays;

public class BestTeamWithNoConflicts {
    public int bestTeamScore(int[] scores, int[] ages) {
        int n = ages.length;
        int[][] candidate = new int[n][2];

        for(int i=0; i<n; i++) {
            candidate[i][0] = ages[i];
            candidate[i][1] = scores[i];
        }
        Arrays.sort(candidate, (a, b) -> a[0] == b[0] ? a[1]-b[1] : a[0]-b[0]);
        int[] dp = new int[n];
        dp[0] = candidate[0][1];
        int max = dp[0];
        for(int i=1; i<n; i++) {
            dp[i] = candidate[i][1];
            for(int j=0; j<i; j++) {
                if(candidate[j][1] <= candidate[i][1]) {
                    dp[i] = Math.max(dp[i], candidate[i][1]+dp[j]);
                }
            }
            max = Math.max(dp[i], max);
        }
        return max;
    }
}
