// Time Complexity: O(v + e)
// Space Complexity: O(v)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No


// Your code here along with comments explaining your approach

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        if(node == null)
            return node;
        Queue<Node> q = new LinkedList<>();
        Node copyNode = clone(node);
        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            List<Node> children = curr.neighbors;
            for(Node child: children) {
                if(!map.containsKey(child)) {
                    clone(child);
                    q.add(child);
                }
            // create the edges of the current Node copy
            // get the deep copy of current
            // add to that deep copy the deep copy of child of curr
            map.get(curr).neighbors.add(map.get(child));
            }
        }
        // return map.get(node);
        return copyNode;
    }
    private Node clone(Node node) {
        if(map.containsKey(node)) return map.get(node);
        Node copy = new Node(node.val);
        map.put(node, copy);
        return copy;
    }
}