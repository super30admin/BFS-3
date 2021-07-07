package com.example.problems;

import java.util.*;

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

public class CloneGraph {
	HashMap<Integer, Node> map;

	public Node cloneGraph(Node node) {
		if (node == null)
			return null;
		map = new HashMap<>();

		Queue<Node> q = new LinkedList<>();

		HashMap<Integer, Node> map = new HashMap<>();
		q.add(node);
		Node newnode = new Node(node.val, new ArrayList<>());
		map.put(newnode.val, newnode);
		while (!q.isEmpty()) {
			Node curr = q.poll();

			for (Node neighbor : curr.neighbors) {

				if (!map.containsKey(neighbor.val)) {
					q.add(neighbor);
					Node nnode = new Node(neighbor.val, new ArrayList<>());
					map.put(neighbor.val, nnode);
				}

				map.get(curr.val).neighbors.add(map.get(neighbor.val));

			}
		}

		return newnode;
	}

	private void dfs(Node node) {
		// Base Case
		if (map.containsKey(node.val))
			return;

		// Logic Case
		Node newnode = new Node(node.val, new ArrayList<Node>());
		map.put(node.val, newnode);

		List<Node> neighbors = node.neighbors;
		for (Node n : neighbors) {
			dfs(n);
			map.get(node.val).neighbors.add(map.get(n.val));
		}
	}
}
