package Atoi;

public class Atoi {
	public int atoi(String s) {
		if(s.length() == 0) {
			throw new IllegalArgumentException();
		}
		int result = 0;
		for(int i = s.length() - 1; i >= 0; i--) {
			Character c = s.charAt(i);
			int digit = c.charValue() - '0';
			result = (int)Math.pow(10, s.length() - i - 1)*digit + result;
		}
		return result;
	}
	public static int atoiImproved(String s) {
		if(s.length() == 0) {
			return 0;
		}
		int num = 0;
		for(int i = 0; i < s.length(); i++) {
			Character c = s.charAt(i);
			int dig = c.charValue() - '0';
			num = num*10 + dig;
		}
		return num;
	}
	public static void main(String[] args) {
		System.out.println(Atoi.atoiImproved("1239"));
	}

}
