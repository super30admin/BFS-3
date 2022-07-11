// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


//dfs

class Solution {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null) return null;
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node) {
        if(map.containsKey(node)) return;
        // we create a clone of all the vertices
        // store it in the map
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        for(Node n: node.neighbors) {
            dfs(n);
            // when a neightbor's clone exists in the map, we add it to the parent's neighbors(clone itself)
            map.get(node).neighbors.add(map.get(n));
        }
    }
}

// bfs
// same time and space as above
class Solution {
    public Node cloneGraph(Node node) {
        Map<Node, Node> map = new HashMap<>();
        if(node == null) return null;
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node neighbor: curr.neighbors) {
                if(!map.containsKey(neighbor)) {
                    Node clonedNode = new Node(neighbor.val);
                    map.put(neighbor, clonedNode);
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }
        return newNode;
    }
}