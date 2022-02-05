// Time Complexity: O(E+V)
// Space Complexity: O(V)
// BFS
public class CloneGraph {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;

        // use a map to save cloned nodes
        Map<Node, Node> map = new HashMap<>();
        // For BFS
        Queue<Node> q = new LinkedList<>();
        q.offer(node);
        
        // clone the root and add to map
        Node clone = new Node(node.val);
        map.put(node, clone);
        
        
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            for(Node neigh: curr.neighbors)
            {
                // clone the neighbor
                if(!map.containsKey(neigh))
                {
                    Node copyNeigh = new Node(neigh.val);
                    map.put(neigh, copyNeigh);
                    // add it to the next level
                    q.add(neigh);
                }
                // add neigbhors to all created nodes
               map.get(curr).neighbors.add(map.get(neigh));
            }
            
        }
        
        return clone;
    }
}

// Time Complexity: O(E+V)
// Space Complexity: O(V)
// BFS
public class CloneGraph {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        map = new HashMap<>();
    
        clone = dfs(node);
        
        return clone;
    }

    private Node dfs(Node node)
    {
        if(map.containsKey(node))
            return map.get(node);

        Node copy = new Node(node.val);
        // add copy to map
        map.put(node, copy);
        for(Node neighbor : node.neighbors)
        {
            copy.neigbhors.add(dfs(neighbor));
        }

        return copy;
    }
}
