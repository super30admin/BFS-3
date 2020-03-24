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
// TC : O(n)
// SC : O(n)

class Solution {
    HashMap<Integer,Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        map = new HashMap<>();
        dfs(node); 
        return map.get(node.val);
       
    }
    
    private void dfs(Node node){
        //Base Case
        if(map.containsKey(node.val)) return;
        
        //Logic Case
        Node newnode = new Node(node.val,new ArrayList<Node>());
        map.put(node.val,newnode);
        
        List<Node> neighbors = node.neighbors;
        for(Node n : neighbors){  
            dfs(n);
            map.get(node.val).neighbors.add(map.get(n.val));
        }
    }
}