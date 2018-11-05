package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * @author create by Xiao Han 11/4/18
 * @version 1.0
 * @since jdk 1.8
 */
public class LongestPalindromicSubsequence {


  public int calculate1(char []str){
    int T[][] = new int[str.length][str.length];
    for(int i=0; i < str.length; i++){
      T[i][i] = 1;
    }
    for(int l = 2; l <= str.length; l++){
      for(int i = 0; i < str.length-l + 1; i++){
        int j = i + l - 1;
        if(l == 2 && str[i] == str[j]){
          T[i][j] = 2;
        }else if(str[i] == str[j]){
          T[i][j] = T[i + 1][j-1] + 2;
        }else{
          T[i][j] = Math.max(T[i + 1][j], T[i][j - 1]);
        }
      }
    }
    System.out.println(T[0][str.length-1]);
    return T[0][str.length-1];
  }

  private int helper(String s, int i, int j, int[] strs, Integer[][] memo) {
    if (memo[i][j] != null) {
      return memo[i][j];
    }
    if (i > j)      return 0;
    if (i == j)     return 1;

    if (s.charAt(i) == s.charAt(j)) {
      strs[i] = j - i + 1;
      memo[i][j] = helper(s, i + 1, j - 1,strs, memo) + 2;
    } else {
      memo[i][j] = Math.max(helper(s, i + 1, j,strs, memo), helper(s, i, j - 1,strs, memo));
    }
    return memo[i][j];
  }

  private String helper(String s, int[] strs, int n) {
    String res = "";

    for (int i = strs.length - 1; i >= 0 && n > 0; i--) {
      if (strs[i] == 0) {
      } else {
        if (strs[i] <= 2) {
          for (int j= 0 ; j <= strs[n]; j ++) {
            res += s.charAt(i + j);
          }
          n -= (strs[i] + 1);
        } else if (res.length() > 0) {
          res = s.charAt(i) + res + s.charAt(i);
          n -= 2;
        }
    }
    }

    return res;
  }

  public static void main(String args[]){
    LongestPalindromicSubsequence lps = new LongestPalindromicSubsequence();
    String str = "euazbipzncptldueeuechubrcourfpftcebikrxhybkymimgvldiwqvkszfycvqyvtiwfckexmowcxztkfyzqovbtmzpxojfofbvwnncajvrvdbvjhcrameamcfmcoxryjukhpljwszknhiypvyskmsujkuggpztltpgoczafmfelahqwjbhxtjmebnymdyxoeodqmvkxittxjnlltmoobsgzdfhismogqfpfhvqnxeuosjqqalvwhsidgiavcatjjgeztrjuoixxxoznklcxolgpuktirmduxdywwlbikaqkqajzbsjvdgjcnbtfksqhquiwnwflkldgdrqrnwmshdpykicozfowmumzeuznolmgjlltypyufpzjpuvucmesnnrwppheizkapovoloneaxpfinaontwtdqsdvzmqlgkdxlbeguackbdkftzbnynmcejtwudocemcfnuzbttcoew";
    int n = str.length();
    int[] strs = new int[n];
    int r1 = lps.helper(str, 0, n - 1, strs, new Integer[n][n]);
    System.out.println(lps.helper(str, strs, r1));
  }
}

