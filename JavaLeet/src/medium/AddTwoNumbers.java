package medium;


//You are given two non-empty linked lists representing two non-negative integers. 
//The digits are stored in reverse order, and each of their nodes contains a single digit. 
//Add the two numbers and return the sum as a linked list.
//You may assume the two numbers do not contain any leading zero, except the number 0 itself.

public class AddTwoNumbers {
	
	
	public static void main(String[] args) {
		
		AddTwoNumbers atn = new AddTwoNumbers();
		ListNode l1 = atn.new ListNode(2, atn.new ListNode(4, atn.new ListNode(3)));
		ListNode l2 = atn.new ListNode(8, atn.new ListNode(3, atn.new ListNode(2)));
		ListNode node = atn.addTwoNumbers(l1, l2);
		atn.printList(node);
	}
	
	
	private class ListNode {
	    int val;
	    ListNode next;
	    ListNode() {}
	    ListNode(int val) { this.val = val; }
	    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
	}

	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode headOfSum = new ListNode();
		headOfSum = addNumbers(l1, l2, headOfSum, 0, headOfSum);
		return headOfSum;
	}
	
	public ListNode addNumbers(ListNode l1, ListNode l2, ListNode curr, int transfer, ListNode headOfSum) { 
		if(l1.next!=null || l2.next!=null) { 
			int sum = 0;
			if(l1!=null) {
				sum += l1.val;
			}
			if(l2!=null) { 
				sum += l2.val;
			}
			sum += transfer;
			if(sum>=10) { 
				transfer = Math.floorDiv(sum, 10);
				int currVal = sum%10;
				curr.val = currVal;
			}
			else  {
				curr.val = sum;
			}
			ListNode next = new ListNode();
			curr.next = next;
			if(l1.next != null) {
				l1 = l1.next;
			}
			if(l2.next != null) {
				l2 = l2.next;
			}
			addNumbers(l1, l2, next, transfer, headOfSum);
		}
		if(l1.next == null && l2.next == null) { 
			int sum = l1.val + l2.val + transfer;
			ListNode next = new ListNode(sum);
			curr.next = next;
			return headOfSum;
		}
		return headOfSum;
	}
	public void printList(ListNode l) { 
		while(l.next!=null) { 
			System.out.print(l.val + " -> "); 
			l = l.next;
		}
		System.out.println(l.val);
	}
}
