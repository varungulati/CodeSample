package geeksforgeeks.string;

import java.util.Stack;

// TODO - Do again

public class LongestValidSubstring {

	public static int findLongestValidSubstring(String str) {
		Stack<Integer> st = new Stack<>();
		int low = 0, curMax = 0, max = 0;
		for (int i = 0; i < str.length(); i++) {
			if(str.charAt(i) == '(') {
				st.push(i);
			} else {
				if(!st.isEmpty()) {
				low = st.pop();
				curMax = i - low;
				}
			}
		}
		return curMax + 1;
	}
	
	public static void main(String[] args) {
		System.out.println(findLongestValidSubstring(")()())"));
	}
}
