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

// just messed up in syntax - rest concept was right
// and too much complicated for loop, keep it simple
// tc: O(n+m) sc: O(n) -> same dfs

class Solution {

  //dfs
  private HashMap<Node, Node> map = new HashMap<>();

  public Node cloneGraph(Node node) {
    if (node == null) return null;

    if (map.containsKey(node)) {
      return map.get(node);
    }

    Node clone = new Node(node.val, new ArrayList<>());
    map.put(node, clone);

    for (Node neighbor : node.neighbors) {
      //did not get this part
      clone.neighbors.add(cloneGraph(neighbor));
    }

    return clone;
  }
}
