package MooreVotingAlgo;

public class FindMajority {

	public int findMajority(int[] arr) {
		int candidate = findCandidate(arr);
		if(validateCandidate(arr, candidate)) {
			return candidate;
		} else {
			return -1;
		}
	}
	public int findCandidate(int[] arr) {
		int count = 1, majCandidate = 0;
		for(int i = 1; i < arr.length; i++) {
			if(arr[i] == arr[majCandidate]) {
				count++;
			} else {
				count--;
			}
			if(count == 0) {
				majCandidate = i;
				count = 1;
			}
		}
		return arr[majCandidate];
	}
	public boolean validateCandidate(int[] arr, int num) {
		int count = 0;
		for(int i = 0; i < arr.length; i++) {
			if(count > arr.length/2) {
				return true;
			}
			if(arr[i] == num) {
				count++;
			}
		}
		return false;
	}
	public static void main(String[] args) {
		int[] arr = {1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,2,2,3,3,4,4,4,4,4,4,4,4,4,4,4};
		FindMajority fm = new FindMajority();
		System.out.println(fm.findMajority(arr));
	}

}
