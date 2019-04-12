package leetcode.leetcode_1to50;

import leetcode.util.ListNode;

/**
 * Given a linked list, remove the n-th node from the end of list and return its head.
 *
 * Example:
 *
 * Given linked list: 1->2->3->4->5, and n = 2.
 *
 * After removing the second node from the end, the linked list becomes 1->2->3->5.
 * Note:
 *
 * Given n will always be valid.
 *
 * Follow up:
 *
 * Could you do this in one pass?
 */
public class Lc19_Remove_Nth_node_from_end_of_list {
    /**
     * use dummy and two pointers
     * fast run n nodes from -1
     * then slow run until fast hit the tail
     *
     * @param head
     * @param n
     * @return
     */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy =  new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;
        while (n-- > 0) fast = fast.next;
        ListNode pre = null;
        while (fast != null){
            pre = slow;
            slow = slow.next;
            fast = fast.next;
        }

        pre.next = slow.next;

        return dummy.next;

    }
}
