package bfs3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
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
	
	//BFS
	//Time Complexity : O(V+E), where V are the number of nodes, E are edges
	//Space Complexity : O(V), for visited nodes
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public Node cloneGraph(Node node) {
        // null
        if(node == null)
            return null;
        
        Map<Node, Node> map = new HashMap<>();
        Node copy = new Node(node.val);
        map.put(node, copy);
        Queue<Node> queue = new LinkedList<>();
        queue.offer(node);
        
        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            for(Node n: curr.neighbors) {
                if(!map.containsKey(n)) {
                    Node copyNode = new Node(n.val);
                    map.put(n, copyNode);
                    queue.offer(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        
        return copy;
    }
	
	//DFS
	//Time Complexity : O(V+E), where V are the number of nodes, E are edges
	//Space Complexity : O(V), for visited nodes
	//Did this code successfully run on Leetcode : Yes
	//Any problem you faced while coding this : No
	public Node cloneGraph1(Node node) {
        // null
        if(node == null)
            return null;
        
        Map<Node, Node> map = new HashMap<>();
        dfs1(node, map);
        return map.get(node);
    }
    
    private void dfs1(Node node, Map<Node, Node> map) {
        // base
        if(map.containsKey(node))
            return;
        
        // logic
        Node deepCopy = new Node(node.val);
        map.put(node, deepCopy);
        for(Node n: node.neighbors) {
            dfs1(n, map);
            map.get(node).neighbors.add(map.get(n));
        }
    }
}
