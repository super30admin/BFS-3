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
    
    HashMap<Node, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
       return clone(node);
    }
    
    private Node clone(Node node){
        //sanity check
         if(node == null){
            return null;
        }
        
        //if node is already created, return new node
        if(map.containsKey(node)){
            return map.get(node);
        }
        
        //create a new node, and add it to the map
        Node newNode = new Node(node.val, new ArrayList<>());
        
        map.put(node, newNode);
        
        for(Node neigh: node.neighbors){
            newNode.neighbors.add(cloneGraph(neigh));
        }
        
        return newNode;
    }
}