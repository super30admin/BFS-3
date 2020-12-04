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

class Solution {//Time of O(V+E) and space of O(V)
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        return dfs(node);
    }
    HashMap<Integer,Node > map = new HashMap<>();
    
    public Node dfs(Node node){
        //if Node exist
        if(map.containsKey(node.val))
            return map.get(node.val);
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val , newNode);
        for(Node n : node.neighbors){
            Node temp = dfs(n);
            map.get(node.val).neighbors.add(dfs(temp));
        }
        return newNode;
    }
}