package window;

//Given a string, find the length of the longest substring without repeating characters.
//
//        Example 1:
//
//        Input: "abcabcbb"
//        Output: 3
//        Explanation: The answer is "abc", with the length of 3.
//        Example 2:
//
//        Input: "bbbbb"
//        Output: 1
//        Explanation: The answer is "b", with the length of 1.
//        Example 3:
//
//        Input: "pwwkew"
//        Output: 3
//        Explanation: The answer is "wke", with the length of 3.
//        Note that the answer must be a substring, "pwke" is a subsequence and not a substring.

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class LongestSubstringWithoutRepeatingCharacters {
    public static int lengthOfLongestSubstring(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int front = 0, back = 0, max = 0;
        Set<Character> charSet = new HashSet<>();

        while (front < s.length()) {
            if (!charSet.contains(s.charAt(front))) {
                charSet.add(s.charAt(front));
                int newMax = front - back;
                if (newMax > max) {
                    max = newMax;
                }
                front++;
            } else {
                charSet.remove(s.charAt(back));
                back++;
            }
        }
        return max + 1;
    }
    public static void main (String[] args) {
        System.out.println(LongestSubstringWithoutRepeatingCharacters.lengthOfLongestSubstring("abcabcaa"));
    }
}
