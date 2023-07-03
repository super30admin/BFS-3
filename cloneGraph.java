// tc : O(nodes + edges) 
// sc : O(nodes)

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
    HashMap<Node,Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if(node == null ) return null;//base case
        helper(node);
        return map.get(node);
    }

    private void helper(Node node){
        map.put(node,new Node(node.val));  
        for(Node curr : node.neighbors){
            // Node curr =node.neighbors.get(i);
            if(!map.containsKey(curr)) helper(curr);
            map.get(node).neighbors.add(map.get(curr));
        }
    }
}




