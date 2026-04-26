// Time Complexity : O(V+E)
// Space Complexity : O(E)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach
/*
We maintain a map to track the mapping/relation for nodes in the graph and their corresponding cloned nodes.
We do a BFS traversal by using queue by starting at the node and the visting its neighbours. If we did not
already visit them or clone them, we can check in the map if they are already present, if not, we add it to
the queue to further visit their neigbours and create the cloned nodes for these neighbours as well and connect
them.
 */
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
    Map<Node, Node> cloneMap;
    public Node cloneGraph(Node node) {
        if(node == null)
            return node;
        this.cloneMap = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()) {
            Node curr = q.poll();
            Node copyCurr = clone(curr);

            for(Node ne : curr.neighbors) {
                if(!cloneMap.containsKey(ne)) {
                    q.add(ne);
                }
                copyCurr.neighbors.add(clone(ne));
            }
        }
        return cloneMap.get(node);
    }

    private Node clone(Node node) {
        if(node == null)
            return null;
        if(cloneMap.containsKey(node))
            return cloneMap.get(node);
        cloneMap.put(node, new Node(node.val));
        return cloneMap.get(node);
    }
}