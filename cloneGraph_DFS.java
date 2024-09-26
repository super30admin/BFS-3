// Time Complexity : O(n) where n is the number of nodes in the graph
// Space Complexity : O(n) where n is the number of nodes in the graph
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

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
class cloneGraph_DFS {
    HashMap<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return node;  
        map = new HashMap<>();
        dfs(node);
        return map.get(node.val);
    }
    private void dfs(Node node) {
        // base case
        if (map.containsKey(node.val)) return;
        // logic
        map.put(node.val, new Node(node.val, new ArrayList<>()));
        for (Node neighbor : node.neighbors) {
            dfs(neighbor);  
            map.get(node.val).neighbors.add(map.get(neighbor.val));
        }
    }
}