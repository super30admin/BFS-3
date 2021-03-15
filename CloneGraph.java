//Problem 144: Clone Graph
//TC:O(V+E)
//SC:O(V)

/*

Can be done either using BFS or DFS. 
Iterate over the graph and maintain a map for creating clone of node and then while traversing the neighbors of the given nodes attach new neighbors to the cloned nodes.

*/

import java.util.*;
class Solution144 {

    class Node{
        int val;
        List<Node> neighbors;
        Node(int val){
            this.val = val;
        }
    }
//BFS
    public Node cloneGraph(Node node) {
        
        if(node==null) return node;
        //Using BFS
        //TC:O(V+E) || SC:O(V)
        Map<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        
        Node copyNode = new Node(node.val);
        map.put(node,copyNode);
        q.offer(node);//insert existing nodes in the queue;
        
        while(!q.isEmpty()){
            
            Node curr = q.poll();
            
            for(Node n:curr.neighbors){
                
                if(!map.containsKey(n)){
                    Node newNode = new Node(n.val);
                    map.put(n,newNode);
                    q.offer(n);
                }
                
                map.get(curr).neighbors.add(map.get(n));//mapping curr dash node with the neighbor dash node->1->1`, then 2->2`=>1`->2`
            }
            
        }
        
        return map.get(node);
    }

}


//DFS
/*

class Solution {
    Map<Node,Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        //DFS
        //TC:O(V+E) || SC:O(V)
        if(node==null) return node;
        
        dfs(node);
        
        return map.get(node);
    }
    
    private void dfs(Node node){
        
        if(map.containsKey(node)) return;
        
        map.put(node,new Node(node.val));
        
        for(Node n:node.neighbors){
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
        
    }
    
}



*/