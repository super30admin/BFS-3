package bfs2;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;


// TC: O(2*N) = O(N)  -> N : number of nodes in the graph
//SC : O(4 *N) = O(N) 
// All leetcode test cases paased
// Approach: In the first pass, create new nodes for each old node in old graph. This does not create edge between edges
// Put the old nodes and new nodes into hashMap, with old node as key and new node as value;
// In the second passs, create edges by traversing old graph and adding edges into new graph by looking up values in hashmap.


class Node {
	public int val;
	public List<Node> neighbors;

	public Node() {
	}

	public Node(int _val) {

		val = _val;
	}

	public Node(int _val, List<Node> _neighbors) {
		val = _val;
		neighbors = _neighbors;
	}
}

public class CloneGraph {

	/*
	 * //Definition for a Node. class Node { public int val; public List<Node>
	 * neighbors;
	 * 
	 * public Node() {}
	 * 
	 * public Node(int _val,List<Node> _neighbors) { val = _val; neighbors =
	 * _neighbors; } };
	 */

	public Node cloneGraph(Node node) {

		Set<Node> seen = new HashSet<Node>();
		Queue<Node> q = new ArrayDeque<Node>();
		Map<Node, Node> mapping = new HashMap<Node, Node>();

		q.offer(node);

		while (!q.isEmpty()) {

			int qsize = q.size();

			while (qsize > 0) {

				Node poped = q.poll();

				Node newNode = new Node(poped.val);
				mapping.put(poped, newNode);

				List<Node> nei = poped.neighbors;

				for (Node neigh : nei) {
					if (!seen.contains(neigh)) {
						q.offer(neigh);
						seen.add(neigh);
					}
				}

				qsize--;
			}
		}

		q.clear();
		seen.clear();
		q.offer(node);
		while (!q.isEmpty()) {

			int qsize = q.size();

			while (qsize > 0) {

				Node poped = q.poll();
				Node val = mapping.get(poped);

				List<Node> nei = poped.neighbors;

				List<Node> newnei = new ArrayList<Node>();
				for (Node neigh : nei) {
					if (!seen.contains(neigh)) {
						q.offer(neigh);
						seen.add(neigh);
					}

					newnei.add(mapping.get(neigh));

				}
				val.neighbors = newnei;
				qsize--;
			}
		}

		return mapping.get(node);

	}
}