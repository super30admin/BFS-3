class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
        
    }
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        
        //logic
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        
        for(Node n: node.neighbors){
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

//TC: O(v + E)
//SC: O(V)
