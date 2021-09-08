// Time Complexity : O(V + E), V-> Number of nodes, E-> Number of edges
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
package problem2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

public class CloneGraph {
	Map<Node, Node> visited;

	/********************* BFS *********************/
	public Node cloneGraph(Node node) {
		if (node == null) {
			return null;
		}

		visited = new HashMap<>();
		Queue<Node> queue = new LinkedList<>();
		queue.add(node);

		visited.put(node, new Node(node.val));

		while (!queue.isEmpty()) {
			Node curr = queue.poll();
			for (Node neighbor : curr.neighbors) {
				if (!visited.containsKey(neighbor)) {
					queue.add(neighbor);
					Node neighborCopy = new Node(neighbor.val);
					visited.put(neighbor, neighborCopy);
				}

				visited.get(curr).neighbors.add(visited.get(neighbor));
			}
		}

		return visited.get(node);
	}

	/********************* DFS *********************/
	public Node cloneGraphDFS(Node node) {
		if (node == null) {
			return null;
		}

		visited = new HashMap<>();
		dfs(node);

		return visited.get(node);
	}

	private void dfs(Node node) {
		// Base
		if (visited.containsKey(node)) {
			return;
		}
		// Logic
		visited.put(node, new Node(node.val));

		for (Node neighbor : node.neighbors) {
			dfs(neighbor);
			visited.get(node).neighbors.add(visited.get(neighbor));
		}
	}

	public static void main(String[] args) {
		CloneGraph obj = new CloneGraph();

		Node node1 = new Node(1);
		Node node2 = new Node(2);
		Node node3 = new Node(3);
		Node node4 = new Node(4);

		node1.neighbors = Arrays.asList(node2, node4);
		node2.neighbors = Arrays.asList(node1, node3);
		node3.neighbors = Arrays.asList(node2, node4);
		node4.neighbors = Arrays.asList(node1, node3);

		Node clone = obj.cloneGraph(node1);
		System.out.println("Graph successfully cloned.");
	}

}
