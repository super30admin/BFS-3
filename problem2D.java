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

class cloneGraphDFS {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        map = new HashMap();
        dfs(node);
        return map.get(node);
    }
    
    private void dfs(Node node){
        if(map.containsKey(node)) return;
        
        clone(node);
        List<Node> neighbors = node.neighbors;
        for(Node n : neighbors){
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
    
    private Node clone(Node node){
        if(map.containsKey(node)) return map.get(node);
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        return copyNode;
    }
}

//time complexity O(V + E)
//space complexity O(V) where V stands for vertics and E stands for edges