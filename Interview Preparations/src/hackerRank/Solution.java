package hackerRank;

import java.io.*;
import java.util.*;

public class Solution {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int tests = scan.nextInt();
		for (int i = 0; i < tests; i++) {
			int size = scan.nextInt();
			int[] arr = new int[size];
			for (int j = 0; j < size; j++) {
				arr[j] = scan.nextInt();
			}
			int cost = Integer.MIN_VALUE;

			int[][] costMatrix = new int[2][size];
			Arrays.fill(costMatrix[0], Integer.MIN_VALUE);
			Arrays.fill(costMatrix[1], Integer.MIN_VALUE);

			System.out.println(maxCost(arr, size - 1, Integer.MIN_VALUE, costMatrix));
		}

	}

	public static int maxCost(int[] arr, int index, int val, int[][] costMatrix) {
		if (index == -1) {
			return 0;
		}

		if (val != 1 && costMatrix[0][index] != Integer.MIN_VALUE) {
			return costMatrix[0][index];
		} else if (val == 1 && costMatrix[1][index] != Integer.MIN_VALUE) {
			return costMatrix[1][index];
		}

		int curCost = 0;
		int using1 = 0;
		int notUsing1 = 0;
		if (val != Integer.MIN_VALUE) {
			using1 = Math.abs(1 - val);
			notUsing1 = Math.abs(arr[index] - val);
		}
		using1 += maxCost(arr, index - 1, 1, costMatrix);
		notUsing1 += maxCost(arr, index - 1, arr[index], costMatrix);

		costMatrix[val == 1 ? 1 : 0][index] = Math.max(using1, notUsing1);
		return costMatrix[val == 1 ? 1 : 0][index];
	}
}