//Time complexity is O(N+M)N is number nodes, m is number of edges
//Space complexity is O(N)
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
        HashMap<Node, Node> visited = new HashMap();

        LinkedList<Node> queue = new LinkedList<Node> ();
        queue.add(node);

        visited.put(node, new Node(node.val, new ArrayList()));

        while (!queue.isEmpty()) {

            Node n = queue.remove();

            for (Node neighbor: n.neighbors) {
                if (!visited.containsKey(neighbor)) {
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList()));
                    queue.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }

        return visited.get(node);
    }
}