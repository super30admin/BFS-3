// Time Complexity :O(V+E)
// Space Complexity :O(V)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }
        
        //to avoid cycles
        HashMap<Node, Node> visited = new HashMap<>();
        
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        visited.put(node, new Node(node.val, new ArrayList<>()));
        
        while(!q.isEmpty()){
            Node n = q.poll();
            
            List<Node> nList = n.neighbors;
            for(Node neighbor:nList){
                if(!visited.containsKey(neighbor)){
                    visited.put(neighbor, new Node(neighbor.val, new ArrayList<>()));
                    q.add(neighbor);
                }
                visited.get(n).neighbors.add(visited.get(neighbor));
            }
        }
        
        return visited.get(node);
    }
}