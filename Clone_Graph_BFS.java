import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

/*
 * Time complexity : O(n)
 * Space Complexity : O(n)
 * 
 * 
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
            return null;
        
        HashMap<Integer, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        
        Node newNode = new Node(node.val);
        map.put(node.val, newNode);
       
        while(!queue.isEmpty()){
            Node current = queue.poll();
            
            for(Node child : current.neighbors){
                
                if(!map.containsKey(child.val)){
                    queue.add(child);
                    Node nChild = new Node(child.val);
                    map.put(child.val, nChild);
                }
                
                map.get(current.val).neighbors.add(map.get(child.val));
            }
        }
        
        return map.get(node.val);
    }
}