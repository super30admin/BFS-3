// Time Complexity : O(v + e)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// DFS soln
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null) return node;
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node){        
        clone(node);
        List<Node> children = node.neighbors;
        for(Node child: children){
            if(!map.containsKey(child)){
                clone(child);
                dfs(child);
            }
            // process edges
            map.get(node).neighbors.add(map.get(child));
        }
    }
    private Node clone(Node node){
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}

//******************************************

// Time Complexity : O(v + e)
// Space Complexity : O(n)
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// BFS soln:

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null) return node;
        Queue<Node> q = new LinkedList<>();
        Node copyNode = clone(node);
        q.add(node);
        
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> children = curr.neighbors;
            for(Node child: children){
                if(!map.containsKey(child)){
                    clone(child); 
                    q.add(child);
                }
                // create edges of curr node's copy
                // get deep copy of curr -> neighbors add deep copy of child
                map.get(curr).neighbors.add(map.get(child));
            }
        }
        return map.get(node);
    }
    private Node clone(Node node){
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}
// *************************************

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