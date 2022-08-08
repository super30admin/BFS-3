class Solution {
  public Node cloneGraph(Node node) {
    if (node == null) {
      return node;
    }
    Map<Node, Node> map = new HashMap<>();
    map.put(node, new Node(node.val, new ArrayList<>()));
    Queue<Node> queue = new LinkedList<>();
    queue.offer(node);

    while (!queue.isEmpty()) {
      int size = queue.size();
      while (size-- > 0) {
        Node cur = queue.poll();
        List<Node> nei = cur.neighbors;
        for (Node n : nei) {
          if (!map.containsKey(n)) {
            map.put(n, new Node(n.val, new ArrayList<>()));
            queue.offer(n);
          }
          map.get(cur).neighbors.add(map.get(n));
        }
      }
    }
    return map.get(node);
  }
}