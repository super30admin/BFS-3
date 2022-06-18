import java.util.*;

public class Problem2 {

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

    class Solution {
        Map<Node, Node> map;

        //BFS
        // TC : O(V + E) where v = vertices and E = edges
        // TC : O(V)
        public Node cloneGraph(Node node) {

            if (node == null) return null;
            map = new HashMap<>();
            Node currRoot = createNode(node);

            Queue<Node> que = new LinkedList<>();
            que.add(node);

            while (!que.isEmpty()) {
                Node currNode = que.poll();
                for (Node neighbor : currNode.neighbors) {
                    if (!map.containsKey(neighbor)) {
                        createNode(neighbor);
                        que.add(neighbor);
                    }
                    map.get(currNode).neighbors.add(map.get(neighbor));
                }
            }
            return currRoot;
        }

        private Node createNode(Node node) {
            if (map.containsKey(node)) return map.get(node);
            Node newNode = new Node(node.val);
            map.put(node, newNode);
            return newNode;
        }
    }

    // DFS Solution
    // TC : O(V + E)
    // SC : O(V)
    Map<Node, Node> map;

    public Node cloneGraph(Node node) {
        //BFS
        if (node == null) return null;
        map = new HashMap<>();

        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node) {
        //base case
        if (map.containsKey(node)) return;

        //logic
        createNode(node);
        for (Node n : node.neighbors) {
            dfs(n);
            map.get(node).neighbors.add(map.get(n));

        }
    }

    private Node createNode(Node node) {
        if (map.containsKey(node)) return map.get(node);
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}
