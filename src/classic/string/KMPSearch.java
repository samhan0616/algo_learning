package classic.string;

import java.util.Arrays;

/**
 * @author create by Xiao Han 10/6/18
 * @version 1.0
 * @since jdk 1.8
 */
class KMPSearch {
  private int[] kmp(char[] str) {
    int[] f = new int[str.length];
    for (int i = 2; i < f.length; i++) {
      int j = f[i-1];
      while (j > 0 && str[j] != str[i-1]) j = f[j];
      if (j > 0 || str[j] == str[i-1]) f[i] = j+1;
    }
    return f;
  }

  public int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    if (needle.length() <= haystack.length()) {
      int[] f = kmp(needle.toCharArray());
      int i = 0, j = 0;
      while (i < haystack.length()) {
        if (haystack.charAt(i) == needle.charAt(j)) {
          i++; j++;
          if (j == needle.length()) return i-j;
        } else if (j > 0) j = f[j];
        else i++;
      }
    }
    return -1;
  }

  // Driver program to test above function
  public static void main(String args[])
  {
    String txt = "aabaaabaaac";
    String pat = "aabaaac";
    new KMPSearch().strStr(pat, txt);
  }
}


