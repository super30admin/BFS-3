// Time Complexity : o(v+e)
// Space Complexity : o(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach


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

// BFS
class Solution {
    
    Map<Node,Node> visited;
    //bfs
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return node;
        
        Queue<Node> queue=new LinkedList<>();
        visited=new HashMap<>();
        queue.add(node);
        
        visited.put(node,new Node(node.val));
        
        while(!queue.isEmpty())
        {
            Node curr=queue.poll();
            
           for(Node neighbor:curr.neighbors)
           {
               if(!visited.containsKey(neighbor))
               {
                   queue.add(neighbor);
                   visited.put(neighbor,new Node(neighbor.val));
               }
               
               Node currCopy=visited.get(curr);
               
               currCopy.neighbors.add(visited.get(neighbor));
           }
        }
        return visited.get(node);
    }
}


//dfs

class Solution {
    
    Map<Node,Node> visited;
    //dfs
    public Node cloneGraph(Node node) {
        
        if(node==null)
            return node;
        
        visited=new HashMap<>();
        
        dfs(node);
        
        return visited.get(node);
        
    }
    
    private void dfs(Node node)
    {
        //base
        if(visited.containsKey(node))
            return;
        
        //logic
        visited.add(node,new Node(node.val));
        
        for(Node neighbor : node.neighbors)
        {
            dfs(neighbor);
            
            visited.get(node).neighbors.add(visited.get(neighbor));
        }
    }
}
