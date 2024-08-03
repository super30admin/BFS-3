/*
// Definition for a Node.
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
*/

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) {
            return null;
        }
        // BFS Solution
        // map = new HashMap<>();
        // Queue<Node> q = new LinkedList<>();
        // Node copyNode = clone(node);
        // q.add(node);
        // while(!q.isEmpty()) {
        //     Node curr = q.poll();
        //     List<Node> neighbors = curr.neighbors;
        //     for(Node neighbor: neighbors) {
        //         if(!map.containsKey(neighbor)) {
        //             q.add(neighbor);
        //         }
        //         Node clonedNeighbor = clone(neighbor);
        //         map.get(curr).neighbors.add(clonedNeighbor);
        //     }
        // }
        // return copyNode;

        // DFS Solution
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node) {
        // base
        if(map.containsKey(node)) {
            return;
        }
        // logic
        clone(node);
        List<Node> neighbors = node.neighbors;
        for(Node neighbor: neighbors) {
            dfs(neighbor);
            map.get(node).neighbors.add(map.get(neighbor));
        }
    }

    private Node clone(Node node) {
        if(map.containsKey(node)) {
            return map.get(node);
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
        return newNode;
    }
}
