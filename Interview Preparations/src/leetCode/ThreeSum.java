package leetCode;

import java.util.Arrays;
import java.util.LinkedList;

public class ThreeSum {
	public static void main(String args[]) {
		int[] arr = { -1, -10, 4, 0, 1, 8, 2, 1, 3, -3 };

		LinkedList<LinkedList<Integer>> results = new LinkedList<LinkedList<Integer>>();
		find3Sums(arr, results);

		System.out.println(Arrays.toString(results.toArray()));
	}

	private static void find3Sums(int[] arr, LinkedList<LinkedList<Integer>> results) {
		Arrays.sort(arr);
		for (int i = 0; i < arr.length; i++) {
			if (i == 0 || arr[i] > arr[i - 1]) {
				int j = i + 1;
				int k = arr.length - 1;

				while (j < k) {
					if (arr[i] + arr[j] + arr[k] == 0 && (j == i + 1 || arr[j] > arr[j - 1])) {
						LinkedList<Integer> result = new LinkedList<Integer>();
						result.add(arr[i]);
						result.add(arr[j]);
						result.add(arr[k]);
						results.add(result);
						j++;
						k--;
					} else if ((arr[i] + arr[j] + arr[k] > 0)) {
						k--;
					} else {
						j++;
					}
				}
			}
		}
	}
}
