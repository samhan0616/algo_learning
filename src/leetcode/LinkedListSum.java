package leetcode;

public class LinkedListSum {
	public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
	 	if (l1 == null) {
            return l2;
        }

        if (l2 == null) {
            return l1;
        }
        
        ListNode result = null;
        ListNode temp = null;
        boolean flag = false;
        int sum = 0;
        while(l1 != null || l2 != null) {
            if(l1 == null) sum = l2.val;
            else if(l2 == null) sum = l1.val;
            else sum = l1.val + l2.val;
            if(flag) {
                sum ++;
                flag = false;
            }
            if(sum >= 10) {
                flag = true;
                sum -= 10;
            }
            if(result == null) {
                result = new ListNode(sum);
                temp = result;
            } else {
                temp.next = new ListNode(sum);
                temp = temp.next;
            }
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(flag) temp.next = new ListNode(1);
        return result;
    }
	 
	 	static class ListNode {
		      int val;
		      ListNode next;
		      ListNode(int x) { val = x; }
			@Override
			public String toString() {
				StringBuilder sb  = new StringBuilder();
				ListNode temp = this;
				while(temp.next != null) {
					sb.append(temp.val + " ->");
					temp = temp.next;
				}
				sb.append(temp.val);
				return sb.toString();
			}
		      
		 }
	 	public static void main(String[] args) {
//			ListNode l1 = new ListNode(2);
//			l1.next = new ListNode(4);
//			l1.next.next = new ListNode(3);
//			ListNode l2 = new ListNode(5);
//			l2.next = new ListNode(6);
//			l2.next.next = new ListNode(4);
	 		ListNode l1 = new ListNode(5);
	 		ListNode l2 = new ListNode(5);
			System.out.println(addTwoNumbers(l1, l2));
		}
}
