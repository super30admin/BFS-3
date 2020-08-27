//time:nodes+connections
//space:o(n)
//leetcode:Yes

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
    HashMap<Integer, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)return node;
        map = new HashMap<>();
        dfs(node);
        return map.get(node.val);
    }
    private void dfs(Node node){
        //base
        if(map.containsKey(node.val))return;
        //logic
        Node copy = new Node(node.val);
        map.put(node.val, copy);
        for(Node n : node.neighbors){
            dfs(n);
            map.get(node.val).neighbors.add(map.get(n.val));
        }        
    }
}