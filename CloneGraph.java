
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
//TC - O(V+E)
//SC - O(V+E)
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

class Solution {
 public Node cloneGraph(Node node) {
     if (node == null)
         return node;
     HashMap<Node, Node> map = new HashMap<>();
     Node child = cloneNode(node, map);
     
     Queue<Node> queue = new LinkedList<>();
     queue.add(node);
     while (!queue.isEmpty()) {
         Node n = queue.poll();            
             for (Node list : n.neighbors) {
                 if (!map.containsKey(list)) {
                     queue.add(list);
                 }
                 Node childList = cloneNode(list, map);
                 map.get(n).neighbors.add(childList);
             }
     }
     return child;
 }

 private Node cloneNode(Node node, HashMap<Node, Node> map) {
     if (map.containsKey(node))
         return map.get(node);
     Node child = new Node(node.val, new ArrayList<>());
     map.put(node, child);
     return child;
 }
}
public class CloneGraph {

}
