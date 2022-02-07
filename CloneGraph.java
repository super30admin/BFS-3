// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use bfs to solve this
// we first create a hashmap and store the clone node as we create them
// then we use the queue to add the edges to the cloned nodes

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();

        Node copyNode = new Node(node.val);
        map.put(node, copyNode);
        q.add(node);

        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neigh : curr.neighbors) {
                if (!map.containsKey(neigh)) {
                    Node newNode = new Node(neigh.val);
                    map.put(neigh, newNode);
                    q.add(neigh);
                }
                map.get(curr).neighbors.add(map.get(neigh));
            }
        }
        return copyNode;
    }
}

// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Approach

// we use dfs to solve this
// we first create a hashmap and store the clone node as we create them
// then we call the function recursively to add the edges
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

        if (map.containsKey(node))
            return;

        Node newnode = new Node(node.val);
        map.put(node, newnode);
        for (Node neigh : node.neighbors) {
            dfs(neigh);
            map.get(node).neighbors.add(map.get(neigh));
        }
    }
}
