// Time Complexity : O(v+e)
// Space Complexity : O(v+e) 
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

/*
* 1. it is BFS approach to solve the problem.
* 2. create a map of original node and clone node.
* 3. use map to insert a node to queue only once.
*/

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
        if(node==null) return node;
        Map<Node,Node> map= new HashMap<>();
        Queue<Node> queue=new LinkedList<>();
        
        queue.add(node);
        Node clone=new Node(node.val);
        map.put(node,clone);
        
        while(!queue.isEmpty()){
            Node n=queue.poll();
            for(Node nei:n.neighbors){
                if(!map.containsKey(nei)){
                    Node nclone=new Node(nei.val);
                    map.put(nei,nclone);
                    queue.add(nei);
                }
                map.get(n).neighbors.add(map.get(nei));
            }
            
        }
        return map.get(node);
    }
}