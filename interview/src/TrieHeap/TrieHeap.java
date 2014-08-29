// Find the k most frequent words from a file
// http://www.geeksforgeeks.org/find-the-k-most-frequent-words-from-a-file/

package TrieHeap;
import java.util.HashMap;

public class TrieHeap {
	private int[] heap;
	private HashMap<Character, HashMap> trie = new HashMap<Character, HashMap>();
	public void printTrie() {
		for(Character c: this.trie.keySet()) {
			System.out.println(c.toString() + ": " + this.trie.get(c).toString());
		}
	}
	private void addToMinHeap(int[] heap) {
		
	}
	public void addToTrie(String s) {
		s += "$";
		HashMap<Character, HashMap> temp = trie;
		for(int i = 0; i < s.length(); i++) {
			Character c = new Character(s.charAt(i));
			if(!temp.containsKey(c)) {
				temp.put(c, new HashMap<Character, HashMap>());
			}
			temp = temp.get(c);
		}
	}
	private void makeTrie(String[] str) {
		for(int i = 0; i < str.length; i++) {
			addToTrie(str[i]);
		}
	}
	private void siftUp(int[] heap) {
		
	}
	public void displayMostFrequent(String[] strArr, int k) {
		this.heap = new int[k];
		makeTrie(strArr);
		for(int i = 0; i < this.heap.length; i++) {
			System.out.println(this.heap[0]);
			siftUp(this.heap);
		}
	}
	public static void main(String[] args) {
		String s = "This is is is is a a program to to to";
		String arr[] = s.split(" ");
		TrieHeap tester = new TrieHeap();
//		tester.displayMostFrequent(arr, 2);
		tester.addToTrie("abcd");
		tester.addToTrie("abdd");
		tester.printTrie();
	}

}
