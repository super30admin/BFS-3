// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
// for each node create a clone and iterate over its neighbours, create clone if not exists, else link cloned copy
// repeat for each node and complete linking, use hashmap as reference to lookup if a clone for this node.val already exists

class Solution {
    private HashMap<Integer, Node> map = new HashMap<>();
    
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        
        return clone(node);
    }

    private Node clone(Node node) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        
        Node clone = new Node(node.val);
        
        map.put(clone.val, clone);
        
        for (Node neighbor : node.neighbors) {
            clone.neighbors.add(clone(neighbor));
        }
        
        return clone;
    }
}