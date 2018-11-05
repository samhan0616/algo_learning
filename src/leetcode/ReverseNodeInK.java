package leetcode;

/**
 * @author create by Xiao Han 10/20/18
 * @version 1.0
 * @since jdk 1.8
 */
public class ReverseNodeInK {
  ListNode dummy = new ListNode(-1);

  public ListNode reverseKGroup(ListNode head, int k) {

    dummy.next = head;
    ListNode helper = head;
    for (int i = 0; head != null; i++) {
      if(i % k == 0) helper = head;
      if(i % k == k - 1) {
        ListNode next = head.next;
        helper(helper, k).next = next;
        head = next;
      } else {
        head = head.next;
      }
      dummy.print();
    }
    return dummy.next;
  }
  private ListNode helper(ListNode head, int k) {
    ListNode prev = null;
    ListNode curr = head;
    ListNode tail = head;
    int count = 1;
    while (curr != null && count<=k) {
      ListNode next = curr.next;
      curr.next = prev;
      prev = curr;
      curr = next;
      count ++;
    }

    return prev;
  }

  public static void main(String[] args) {
    ListNode node = new ListNode(1);
    node.next = new ListNode(2);
    node.next.next = new ListNode(3);
    node.next.next.next = new ListNode(4);
    node.next.next.next.next = new ListNode(5);
    new ReverseNodeInK().reverseKGroup(node, 2);
  }
}
