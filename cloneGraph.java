// Time Complexity : O(v+e)
// Space Complexity : O(v)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach
// BFS Approach
class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;

        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();

        q.add(node);
        Node copynode = new Node(node.val);
        map.put(node, copynode);

        while(!q.isEmpty()) {
            Node curr = q.poll();
            for (Node neighbor: curr.neighbors) {
                if (!map.containsKey(neighbor)) {
                    Node copy = new Node(neighbor.val);
                    map.put(neighbor, copy);
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return copynode;
    }
}

// ------------------------------------------------------------------------------------------------------------------
// DFS Approach
class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        map = new HashMap<>();

        dfs(node);

        return map.get(node);
    }

    private void dfs(Node node) {
        //base
        if(map.containsKey(node)) return;

        //logic
        Node newNode = new Node(node.val);
        map.put(node, newNode);

        for (Node neighbor: node.neighbors) {
            dfs(neighbor);
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }
}