/*
	reverse second half of linked list
	time complexity: O(n)
*/
class ListNode {
	int val;
	ListNode next;
	ListNode(int x) { val = x; }
}

public class ReverseSecondHalfList {
	public static ListNode Solution(ListNode head) {
		if(head == null || head.next == null || head.next.next == null) return head;
		ListNode slow = head;
		ListNode fast = head.next;
		// find mid node's pre node
		while(fast.next != null && fast.next.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}
		ListNode pre = null;
		ListNode start = slow.next;
      	// represent the next node of current node
		fast = null;   
		while(start != null) {
			fast = start.next;
			start.next = pre;
			pre = start;
			start = fast;
		}
		// link last element of first half with last element of second half
      	slow.next = pre;
      	return head;
	}
}