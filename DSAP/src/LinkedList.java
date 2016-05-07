import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList implements Iterable<Object> {
	private Node head;
	public LinkedList() {
		this.head = null;
	}
	public void addFirst(int data) {
		this.head = new Node(data, this.head);
	}
	public void traverse() {
		Node temp = this.head;
		while(temp != null) {
			System.out.println(temp.data);
			temp = temp.next;
		}
	}
	public void addLast(int data) {
		if(this.head == null) {
			this.head = new Node(data, null);
			return;
		}
		Node temp = this.head;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.next = new Node(data, null);
	}
	public void insertAfter(int key, int data) {
		if(this.head == null) {
			return;
		}
		Node temp = this.head;
		while(temp != null && temp.data != key) {
			temp = temp.next;
		}
		if(temp != null) {
			Node insert = new Node(data, temp.next);
			temp.next = insert;
		} else {
			System.out.println("No Entry");
		}
	}
	public void insertBefore(int key, int data) {
		if(this.head == null) {
			return;
		}
		if(this.head.data == key) {
			head = new Node(data, head);
			return;
		}
		Node curr = this.head;
		Node prev = null;
		while(curr != null && curr.data !=key) {
			prev = curr;
			curr = curr.next;
		}
		if(curr != null) {
			prev.next = new Node(data, curr);
		} else {
			System.out.println("No Entry");
		}
	}
	public void remove(int data) {
		if(this.head == null) {
			return;
		}
		if(this.head.data == data) {
			head = head.next;
			return;
		}
		Node curr = this.head;
		Node prev = null;
		while(curr != null && curr.data != data) {
			prev = curr;
			curr = curr.next;
		}
		if(curr != null) {
			prev.next = curr.next;
		} else {
			System.out.println("Not Found");
		}
	}
	@Override
	public Iterator<Object> iterator() {
		if(this.head == null) {
			return null;
		}
		return new LinkedListIterator();
	}
	private final class LinkedListIterator implements Iterator<Object> {
		private Node start = null;
		public LinkedListIterator() {
			this.start = head;
		}
		@Override
		public boolean hasNext() {
			return this.start != null;
		}
		@Override
		public Object next() {
			if(this.start == null) {
				throw new NoSuchElementException();
			}
			int toReturn = this.start.data;
			this.start = this.start.next;
			return toReturn; 
		}
		@Override
		public void remove() {
			return;
		}
	}
	private static final class Node {
		int data;
		private Node next;
		public Node(int data, Node next) {
			this.data = data;
			this.next = next;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LinkedList ll = new LinkedList();
		ll.addFirst(2);
		ll.addFirst(1);
		ll.addLast(3);
		ll.addLast(4);
		ll.insertBefore(1, 8);
		ll.remove(4);
//		ll.traverse();
		Iterator<?> iter = ll.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
	}

}
