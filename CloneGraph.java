// Time Complexity : O(V+E)
// Space Complexity : O(V+E)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

import java.util.*;

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


    // Solution using BFS
    public Node cloneGraphBFS(Node node) {
        // BFS Solution
        // Map to store deep copy of nodes
        HashMap<Integer, Node> map = new HashMap<>();

        // base case
        if(node == null){
            return node;
        }

        Queue<Node> q = new LinkedList<>();
        q.add(node);

        Node nodeCopy = new Node(node.val);
        map.put(node.val, nodeCopy);

        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> n = curr.neighbors;
            for(Node neighbor : n){
                if(!map.containsKey(neighbor.val)){
                    Node nCopy = new Node(neighbor.val);
                    map.put(neighbor.val, nCopy);
                    // we always add original node in the queue
                    q.add(neighbor);
                }

                map.get(curr.val).neighbors.add(map.get(neighbor.val));
            }
        }

        return nodeCopy;
    }
    // Solution using DFS

    HashMap<Integer, Node> map;
    public Node cloneGraph(Node node) {
        // Map to store deep copy of nodes
        map = new HashMap<>();

        // base case
        if(node == null){
            return node;
        }

        dfs(node);

        return map.get(node.val);
    }

    private void dfs(Node node){
        if(map.containsKey(node.val)){
            return;
        }

        Node newNode = new Node(node.val);
        map.put(node.val, newNode);

        for(Node n : node.neighbors){
            dfs(n);
            newNode.neighbors.add(map.get(n.val));
        }
    }
}
