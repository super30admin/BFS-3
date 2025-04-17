// Time Complexity: O(V+E) where V is the number of vertices and E is the number of edges
// Space Complexity: O(V) for the map
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

import java.util.HashMap;

class CloneGraph {
    Map<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){
        if(map.containsKey(node)){
            return;
        }

        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for(Node neigh: node.neighbors){
            dfs(neigh);
            map.get(node).neighbors.add(map.get(neigh));
        }
    }
}