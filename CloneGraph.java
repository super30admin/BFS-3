import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.LinkedList;

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
	

	class Solution {
	    public Node cloneGraph(Node node) {
	        if(node ==null) 
	        return node;
	        Set<Node> visited = new HashSet<>();

	        Map<Node,Node> map = new HashMap<>();
	        Queue<Node> q = new LinkedList<>();
	        q.add(node);
	        Node copyNode = new Node(node.val);
	        map.put(node,copyNode);
	        visited.add(node);
	        while(!q.isEmpty()){
	            Node poppedNode = q.poll();
	                
	            if(map.containsKey(poppedNode))
	                copyNode = map.get(poppedNode);
	           
	            for(Node vertex:poppedNode.neighbors){
	                if(!visited.contains(vertex)){
	                        q.add(vertex);  
	                        visited.add(vertex);    
	                }
	                    
	                if(map.containsKey(vertex)){
	                    copyNode.neighbors.add(map.get(vertex));
	                }else{
	                    Node temp = new Node(vertex.val);
	                    map.put(vertex,temp);
	                    copyNode.neighbors.add(map.get(vertex));
	                }
	            }
	        }
	    return map.get(node);

	    }
	}
}
