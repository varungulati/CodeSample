package geeksforgeeks.string;

public class OneAndTwoComplement {
	public static String onesComplement(String binArg) {
		StringBuffer toReturn = new StringBuffer();
		for (int i = 0; i < binArg.length(); i++) {
			if(binArg.charAt(i) == '0') {
				toReturn.append('1');
			} else {
				toReturn.append('0');
			}
		}
		return toReturn.toString();
	}
	
	public static String twosComplement(String binArg) {
		StringBuffer toReturn = new StringBuffer();
		String onesComp = onesComplement(binArg);
		if(onesComp.charAt(onesComp.length()-1) == '0') {
			toReturn.append(onesComp.substring(0, onesComp.length() - 1));
			toReturn.append('1');
			return toReturn.toString();
		}
		int i;
		for(i = onesComp.length() - 1; i >= 0; i--) {
			if(onesComp.charAt(i) == '0') {
				break;
			}
		}
		if(i == -1) {
			toReturn.append('1');
			int j = 0;
			while(j++ < onesComp.length()) {
				toReturn.append('0');
			}
			return toReturn.toString();
		}
		toReturn.append(onesComp.substring(0, i));
		toReturn.append('1');
		int j = i+1;
		while(j++ < onesComp.length()) {
			toReturn.append('0');
		}
		return toReturn.toString();
	}
	public static void main(String args[]) {
		String arg = "11000000000000000000000111100001100";
		System.out.println(onesComplement(arg));
		System.out.println(twosComplement(arg));
	}
}
