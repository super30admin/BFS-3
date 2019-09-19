package bfs3;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

// Definition for a Node.
	class Node {
	    public int val;
	    public List<Node> neighbors;

	    public Node() {}

	    public Node(int _val,List<Node> _neighbors) {
	        val = _val;
	        neighbors = _neighbors;
	    }
	};
	public class CloneGraph {
	   // Keep a hashmap to maintain the records of previously visited nodes
	    HashMap<Integer, Node> map = new HashMap<>(); 
	   
	    public Node cloneGraph(Node node) { 
	        return dfs(node, map);
	        }
	   
	        // recursively check if the incoming nodes are already present in the hashmap or that we have to get their connected nodes
	        public Node dfs(Node node, HashMap<Integer, Node> map) {
	            if(node == null) return node;
	            
	            if(map.containsKey(node.val)) {
	                return map.get(node.val);
	            }
	            // for cloning, we construct a new node, with its value and new array to store its corresponding neighbors as parameters
	            Node n = new Node(node.val, new ArrayList<Node>());
	            // put them in the map because we have to mark them visited
	            map.put(n.val, n);
	            // add all the neighbors to the node and perform recursive dfs on all those neighbors to further find thier neighbors
	            for(Node neighbor : node.neighbors) {
	                n.neighbors.add(dfs(neighbor, map));
	            }
	            return n;
	        } 
	}

	

