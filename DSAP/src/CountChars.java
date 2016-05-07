
public class CountChars {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		String name = "aaaabb";
		int count = 0, i = 1;
		StringBuffer toReturn = new StringBuffer();
		for(i=1; i < name.length(); i++) {
			if(name.charAt(i) == name.charAt(i-1)) {
				count++;
			} else {
				toReturn.append(Character.toString(name.charAt(i-1)) + (count+1));
				count = 0;
			}
		}
		if((count == 0 && i == name.length()) || count!=0) {
			toReturn.append(Character.toString(name.charAt(name.length() - 1)) + (count+1));
		} 
		System.out.println(toReturn.toString());
	}

}
