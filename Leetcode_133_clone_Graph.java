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

/*approach: 
 * 1. we'll take a map for a constant time lookup, and also to check if that node e=was ever isited, before adding to the BFS Queue.
 * 2. We'll add node in q. 
 * 3. traverse through the neighbors, and for corresponding neighbors, we'll create a copy, and add to the currcopy's neighbor list.
 * 4. At max we're travelling with V Nodes and E Edges. 
 * TC: O(V+E)
 * SC: O(V) // we are not adding repeated node, so we'll ony add V nodes.
 * 
*/

class Solution {

    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {

        if (node == null)
            return node;

        this.map = new HashMap<>();

        Queue<Node> q = new LinkedList<>();
        q.add(node);
        map.put(node, clone(node)); // added a copy node in map

        while (!q.isEmpty()) {
            Node curr = q.poll();

            // go through it's neighbors
            List<Node> neighbors = curr.neighbors;
            Node currcopy = map.get(curr); // copied node

            for (Node neighbor : neighbors) {
                // map act as a set here to find if the node is visited or not!
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, clone(neighbor));
                    q.add(neighbor);
                }
                currcopy.neighbors.add(map.get(neighbor));
            }
        }
        return map.get(node);
    }

    private Node clone(Node node) {
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        return map.get(node); // return akways copy node
    }
}

/*
 * DFS APPROACH
 * 1. check the curr node, get the copy.
 * 2. traverse through the neighbors
 * 3. if map doesn;t ahve it, do dfs
 * 4. else add neighbors clone to curr's neclones neighbor list.
 * 5. once for loop for neighbor is done, we automatically return.
 */

// TC: O(V+E) - we're not adding repeated
// sc: O(V)
class Solution {

    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {

        if (node == null)
            return node;
        this.map = new HashMap<>();

        dfs(node);

        return map.get(node); // return akways copy node
    }

    private void dfs(Node node) {

        // logic
        Node copynode = clone(node); // if we dont have it, clone will generate it,

        // go through the neighbors
        List<Node> nodeneighbor = node.neighbors;

        for (Node baby : nodeneighbor) {
            if (!map.containsKey(baby)) {
                // explore this node with dfs
                dfs(baby);
            }
            // we already have visited this neighbor 'n' now
            copynode.neighbors.add(map.get(baby));
        }
        return;
    }

    // Cloning Nodes
    private Node clone(Node node) {
        if (!map.containsKey(node)) {
            map.put(node, new Node(node.val));
        }
        return map.get(node); // return akways copy node
    }
}