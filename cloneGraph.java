// TC: O(N+M)  for number of vertices and number of edges
// SC: O(N) for HashMap to store values of Nodes

import java.util.*;
// create a Node class having constructor for value and neighbors
class Node {
	
	int val;
	List<Node> neighbors;
	
	public Node() {
		val = 0;
		neighbors = new ArrayList<>();
	}
	public Node(int val, List<Node> neighbors){
		this.val = val;
		this.neighbors = neighbors;
	}
}

public class cloneGraph {

	HashMap<Node, Node> map;
	// create a hashmap which will store the given nodes as key and new clone nodes created as values
	public Node CloneGraph(Node node) {
		
		// if the node is null, return null
		if( node == null)
			return null;
		// initialize the hashmap
		map = new HashMap<>();
		// return the cloned nodde
		return clone(node);
		
	}
	
	public Node clone(Node node) {
		if(node == null)
			return null;
		
		// if the map already contains the value for the node given, i.e., newNode value, return that node
		if(map.containsKey(node)) {
			return map.get(node);
		}
		
		// if not in map, add new values into map for given node as key and newly created clone Node as value
		Node newNode = new Node(node.val, new ArrayList<Node>());
		map.put(node, newNode);
		// iterate over the node neighbors and add them as neighbors of newly created node, in this we recursively add all those values
		// of neighbors onto newNode.
		for(Node neighbor: node.neighbors) {
			newNode.neighbors.add(clone(neighbor));
		}
		
		// return the newNode created
		return newNode;
	}
}
