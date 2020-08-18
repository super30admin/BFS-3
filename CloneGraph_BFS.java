// Time Complexity : O(V + E) --> where V is the vertices and E is the edges in the graph
// Space Complexity : O(n) --> where n is number of nodes in the graph
// Did this code successfully run on Leetcode (133): Yes
// Any problem you faced while coding this : No

// Your code here along with comments explaining your approach

class Solution {
    public Node cloneGraph(Node node) { 
        // edge case
        if (node == null) return node;
        
        Map<Integer, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node.val, copyNode); 
        q.add(node);
        
        while (!q.isEmpty()) {
            Node curr = q.poll();
            for (Node n : curr.neighbors) {
                if (!map.containsKey(n.val)) {
                    Node copy = new Node(n.val);
                    map.put(n.val, copy);
                    q.add(n);
                }
                // get copy of original node
                // add to its neighbors, copy of my original nodeneig
                map.get(curr.val).neighbors.add(map.get(n.val));
            }
        }
        return copyNode;
    }
}