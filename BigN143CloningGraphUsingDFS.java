// Time complexity is O(N)
// Space complexity is O(N)
// This solution is submitted on leetcode

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class BigN143CloningGraphUsingDFS {
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
	    HashMap<Integer,Node> map;
	    public Node cloneGraph(Node node) {
	        //edge case
	        if(node ==null )
	            return node;
	        map = new HashMap<>();
	        dfs(node);
	        return map.get(node.val);
	    }
	    
	    private void dfs(Node node){
	        // base case
	        if(map.containsKey(node.val)){
	            return;
	        }
	        //logic
	        Node newNode = new Node(node.val, new ArrayList<>());
	        map.put(node.val,newNode);
	        for(Node n : node.neighbors){
	            dfs(n);
	            map.get(node.val).neighbors.add(map.get(n.val));
	        }
	    }
	}
}