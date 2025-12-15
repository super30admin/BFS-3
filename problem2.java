// Time Complexity :O(n)
// Space Complexity :O(n)
// Did this code successfully run on Leetcode :yes
// Any problem you faced while coding this : I am fuzzy on the logic

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null)
            return node;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node CopyNode = new Node(node.val);
        map.put(node, CopyNode);
        q.add(node);
        while (!q.isEmpty()) {
            Node cur = q.poll();
            for (Node ne : cur.neighbors) {
                if (!map.containsKey(ne)) {
                    Node newNode = new Node(ne.val);
                    map.put(ne, newNode);
                    q.add(ne);
                }
                map.get(cur).neighbors.add(map.get(ne));
            }
        }
        return CopyNode;
    }
}