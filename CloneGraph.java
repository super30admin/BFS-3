import java.util.*;
/*
TC: O(V+E) Vertices + Edges
SC: O(H) height of graph. It is O(N) N - number of nodes.HashMap  has N entries and recursion stack can also have N entries.

1. This is a DFS approach. 
2. Keep the record of visited node in hashmap.
3. HashMap contains newNode.
4. If we encounter a node that is already visited, add it to the neighbors list of the node.


*/

public class CloneGraph {
   
    HashMap<Integer, Node> map;
    public Node clone(Node node){
        if(node == null) return null;

        map = new HashMap<>();
        return helper(node);
    }
    
    private Node helper(Node node){

        if(map.containsKey(node.val)){
            return map.get(node.val);
        }

        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);

        for(Node n : node.neighbors){
            newNode.neighbors.add(helper(n));
            //Node cur = helper(n);
            //map.get(node.val).neighbors.add(cur);
        }
        return newNode;
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