// DFS
// Time - O(n) or O(v * E)
// Space - O(n) for queue and HashMap
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        map = new HashMap<>();
        dfs(node);
        
        return map.get(node);
    }
    
    private void dfs(Node node){
         if(node == null)
            return;
        map.put(node, new Node(node.val));
        for(Node n: node.neighbors){
            if(!map.containsKey(n))
                dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
        
    }
}