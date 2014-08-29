//  http://www.geeksforgeeks.org/pairwise-swap-elements-of-a-given-linked-list-by-changing-links/
//	Pairwise swap elements of a given linked list by changing links
//	Given a singly linked list, write a function to swap elements pairwise. 
//  For example, if the linked list is 1->2->3->4->5->6->7 then the function should change it to 2->1->4->3->6->5->7,
//  and if the linked list is 1->2->3->4->5->6 then the function should change it to 2->1->4->3->6->5
//	
//	This problem has been discussed here. The solution provided there swaps data of nodes. If data contains many fields, there will be many swap operations. So changing links is a better idea in general. Following is a C implementation that changes links instead of swapping data.

public class PairwiseSwap {

	public static LinkedList pairwiseSwap(LinkedList head) {
		if(head == null || head.next == null) {
			return head;
		}
		LinkedList curr = head, prev = null, pprev = null;
		head = head.next;
		while(curr != null && curr.next != null) {
			prev = curr;
			curr = curr.next.next;
			prev.next.next = prev;
			if(pprev != null) {
				pprev.next = prev.next;
			} else {
				pprev = prev;
			}
			prev.next = curr;
			pprev = prev;
		}
		return head;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l = new LinkedList(1, null);
		l.addLast(new LinkedList(2, null));
		l.addLast(new LinkedList(3, null));
		l.addLast(new LinkedList(4, null));
		l.addLast(new LinkedList(5, null));
		l.addLast(new LinkedList(6, null));
//		l.addLast(new LinkedList(7, null));
		System.out.println(l);
		System.out.println(pairwiseSwap(l));
	}

}
