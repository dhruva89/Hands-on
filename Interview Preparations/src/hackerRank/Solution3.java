package hackerRank;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution3 {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int q = in.nextInt();
		for (int a0 = 0; a0 < q; a0++) {
			int numCities = in.nextInt();
			int numRoads = in.nextInt();
			int costLib = in.nextInt();
			int costRoad = in.nextInt();
			LinkedList<LinkedList<Integer>> roads = new LinkedList<LinkedList<Integer>>();
			for (int i = 0; i <= numCities; i++) {
				roads.add(new LinkedList<Integer>());
			}
			for (int a1 = 0; a1 < numRoads; a1++) {
				int city_1 = in.nextInt();
				int city_2 = in.nextInt();
				roads.get(city_1).add(city_2);
				roads.get(city_2).add(city_1);
			}
		}
	}
}

