// Time Complexity : O(v + e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

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

class Main {
    // approch 1 using BFS
    public static Node cloneGraph1(Node node) {
        // null case
        if (node == null)
            return null;
        // map for stroing node and it's clone
        Map<Node, Node> map = new HashMap<>();
        // queue for BFS
        Queue<Node> q = new LinkedList<>();
        // create copy of the firstNode
        Node copyNode = new Node(node.val);
        // add it inside the map
        map.put(node, copyNode);
        q.add(node);
        // BFS traversal of the graph
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                // check if n is already inside the map
                // or not if not make a copy of n and
                // put inside the map and add it into the queue
                if (!map.containsKey(n)) {
                    Node copyN = new Node(n.val);
                    map.put(n, copyN);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    // approch 2 using DFS
    // map for stroing node and it's clone
    private static Map<Node, Node> map;

    public static Node cloneGraph2(Node node) {
        // null case
        if (node == null)
            return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private static void dfs(Node node) {
        // base case
        if (map.containsKey(node))
            return;
        // main logic
        // create a copy of the node and
        // put it inside the map
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        // traverse in the neighbors{
        for (Node n : node.neighbors) {
            // run dfs on the neighbours
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }

    public static void main(String[] args) {

    }

}