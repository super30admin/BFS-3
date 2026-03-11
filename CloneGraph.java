// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach
// Everytime we encounter a new node we create a copy of it and add it to the map
// Then we add all the neighbours of the curr node to the respective copied node
// We use a hashmap to keep track of nodes and their copies 

class Solution {

    HashMap<Node, Node> map = new HashMap();

    public Node cloneGraphDFS(Node node) {
        if (node == null)
            return node;

        if (map.containsKey(node))
            return map.get(node);

        Node copy = new Node(node.val);
        map.put(node, copy);
        for (Node n : node.neighbors) {
            copy.neighbors.add(cloneGraphDFS(n));
        }

        return copy;
    }

    public Node cloneGraphBFS(Node node) {
        if (node == null)
            return node;
        Queue<Node> q = new LinkedList();
        q.add(node);
        while (!q.isEmpty()) {
            Node pop = q.poll();
            Node copy = clone(pop);
            for (Node n : pop.neighbors) {
                if (!map.containsKey(n))
                    q.add(n);
                copy.neighbors.add(clone(n));
            }
        }

        return map.get(node);
    }

    private Node clone(Node node) {
        if (node == null)
            return node;
        if (map.containsKey(node))
            return map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }

}