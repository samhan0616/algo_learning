package leetcode.leetcode_1to50;

import leetcode.util.ListNode;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 *
 * You may not modify the values in the list's nodes, only nodes itself may be changed.
 *
 *
 *
 * Example:
 *
 * Given 1->2->3->4, you should return the list as 2->1->4->3.
 */
public class Lc24_swap_nodes_in_paris {
    /**
     *
     * @param head
     * @return
     */
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode curr = head.next;
        head.next = swapPairs(head.next.next);
        curr.next = head;
        return curr;
    }
}
