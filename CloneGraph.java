// Time Complexity : O(V+E)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    
    Map<Integer, Node> map = new HashMap<>();
    
    // DFS 
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        return dfs(node);
    }
    
    private Node dfs(Node node){ 
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        
        for(Node n :  node.neighbors){
            if(map.containsKey(n.val)){
                Node dfsCall = map.get(n.val);
                map.get(node.val).neighbors.add(dfsCall);
            }else{
                Node dfsCall = dfs(n);
                map.get(node.val).neighbors.add(dfsCall);
            }
        }
        return newNode;
        
    }
    
    
    
    //BFS
    public Node cloneGraphBFS(Node node) {
        if(node==null){
            return null;
        }
        
        Map<Node, Node> visited = new HashMap<>();
        
        Queue<Node> q = new LinkedList();
        q.add(node);
        
        visited.put(node, new Node(node.val, new ArrayList<>()));
        while(!q.isEmpty()){
            Node front = q.remove();
            for(Node n: front.neighbors){
                if(!visited.containsKey(n)){
                    visited.put(n, new Node(n.val, new ArrayList<>()));
                    q.add(n);
                }
                visited.get(front).neighbors.add(visited.get(n));
            }
        }
        return visited.get(node);
    }
}
