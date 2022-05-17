import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

//Time Complexity : O(V+E) 
//Space Complexity : O(V)
public class CloneGraph {	
	// Definition for a Node.
	static class Node {
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
	/**Approach1: BFS**/
	public Node cloneGraph(Node node) {
        if(node == null) return null;        
        HashMap<Node, Node> map= new HashMap<>();
        Queue<Node> q= new LinkedList<>();    
        Node newNode= new Node(node.val);//create copy of first node
        map.put(node, newNode);
        q.add(node);        
        while(!q.isEmpty()){
            Node curr= q.poll();            
            List<Node> edges = curr.neighbors;
            for(Node edge : edges){
                if(!map.containsKey(edge)){
                    Node copy = new Node(edge.val);
                    map.put(edge, copy);
                    q.add(edge);
                }
                //get deep copy of curr node 
                //and edges list of deep copy               
                map.get(curr).neighbors.add(map.get(edge));                
            }
        }        
        return newNode;
    }
	
	/**Approach2: DFS**/
	/*HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;        
        map= new HashMap<>();
        dfs(node);
        return map.get(node);
    }
    private void dfs(Node node){
        //base
        if(map.containsKey(node)) return;
        
        //logic
        Node newNode= new Node(node.val);
        map.put(node, newNode);
        for(Node edge : node.neighbors){
            dfs(edge);                           
            map.get(node).neighbors.add(map.get(edge));                
        }
    }*/
    
	// Driver code to test above
	public static void main (String[] args) {	
		CloneGraph ob  = new CloneGraph();			
		ArrayList<Node> list1= new ArrayList<>();
		list1.add(new Node(2));
		list1.add(new Node(3));		
		Node node= new Node(1, list1);
		System.out.println("Cloned graph: "+ob.cloneGraph(node));
		for(Node n: node.neighbors) {
			System.out.println(node.val+" connected to "+ n.val);
		}
	}
}
