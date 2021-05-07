// Time Complexity :O(V+E ) where V is the number of vertices and e is the number of edges
// Space Complexity :O(V)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
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
    public Node cloneGraph(Node node) {
      
      if(node == null)
      {
        return node;
      }
      
      HashMap<Node,Node> map = new HashMap<>();
      
      Queue<Node> queue = new LinkedList<>();
      //add the node to the queue
      queue.add(node);
      map.put(node,new Node(node.val));
      
      while(!queue.isEmpty())
      {
        Node front = queue.poll();
        //explore the neighbors 
        for(Node neighbor : front.neighbors)
        {
          //add the neighbor to the queue and map and add new node of this neighbor to the map
          if(!map.containsKey(neighbor))
          {
            queue.add(neighbor);
            map.put(neighbor,new Node(neighbor.val));
          }
          //add the neighbor to the list of neighbors for the front node
          map.get(front).neighbors.add(map.get(neighbor));
        }
      }
      //return the clones node from the map
        return map.get(node);
    }
}