package leetCode;

import java.util.HashMap;

public class LFUCache {

	public static void main(String args[]) {
		LFUCache cache = new LFUCache(2 /* capacity */ );

		cache.put(1, 1);
		cache.put(2, 2);
		System.out.println(cache.get(1)); // returns 1
		cache.put(3, 3); // evicts key 2
		System.out.println(cache.get(2)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3.
		cache.put(4, 4); // evicts key 1.
		System.out.println(cache.get(1)); // returns -1 (not found)
		System.out.println(cache.get(3)); // returns 3
		System.out.println(cache.get(4)); // returns 4

	}

	private class ListNode {
		int key;
		int val;
		ListNode next;
		ListNode prev;
		OuterListNode outer;

		public ListNode(int key, int val, ListNode prev, OuterListNode outer) {
			this.prev = prev;
			this.key = key;
			this.val = val;
			this.outer = outer;
			next = null;
		}
	}

	private class OuterListNode {
		ListNode start;
		ListNode end;
		int freq;
		OuterListNode next;
		OuterListNode prev;

		public OuterListNode(int freq, OuterListNode prev) {
			this.prev = prev;
			this.freq = freq;
			next = null;
		}
	}

	HashMap<Integer, ListNode> map = new HashMap<Integer, ListNode>();
	OuterListNode end;
	int cap;
	int size;

	public LFUCache(int capacity) {
		cap = capacity;
		end = null;
		size = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			int freq = node.outer.freq;
			OuterListNode prevOuter = map.get(key).outer.prev;
			if (prevOuter == null || prevOuter.freq > freq + 1) {
				OuterListNode newPrevOuter = new OuterListNode(freq + 1, prevOuter == null ? null : prevOuter.prev);
				newPrevOuter.next = node.outer;
				node.outer.prev = newPrevOuter;
				if (newPrevOuter.prev != null) {
					newPrevOuter.prev.next = newPrevOuter;
				}
				prevOuter = newPrevOuter;
			}
			if (node.prev != null) {
				node.prev.next = node.next;
			} else {
				if (end == node.outer) {
					node.outer.prev.next = null;
					end = prevOuter;
				} else {
					if (node.outer.prev != null) {
						node.outer.prev.next = node.outer.next;
					}
					node.outer.next.prev = node.outer.prev;
				}
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				node.outer.end = node.prev;
			}
			if (prevOuter.start == null) {
				prevOuter.start = node;
				prevOuter.end = node;
			} else {
				node.next = prevOuter.start;
				node.prev = null;
				prevOuter.start.prev = node;
				prevOuter.start = node;
			}
			node.outer = prevOuter;
			return node.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			node.val = value;
			if (node.prev != null) {
				node.prev.next = node.next;
			}
			if (node.next != null) {
				node.next.prev = node.prev;
			} else {
				node.outer.end = node.prev;
			}
			node.next = end.start;
			if (end.start != null) {
				end.start.prev = node;
			} else {
				end.end = node;
			}
			end.start = node;
			node.prev = null;
			return;
		}
		if (cap == size) {
			map.remove(end.end.key);
			if (end.end.prev != null) {
				end.end.prev.next = null;
				end.end = end.end.prev;
			} else {
				end = end.prev;
			}
		} else {
			size++;
		}
		if (end == null) {
			end = new OuterListNode(0, null);
		}
		if (end.freq != 0) {
			end.next = new OuterListNode(0, end);
			end = end.next;
		}
		ListNode node = new ListNode(key, value, null, end);
		node.next = end.start;
		if (end.end == null) {
			end.start = node;
			end.end = node;
		} else {
			end.start.prev = node;
		}
		end.start = node;
		map.put(key, end.start);
	}
}
