package programCreek;

import java.util.HashMap;
import java.util.Random;

public class InsertDeleteGetRandom<T> {
	HashMap<T, Integer> map1;
	HashMap<Integer, T> map2;

	public InsertDeleteGetRandom() {
		map1 = new HashMap<T, Integer>();
		map2 = new HashMap<Integer, T>();
	}

	public void add(T data) {
		map1.put(data, map1.size());
		map2.put(map2.size(), data);
	}

	public boolean remove(T data) {
		if (map1.containsKey(data)) {
			int index = map1.get(data);

			map1.remove(data);
			map2.remove(index);

			if (index == map1.size()) {
				return true;
			} else {
				int lastIndex = map1.size();
				T lastData = map2.get(lastIndex);
				map1.put(lastData, index);
				map2.remove(lastIndex);
				map2.put(index, lastData);
				return true;
			}
		} else {
			return false;
		}
	}

	public T getRandom() {
		return map2.get(new Random().nextInt(map2.size()));
	}

	public static void main(String args[]) {
		InsertDeleteGetRandom<Integer> dS = new InsertDeleteGetRandom<Integer>();
		dS.add(1);
		dS.add(2);
		dS.add(3);
		dS.add(4);
		dS.add(5);
		dS.add(6);
		dS.add(7);
		dS.add(8);
		dS.add(9);
		dS.add(10);
		System.out.println(dS.remove(10));
		System.out.println(dS.remove(1));
		System.out.println(dS.getRandom());
	}

}
