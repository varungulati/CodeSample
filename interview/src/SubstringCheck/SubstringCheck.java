package SubstringCheck;

public class SubstringCheck {

	// NAIVE PATTERN SEARCHING
	// Number of comparisons in worst case is O(m*(n-m+1))
	// m = sub.length()
	// n = s.length()
	public static void substringCheck(String s, String sub) {
		for(int i = 0; i < s.length() - sub.length(); i++) {
			if(s.charAt(i) == sub.charAt(0)) {
				for(int j = 1, k = i + 1; j < sub.length() && k < s.length(); j++, k++) {
					if(sub.charAt(j) != s.charAt(k)) {
						break;
					}
					if(j == sub.length() - 1) {
						System.out.println("Pattern found at: " + i);;
					}
				}
			}
		}
	}
	// KMP pattern searching.
	// 1. Build pattern array.
	public static void buildArray(String sub, int[] arr) {
		int i = 0;
		arr[0] = 0;
		for(int j = 1; j < sub.length(); j++) {
			if(sub.charAt(j) == sub.charAt(i)) {
				arr[j] = arr[j-1] + 1;
				i++;
			} else {
				i = 0;
				if(sub.charAt(j) == sub.charAt(i)) {
					arr[j] = arr[j-1] + 1;
					i++;
				}
			}
		}
	}
	public static void displayArray(int arr[]) {
		for(int a = 0; a < arr.length; a++) {
			System.out.println(arr[a]);
		}
	}
	public static void substringKMP(String s, String sub) {
		int[] arr = new int[sub.length()];
		buildArray(sub, arr);
		int i = 0;
		while(i < s.length() - sub.length()) {
			if(s.charAt(i) == sub.charAt(0)) {
				int j = 1, k = i + 1;
				for(; j < sub.length(); j++, k++) {
					if(s.charAt(k) != sub.charAt(j)) {
						i += sub.length() - arr[j];
						break;
					}
				}
				if(j == sub.length()) {
					System.out.println("Found at index: " + i);
				}
			}
			i++;
		}
	}
	public static void main(String[] args) {
		String s = "lklkalklkask";
		String sub = "lk";
//		substringCheck(s, sub);
		substringKMP(s, sub);
	}

}
