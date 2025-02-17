package Atoi;

public class Atoi {
    public int atoi(String s) {
        if (s.length() == 0) {
            throw new IllegalArgumentException();
        }
        int result = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            Character c = s.charAt(i);
            int digit = c.charValue() - '0';
            result = (int) Math.pow(10, s.length() - i - 1) * digit + result;
        }
        return result;
    }

    public static int atoiImproved(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int num = 0;
        for (int i = 0; i < s.length(); i++) {
            Character c = s.charAt(i);
            int dig = c.charValue() - '0';
            num = num * 10 + dig;
        }
        return num;
    }

    private int atoiNewHelper(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        return (s.charAt(s.length() - 1) - '0') + 10 * atoiNewHelper(s.substring(0, s.length() - 1));
    }

    public int atoiNew(String s) {
		if (s.charAt(0) == '-') {
			return -1 * atoiNewHelper(s.substring(1));
		} else {
			return atoiNewHelper(s);
		}
    }

    public static void main(String[] args) {
        Atoi atoi = new Atoi();
        System.out.println(atoi.atoiNew("-1"));
    }

}
