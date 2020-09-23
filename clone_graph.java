import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

//Approach:We will be doing bfs or dfs to iterate over the graph and maintain an visited map to make sure we dont visit the same nodes again and again.
//This way we will be creating cloned nodes and map them in the visited map and add the neighbors too.
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
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null)
            return node;
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node)
    {
        //base condition
        if(map.containsKey(node))
            return;
        
        //logic
        Node copy = new Node(node.val);
        map.put(node, copy);
        for(Node n: node.neighbors)
        {
            dfs(n);
            //add neighbors
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

class clone_graph {
    public Node cloneGraph(Node node) {
        //edge case
        if(node == null)
            return node;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        Node copy = new Node(node.val);
        map.put(node, copy);
        queue.add(node);
        while(!queue.isEmpty())
        {
            Node curr = queue.poll();
            for(Node n: curr.neighbors)
            {
                if(!map.containsKey(n))
                {
                    Node newNode = new Node(n.val);
                    map.put(n, newNode);
                    queue.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return copy;                                     
    }
}
//Time Complexity : O(V+E)
//Space Complexity : O(V+E)
//Did this code successfully run on Leetcode :yes
//Any problem you faced while coding this :
