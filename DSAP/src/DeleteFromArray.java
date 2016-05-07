import java.util.Arrays;


public class DeleteFromArray {
	public static int[] delete(int[] arr, int pos) {
		if(pos >= 0 && pos < arr.length) {
		int[] temp = new int[arr.length - 1];
		System.arraycopy(arr, 0, temp, 0, pos);
		System.arraycopy(arr, pos + 1, temp, pos, arr.length - pos - 1);
		return temp;
		} else {
			return arr;
		}
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] arr = {0,1,2,3,4,5,6,7};
		arr = delete(arr, 1);
		System.out.println(Arrays.toString(arr));
	}

}
