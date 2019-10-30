package rabinkarp;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class RK {

	//
	// Be sure to look at the write up for this assignment
	// so that you get full credit by satisfying all
	// of its requirements
	//

	/**
	 * Rabin-Karp string matching for a window of the specified size
	 * 
	 * @param m
	 *            size of the window
	 */
	private String allChars;
	private int length;
	
	public RK(int m) {
		allChars = "";
		length = m;
	}

	/**
	 * Compute the rolling hash for the previous m-1 characters with d appended.
	 * 
	 * @param d
	 *            the next character in the target string
	 * @return
	 */
	public int nextCh(char d) {
		allChars += d;
		allChars = allChars.substring(Math.max(allChars.length() - length, 0), allChars.length());
		char[] charArray = allChars.toCharArray();
		return hashFor(charArray, 0, charArray.length);
	}

	private static int hashFor(char[] chars, int start, int m) {
		   int ans = 0;
		   for (int i=start; i < start+m; ++i) {
		      int val = 0;
		      if (i >= 0 && i < chars.length){ 
		         val = chars[i];       
		      }
		      ans = (
		                ((31*ans% 511) + (val % 511)) % 
		                511
		               );
		   }
		   return ans;
		}

}
