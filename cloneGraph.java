// Time complexity: O(V+E)
// Space complexity: O(V)

import java.util.*;
class Solution {
    class Node {
        public int val;
        public List<Node> neighbors;
    
        public Node() {}
    
        public Node(int _val,List<Node> _neighbors) {
            val = _val;
            neighbors = _neighbors;
        }
    }
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        Map<Node, Node> vertexMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        q.add(node);
        vertexMap.put(node, createNode(node.val));
        
        while(!q.isEmpty())
        {
            Node currVertex = q.remove();
            
            for (Node neighbor: currVertex.neighbors)
            {
                
                if(!vertexMap.containsKey(neighbor.val))
                {
                    vertexMap.put(neighbor, createNode(neighbor.val));
                    q.add(neighbor);
                }
                vertexMap.get(currVertex).neighbors.add(vertexMap.get(neighbor));
            }
            
        }
        return vertexMap.get(node);

    }
    
    public Node createNode(int n)
    {
        Node newNode = new Node(n);
        newNode.neighbors = new ArrayList<>();
        return newNode;
            
    }
}