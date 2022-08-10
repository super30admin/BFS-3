// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : None


import java.util.*;
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


class Solution {
    private HashMap<Node,Node> visited = new HashMap<> ();
    public Node cloneGraph(Node node) {
        if(node==null){
            return node;
        }

        Node newnode = new Node(node.val, new ArrayList());

        if(visited.containsKey(node)){
            return visited.get(node);
        }

        visited.put(node, newnode);

        for(Node neighbor: node.neighbors){
            newnode.neighbors.add(cloneGraph(neighbor));
        }

        return newnode;

    }
}