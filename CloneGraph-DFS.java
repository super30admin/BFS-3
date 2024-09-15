class Solution {
    public Node cloneGraph(Node node) {
        if(node==null) return null;
        return dfs(node);
        
    }
    
    HashMap<Integer, Node> map = new HashMap<>();
    public Node dfs(Node node)
    {
        if(map.containsKey(node.val)) return map.get(node.val);
        Node newnode = new Node(node.val,new ArrayList<>());
        map.put(node.val,newnode);
        for(Node n : node.neighbors)
        {
            map.get(node.val).neighbors.add(dfs(n));
        }
        return newnode;
    }

}
