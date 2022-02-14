package medium;

public class LeetCode24 {

	static class ListNode {
		
		int val;
		ListNode next;
		ListNode() {}
		ListNode(int val) { 
			this.val = val; 
		}
		ListNode(int val, ListNode next) { 
			this.val = val; 
			this.next = next; 
		}
	}
	public static ListNode swapPairs(ListNode head) {
        
        if(head == null) { 
            return null;
        }
        if(head.next == null)  {
            return head;
        }
        ListNode temp = head;
        ListNode newHead = head.next;
        ListNode prev = null;
        ListNode saveNext = temp.next;
        while(temp!=null && temp.next!=null) {
        	saveNext = temp.next;
        	temp.next = temp.next.next;
        	saveNext.next = temp;
        	if(prev == null) { 
        		prev = temp;
        	}
        	else {
	        	prev.next = saveNext;
	        	prev = temp;
        	}
        	temp = temp.next;
        }
        return newHead;
    }
}
