//Time Complexity: O(n) in terms of Nodes
//Space Complexity:  O(n) in terms of Nodes

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

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
        if(node == null) return node;
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Map<Integer, Node> map = new HashMap<>();
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node n: curr.neighbors){
                if(!map.containsKey(n.val)){
                    q.add(n);
                    Node nCopy = new Node(n.val, new ArrayList<>());
                    map.put(n.val, nCopy);
                }
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return newNode;
    }
}
