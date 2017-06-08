package leetCode;

import java.util.HashMap;

public class LRUCache {
	private class ListNode {
		int val;
		int key;
		ListNode next;
		ListNode prev;

		public ListNode(int key, int val, ListNode prev) {
			this.val = val;
			this.key = key;
			this.prev = prev;
			next = null;
		}
	}

	HashMap<Integer, ListNode> map;
	ListNode start;
	ListNode end;
	final int capacity;
	int size;

	public LRUCache(int capacity) {
		map = new HashMap<Integer, ListNode>();
		start = null;
		end = start;
		this.capacity = capacity;
		size = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			ListNode node = map.get(key);
			if (start != node) {
				node.prev.next = node.next;
				if (end == node) {
					end = node.prev;
				} else {
					node.next.prev = node.prev;
				}
				node.next = start;
				start.prev = node;
				start = node;
			}
			return node.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			map.get(key).val = value;
			get(key);
			return;
		}

		if (size == capacity) {
			map.remove(end.key);
			if (end != start) {
				end.prev.next = end.next;
				end = end.prev;
			} else {
				end = null;
				start = null;
			}
		} else {
			size++;
		}
		ListNode newNode = new ListNode(key, value, null);
		newNode.next = start;
		if (start != null) {
			start.prev = newNode;
		} else {
			end = newNode;
		}
		start = newNode;
		map.put(key, newNode);

	}
}