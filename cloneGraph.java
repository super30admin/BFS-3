// Time Complexity : O(N+E), N-no of node, E-no of edges
// Space Complexity : O(N+E)

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
  Map<Node, Node> map;
  public Node cloneGraph(Node node) {
    if(node == null) return null;
    map = new HashMap<>();
    Queue<Node> queue = new LinkedList<>();
    queue.add(node);
    Node clone = cloneNode(node);
    while(!queue.isEmpty()) {
      Node current = queue.poll();
      List<Node> neighbors = current.neighbors;
      for(Node neighbor: neighbors) {
        if(!map.containsKey(neighbor)) queue.add(neighbor);
        Node clonedNeighbor = cloneNode(neighbor);
        map.get(current).neighbors.add(clonedNeighbor);
      }
    }
    return clone;
  }
  Node cloneNode(Node node) {
    if(map.containsKey(node)) return map.get(node);
    Node newNode = new Node(node.val);
    map.put(node, newNode);
    return newNode;
  }
}