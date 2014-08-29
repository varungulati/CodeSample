
public class Reverse {
	public static void reverseRecursive(LinkedList head) {
		if(head == null) {
			return;
		}
		reverseRecursive(head.next);
		System.out.println(head.data);
	}
//	public static LinkedList reverseRecursiveNewLL(LinkedList head) {
//		if(head == null) {
//			return null;
//		}
//		if(head.next == null) {
//			return new LinkedList(head.data, null);
//		}
////		return head.setNext(reverseRecursiveNewLL(head.next));
//		return new LinkedList(head.data, null).setNext(reverseRecursiveNewLL(head.next));
//	}
	public static LinkedList reverseIterative(LinkedList head) {
		if(head == null) {
			return head;
		}
		LinkedList temp = head;
		// 10 5 11
		LinkedList curr = null;
		LinkedList prev = null;
		while(temp != null) {
			curr = temp;
			temp = temp.next;
			curr.next = prev;
			prev = curr;
		}
		return curr;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList head = new LinkedList(10, new LinkedList(5, new LinkedList(11, null)));
		System.out.println(head);
		reverseRecursive(head);
//		System.out.println(reverseRecursiveNewLL(head));
		System.out.println(reverseIterative(head));
	}
}
