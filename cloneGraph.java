// Time Complexity : O(N) 
// Space Complexity : O(N) 
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    public Node cloneGraph(Node node) {
         if(node == null) return null;
          HashMap<Node,Node> map = new HashMap<>();
          Queue<Node> q = new LinkedList<>();

          Node copyNode = new Node(node.val);
          map.put(node, copyNode);
          q.add(node);

          while(!q.isEmpty()) {
              Node curr = q.poll();
              if(curr.neighbors != null) {
                  List<Node> neighbrs = curr.neighbors;

                  for(Node n : neighbrs) {
                      if(!map.containsKey(n)) { 
                          Node deepCopy = new Node(n.val);
                          map.put(n, deepCopy);
                          q.add(n);
                      }
                       map.get(curr).neighbors.add(map.get(n));
                  }
              }
          }

        return copyNode; 
    }
}
