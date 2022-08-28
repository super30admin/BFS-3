//Time : O(V+E)
//Space : O(V+E)

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);
        while (!q.isEmpty()) {
            Node n = q.poll();
            for (Node nodes : n.neighbors) {
                if (!map.containsKey(nodes)) {
                    Node copyNew = new Node(nodes.val);
                    map.put(nodes, copyNew);
                    q.add(nodes);
                }
                map.get(n).neighbors.add(map.get(nodes));
            }

        }
        return copyNode;

    }
}