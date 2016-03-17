package LongestTwoCharacterString;

// Given aaabccdddefgggh
// Return ccddd = 5 = fc, sc, temp_max, curr_max, two_Char
// a = 1, 0 = 1, 0, 0, 0, false
// aa = 2, 0 = 2, 0, 2, 2, false
// aaa = 3, 0 = 3, 0, 3, 3, false
// aaab = 4, 0 = 3, 1, 3, 3, true
// bc = 4, 2 = 1, 1, 2, 3, true
// bcc = 4, 3 = 1, 2, 3, 3, true
// ccd = 4, 3
// ccdd = 4, 4
// ccddd = 5, 5

public class LongestTwoCharacterString {
	public static int getLongest(String s) {
		if(s.length() <= 2) {
			return s.length();
		}
		int curr_max = 0, temp_max = 0, fc = 1, sc = 0;
		boolean two_char = false;
		for(int i = 1; i < s.length(); i++) {
			if(s.charAt(i) != s.charAt(i-1) && two_char == true) {
				fc = sc;
				sc = 1;
			}
			if(s.charAt(i) != s.charAt(i-1) && two_char == false) {
				sc = 1;
				two_char = true;
			}
			if(s.charAt(i) == s.charAt(i-1)) {
				if(two_char) {
					sc++;
				} else {
					fc++;
				}
			}
			temp_max = fc + sc;
			if(temp_max > curr_max) {
				curr_max = temp_max;
			}
		}
		return curr_max;
	}
	public static void main(String[] args) {
		System.out.println(getLongest("aaabccdddefgggh"));
	}
}
