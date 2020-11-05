    /*  Explanation
    # Leetcode problem link : https://leetcode.com/problems/clone-graph/
    Time Complexity for operators : o(n^n) .. n is the length of the string
    Extra Space Complexity for operators : o(n) for (List<String> path) without recursive stack
    Did this code successfully run on Leetcode : NA
    Any problem you faced while coding this : No
# Your code here along with comments explaining your approach
        # Basic approach : 
        # Optimized approach: 
                              
            # 1. 
                    A) 


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


