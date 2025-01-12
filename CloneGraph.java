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
    HashMap<Node, Node>  map;
    public Node cloneGraph(Node node) {
        if(node == null ) return null;
        
        this.map = new HashMap<>();
       dfs(node);
      return map.get(node);

    }

    private void dfs(Node curr){
        Node copycurr = clone(curr);
        for(Node ne: curr.neighbors){
            if(!map.containsKey(ne)){
                dfs(ne);
            }
            copycurr.neighbors.add(clone(ne));
        }
    }


    private Node clone(Node node){
        if(!map.containsKey(node)){
            map.put(node, new Node(node.val));
        }

        return map.get(node);
    }
}