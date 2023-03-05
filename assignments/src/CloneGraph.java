// Approach: BFS using Queue and Hashmap to store Node to copyNode mapping.
// Time: O(V + E)
// Space: O(V + E)

import java.util.*;

class CloneGraph {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node copyNode = clone(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            if (curr.neighbors == null) continue;

            for (Node n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    clone(n);
                    q.add(n);
                }
                // deep copy of curr node (node)
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return copyNode;
    }

    private Node clone(Node node) {
        if (map.containsKey(node)) return map.get(node);
        Node deepCopy = new Node(node.val);
        map.put(node, deepCopy);
        return deepCopy;
    }
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