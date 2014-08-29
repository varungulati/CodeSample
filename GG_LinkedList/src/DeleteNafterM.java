//  http://www.geeksforgeeks.org/delete-n-nodes-after-m-nodes-of-a-linked-list/
//	Given a linked list and two integers M and N. Traverse the linked list such that you retain M nodes then delete next N nodes, continue the same till end of the linked list.
//	
//	Difficulty Level: Rookie
//	
//	Examples:
//	
//	Input:
//	M = 2, N = 2
//	Linked List: 1->2->3->4->5->6->7->8
//	Output:
//	Linked List: 1->2->5->6
//	
//	Input:
//	M = 3, N = 2
//	Linked List: 1->2->3->4->5->6->7->8->9->10
//	Output:
//	Linked List: 1->2->3->6->7->8
//	
//	Input:
//	M = 1, N = 1
//	Linked List: 1->2->3->4->5->6->7->8->9->10
//	Output:
//	Linked List: 1->3->5->7->9
public class DeleteNafterM {
	public static LinkedList deleteNafterM(LinkedList head, int n, int m) {
		LinkedList temp = head;
		while(temp != null) {
			int i = 0;
			if(temp == head) {
				i = 1;
			} else {
				i = 0;
			}
			for(; i < m && temp != null; i++) {
				temp = temp.next;
			}
			if(temp == null) {
				return head;
			}
			LinkedList node = temp;
			for(int j = 0; j < n && temp != null; j++) {
				temp = temp.next;
			}
			if(temp == null) {
				node.next = null;
				return head;
			}
			node.next = temp.next;
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
		l.addLast(new LinkedList(7, null));
		l.addLast(new LinkedList(8, null));
		System.out.println(l);
		System.out.println(deleteNafterM(l, 1, 1));
	}

}
