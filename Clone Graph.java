public class Solution {

public UndirectedGraphNode cloneGraph(UndirectedGraphNode root) {
  if (root == null) return null;
  
  Queue<UndirectedGraphNode> queue = new LinkedList<UndirectedGraphNode>();
  queue.add(root);
  
  Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();
  
  map.put(root, new UndirectedGraphNode(root.label));
  
  while (!queue.isEmpty()) {
    UndirectedGraphNode node = queue.poll();
    
    for (UndirectedGraphNode neighbor : node.neighbors) {
      if (!map.containsKey(neighbor)) {
        map.put(neighbor, new UndirectedGraphNode(neighbor.label));
        queue.add(neighbor);
      }
      
      map.get(node).neighbors.add(map.get(neighbor));
    }
  }
  
  return map.get(root);
}
