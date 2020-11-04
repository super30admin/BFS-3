
class Solution {
    // TC: O(V+E)
    // SC: O(N)

    HashMap<Integer, Node> map = new HashMap<>();
        
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        return dfs(node);
    }
    
    private Node dfs(Node node){
        if(map.containsKey(node.val))
            return map.get(node.val);
        
        Node new_node = new Node(node.val, new ArrayList<>());
        map.put(node.val, new_node);
        for(Node n : node.neighbors){
            map.get(node.val).neighbors.add(dfs(n));
        }
        return new_node;
        
    }
}