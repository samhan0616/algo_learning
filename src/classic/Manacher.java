package classic;

/**
 * @author create by Xiao Han 10/25/18
 * @version 1.0
 * @since jdk 1.8
 */
public class Manacher {

  public int longestPalindorm(String str) {
    StringBuilder stringBuilder = new StringBuilder("$#");
    for (char c : str.toCharArray()) {
      stringBuilder.append(c).append("#");
    }
    String newStr = stringBuilder.toString();
    int p[] = new int[newStr.length()];

    int mx = 0;
    int id = 0;
    int ans = 0;
    for (int i = 0; i < p.length; i++) {
      if (i < mx) {
        p[i] = Math.min(p[2*id - 1], mx - i);
      } else {
        p[i] = 1;
      }
      while (newStr.charAt(i - p[i]) == newStr.charAt(i + p[i])) {
        p[i] ++;
      }

      if (p[i] + i > mx) {
        mx = p[i] + i;
        id = i;
      }
      ans = Math.max(ans, p[i]);
    }
    return ans - 1;
  }

  public String longestPalindrome(String s) {
    if (s.length() < 2) return s;
    StringBuilder sb = new StringBuilder("$#");
    for (char c : s.toCharArray()) {
      sb.append(c).append("#");
    }
    sb.append("%");

    String newStr = sb.toString();
    int[] length = new int[newStr.length()];
    int max = 0;
    int index = 0;
    int ans = 0;
    int cen = 0;

    for (int i = 1; i < length.length - 1; i++) {
      if (max > i) {
        length[i] = Math.min(max - i, length[2*index -i]);
      } else {
        length[i] = 1;
      }

      while (newStr.charAt(i - length[i]) == newStr.charAt(i + length[i])) {
        length[i] ++;
      }

      if (length[i] + i > max) {
        max = length[i] + i;
        index = i;
      }
      if (ans <= length[i]) {
        ans = length[i];
        cen = i;
      }

    }
    return s.substring((cen - ans)/ 2, (cen - ans)/ 2 + ans - 1);


  }

  public static void main(String[] args) {
    System.out.println(new Manacher().longestPalindrome("babad"));
  }
}
