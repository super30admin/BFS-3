/*
Time Complexity - O(V+E)
Space Complexity - O(V)
Did this code successfully run on Leetcode : Yes
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
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        
        if(node==null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
        
    }
    
    private void dfs(Node node){

        //logic
        Node newNode = new Node(node.val);
        map.put(node,newNode);
        for(Node n: node.neighbors){
            if(!map.containsKey(n)){
                dfs(n);
            }
            map.get(node).neighbors.add(map.get(n));
        }
    }
    
}









