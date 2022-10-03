import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

// Time Complexity : O(V+E) where V = number of vertices, E = number of edges
// Space Complexity : O(V) where V = number of vertices
// Did this code successfully run on Leetcode :
// Any problem you faced while coding this :

// Your code here along with comments explaining your approach
//133. Clone Graph (Medium) - https://leetcode.com/problems/clone-graph/
/*
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
*/

// Time Complexity : O(V+E) where V = number of vertices, E = number of edges
// Space Complexity : O(V) where V = number of vertices
// BFS Approach
//class Solution {
//    
//    Map<Node, Node> map;
//    
//    public Node cloneGraph(Node node) {
//        map = new HashMap<>();
//        if (node == null) return node;
//        
//        Node newNode = new Node(node.val);
//        map.put(node, newNode);
//        
//        Queue<Node> queue = new LinkedList<>();
//        queue.add(node);
//        
//        while (!queue.isEmpty()) {
//            Node curr = queue.poll();
//            
//            for (Node child : curr.neighbors) {
//                if (!map.containsKey(child)) {
//                    Node newChild = new Node(child.val);
//                    map.put(child, newChild);
//                    queue.add(child);
//                }
//                map.get(curr).neighbors.add(map.get(child)); // get the curr node's deep copy and add to its list, the curr child's deep copy
//            }
//        }
//        
//        return newNode;
//    }
//}

/*
//Definition for a Node.
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
*/

// Time Complexity : O(V+E) where V = number of vertices, E = number of edges
// Space Complexity : O(V) where V = number of vertices
// DFS Approach
class Solution {

	Map<Node, Node> map;

	public Node cloneGraph(Node node) {
		map = new HashMap<>();
		if (node == null)
			return node;

		dfs(node);

		return map.get(node);
	}

	private void dfs(Node node) {
		// base
		if (map.containsKey(node))
			return;
		// logic
		Node newNode = new Node(node.val);
		map.put(node, newNode);

		for (Node child : node.neighbors) {
			dfs(child);
			map.get(node).neighbors.add(map.get(child));
		}
	}
}