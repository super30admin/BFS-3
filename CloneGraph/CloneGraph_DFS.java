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

/* Time Complexity : O(V+E) */
/* Space Complexity : O(V)
 * 	size of the hashmap  */
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :

//DFS

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        //map to maintain link b/n original node and copy of that node
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> map){
        //base condn
        if(map.containsKey(node)) return;
        //logic
        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        for(Node child: node.neighbors){
            dfs(child, map);
            map.get(node).neighbors.add(map.get(child));
        }
    }
}