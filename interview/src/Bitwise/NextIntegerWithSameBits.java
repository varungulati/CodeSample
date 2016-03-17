package Bitwise;

public class NextIntegerWithSameBits {
	public static int getNext(int n) {
		if(n <= 0) return 0;
		int toReturn = 0;
		if(n % 2 == 0) {
			int temp = n, count = 0;
			while((temp %2) == 0) {
				temp /= 2;
				count++;
			}
			count = (int)Math.pow(2, count);
			count ++;
			toReturn = n + count;
		} else {
			int temp = n, count = 0;
			while(((temp/2) % 2) != 0) {
				count++;
				temp /= 2;
			}
			count = (int)Math.pow(2, count);
			toReturn = n + count;
		}
		return toReturn;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		System.out.println(getNext(3));
		System.out.println(getNext(6));
		System.out.println(getNext(11));
		System.out.println(getNext(23));
		System.out.println(getNext(24));
		System.out.println(getNext(44));
		
	}

}
