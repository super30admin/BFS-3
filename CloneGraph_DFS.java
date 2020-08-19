// Time Complexity : O(V + E) --> where V is the vertices and E is the edges in the graph
// Space Complexity : O(n) --> where n is number of nodes in the graph
// Did this code successfully run on Leetcode (133): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
     Map<Integer, Node> map;
    public Node cloneGraph(Node node) { 
        // edge case
        if (node == null) return node;
        
        map = new HashMap<>();
        dfs(node);        
        return map.get(node.val);
    }
    
    private void dfs(Node node) {
        // base case
        if (map.containsKey(node.val)) return;
        
        // logic
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for (Node n : node.neighbors) {
            dfs(n);
            map.get(node.val).neighbors.add(map.get(n.val));
        }
    }
}