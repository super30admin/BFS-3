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

// TC : O(V + E)
// SC : (V)
// method - DFS

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return node;

        map = new HashMap<>();
        
        dfs(node);
        return map.get(node);
    }
    
    private void dfs(Node node) {
        
        //base
        if(node == null || map.containsKey(node)) return;
        
        if(!map.containsKey(node))
            map.put(node, new Node(node.val, new ArrayList<>()));
        
        //logic
        for(Node temp : node.neighbors) {
            dfs(temp);
            map.get(node).neighbors.add(map.get(temp));
        }

    }
}
