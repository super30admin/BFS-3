// Time Complexity : O(V+E) 
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this: No

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
//lastmethod left
*/
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<Node, Node>();
        if(node == null) return null;
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        //logic
        if(!map.containsKey(node)){
            Node copy = new Node(node.val);
            map.put(node,copy);
        }
        for(Node n: node.neighbors){
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

/*
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<Node, Node>();
        if(node == null) return null;
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n : curr.neighbors){
                if(!map.containsKey(n)){
                    Node copyN = new Node(n.val);
                    map.put(n, copyN);
                    q.add(n);
                }
                // adding deep copy of original neighbor
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return copyNode;
    }
}
*/