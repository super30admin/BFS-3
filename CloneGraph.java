// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

public class CloneGraph {
	 public Node cloneGraph(Node node) {
	        if(node==null) return node;
	        HashMap<Node,Node> map=new HashMap<>();
	        Queue<Node> queue=new LinkedList<>();
	        queue.add(node);
	        map.put(node,new Node(node.val,new ArrayList<>()));
	        while(!queue.isEmpty()){
	            Node curr=queue.poll();
	            List<Node> neighbors=curr.neighbors;
	            for(Node n:neighbors){
	                if(!map.containsKey(n)){
	                    map.put(n,new Node(n.val));
	                    queue.add(n);
	                }
	                map.get(curr).neighbors.add(map.get(n)); 
	             
	            }
	        }
	        
	        return map.get(node);
	  }
	 
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
}
