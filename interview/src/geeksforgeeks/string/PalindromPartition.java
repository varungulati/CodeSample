package geeksforgeeks.string;

public class PalindromPartition {

	public static boolean isPalindrom(String str) {
		StringBuffer temp = new StringBuffer();
		int i = str.length() - 1;
		while(i >= 0 ) {
			temp.append(str.charAt(i--));
		}
		if(temp.toString().equals(str)) {
			return true;
		}
		return false;
	}
	public static void printer(String str) {
		for (int i = 0; i < str.length(); i++) {
			System.out.println();
			for (int j = i; j < str.length(); j++) {
				if(j == str.length()) {
					if(isPalindrom(str.substring(i))) {
						System.out.print(" "  + str.substring(i));
					}
					break;
				}
				if(isPalindrom(str.substring(i, j+1))) {
					System.out.print(" " + str.substring(i, j+1));
				}
			}
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		printer("nitin");
	}

}
