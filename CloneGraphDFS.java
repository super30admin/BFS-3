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
//Time Complexity - O(V+E)
//Space Complexity - O(V)
class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
      map = new HashMap<>();
      if(node == null) return null;
      dfs(node);
      return map.get(node);
    }
   public void dfs(Node node) {
     //base
     if(map.containsKey(node)) {
       return;
     }
     //logic
     Node newNode = new Node(node.val);
     map.put(node, newNode);
     for(Node neighbor : node.neighbors) {
       dfs(neighbor);
       map.get(node).neighbors.add(map.get(neighbor));
     }
   }
}