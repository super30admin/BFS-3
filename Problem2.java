/*
    LC - 133. Clone Graph
    TC - O(V+E)
    SC - O(V) for recursive stack + O(V) for hashmap ~ O(V)
*/

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

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    public void dfs(Node node) {
        // base
        if(map.containsKey(node)) {
            return;
        }

        // logic
        Node cloneNode = clone(node);
        List<Node> neighbors = node.neighbors;
        for(Node neighbor : neighbors) {
            dfs(neighbor);
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
    private Node clone(Node node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}