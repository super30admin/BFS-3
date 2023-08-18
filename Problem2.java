class Solution {
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;// base case
        helper(node);
        return map.get(node);
    }

    private void helper(Node node) {
        map.put(node, new Node(node.val));
        for (Node curr : node.neighbors) {
            // Node curr =node.neighbors.get(i);
            if (!map.containsKey(curr))
                helper(curr);
            map.get(node).neighbors.add(map.get(curr));
        }
    }
}