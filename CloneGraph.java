// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
/*
 * 1 - Similar to create a clone of the Linked List problem
 * 2 - Add a copyNode of the head of the graph and add it to the map and to the queue(BFS).
 * 3 - Take the node out of the queue and run a loop over its adjacency list. For every Adj node, check if it exists 
 * in the map. If not, create a copy of the node and add it to the map and to the queue. 
 * 4 - Also, get the neighbours of the deep copy node and add the deep copy of the adjacent nodes in the original graph.
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class CloneGraph {
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
    
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        
        HashMap<Node,Node> map = new HashMap<>(); 
        Queue<Node> q = new LinkedList<>();
        
        Node copyNode = new Node(node.val);
        map.put(node,copyNode);
        q.add(node);
        
        while(!q.isEmpty())
        {
            Node curr = q.poll();
            for(Node adj : curr.neighbors)
            {
                if(!map.containsKey(adj))
                {
                    Node newNode = new Node(adj.val);
                    map.put(adj,newNode);
                    q.add(adj);
                }
                map.get(curr).neighbors.add(map.get(adj));
            }
        }
        return copyNode;
    }
}


/*
 * Approach 2 - DFS
 */

class Solution {
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

    HashMap<Node,Node> map;
    
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        
        if(node == null)
            return null;

        dfs(node);
        
        return map.get(node);
    }
    private void dfs(Node node)
    {
        //base
        if(map.containsKey(node))
            return;
        //logic
        if(!map.containsKey(node))
        {
            Node newNode = new Node(node.val);
            map.put(node,newNode);
        }
        
        for(Node adj:node.neighbors)
        {
            dfs(adj);
            map.get(node).neighbors.add(map.get(adj));
        }
    }
}