// Time Complexity : O(N)
// Space Complexity: O(N)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No
// Your code here along with comments explaining your approach:
/*
Perform BFS and use hashmap to keep track for all the nodes cloned, remaining can be added
* */
public class CloneGraph {
        HashMap<Node, Node> hm= new HashMap<>();
        public Node cloneGraph(Node node) {
            if (node == null) return null;

            Queue<Node> queue = new ArrayDeque<>();


            Node copyNode = new Node(node.val, new ArrayList<>());
            hm.put(node, copyNode);

            queue.offer(node);

            while (!queue.isEmpty()) {
                Node curr = queue.poll();

                for (Node neighbor : curr.neighbors) {
                    if (!hm.containsKey(neighbor)) {
                        Node newNeigh = new Node(neighbor.val, new ArrayList<>());
                        queue.offer(neighbor);
                        hm.put(neighbor, newNeigh);
                    }
                    hm.get(curr).neighbors.add(hm.get(neighbor));
                }

            }

            return copyNode;
        }
}
