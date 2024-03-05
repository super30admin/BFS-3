/*
* Did this code successfully run on Leetcode : YES
* 
* Any problem you faced while coding this : NO
* 
* Time Complexity: O(V+E)
    V - vertices in graph
    E - edges in the graph
* 
* Space Complexity: O(V)
* 
*/

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
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

public class CloneGraphBFS {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        HashMap<Integer, Node> hmap = new HashMap<>();

        Queue<Node> queue = new LinkedList<>();

        HashSet<Node> hset = new HashSet<>();

        queue.add(node);
        hset.add(node);

        while (!queue.isEmpty()) {
            Node temp = queue.poll();

            if (!hmap.containsKey(temp.val)) {
                hmap.put(temp.val, new Node(temp.val));
            }

            Node clonedNode = hmap.get(temp.val);

            for (Node child : temp.neighbors) {
                if (!hmap.containsKey(child.val)) {
                    hmap.put(child.val, new Node(child.val));
                }

                Node clonedChild = hmap.get(child.val);
                clonedNode.neighbors.add(clonedChild);

                if (!hset.contains(child)) {
                    queue.add(child);
                    hset.add(child);
                }
            }
        }

        return hmap.get(node.val);
    }
}
