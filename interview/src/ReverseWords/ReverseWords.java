package ReverseWords;

import java.util.Arrays;

public class ReverseWords {
	public static void reverseWords(char[] ch, String word) {
		if(ch.length == 0) {
			System.out.println(word);
			return;
		}
		if(ch[0] != ' ') {
			word = word + ch[0];
			reverseWords(Arrays.copyOfRange(ch, 1, ch.length), word);
		} else {
			reverseWords(Arrays.copyOfRange(ch, 1, ch.length), "");
			System.out.println(word);
		}
	}
	public static void main(String[] args) {
		char[] ch = {'a', 'b', 'c', ' ', 'd', 'e', 'f', ' ', 'g', 'h'};
		reverseWords(ch, "");
	}
}
