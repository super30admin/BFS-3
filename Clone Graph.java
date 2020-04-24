// Time Complexity : o(V+E)
// Space Complexity : o(V+E)  vertices+edges
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this :


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

class Solution {
    public Node cloneGraph(Node node) {
        //System.out.println(node.val);
        if(node == null) return null;
        
        Map<Integer,Node> map=new HashMap<Integer,Node>();
        Queue<Node> q=new LinkedList<>();
        
        Node firstnode=new Node(node.val);
        map.put(node.val,firstnode);
        q.add(node);
        
        while(!q.isEmpty()){
            Node current=q.poll();
            Node clonenode=map.get(current.val);
         
            for(Node neighbor:current.neighbors){
                Node neighbornode=map.get(neighbor.val);
             if(neighbornode==null){
                  neighbornode=new Node(neighbor.val);
                map.put(neighbor.val,neighbornode);
                 q.add(neighbor);  
            } 
                clonenode.neighbors.add(neighbornode);      
            }     
        }
        return firstnode;
    }
}