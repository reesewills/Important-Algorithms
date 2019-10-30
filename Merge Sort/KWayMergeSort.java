package kwaymergesort;

import java.util.ArrayList;
import java.util.LinkedList;

import timing.Ticker;

public class KWayMergeSort {

	/**
	 * 
	 * @param K
	 *            some positive power of 2.
	 * @param input
	 *            an array of unsorted integers. Its size is either 1, or some
	 *            other power of 2 that is at least K
	 * @param ticker
	 *            call .tick() on this to account for the work you do
	 * @return
	 */
	public static Integer[] kwaymergesort(int K, Integer[] input, Ticker ticker) {
		int n = input.length;
		ticker.tick();
		//
		// FIXME
		// Following just copies the input as the answer
		//
		// You must replace the loop below with code that performs
		// a K-way merge sort, placing the result in ans
		//
		// The web page for this assignment provides more detail.
		//
		// Use the ticker as you normally would, to account for
		// the operations taken to perform the K-way merge sort.
		//

		if (n == 0 || n == 1) {
			ticker.tick();
			return input;
		} else {
			ArrayList<Integer[]> arrayList = new ArrayList<Integer[]>();
			ticker.tick();
			int counter = 0;
			ticker.tick();
			for (int i = 0; i < K; ++i) {
				Integer[] a = new Integer[n / K];
				ticker.tick();
				for (int j = 0; j < n / K; ++j) {
					a[j] = input[counter];
					ticker.tick();
					++counter;
					ticker.tick();
				}
				arrayList.add(kwaymergesort(K, a, ticker));
				ticker.tick();
			}
			ticker.tick();
			return merge(arrayList, ticker);
		}
	}

	public static Integer[] merge(ArrayList<Integer[]> arrayList, Ticker ticker) {
		int counter = 0;
		ticker.tick();
		int lengthBrah = 0;
		ticker.tick();
		for (int i = 0; i < arrayList.size(); ++i) {
			lengthBrah += arrayList.get(i).length;
			ticker.tick();
		}
		Integer[] ans = new Integer[lengthBrah];
		ticker.tick();
		int[] indicies = new int[arrayList.size()];
		ticker.tick();
		while (counter < lengthBrah) {
			int min = Integer.MAX_VALUE;
			ticker.tick();
			int keepCheck = 0;
			ticker.tick();
			for (int i = 0; i < arrayList.size(); ++i) {
				if (indicies[i] < arrayList.get(i).length && arrayList.get(i)[indicies[i]] < min) {
					min = arrayList.get(i)[indicies[i]];
					ticker.tick();
					keepCheck = i;
					ticker.tick();
				}
			}
			indicies[keepCheck] += 1;
			ticker.tick();
			ans[counter] = min;
			ticker.tick();
			++counter;
			ticker.tick();
		}
		ticker.tick();
		return ans;
	}

}
