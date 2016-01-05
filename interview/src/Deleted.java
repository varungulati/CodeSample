import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class Deleted {
//    public static ArrayList<ArrayList<Integer>> toReturn;

    // [1, 2, 3] --> items
    // [1, 2]-- items and [3] as temp
    // [1, 3] -- items and [2] as temp
    // [2, 3] -- items and [1] as temp
    // [] -- items and [1, 2, 3] as temp
    // [] -- items and [3, 2, 1] as temp
    // [] -- items and [1, 3, 2] as temp
    public void generateHelper(ArrayList<Integer> items, ArrayList<Integer> temp, ArrayList<ArrayList<Integer>> toReturn) {
        // Base case.
        if(items.size() == 0) {
            toReturn.add(temp);
//            return toReturn;
        }
        // makes deep copy
        List<Integer> tempItems = new ArrayList<Integer>(items);
        for(int i = 0; i < tempItems.size(); i++) {
        	ArrayList<Integer> tempItemstemp = new ArrayList<Integer>(temp);
            Integer toRemove = items.get(i);
            tempItemstemp.add(toRemove);
            ArrayList<Integer> tempItemspass = new ArrayList<Integer>(items);
            tempItemspass.remove(i);
            generateHelper(tempItemspass, tempItemstemp, toReturn);
        }
    }
    public ArrayList<ArrayList<Integer>> generate(ArrayList<Integer> items) {
        // Base case.
        if(items.size() == 0) {
        }
        ArrayList<ArrayList<Integer>> toReturn;
        toReturn = new ArrayList<ArrayList<Integer>>();
        generateHelper(items, new ArrayList<Integer>(), toReturn);
        return toReturn;
    }
    public static void main(String[] args) {
    	Deleted d = new Deleted();
    	ArrayList<Integer> aa = new ArrayList<Integer>();
    	aa.add(1);
    	aa.add(2);
    	aa.add(3);
    	for(ArrayList<Integer> i: d.generate(aa)) {
    		System.out.println(i);
    	}
    }
}
