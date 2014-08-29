package SegmentTrees;

public class SegmentTrees {
	public int[] st;
	public int makeTreeUtil(int[] arr, int lo, int hi, int[] st, int si) {
		if(hi == lo) {
			System.out.println(si);
			st[si] = arr[lo];
			return st[si];
		}
		int mid = (lo + hi)/2;
		st[si] = makeTreeUtil(arr, lo, mid, st, 2*si + 1) + makeTreeUtil(arr, mid + 1, hi, st, 2*si + 2);
		return st[si];
		
	}
	public int getSumUtil(int[] arr, int qs, int qe, int ss, int se, int si) {
		if(qs <= ss && qe >= se) {
			return this.st[si];
		}
		if(qe < ss || qs > se) {
			return 0;
		}
		int sum = 0;
		int mid = (ss + se)/2;
		sum = getSumUtil(arr, qs, qe, ss, mid, 2*si + 1) + getSumUtil(arr, qs, qe, mid + 1, se, 2*si + 2);
		return sum;
	}
	public int getSum(int[] arr, int qs, int qe) {
		if(qs < 0 || qe > this.st.length) {
			throw new IllegalArgumentException();
		}
		return getSumUtil(arr, qs, qe, 0, arr.length - 1, 0);
	}
	public void makeTree(int[] arr) {
		int height = (int)Math.ceil(Math.log(arr.length)/Math.log(2));
		int size = 2*(int)(Math.pow(2, height)) - 1;
		this.st = new int[size];
		makeTreeUtil(arr, 0, arr.length - 1, st, 0);
		for(int i = 0; i < this.st.length; i++) {
			System.out.print(this.st[i] + " ");
		}
	}

	public static void main(String[] args) {
		int[] arr = {1,3,5,7,9,11};
		SegmentTrees st = new SegmentTrees();
		st.makeTree(arr);
		System.out.println(st.getSum(arr, 3, 4));
	}

}
