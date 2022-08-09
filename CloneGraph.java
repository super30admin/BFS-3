// Time Complexity : O(V + E) V -> Vertices + Edges
// Space Complexity : O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this :


// Your code here along with comments explaining your approach
class Solution {
    public Node cloneGraph(Node node) {

        if (node == null) return node;

        // using BFS
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        Node cloneNode = new Node(node.val);
        map.put(node, cloneNode);

        while (!q.isEmpty()) {

            Node curr = q.poll();

            for (Node n : curr.neighbors) {

                if (!map.containsKey(n)) {
                    Node nClone = new Node(n.val);
                    map.put(n, nClone);
                    q.add(n);
                }

                // add the neighbours to clone
                map.get(curr).neighbors.add(map.get(n));
            }
        }

        return cloneNode;
    }
}