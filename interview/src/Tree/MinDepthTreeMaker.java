package Tree;

import java.util.Arrays;

public class MinDepthTreeMaker {
	public static void treeMaker(int sorted[], int tree[], int p, int lo, int hi) {
		if(p >= 2*sorted.length + 2 || lo > hi) {
			return;
		}
		int mid = lo + (hi - lo)/2;
			tree[p] = sorted[mid];
		treeMaker(sorted, tree, 2*p + 1, lo, mid - 1);
		treeMaker(sorted, tree, 2*p + 2, mid + 1, hi);
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = {1,2,3,4,5,6,7,8,9};
		int tree[] = new int[80];
		Arrays.fill(tree, -1);
		treeMaker(arr, tree, 0, 0, arr.length- 1);
		System.out.println(Arrays.toString(tree));
	}

}
