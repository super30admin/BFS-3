import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Time Complexity: O(V+E)
 * Space Complexity: O(V)
 * Did this code successfully run on Leetcode: Yes
 * Any problem you faced while coding this: None

 * Approach:
 * BFS to go over all neighbors and create a copy and add its neighbors
 */


public class CloneGraph {
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

    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        map = new HashMap<>();
        Node copyNode = clone(node);
        Queue<Node> q = new LinkedList<>();

        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;

            for (Node neighbor: neighbors) {
                if (!map.containsKey(neighbor)) {
                    q.add(neighbor);
                    clone(neighbor);
               }
               map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);
    }

    private Node clone(Node node) {
        if (map.containsKey(node)) {
            return map.get(node);
        }

        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }

    public static void main(String[] args) {
        // Your code here
    }
}