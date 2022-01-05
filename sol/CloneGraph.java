package sol;
import java.util.*;


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

public class CloneGraph {
	 public Node cloneGraph(Node node) {
	        if(node==null){return null;}
	        HashMap<Node, Node>hm= new HashMap<>();
	        
	        Queue<Node> q= new LinkedList();
	        q.add(node);
	       // System.out.println(node.val);
	        hm.put(node, new Node(node.val));
	        
	        while(!q.isEmpty()){
	            
	            Node cur=q.poll();
	             
	            for(Node x: cur.neighbors){
	                
	                if(!hm.containsKey(x)) {
	                    
	                     hm.put(x,new Node(x.val));
	                   
	                     q.add(x); 
	                }
	                
	                 hm.get(cur).neighbors.add(hm.get(x));
	            } 
	            //System.out.println(cur.val);
	            }
	   
	   
	        
	    return hm.get(node);
	    
	        
	    }
	         
}
