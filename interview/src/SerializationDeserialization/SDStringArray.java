package SerializationDeserialization;

import java.util.Arrays;

public class SDStringArray {
	public static String serialize(String[] sa) {
		StringBuffer toReturn = new StringBuffer();
		toReturn.append(sa.length + "$");
		for(String s: sa) {
			toReturn.append(s.length() + "$");
			toReturn.append(s);
		}
		return toReturn.toString();
	}
	public static String readTillDollar(String s) {
		StringBuffer toReturn = new StringBuffer();
		for(int i = 0; i < s.length(); i++) {
			if(s.charAt(i) != '$') {
				toReturn.append(s.charAt(i));
			} else {
				break;
			}
		}
		return toReturn.toString();
	}
	public static String[] deserialize(String s) {
		int read = 0;
		String size = readTillDollar(s);
		read = read + size.length() + 1;
		String[] toReturn = new String[Integer.valueOf(size)];

		for(int j = 0; read < s.length();) {
			String len = readTillDollar(s.substring(read));
			read = read + len.length() + 1;
			toReturn[j++] = s.substring(read, read + Integer.valueOf(len) - 1);
			read = read + Integer.valueOf(len);
		}
		return toReturn;
	}
	public static void main(String[] args) {
		String[] sa = {"as $sa", "fff hr", "kokoko kk", "looo"};
		System.out.println(Arrays.toString(deserialize(serialize(sa))));
	}
}
