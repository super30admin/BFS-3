/*Time Complexity: O(V+E)

Space Complexity: O(V)

Did this code successfully run on Leetcode : Yes

Approach: DFS - Keep creating node and add it to map and do dfs on node. 

Prob: 133. Clone Graph
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        dfs(node,map);
        return map.get(node);
    }
    private void dfs(Node node, HashMap<Node,Node> map){
        if(map.containsKey(node)) return;
        Node copy = new Node(node.val);
        map.put(node,copy);
        for(Node ne : node.neighbors){
            dfs(ne,map);
            map.get(node).neighbors.add(map.get(ne));
        }
    }
}