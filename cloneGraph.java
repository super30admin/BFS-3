//Time Complexity: O(V+E)
//Space Complexity: O(V+E)
//Did it run on leetcode: yes

class Solution {
    public Node cloneGraph(Node node) {
        if(node==null)
            return null;
        
        return dfs(node);
    }
    
    HashMap<Node, Node> map = new HashMap<>();
    
    private Node dfs(Node node){
        
        if(map.containsKey(node))
            return map.get(node);
        
        Node newNode = new Node(node.val, new ArrayList<>());
        
        map.put(node, newNode);
        for(Node n : node.neighbors){
            map.get(node).neighbors.add(dfs(n));
        }
        return newNode;
    }
}
