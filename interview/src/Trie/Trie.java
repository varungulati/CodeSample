package Trie;

import java.util.HashMap;
import java.util.ArrayList;

public class Trie {
	private HashMap<Character, HashMap> root;
	
	public Trie() {
		this.root = new HashMap<Character, HashMap>();
	}
	public HashMap<Character, HashMap> getRoot() {
		return this.root;
	}
	public ArrayList<ArrayList<String>> getString(HashMap<Character, HashMap> map, ArrayList<ArrayList<String>> array) {
		if(map.keySet().size() == 0) {
			return null;
		}
		ArrayList<String> toReturn = new ArrayList<String>();
		for(Character c: map.keySet()) {
			toReturn.add(c.toString() + getString(map.get(c), array));
		}
		array.add(toReturn);
		return array;
	}
	public ArrayList<String> autoComplete(String s) {
		HashMap<Character, HashMap> temp = this.root;
		for(int i = 0; i < s.length(); i++) {
			if(temp.containsKey(s.charAt(i))) {
				temp = temp.get(s.charAt(i));
			} else {
				return null;
			}
		}
		ArrayList<String> toReturn = new ArrayList<String>();
		for(Character c: temp.keySet()) {
			String toAdd = c.toString();
			HashMap<Character, HashMap> inner = temp.get(c);
			while(!inner.containsKey('$')) {
				inner = inn
			}
		}
		return null;
	}
    public boolean findPattern(String s) {
    	for(Character c: this.root.keySet()){
    		if(c.equals(s.charAt(0))) {
    			HashMap<Character, HashMap> curr = this.root.get(c);
    			for(int j = 1; j < s.length(); j++) {
    				if(!curr.containsKey(s.charAt(j))) {
    					break;
    				}
    				if(j == s.length() - 1 && curr.containsKey(s.charAt(j))) {
    					return true;
    				}
    				curr = curr.get(s.charAt(j));
    			}
    		}
    	}
    	return false;
    }
    public void add(String s) {
        s += "$";
        for(int i = 0; i < s.length(); i++) {
        	HashMap<Character, HashMap> curr = root;
        	for(int j = i; j < s.length(); j++) {
        		if(!curr.containsKey(s.charAt(j))) {
        			curr.put(s.charAt(j), new HashMap<Character, HashMap>());
        		}
        		curr = curr.get(s.charAt(j));
        	}
        }

//        for(Character c: this.root.keySet()) {
//        	String a = c.toString();
//        	String v = this.root.get(c).toString();
//        	System.out.println(c + v);
//        }
    }

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Trie t = new Trie();
		t.add("abaaaba");
		System.out.println(t.findPattern("aaaba"));
		HashMap<Character, HashMap> map = t.getRoot();
		ArrayList<ArrayList<String>> array = new ArrayList<ArrayList<String>>();
		t.getString(map, array);
		for(ArrayList<String> arr: array) {
			for(String s: arr){
				System.out.print(s);
			}
			System.out.println();
		}
	}

}
