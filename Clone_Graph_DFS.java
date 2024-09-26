import java.util.HashMap;

/*
 * 
 * Time complexity : O(n)
 * Space Complexity : O(n)
 * 
 * 
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
    HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        
        //Edge condition
        if(node == null){
            return node;
        }
        
        return dfs(node);
    }
    
    private Node dfs(Node node){
        //Base condition        
        if(map.containsKey(node.val)){
            return map.get(node.val);
        }
        
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
        
        for(Node child : node.neighbors){
            dfs(child);
            map.get(node.val).neighbors.add(map.get(child.val));
        }
        
        return newNode;
    }
}