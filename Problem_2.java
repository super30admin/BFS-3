// Time Complexity : O(n^n)
// Space Complexity : O(1)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach
//going node by node and looping through the neighbors, using HashMap to avoid visiting node again 
//and using DFS method to iterate through the graph

//133. Clone Graph

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        
        map = new HashMap<>();
        clone(node);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neighbor : curr.neighbors){
                if(!map.containsKey(neighbor)){
                    clone(neighbor);
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor)); 
            }
        }
        
        return map.get(node);
    }
    
    private void clone(Node node){
        if(node == null) return;
        if(map.containsKey(node)) return;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
    }
}