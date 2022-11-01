// Time complexity: O(V+E)
// Space complexity: O(V+E)

// Approach: DFS

class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    
    private void dfs(Node node) {
        // base

        // logic
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        for(Node n : node.neighbors) {
            if (!map.containsKey(n)) {
              dfs(n);  
            }
            map.get(node).neighbors.add(map.get(n));
        }
    }
}