// Problem Type: BFS - 3
// LeetCode - 133

// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : 
/**
 * node == null case not handled
*/

// Your code here along with comments explaining your approach

/**
 * Intuition: Graph and traversal problem
 * Hence, apply BFS or DFS to traverse all the nodes and their adj. list.
 * 
 * NOTE: Maintain a mapping of the original node and the deep copy node.
 */

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class CloneGraph {

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

    private Map<Node, Node> nodes = new HashMap<>();

    // Time Complexity : O(V + E)
    // Space Complexity : O(V) + O(V)
    public Node cloneGraph_bfs(Node node) {
        if (node == null) {
            return null;
        }
        Deque<Node> queue = new ArrayDeque<>();
        queue.offer(node);

        nodes.put(node, new Node(node.val));

        while (!queue.isEmpty()) {
            Node poll = queue.poll();

            for (Node adj : poll.neighbors) {
                if (!nodes.containsKey(adj)) {
                    nodes.put(adj, new Node(adj.val));
                    queue.offer(adj);
                }
                nodes.get(poll).neighbors.add(nodes.get(adj));
            }
        }
        return nodes.get(node);
    }

    private Map<Integer, Node> nodes_dfs = new HashMap<>();

    // Time Complexity : O(V + E)
    // Space Complexity : O(V) + O(V)
    public Node cloneGraph_dfs(Node node) {
        if (node == null) {
            return null;
        }
        if (nodes_dfs.containsKey(node.val)) {
            return nodes_dfs.get(node.val);
        }
        // logic
        Node clone = new Node(node.val);
        nodes_dfs.put(node.val, clone);
        List<Node> neighbors = clone.neighbors;

        for (Node adj : node.neighbors) {
            Node adjClone = cloneGraph_dfs(adj);
            neighbors.add(adjClone);
        }
        return clone;
    }

}