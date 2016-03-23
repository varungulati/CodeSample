package Mathematical;

import java.util.ArrayList;

//http://www.geeksforgeeks.org/given-array-strings-find-strings-can-chained-form-circle/

public class CircularString {
	public static boolean isChain(ArrayList<Character> c1, ArrayList<Character> c2, char first, char search) {
		if(c1.size() == 0 && first != search) return false;
		if(c1.size() == 0 && first == search) {
			return true;
		}
		boolean result = false;
		for (int i = 0; i < c2.size(); i++) {
			if (c1.get(i) == search) {
				ArrayList<Character> tempC1 = new ArrayList<>(c1);
				ArrayList<Character> tempC2 = new ArrayList<>(c2);
				tempC1.remove(i);
				tempC2.remove(i);
				result = result || isChain(tempC1, tempC2, first, c2.get(i));
			}
		}
		return result;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Character> c1 = new ArrayList<Character>();
		ArrayList<Character> c2 = new ArrayList<Character>();
/*		c1.add('f');
		c2.add('r');*/
		c1.add('g');
		c2.add('k');
		c1.add('r');
		c2.add('g');
		c1.add('k');
		c2.add('f');
		System.out.println(isChain(c1, c2, 'f', 'r'));
	}

}
