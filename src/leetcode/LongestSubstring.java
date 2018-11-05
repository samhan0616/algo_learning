package leetcode;

/**
 * @author create by Xiao Han 9/26/18
 * @version 1.0
 * @since jdk 1.8
 */
public class LongestSubstring {
  public static int lengthOfLongestSubstring(String s) {

    int ans = 0;
    int len = s.length();
    int[] indexArr = new int[128];

    for(int i=0, j=0; i< len; i++) {

      j = Math.max(indexArr[s.charAt(i)], j);
      ans = Math.max(ans, i-j+1);
      indexArr[s.charAt(i)] = i+1;
    }

    return ans;
  }

  public static void main(String[] args) {
    System.out.println(lengthOfLongestSubstring("abcadabcadbb"));
  }
}
