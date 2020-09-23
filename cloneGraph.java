// Time Complexity : V+E
// Space Complexity : V V- Vertices E-Edges
// Did this code successfully run on Leetcode : Yes
// https://leetcode.com/problems/clone-graph/

// DFS Approach
class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        //edge case
        if(node ==null) return null;
        map=new HashMap<>();
        dfs(node);
        return map.get(node);
        
    }
    
    public void dfs(Node node)
    {
        //base case
        if(map.containsKey(node)) return;
        
        //logic
        Node copy=new Node(node.val);
        map.put(node,copy);
        for(Node n:node.neighbors)
        {
            dfs(n);
            copy.neighbors.add(map.get(n));
        }
    }
}

//BFS Approach

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
   
    public Node cloneGraph(Node node) {
        //edge case
        if(node ==null) return null;
        HashMap<Node,Node> map=new HashMap<>();
        Queue<Node> q=new LinkedList<>();
        Node copy=new Node(node.val);
        map.put(node,copy);
        q.add(node);
        while(!q.isEmpty())
        {
            Node curr=q.poll();
            for(Node n:curr.neighbors)
                {
                    if(!map.containsKey(n))
                    {
                        Node copyNeighbor=new Node(n.val);
                        map.put(n,copyNeighbor); 
                        q.add(n);
                    }
                    map.get(curr).neighbors.add(map.get(n));
               
                }
            
        }
        
         
        return copy;
        
    }
    

}