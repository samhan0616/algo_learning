package leetcode.leetcode_1to50;

import leetcode.util.ListNode;

/**
 * You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.
 *
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Example:
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * Explanation: 342 + 465 = 807.
 *
 * @author create by Xiao Han 9/20/18
 * @version 1.0
 * @since jdk 1.8
 */
public class Lc2_Add_Two_Numbers {

  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    int sum = l1.val + l2.val;
    ListNode result = new ListNode(sum % 10);
    int carry = sum / 10;
    while(l1.next != null && l2.next != null) {
      l1 = l1.next;
      l2 = l2.next;
      sum = l1.val + l2.val + carry;
      result.next = new ListNode(sum % 10);
      result = result.next;

      carry = sum / 10;

    }
    while(l1.next != null) {
      l1 = l1.next;
      result.next = new ListNode(l1.val + carry);
      result = result.next;
      carry = (l1.val + carry) / 10;
    }
    while(l2.next != null) {
      l2 = l2.next;
      result.next = new ListNode(l2.val + carry);
      result = result.next;
      carry = (l2.val + carry) / 10;
    }
    return result;
  }
}
