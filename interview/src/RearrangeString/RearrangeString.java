package RearrangeString;

import java.util.Arrays;
import java.util.HashMap;
import java.util.TreeMap;

public class RearrangeString {
	public static TreeMap<Character, Integer> getCharCount(String str) {
		if (str.length() == 0) {
			return null;
		}
		TreeMap<Character, Integer> toReturn = new TreeMap<>();
		for (int i = 0; i < str.length(); i++) {
			if(toReturn.keySet().contains(str.charAt(i))) {
				toReturn.put(str.charAt(i), toReturn.get(str.charAt(i)) + 1);
			} else {
				toReturn.put(str.charAt(i), 1);
			}
		}
		return toReturn;
	}

	public static String getPacking(String str, int d) {
		TreeMap<Character, Integer> charCount = getCharCount(str);
		char[] temp = new char[str.length()];
		Arrays.fill(temp, '\0');
		while(!charCount.isEmpty()) {
			char c= '\0';
			int currMax = 0;
			for(Character ch: charCount.keySet()) {
				if(currMax < charCount.get(ch)) {
					currMax = charCount.get(ch);
					c = ch;
				}
			}
			int index = 0;
			for (int i = 0; i < charCount.get(c);) {
				if(temp[index] == '\0') {
					temp[index] = c;
					index += d;
					i++;
				} else {
					index++;
				}
			}
			charCount.remove(c);
		}
		return Arrays.toString(temp);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getPacking("aacbbc", 3));
		System.out.println(getPacking("geeksforgeeks", 3));
		System.out.println(getPacking("aaa", 2));
	}

}
