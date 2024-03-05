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
import java.util.List;

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

class CloneGraphDFS {
    HashMap<Integer, Node> hmap;

    HashSet<Node> hset;

    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        hmap = new HashMap<>();

        hset = new HashSet<>();

        dfs(node);

        return hmap.get(node.val);
    }

    private void dfs(Node node) {
        if (hset.contains(node)) {
            return;
        }

        if (!hmap.containsKey(node.val)) {
            hmap.put(node.val, new Node(node.val));
        }

        Node newNode = hmap.get(node.val);

        hset.add(node);

        for (Node child : node.neighbors) {
            if (!hmap.containsKey(child.val)) {
                hmap.put(child.val, new Node(child.val));
            }

            newNode.neighbors.add(hmap.get(child.val));
            dfs(child);
        }
    }
}