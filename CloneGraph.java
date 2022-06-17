// Time Complexity : O(n)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

class Solution {
    Map<Node, Node> map;

    public Node cloneGraph(Node node) {
        
        if(node == null) return null;
        
        map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        
        queue.add(node);
        clone(node);
        
        while(!queue.isEmpty()) {
            Node current = queue.poll();
            
            List<Node> neighbors = current.neighbors;
            
            for(Node neighbor: neighbors) {
                
                if(!map.containsKey(neighbor)) {
                    clone(neighbor);
                    queue.add(neighbor);
                }
                
                map.get(current).neighbors.add(map.get(neighbor));
            }
        }
        
        return map.get(node);
    }
    
    private void clone(Node node) {
        Node deepCopy = new Node(node.val);
        
        map.put(node, deepCopy);
    }
}