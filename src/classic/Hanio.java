package classic;

/**
 * @author create by Xiao Han 9/23/18
 * @version 1.0
 * @since jdk 1.8
 */
public class Hanio {

  public static void main(String[] args) {
    hanio("a","b","c",3);
  }
  public static void hanio(String a, String b, String c, int n) {
    if (n == 1) {
      System.out.println(n + "th: " +a + "->" + c);
    } else  {
      hanio(a,c,b,n -1);
      System.out.println(n + "th: " + a + "->" + c);
      hanio(b,a,c,n - 1);

    }

  }
}
