package LRC;

import java.util.HashMap;
import java.util.HashSet;

class DLL {
	public int data;
	public DLL left = null;
	public DLL right = null;
	public DLL() {
		
	}
	public DLL(int data, DLL left, DLL right) {
		this.data = data;
		this.left = left;
		this.right = right;
	}
}
public class LeastRecentCache {
	public HashMap<String, DLL> lru = null;
	public DLL head = null;
	public DLL tail = null;
	
	public LeastRecentCache() {
		lru = new HashMap<String, DLL>();
	}
	public HashMap<String, DLL> remove(String key) {
		if(lru.size() == 0 || this.lru.get(key) == null) {
			return null;
		}
		if(this.lru.get(key) == tail) {
			tail = tail.left;
			tail.right = null;
		}
		if(this.lru.get(key) == head) {
			head = head.right;
			head.left = null;
		}
		DLL temp = this.lru.get(key);
		this.lru.remove(key);
		HashMap<String, DLL> toReturn = new HashMap<String, DLL>();
		toReturn.put(key, temp);
		return toReturn;
	}
	public void insert(String key, int value) {
		if(lru.size() == 0) {
			head = new DLL(value, null, null);
			lru.put(key, head);
			tail = head;
		} else {
			DLL temp = new DLL(value, null, null);
			lru.put(key, temp);
			temp.right = head;
			head.left = temp;
			head = temp;
		}
	}
	public void add(String key, int value) {
		remove(key);
		insert(key, value);
	}
	public String toString() {
		DLL temp = head;
		while(temp != null) {
			System.out.print(temp.data);
		}
		return null;
	}
	public static void main(String[] args) {
		LeastRecentCache l = new LeastRecentCache();
		l.add("A", 1);
		System.out.println(l);
	}
}
