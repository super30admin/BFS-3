/*

Space complexity : O(V) Number of nodes
Time complexity : O(V+E)visiting every node and every edges

Clone graph : is worked on leetcode :  YES

*/



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
    HashMap<Integer,Node> visited = new HashMap();
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Node newNode = deepCopy(node);
        
        return newNode;
        
    }
    
    
    private Node deepCopy(Node node) {
        
        if(visited.containsKey(node.val)){
            return visited.get(node.val);
        }else{
            Node  n = new Node(node.val, new ArrayList<Node>());
            visited.putIfAbsent(n.val, n);
            for(Node _node : node.neighbors){
                n.neighbors.add(deepCopy(_node));
            } 
            
            return n;
        }
       
        
        
        
        
        
        
    }
}
