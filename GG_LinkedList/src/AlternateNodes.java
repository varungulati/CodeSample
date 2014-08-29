//  http://www.geeksforgeeks.org/given-linked-list-reverse-alternate-nodes-append-end/
//	Given a linked list, reverse alternate nodes and append at the end
//	Given a linked list, reverse alternate nodes and append them to end of list. Extra allowed space is O(1) 
//	Examples
//	
//	Input List:  1->2->3->4->5->6
//	Output List: 1->3->5->6->4->2
//	
//	Input List:  12->14->16->18->20
//	Output List: 12->16->20->18->14
public class AlternateNodes {

	public static void alternateNodesHelper(LinkedList head) {
		if(head == null) {
			return;
		}
		System.out.println(head.data);
		if(head.next != null) {
			if(head.next.next != null) {
				alternateNodesHelper(head.next.next);
			}
			System.out.println(head.next.data);
		}
	}
	public static void alternateNodes(LinkedList head) {
		if(head == null) {
			return;
		}
		alternateNodesHelper(head);
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
		System.out.println(l);
		alternateNodes(l);
	}

}
