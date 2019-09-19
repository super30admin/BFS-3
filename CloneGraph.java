import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
// BFS
// time complexity is o(n)
//space o(n)
// put new node in queue and map.
//and check its neighboring node.
//if node already present in map then add its child neighbouring node in node's neighbore.
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
	 public Node cloneGraph(Node node) {
	        if(node==null) return node;
	        Map<Integer,Node> map = new HashMap<>();
	        map.put(node.val,new Node(node.val,new ArrayList<>()));
	        Queue<Node> queue = new LinkedList<>();
	        queue.add(node);
	        while(!queue.isEmpty()){
	            Node cur = queue.poll();        
	            if(cur.neighbors==null || cur.neighbors.size()==0) continue;
	            for(Node n : cur.neighbors){
	                if(!map.containsKey(n.val)){
	                    queue.add(n);
	                    map.put(n.val,new Node(n.val,new ArrayList<>()));
	                }
	                map.get(cur.val).neighbors.add(map.get(n.val));
	            }
	            
	        }
	        return map.get(node.val);
	    }
}
