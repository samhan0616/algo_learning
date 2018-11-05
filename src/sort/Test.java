package sort;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @author create by Xiao Han 9/28/18
 * @version 1.0
 * @since jdk 1.8
 */
public class Test {

  public static int strStr(String haystack, String needle) {
    if (needle.length() == 0) return 0;
    if (haystack.length() < needle.length()) return -1;

    int[] arr = new int[needle.length()];
    for (int i = 1; i < needle.length(); i++) {
      if (needle.charAt(i) == needle.charAt(arr[i - 1])) {
        arr[i] = arr[i - 1] + 1;
      }
    }
    System.out.println(Arrays.toString(arr));

    int h = 0, n = 0, hlength = haystack.length(), nlength = needle.length();
    while (h < hlength) {
      if (haystack.charAt(h) == needle.charAt(n)) {
        h++;
        n++;
      } else {
        if (n == 0){
          h ++;
          continue;
        } else {
          n = arr[n];
          continue;
        }
      }
      if (n == nlength) return h - nlength;
    }
    return -1;
  }

  static String count(String str) {
    StringBuilder sb = new StringBuilder();
    char c = str.charAt(0);
    int i = 1, count = 1;
    for (; i < str.length(); i++) {
      if ( c == str.charAt(i)) {
        count ++;
      } else {
        sb.append(count).append(c);
        count = 1;
        c = str.charAt(i);
      }
    }
    sb.append(count).append(str.charAt(i - 1));

    return sb.toString();
  }

  static String recursion(int n, String str) {
    if (n > 1) {
      String s = recursion(n - 1, str);
      return count(s);
    } else {
      return str;
    }
  }

  public static int lengthOfLastWord(String s) {
    int len = s.length();
    int m = -1;
    while (m < len) {
      int n = s.indexOf(" ", m + 1);
      if (n < 0) {
        return len - m;
      } else if (n < len - 1) {
        m = n;
      } else {
        return n - m - 1;
      }
    }
    return 0;
  }

  public static void main(String[] args) {
//    System.out.println(strStr(    "aabaaabaaac",        "aabaaac"));
//    System.out.println(count("21"));
//    System.out.println(recursion(5,"1"));
//    System.out.println("a ".lastIndexOf(" "));
//    System.out.println("a ".length());
//    System.out.println("b a ".indexOf(" ", 1));
    System.out.println(lengthOfLastWord("b   a    "));
    System.out.println("b  a     ".trim());
  }
}
