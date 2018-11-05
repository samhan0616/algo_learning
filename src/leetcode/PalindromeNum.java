package leetcode;

/**
 * @author create by Xiao Han 10/22/18
 * @version 1.0
 * @since jdk 1.8
 */
public class PalindromeNum {

    public boolean isPalindrome(int x) {
      int temp = x;
      if (x < 0) return false;
      long res = 0;
      while (x != 0) {
        res *= 10;
        res += x % 10;
        x /= 10;
      }
      if (res > 2147483647) return false;
      System.out.println(res);
      return (int)res == temp;
    }

  public static void main(String[] args) {
    System.out.println(new PalindromeNum().isPalindrome(121));
  }

}
