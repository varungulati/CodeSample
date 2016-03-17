package Recursion;

public class PrintTwoDArray {

	public static void printer(String str[][], int row, int col, String output) {
		if(output.split(" ").length == str.length + 1) {
			System.out.println(output);
			return;
		}
		for (int i = 0; i < str[row].length; i++) {
			printer(str, row + 1, i, output + " " + str[row][i]);
		}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str[][] = {{"you", "we"},{"have", "are"},{"sleep", "eat", "drink"}};
		printer(str, 0, 0, "");
	}
}
