package leetCode;

import java.util.HashMap;
import java.util.Random;

public class RandomizedSet {
	HashMap<Integer, Integer> first = new HashMap<Integer, Integer>();
	HashMap<Integer, Integer> second = new HashMap<Integer, Integer>();

	public static void main(String args[]){
		RandomizedSet set = new RandomizedSet();
		set.insert(1);
		set.remove(2);
		set.insert(2);
		set.getRandom();
		set.remove(1);
		set.insert(2);
		System.out.println(set.getRandom());
	}
	
	/** Initialize your data structure here. */
	public RandomizedSet() {

	}

	/**
	 * Inserts a value to the set. Returns true if the set did not already
	 * contain the specified element.
	 */
	public boolean insert(int val) {
		if (!first.containsKey(val)) {
			first.put(val, first.size());
			second.put(second.size(), val);
			return true;
		} else {
			return false;
		}
	}

	/**
	 * Removes a value from the set. Returns true if the set contained the
	 * specified element.
	 */
	public boolean remove(int val) {
		if (first.containsKey(val)) {
			int indexRemoved = first.get(val);
			first.remove(val);
			second.remove(indexRemoved);
			int lastIndex = first.size();
			if (indexRemoved == lastIndex || lastIndex == 0) {
				return true;
			}
			first.put(second.get(lastIndex), indexRemoved);
			second.put(indexRemoved, second.get(lastIndex));
			second.remove(lastIndex);
			return true;
		} else {
			return false;
		}
	}

	/** Get a random element from the set. */
	public int getRandom() {
		return second.get(new Random().nextInt(second.size()));
	}
}
