// S30 Big N Problem #143 {Medium}
// 133. Clone Graph
// Time Complexity : O(n) where n is the number of nodes in the graph
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :None

// Your code here along with comments explaining your approach
// BFS approach
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
        if(node==null) return null;
        
        Queue<Node> q=new LinkedList<>();
        q.add(node);
        
        HashMap<Integer, Node> map=new HashMap<>();
        Node newNode=new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        
        while(!q.isEmpty()){
            Node curr=q.poll();
            for(Node n:curr.neighbors){
                if(!map.containsKey(n.val)){
                    q.add(n);
                    Node newCopy=new Node(n.val, new ArrayList<>());
                    map.put(n.val, newCopy);
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return newNode;
    }
}