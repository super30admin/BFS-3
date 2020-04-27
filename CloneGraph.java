Time Complexity = O(V+E)
Space Complexity = O(V+E)

class Solution {
    public UnidirectedGraphNode cloneGraph(UnidirectedGraphNode node) {
        if(node == null)return null;
        
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(root);
        
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        
        map.put(root, new UndirectedGraphNode(root.label));
  
        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();

            // handle the neighbors
            for (UndirectedGraphNode neighbor : node.neighbors) {
              if (!map.containsKey(neighbor)) {
                // clone the neighbor
                map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                // add it to the next level
                queue.add(neighbor);
              }

              // copy the neighbor
              map.get(node).neighbors.add(map.get(neighbor));
            }
          }

          return map.get(root);
        }
}