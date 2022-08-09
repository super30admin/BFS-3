// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

//133. Clone Graph
//https://leetcode.com/problems/clone-graph/

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


class Solution {
    //DFS
    //time: V+E
    //space: V
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        
        if(node == null) return node;
        
        map = new HashMap<>();
        map.put(node, new Node(node.val));
        
        dfs(node);
        
        return map.get(node);
    }
    
    private void dfs(Node node){
        //base
        for(Node n: node.neighbors){
            if(!map.containsKey(n)){
                map.put(n, new Node(n.val));
                dfs(n);
            }
            map.get(node).neighbors.add(map.get(n));
        }
        
    }
    
}


/*
class Solution {
    //BFS
    //time: V+E
    //space: V
    public Node cloneGraph(Node node) {
        
        Queue<Node> q = new LinkedList<>();
        
        HashMap<Node, Node> map = new HashMap<>();
        
        if(node == null) return node;
        
        map.put(node, new Node(node.val));
        q.add(node);
        
        while(!q.isEmpty()){
            
            Node temp = q.peek();
            
            for(Node n: q.peek().neighbors){
                
                if(!map.containsKey(n)){
                    map.put(n, new Node(n.val));
                    q.add(n);
                    
                }
                
                //add to clone's list
                map.get(q.peek()).neighbors.add(map.get(n));
            }
            
            q.poll();

        }
        return map.get(node);
    }
}
*/
