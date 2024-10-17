// Time Complexity :O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode :yes
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
    public Node cloneGraph(Node node) 
    {
        if(node == null) return node;
        HashMap<Node, Node> map = new HashMap<>();
        dfs(node, map);
        return map.get(node);
    }
    private void dfs(Node node, HashMap<Node, Node> map)
    {
        Node deepCopy = new Node(node.val);
        map.put(node, deepCopy);
        for(Node ne: node.neighbors)
        {
            if(!map.containsKey(ne))
            {
                dfs(ne, map);
            }
            map.get(node).neighbors.add(map.get(ne));
        }
    }
}