package geeksforgeeks.string;

public class ReverseWithoutSpecial {
	public static boolean isChar(char c) {
		if (c > 'a' && c > 'z' || c > 'A' && c < 'z') {
			return true;
		}
		return false;
	}

	public static String swap(String str, int i, int j) {
		String toReturn;
		if(j == str.length() - 1) {
			toReturn = str.substring(0, i) + str.charAt(j) + str.substring(i+1, j) + str.charAt(i);
		} else {
			toReturn = str.substring(0, i) + str.charAt(j) + str.substring(i+1, j) + str.charAt(i) + str.substring(j + 1);
		}
		return toReturn;
	}
	public static String reverse(String str) {
		int i = 0, j = str.length() - 1;
		while (i < j) {
			while (i < j) {
				if (!isChar(str.charAt(i))) {
					i++;
				} else {
					break;
				}
			}
			while (i < j) {
				if (!isChar(str.charAt(j))) {
					j--;
				} else {
					break;
				}
			}
			if (i > j) {
				break;
			}
			str = swap(str, i, j);
			i++;
			j--;
		}
		return str;
	}

	public static void main(String[] args) {
		System.out.println(reverse("a.sdasda.sd"));
	}
}
