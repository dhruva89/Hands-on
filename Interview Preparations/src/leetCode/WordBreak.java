package leetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class WordBreak {
	public static void main(String args[]) {
		List<String> list = Arrays.asList(new String[] { "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa",
				"aaaaaaaaa", "aaaaaaaaaa", "ba" });
		String input = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa";
		System.out.println(new WordBreak().wordBreak(input, list));
	}

	public boolean wordBreak(String s, List<String> wordDict) {
		HashSet<String> dict = new HashSet<String>();
		dict.addAll(wordDict);
		HashMap<String, Boolean> memo = new HashMap<String, Boolean>();
		return wordBreak(s, dict, memo, 0, s.length() - 1);
	}

	public boolean wordBreak(String s, HashSet<String> dict, HashMap<String, Boolean> memo, int start, int end) {
		String current = s.substring(start, end + 1);
		if (dict.contains(current)) {
			return true;
		}

		if (memo.containsKey(current)) {
			return memo.get(current);
		}

		for (int i = start; i < end; i++) {
			if (wordBreak(s, dict, memo, start, i) && wordBreak(s, dict, memo, i + 1, end)) {
				memo.put(current, true);
				return true;
			}
		}

		memo.put(current, false);
		return false;
	}
}