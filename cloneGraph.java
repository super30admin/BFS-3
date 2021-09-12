//Time: O(V + E)
//Space: O(V)

import java.util.*;

class cloneG {
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        
        //hashmap to track if clone has been made already and if it has been visited already
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        //to begin we add node with a new copy node
        map.put(node, new Node(node.val));
        
        while(!queue.isEmpty()){
            
            Node curr = queue.poll();
            //we iterate through all neighbors of curr node
            for(Node neighbor: curr.neighbors){
                
                //if it is not in map already 
                //then we add it to queue, make copy, add original and copy on map
                if(!map.containsKey(neighbor)){
                    queue.add(neighbor);
                    Node copy = new Node(neighbor.val);
                    map.put(neighbor, copy);
                }
                
                //regardless if on map or not, we add neighbors to the copy
                Node currCopy = map.get(curr);
                currCopy.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
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
