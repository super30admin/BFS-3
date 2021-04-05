// Time Complexity : O(n)
// Space Complexity : O(n) 
// Did this code successfully run on Leetcode : YES
// Any problem you faced while coding this : NO

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

public class Solution {
    public Node cloneGraph(Node node) {
        
        if (node == null) return null;
        
        Node root = new Node(node.val, new ArrayList());
        Map<Node, Node> map = new HashMap();
        
        Queue<Node> q = new LinkedList();
        q.add(node);
        map.put(node, root);
        
        while(!q.isEmpty()) {
            
            Node curr = q.poll();
            Node clone = map.get(curr);
            
            for(Node n : curr.neighbors) {
                
                if(!map.containsKey(n)) {
                    
                    Node newChild = new Node(n.val, new ArrayList());
                    q.add(n);
                    map.put(n, newChild);
                    
                    
                    
                } 
                clone.neighbors.add(map.get(n));
            }
            
        }
        return root;
    }
}
