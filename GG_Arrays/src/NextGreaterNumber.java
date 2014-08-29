import java.util.Arrays;

//	Given a number n, find the smallest number that has same set of digits as n and is greater than n. If x is the greatest possible number with its set of digits, then print “not possible”.
//	
//	Examples:
//	For simplicity of implementation, we have considered input number as a string.
//	
//	Input:  n = "218765"
//	Output: "251678"
//	
//	Input:  n = "1234"
//	Output: "1243"
//	
//	Input: n = "4321"
//	Output: "Not Possible"
//	
//	Input: n = "534976"
//	Output: "536479"

public class NextGreaterNumber {
	public static int swap(int num, int a, int b) {
//		ArrayList<Integer> al = new ArrayList<Integer>();
		int[] al = new int[b];
		int i = 0;
		while(num > 0 && i < b) {
			al[i] = num%10;
			num /= 10;
			i++;
		}
		int temp = al[0];
		al[0] = al[al.length - 1];
		al[al.length - 1] = temp;
		for(int j = al.length - 1; j >= 0; j--) {
			num = num*10 + al[j];
		}
		return num;
	}
	public static int getNextNumber(int num, int limit) {
		int i = 0;
		int[] al = new int[limit];
		while(num > 0 && i < limit) {
			al[i] = num%10;
			num /= 10;
			i++;
		}
		Arrays.sort(al);
		for(int j = 0; j < al.length; j++) {
			num = num*10 + al[j];
		}
		return num;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int num = 534976;
		int unit = num %10;
		int temp = num, i = 0;
		while(temp > 0) {
			if(temp % 10 < unit) {
				break;
			}
			temp /= 10;
			i++;
		}
		if(temp == 0) {
			return;
		}
		num = swap(num, 0, i + 1);
		num = getNextNumber(num, i);
		System.out.println(num);
	}

}
