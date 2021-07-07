//Time complexity is O(N)
//Space complexity is O(N)
//This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BigN143CloningGraphUsingBFS {
	class Node {
		public int val;
		public List<Node> neighbors;

		public Node() {
			val = 0;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val) {
			val = _val;
			neighbors = new ArrayList<Node>();
		}

		public Node(int _val, ArrayList<Node> _neighbors) {
			val = _val;
			neighbors = _neighbors;
		}
	}

	class Solution {
		public Node cloneGraph(Node node) {
			// edge case
			if (node == null)
				return node;
			HashMap<Integer, Node> map = new HashMap<>();
			Queue<Node> q = new LinkedList<>();
			q.add(node);
			Node newNode = new Node(node.val, new ArrayList<>());
			map.put(node.val, newNode);
			while (!q.isEmpty()) {
				Node temp = q.poll();
				for (Node n : temp.neighbors) {
					if (!map.containsKey(n.val)) {
						q.add(n);
						Node newCopy = new Node(n.val, new ArrayList<>());
						map.put(n.val, newCopy);
					}
					map.get(temp.val).neighbors.add(map.get(n.val));
				}
			}
			return newNode;
		}
	}
}