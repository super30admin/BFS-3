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
}*/

// BFS
// TC: O(V+E)
// SC: O(V)
// Did it run successfully on Leetcode? : Yes
class Solution {
   public Node cloneGraph(Node node) {
        if (node == null) {
            return node;
        }
      HashMap<Node, Node> map = new HashMap();
     
      Queue<Node> q = new LinkedList();
       
      Node cloneNode =  new Node(node.val);
      map.put(node, cloneNode);
        
      q.add(node);
       
      while (!q.isEmpty())
      {
         Node currNode = q.poll();
    
         for ( Node neighbor : currNode.neighbors)
         {
             if (!map.containsKey(neighbor))
             {
              Node cloneNeighbor =  new Node(neighbor.val);
              map.put(neighbor, cloneNeighbor);
              q.add(neighbor);
             }
             
            // add all currNode's neighbors to cloneNode's neighbors list (deep copy)
            map.get(currNode).neighbors.add(map.get(neighbor));
          }
         
       }
      return cloneNode; 
   }
}

// DFS
// TC: O(V+E)
// SC: O(V)
// Did it run successfully on Leetcode? : Yes
// class Solution {
//     HashMap<Node, Node> visited = new HashMap<Node, Node>();
//     public Node cloneGraph(Node node) {
             // base case
//         if (node == null)
//             return null;
   
//         if (visited.containsKey(node))
//             return visited.get(node);
    
        // logic
//         Node cloneNode = new Node(node.val, new ArrayList());
        
//         visited.put(node, cloneNode);
        
//         for (Node neighbor : node.neighbors)
//         {
//             cloneNode.neighbors.add(cloneGraph(neighbor));
//         }
//         return cloneNode;
//     }
// }
