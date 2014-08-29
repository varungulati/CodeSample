//	Merge a linked list into another linked list at alternate positions
//	Given two linked lists, insert nodes of second list into first list at alternate positions of first list.
//	For example, if first list is 5->7->17->13->11 and second is 12->10->2->4->6, the first list should become 5->12->7->10->17->2->13->4->11->6 and second list should become empty. The nodes of second list should only be inserted when there are positions available. 
//  For example, if the first list is 1->2->3 and second list is 4->5->6->7->8, then first list should become 1->4->2->5->3->6 and second list to 7->8.
//	
//	Use of extra space is not allowed (Not allowed to create additional nodes), i.e., insertion must be done in-place. Expected time complexity is O(n) where n is number of nodes in first list.
//	
//	The idea is to run a loop while there are available positions in first loop and insert nodes of second list by changing pointers. Following is C implementation of this approach.
public class MergeLL {
	public static LinkedList mergeLL(LinkedList l1, LinkedList l2) {
		if(l1 == null) {
			return l2;
		}
		if(l2 == null) {
			return l1;
		}
		LinkedList c1 = l1, curr1 = l1, curr2 = l2;
		while(l1.next != null && l2.next != null) {
			curr1 = l1.next;
			l1.next = l2;
			curr2 = l2.next;
			l2.next = curr1;
			l1 = curr1;
			l2 = curr2;
		}
		if(l1.next == null) {
			l1.next = curr2;
		}
		if(l2.next == null) {
			l2.next = curr1;
		}
		return c1;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList l1 = new LinkedList(1, null);
		l1.addLast(new LinkedList(2, null));
		l1.addLast(new LinkedList(3, null));
		LinkedList l2 = new LinkedList(4, null);
		l2.addLast(new LinkedList(5, null));
		l2.addLast(new LinkedList(6, null));
		l2.addLast(new LinkedList(7, null));
		l2.addLast(new LinkedList(8, null));
		System.out.println(mergeLL(l1, l2));
	}

}
