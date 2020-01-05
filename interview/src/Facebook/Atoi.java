package Facebook;

public class Atoi {
    public static int myAtoi(String str) {
        long ret = 0, start = 0;
        boolean isPositive = true, signCheck = false;
        for (int i = 0; i < str.length(); i++) {
            if (isANumber(str.charAt(i))) {
                for (int j = i; j < str.length() && isANumber(str.charAt(j)); j++) {
                    ret = ret * 10 + str.charAt(j) - 48;
                    if (ret > Integer.MAX_VALUE && isPositive) {
                        return Integer.MAX_VALUE;
                    }
                    if (-ret < Integer.MIN_VALUE && !isPositive) {
                        return Integer.MIN_VALUE;
                    }
                }
                break;
            } else {
                if (signCheck) {
                    return 0;
                }
                if (str.charAt(i) == ' ') {
                    continue;
                } else {
                    signCheck = true;
                    if (str.charAt(i) == '-' || str.charAt(i) == '+') {
                        if (str.charAt(i) == '-') {
                            isPositive = false;
                        }
                    } else {
                        return 0;
                    }
                }
            }
        }

        if (isPositive) {
            return (int) ret;
        } else {
            return (int) -ret;
        }
    }
    private static boolean isANumber(char charAt) {
        return charAt >= '0' && charAt <= '9';
    }

    public static void main (String[] args) {
        System.out.println(Atoi.myAtoi("4193 with words"));
    }
}
