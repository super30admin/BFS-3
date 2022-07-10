// Time Complexity :O(V+E) where v is no of vertices and e is no of edges
// Space Complexity :V
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        HashSet<Node> visited = new HashSet<>();
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            // if node already processed, return
            if (visited.contains(curr))
                continue;
            // get neighbors
            List<Node> children = curr.neighbors;
            // foreach neighbor, create dummy node if not created and make adjacency list
            // for each
            for (Node node1 : children) {
                if (!map.containsKey(node1)) {
                    Node newchild = new Node(node1.val);
                    map.put(node1, newchild);
                }
                map.get(curr).neighbors.add(map.get(node1));
                q.add(node1);
            }
            // after node is processed, add in set
            visited.add(curr);
        }
        return map.get(node);
    }
}

// ---------------DFS------------------------
// Time Complexity :O(V+E)
// Space Complexity :O(V)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No

class Solution {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        map = new HashMap<>();
        dfs(node);

        return map.get(node);
    }

    public void dfs(Node node) {
        // edge
        if (map.containsKey(node))
            return;
        // create dummy node
        if (!map.containsKey(node)) {
            Node newNode1 = new Node(node.val);
            map.put(node, newNode1);
        }
        // logic
        List<Node> ls = node.neighbors;
        for (Node n : ls) {
            // recursive call for neighbor
            dfs(n);
            // add dummy neighbour in dummy node
            map.get(node).neighbors.add(map.get(n));
        }

    }
}