//TC - O(N)
//SC = O(N)

import java.util.*;

public class clone_graph {

}

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

class Solution1 {
	public Node cloneGraph(Node node) {
		if (node == null)
			return node;
		HashMap<Integer, Node> map = new HashMap<>();
		Queue<Node> q = new LinkedList<>();
		Node copyNode = new Node(node.val);
		q.add(node);
		map.put(node.val, copyNode);
		while (!q.isEmpty()) {
			Node curr = q.poll();
			for (Node n : curr.neighbors) {
				if (!map.containsKey(n.val)) {
					Node copy = new Node(n.val);
					map.put(n.val, copy);
					q.add(n);
				}
				map.get(curr.val).neighbors.add(map.get(n.val));
			}
		}
		return copyNode;
	}
}
