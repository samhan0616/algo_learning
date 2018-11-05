package classic;

/**
 * @author create by Xiao Han 9/27/18
 * @version 1.0
 * @since jdk 1.8
 */
public class XPow {

  public static void main(String[] args) {
    System.out.println(pow(3,1,4));
  }

  public static int pow(int x1, int x2, int n) {
    if (n == 1) {
      return x1 * x2;
    } else if (n % 2 == 0) {
      n = n / 2;
      return pow(x1 * x2, x1 * x2, n);
    } else {
      n = n / 2;
      return pow(x1 * x2, x1 * x2 * x1, n);
    }
  }
}
