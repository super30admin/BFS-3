import java.util.*;

// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes

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


public class CloneGraphUsingBFS {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            Node copyCurr = clone(curr);
            List<Node> li = curr.neighbors;
            if(li != null){
                for(Node neighbor : li){
                    if(!map.containsKey(neighbor))
                        q.add(neighbor);

                    Node copyNeighbor = clone(neighbor);
                    copyCurr.neighbors.add(copyNeighbor);
                }
            }
        }
        return map.get(node);
    }

    private Node clone(Node node){
        if(!map.containsKey(node)){
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return map.get(node);
    }
}