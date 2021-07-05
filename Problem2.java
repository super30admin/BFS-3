// Time Complexity : O(V+E)
// Space Complexity :O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no

// Your code here along with comments explaining your approach: Used hashmap to store all cloned vertices. Then made sure to work on BFS by using queue. At each node all its neighbors are checked and added in the hashmap and clone's neighbor accordignly

class Solution {
    public Node cloneGraph(Node node) {

        if (node == null)
            return null;

        HashMap<Integer, Node> hp = new HashMap<>();
        Queue<Node> q = new LinkedList<>();

        Node cloneNode = new Node(node.val);
        hp.put(node.val, cloneNode);
        q.add(node);

        while (!q.isEmpty()) {
            Node current = q.poll();
            Node cloneCurrent = hp.get(current.val);

            for (Node neigh : current.neighbors) {
                Node cloneNeigh = hp.get(neigh.val);
                if (cloneNeigh == null) {
                    cloneNeigh = new Node(neigh.val);
                    hp.put(neigh.val, cloneNeigh);
                    q.add(neigh);
                }

                cloneCurrent.neighbors.add(cloneNeigh);
            }
        }
        return cloneNode;
    }
}