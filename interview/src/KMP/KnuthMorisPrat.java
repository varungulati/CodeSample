package KMP;

import java.util.Arrays;

public class KnuthMorisPrat {
	public static int[] presuff(String pat) {
		if (pat.length() == 0) {
			return new int[] {};
		}
		if (pat.length() == 1) {
			return new int[] { 0 };
		}
		int i = 0, j = 1;
		int arr[] = new int[pat.length()];
		arr[0] = 0;
		while (j < pat.length()) {
			if (pat.charAt(i) == pat.charAt(j)) {
				i++;
				arr[j] = arr[j - 1] + 1;
				j++;
			} else {
				if (i == 0) {
					j++;
					continue;
				} else {
					i = arr[i - 1];
				}
			}
		}
		return arr;
	}

	public static void finder(String str, String pat) {
		if (str.length() == 0 || pat.length() == 0) {
			return;
		}
		int arr[] = presuff(pat);
		for (int i = 0, j = 0; i < str.length();) {
			if (pat.charAt(j) == str.charAt(i)) {
				i++;
				j++;
				if (j == pat.length() - 1) {
					System.out.println("Found at: " + (i - pat.length() + 1));
					j = arr[j - 1];
				}
			} else {
				if (j == 0) {
					i++;
					continue;
				}
				j = arr[j - 1];
			}
		}
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		String str = "AABAACAADAABAABAA";
//		String pat = "AABAA";
		String str = "THIS IS A TEST TEXT";
		String pat = "TEST";
		System.out.println(Arrays.toString(presuff(pat)));
		finder(str, pat);
	}

}
