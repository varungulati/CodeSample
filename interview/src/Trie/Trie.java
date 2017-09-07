package Trie;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// http://www.geeksforgeeks.org/longest-prefix-matching-a-trie-based-solution-in-java/

class TrieNode {
	Character ch;
	Map<Character, TrieNode> children;
	boolean isEnd = false;
	public TrieNode(Character ch, Map<Character, TrieNode> children, boolean isEnd) {
		super();
		this.ch = ch;
		this.children = children;
		this.isEnd = isEnd;
	}
}

public class Trie {
	static TrieNode root;
	public Trie() {
		root = new TrieNode('0', new HashMap<Character, TrieNode>(), true);
	}
	public static boolean add(String word) {
		TrieNode temp = root;
		for(int i = 0; i < word.length(); i++) {
			Character c = word.charAt(i);
			if(!temp.children.containsKey(c)) {
				temp.children.put(c, new TrieNode('0', new HashMap<Character, TrieNode>(), false));
			}
			if(i == word.length() - 1) 
				temp.children.get(c).isEnd = true;
			temp = temp.children.get(c);
		}
		return true;
	}
	public static boolean contains(String word) {
		TrieNode temp = root;
		int i = 0;
		while(i < word.length() && temp.children.containsKey(word.charAt(i))) {
			temp = temp.children.get(word.charAt(i));
			if(i == word.length() - 1)
				return temp.isEnd;
			i++;
		}
		return false;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.add("abc");
		t.add("abd");
		t.add("gulati");
		System.out.println(t.root.children.get('a').children.get('b').children.get('d').isEnd);
		System.out.println(t.contains("gulti"));
	}

}
