package BFS3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;


/*https://leetcode.com/problems/clone-graph/
-------------------------------------------------------------------------------------------------------
Time complexity : O(N)
space complexity: O(N)
Did this code run successfully in leetcode : yes
problems faces : no
*/    
public class CloneGraph {
    
  
    
  public Node cloneGraph(Node node) {
      
          if(node == null) return null;
          HashMap<Node,Node> map = new HashMap<>();   // auxilary data structure to store node as key and its corresponding cloned node as value
          Queue<Node> q = new LinkedList<>();
          
          Node copyNode = new Node(node.val);
          map.put(node, copyNode);
          q.add(node);
          
          while(!q.isEmpty())
          {
              Node curr = q.poll();
              if(curr.neighbors != null)
              {
              List<Node> neighbrs = curr.neighbors;
              
              for(Node n : neighbrs)
              {
                  if(!map.containsKey(n))
                  { 
                      Node deepCopy = new Node(n.val);
                      map.put(n, deepCopy);
                      q.add(n);
                  }
                   map.get(curr).neighbors.add(map.get(n));
              }
              }
          }
      
        return copyNode; // Or return map.get(curr);
    }

  
/*------------------------------------------------------------------------------------------
  -------------------------DFS solution ----------------------------------------------------
  ------------------------------------------------------------------------------------------*/
    HashMap<Node, Node> map = new HashMap<>();

    public Node cloneGraphWithDfs(Node node) {

        if (node == null)
            return null;
        dfs(node);
        return map.get(node); // Or return map.get(curr);
    }

    private void dfs(Node node) {
        //base
        if (map.containsKey(node))
            return;
        //logic
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        for (Node n : node.neighbors) {
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }

    }

}


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
