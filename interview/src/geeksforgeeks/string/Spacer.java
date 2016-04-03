package geeksforgeeks.string;

public class Spacer {

	public static void spacer(String str, String res) {
		if (str.length() == 0) {
			System.out.println(res);
			return;
		}
		res = str.charAt(str.length() - 1) + res;
		spacer(str.substring(0, str.length() - 1), res);
		if(str.length() - 1 != 0)
			spacer(str.substring(0, str.length() - 1), " " + res);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		spacer("ABC", "");
	}

}
