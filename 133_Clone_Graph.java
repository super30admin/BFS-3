    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/clone-graph/
    Time Complexity for operators : o(V+E) .. n is the length of the string
    Extra Space Complexity for operators : o(V+E) for hashmap
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) Do the DFGS traversal on the given nodes and create deep copy accordingly.
                    B) Maintain hashmap of visited node. If node is visited then return the value of that node which 
                       is nothing but the deepcopy created of it.
                    C) Now create newNode and add all its neighbours to the arra list
                    D) At the end, return newNode.


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
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        
        hm = new HashMap<>();
        
        return dfs(node);
    }
    
    HashMap<Integer, Node> hm;
    
    private Node dfs(Node node){
        if(hm.containsKey(node.val)){
            return hm.get(node.val);
        }
        
        Node newNode = new Node(node.val, new ArrayList<>());
        
        hm.put(node.val, newNode);
        
        for(Node n : node.neighbors){
            hm.get(node.val).neighbors.add(dfs(n));
        }
        
        return newNode;
    }
}


