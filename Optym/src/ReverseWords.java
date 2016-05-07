
public class ReverseWords {
public String reverseWords(String s) {
	String[] temp = s.split(" ");
	StringBuffer toReturn = new StringBuffer();
	for(int i = temp.length - 1; i >= 0;) {
		if(i == temp.length - 1) {
			toReturn.append(Character.toUpperCase(temp[i].charAt(0)));
			toReturn.append(temp[i].substring(1, temp[i].length() - 1));
			if(i != 0) {
				toReturn.append(" ");
			}
			i--;
		} else if(i == 0) {
			if(temp[i].equals("I")) {
				toReturn.append(temp[i]);
			} else {
				toReturn.append(Character.toLowerCase(temp[i].charAt(0)));
				toReturn.append(temp[i].substring(1, temp[i].length()));
			}
			i--;
		} else {
			toReturn.append(temp[i]);
			if(i != 0) {
				toReturn.append(" ");
			}
			i--;
		}
	}
	toReturn.append(".");
	return toReturn.toString();
}
	public static void main(String[] args) {
		String s = "He is good.";
		ReverseWords ob = new ReverseWords();
		System.out.println(ob.reverseWords(s));
	}
}
