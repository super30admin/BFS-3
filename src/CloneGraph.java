// Time Complexity : O(V)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
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
        if(node == null) return node;
        
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node.val, copyNode);
        q.add(node);
        
        while(!q.isEmpty()) {
            Node curr = q.poll();
            
            for(Node child: curr.neighbors){
                if(!map.containsKey(child.val)){
                    Node childCopy = new Node(child.val);
                    map.put(child.val, childCopy);
                    q.add(child);
                }
                
                map.get(curr.val).neighbors.add(map.get(child.val));
            }
        }
        
        return copyNode;
    }

}