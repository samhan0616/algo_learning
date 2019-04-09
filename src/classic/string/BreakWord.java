package classic.string;

import java.util.Arrays;

public class BreakWord {

    public int breakstring(int[] seg, String n) {
        int length = n.length();
        seg = Arrays.copyOf(seg ,seg.length + 2);
        seg[seg.length - 2] = 0;
        seg[seg.length - 1] = length;
        Arrays.sort(seg);

        int sl = seg.length;
        int[][] dp = new int[sl + 1][sl + 1];
        for (int l = 3; l <= sl; l++) {
            for (int i = 1; i <= sl - l + 1; i++) {
                int j = i + l - 1;
                for (int k = i + 1; k <= j-1; k++) {
                    dp[i][j] = Math.min(dp[i][j] == 0 ? Integer.MAX_VALUE : dp[i][j], dp[i][k] + dp[k][j]);
                }
                dp[i][j] += seg[j - 1] - seg[i - 1];
            }
        }
        return dp[1][sl];
    }


    public static void main(String[] args) {
       System.out.println( new BreakWord().breakstring(new int[]{4,7,10}, "abcdefghagilnmopqret"));
    }
}
