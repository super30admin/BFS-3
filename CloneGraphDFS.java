// Time Complexity : O(V + E)
// Space Complexity : O(V)

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
    Map<Node, Node> map;
    
    public Node cloneGraph(Node node) {
        if(node  == null)
            return node;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    
    public void dfs(Node node){
        //base
        if(map.containsKey(node))
            return;
        //logic
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node cur: node.neighbors){
            dfs(cur);
            map.get(node).neighbors.add(map.get(cur));
        }
    }
}