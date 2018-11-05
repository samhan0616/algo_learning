package leetcode;

/**
 * @author create by Xiao Han 10/20/18
 * @version 1.0
 * @since jdk 1.8
 */
public class ListNode {
  int val;
  ListNode next;

  ListNode(int x) {
    val = x;
  }

  public void print() {
    ListNode dummy = this;
    while (dummy != null) {
      System.out.print(dummy.val + "->");
      dummy = dummy.next;
    }
    System.out.println("null");
  }
}