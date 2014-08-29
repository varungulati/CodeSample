package PowerSet;
import java.util.ArrayList;
import java.util.List;

/****************************************************************************
 * Author: Isai Damier
 * Title: Power Set
 * Project: geekviewpoint
 * Package: algorithms
 *
 * Statement:
 *   Given a set of objects (here a string representing a set of characters),
 *   find the power set.
 *
 * Sample Input:  {a,b,c}
 * Sample Output: {{a,b,c},{a,b},{a,c},{a},{b,c},{b},{c},{}}
 *
 * Technical Details:
 *   This solution is one of the most powerful and most elegant results of
 *   bitwise operations. To find the powerset of any set of size n, simply
 *   start with an ALL_BITS number of size n and count down:
 *   {a,b,c},{a,b  }, {a,  c},{a    },{  b,c},{  b  },{    c},{     }
 *    1 1 1 , 1 1 0 ,  1 0 1 , 1 0 0 , 0 1 1 , 0 1 0 , 0 0 1 , 0 0 0.
 *
 *   This solution is important, for example, because all problems whose
 *   solutions depend on finding the combination C(n,k) of a set can be
 *   solved by finding the power set of said set. The power set, of course,
 *   is the general solution, and thus maybe an inefficient approach for
 *   solving particular instances.
 ***************************************************************************/
class PowerSet {
	 public List<String> powerSet(String set) {
	  //return null if set is null or empty
	  if (null == set || set.trim().equals("\"\"")) {
	    return null;
	  }
	 
	  //create structure to hold power set, subset, etc. And create
	  //a bit string the same size as set and fill it with 1s
	  List<String> powset = new ArrayList<String>();
	  int s = set.length();
	  String subset, bits = "\"\"";
	  for (int i = 0; i < s; i++) {
	    bits += 1;
	  }
	 
	  //extract power set by counting down in 'binary'
	  for (int i = Integer.parseInt(bits, 2), b; i >= 0; i--) {
	    //get bit representation of new subset
	    bits = Integer.toString(i, 2);
	    b = bits.length();
	    subset = "\"\"";//empty subset holder
	    for (int k = b - 1; k >= 0; k--)//assemble subset from bits
	    {
	      if ('1' == bits.charAt(k)) {
	        subset += set.charAt(s - 1 - (b - 1 - k));
	      }
	    }
	    powset.add(subset);//add subset to power set
	  }//for
	  return powset;
	}
}