/*
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
*/
// Idea here to keep track of cloned nodes using map and from each node keep traversing its neighbors
// and use recursion to traverse all nodes
// Time Complexity: O(V+E)
class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node==null) return node;
        Node copyNode = clone(node);
        dfs(node);
        return map.get(node);
    }
    
    private void dfs(Node node) {
        clone(node);
        List<Node> children = node.neighbors;
        for(Node child: children) {
            if(!map.containsKey(child)){
                clone(child);
                dfs(child);
            }
            map.get(node).neighbors.add(map.get(child));
        }
    }
    
    
    private Node clone(Node node) {
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}