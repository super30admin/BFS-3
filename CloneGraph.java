import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

import org.w3c.dom.Node;
import Node.Node;

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

//Time: 
//Space: 

//BFS Solution

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        HashMap<Node, Node> map = new HashMap<>();
        
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            for(Node n: curr.neighbors) {
                if(!map.containsKey(n)) {
                    Node copyN= new Node(n.val);
                    map.put(n, copyN);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
            
        }
        return map.get(node);
    }
}