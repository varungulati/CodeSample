
public class LinkedList {
	int data;
	LinkedList next;
	LinkedList(int data, LinkedList next) {
		this.data = data;
		this.next = next;
	}
	public void setNext(LinkedList node) {
		this.next = node;
	}
	public LinkedList getNext() {
		return next;
	}
	public void addLast(LinkedList node) {
		LinkedList temp = this;
		while(temp.next != null) {
			temp = temp.next;
		}
		temp.setNext(node);
	}
	public String toString() {
		LinkedList temp = this;
		String toReturn = "";
		while(temp != null) {
			toReturn = toReturn + temp.data + " ";
			temp = temp.next;
		}
		return toReturn;
	}
}
