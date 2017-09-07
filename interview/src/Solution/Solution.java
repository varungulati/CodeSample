package Solution;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

/**
 * Definition for an interval.

 */
class Interval {
     int start;
     int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
     @Override
     public String toString() {
    	 return "[" + start + " ," + end + "]"; 
     }
 }

public class Solution {
    class ABC {
        int amount;
        int curr;
        public ABC(int amount, int curr) {
            this.amount = amount;
            this.curr = curr;
        }
    }
    private int helper(int amount, int[] coins, int curr, HashMap<ABC, Integer> temp) {
        ABC abc = new ABC(amount, curr);
        if(temp.containsKey(abc)) return temp.get(abc);
        if(amount == 0) return 1;
        if(amount < 0) return 0;
        int sum = 0;
        for(int i = curr; i < coins.length; i++) {
            if(i >= curr)
                sum += helper(amount - coins[i], coins, i, temp);
        }
        temp.put(abc, sum);
        return sum;
    }
    public int change(int amount, int[] coins) {
        if(coins.length == 0) return amount == 0 ? 1 : 0;
        HashMap<ABC, Integer> temp = new HashMap<>();
        return helper(amount, coins, 0, temp);
    }
	public static void main(String args[]) {
		Solution s = new Solution();
		
    	System.out.println(s.change(500, new int[] {1,2,5}));
    }
}