// Time Complexity : O(N)
// Space Complexity : O(N)
// Did this code successfully run on Leetcode :
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
    HashMap<Node,Node> map = new HashMap<>();
    public Node cloneGraph(Node head) {
        //Base
        if(head == null) return null;
        if(map.containsKey(head)) return map.get(head);
        //Action
        Node node = new Node(head.val);
        map.put(head,node);
        //Recurse 
        for(Node nei:head.neighbors) node.neighbors.add(cloneGraph(nei));
        return node;
    }
}
