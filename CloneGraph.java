// Time Complexity : O(V+E)
// Space Complexity : O(V)
// V --> vertices (nodes)
// E --> edges(neighbors)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach

//Method 2 - DFS
// TC: O(V+E)
// SC: O(V)
// V : vertices
// E : edges
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
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        //null check
        if(node == null)
            return null;
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){
        //base case
        if(map.containsKey(node))
            return;
        //logic
        Node clonedNode = new Node(node.val);
        map.put(node,clonedNode);
        for(Node n: node.neighbors){
            dfs(n);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

//Method 1 - BFS
// TC: O(V+E)
// SC: O(V)
// V : vertices
// E : edges
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
        if(node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node,Node> map = new HashMap<>();
        Node newNode = new Node(node.val);
        q.add(node);
        map.put(node,newNode);

        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors;
            for(Node n : neighbors){
                if(!map.containsKey(n)){
                    Node clonedNode = new Node(n.val);
                    map.put(n,clonedNode);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return newNode;
    }
}