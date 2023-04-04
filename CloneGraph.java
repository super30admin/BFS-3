import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;

/*
// Definition for a Node.
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
*/

//Time Complexity : O(V+E)
//Space Complexity : O(V+E)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a map to map original node to the newly created node. Put the node in to
 * a queue. Poll the queue until its empty. for each polled node, iterate over
 * its neighbors and create nodes for them too and then add them to the queue if
 * not present in the map already. And then after each iteration, add the newly
 * created neighbor to the newly created node from the map. finally return the
 * newly created for the initial node.
 *
 */
class Solution {
	public Node cloneGraph(Node node) {
		HashMap<Node, Node> map = new HashMap<>();
		if (node == null)
			return null;

		Queue<Node> queue = new LinkedList<>();
		queue.add(node);
		map.put(node, new Node(node.val));
		while (!queue.isEmpty()) {
			Node temp = queue.poll();
			for (Node n : temp.neighbors) {
				if (!map.containsKey(n)) {
					map.put(n, new Node(n.val));
					queue.add(n);
				}
				map.get(temp).neighbors.add(map.get(n));
			}
		}
		return map.get(node);
	}
}
