/*
	Insert into sorted cycle linked list
	time complexity: O(n);
*/
public class CNode {
	public int val;
	public CNode next;
	CNode(int _val) {
		val = _val;
	}
}

public class InsertInCycle {
	public static CNode Solution(CNode head, int target) {
		CNode newNode = new CNode(target);
		if(head == null) {
			newNode.next = newNode;
			return newNode;
		}
		CNode crtNode = head;
		/*
		CNode realHead = head;
		*/
		do {
			// find real head of the linked list
			/*
			if(crtNode.val > crtNode.next.val) realHead = crtNode.next;
			*/
			// < insert at the end of same elements, > insert at the beginning of same elements
			if(target > crtNode.val && target <= crtNode.next.val) break;
			if(crtNode.val > crtNode.next.val && (target > crtNode.val || target <= crtNode.next.val)) break;
			crtNode = crtNode.next;
		} while(crtNode != head);
		newNode.next = crtNode.next;
		crtNode.next = newNode;
		return newNode;
		// return realHead;
	}
}