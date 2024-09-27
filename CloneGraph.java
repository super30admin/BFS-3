//o(n) time and space
//passed all leetcode cases
//used bfs approach

class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> clones = new HashMap<>();
        if(node == null) return  node;
        cloneAllNodes(node, clones);
        return clones.get(node);
    }

    public void cloneAllNodes( Node node, Map<Node, Node> clones) {
        if (clones.containsKey(node)) return;
        Node clone = new Node(node.val, new ArrayList<Node>());
        clones.put(node, clone);
        for(Node neighbor : node.neighbors) {
            cloneAllNodes(neighbor, clones);
            Node clonedNeighbor = clones.get(neighbor);
            clone.neighbors.add(clonedNeighbor);
        }
    }
}