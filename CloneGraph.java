package Dec28;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/*
//Definition for a Node.
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

/*

Approach: BFS

Add given node(1) to queue
Create a deep copy of the popped node(1'). Deep copy node's neighbors list will be blank for now.
Pop from queue(1)
Check popped node's neighbors(2,4)
If neighbors deep copy not created already, create its deep copy.(2',4'). Neighbors' deep copies have blank neighbor list.
Add neighbors to queue(2,4)
Add neighbor deep copy to first node neighbor list

Keep processing till queue is empty

Time complexity: O(V+E)

*/

class CloneGraph {

 public Node cloneGraph(Node node) {
     
     // edge
     if (node == null) {
         return null;
     }
     
     // map to store original nodes as key and their deep copy as value
     Map<Node, Node> hm = new HashMap<>();
     // BFS queue
     Queue<Node> queue = new LinkedList<>();
     Node copyRoot = new Node(node.val);
     queue.add(node);
     hm.put(node, copyRoot);
     while (!queue.isEmpty()) {
         Node cur = queue.poll();
         for (Node n: cur.neighbors) {
             if (!hm.containsKey(n)) {
                 Node curNeighborDeepCopy = new Node(n.val);
                 hm.put(n, curNeighborDeepCopy);
                 queue.add(n);
             }
             // neighbors of my original node deep copy: To add deep copy of n
          hm.get(cur).neighbors.add(hm.get(n));
         }
         
     }
     
     return copyRoot;
     
 }
}