public class CloneGraph {
    public Node cloneGraph(Node node) {
        return cloneGraphBFS(node);
    }
    // TC: O(N + M) where N is number of nodes and M is number of edges
    // SC: O(N) where N is number of nodes
    private Node cloneGraphDFS(Node node) {
        if (node == null) return null;
        Map<Node, Node> origToClone = new HashMap<>();
        Node newHead = new Node(node.val);
        origToClone.put(node, newHead);
        dfs(node, origToClone);
        return origToClone.get(node);
    }
    private void dfs(Node node, Map<Node, Node> origToClone) {
        for (Node child : node.neighbors) {
            if (!origToClone.containsKey(child)) {
                origToClone.put(child, new Node(child.val));
                dfs(child, origToClone);
            }
            origToClone.get(node).neighbors.add(origToClone.get(child));
        }
    }
    // TC: O(N + M) where N is number of nodes and M is number of edges
    // SC: O(N) where N is number of nodes
    private Node cloneGraphBFS(Node node) {
        if (node == null) return null;
        Map<Node, Node> origToClone = new HashMap<>();
        Node newHead = new Node(node.val);
        origToClone.put(node, newHead);
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for (Node child : curr.neighbors) {
                if (!origToClone.containsKey(child)) {
                    origToClone.put(child, new Node(child.val));
                    queue.add(child);
                }
                origToClone.get(curr).neighbors.add(origToClone.get(child));
            }
        }
        return origToClone.get(node);
    }
}
}
