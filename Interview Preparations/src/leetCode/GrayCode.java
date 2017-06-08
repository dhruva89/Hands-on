package leetCode;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;

public class GrayCode {
	public static void main(String args[]) {
		System.out.println(new GrayCode().grayCode(2));

	}

	public List<Integer> grayCode(int n) {
		if (n == 0) {
			LinkedList<Integer> result = new LinkedList<Integer>();
			result.add(0);
			return result;
		}
		String input = "";
		for (int i = 0; i < n; i++) {
			input += "0";
		}
		LinkedList<Integer> result = new LinkedList<Integer>();
		dfs(new StringBuilder(input), new HashSet<String>(), result);
		return result;
	}

	public void dfs(StringBuilder cur, HashSet<String> visited, LinkedList<Integer> result) {
		String currentString = cur.toString();
		if (!visited.contains(currentString)) {
			result.add(Integer.valueOf(currentString, 2));
			visited.add(currentString);
			for (int i = cur.length() - 1; i >= 0; i--) {
				cur = cur.replace(i, i + 1, flip(cur.charAt(i)));
				dfs(cur, visited, result);
				cur = cur.replace(i, i + 1, flip(cur.charAt(i)));
			}
		}

	}

	public String flip(char c) {
		if (c == '1') {
			return "0";
		} else {
			return "1";
		}
	}
}