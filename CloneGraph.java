import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * Uses BFS to traverse the graph and a HashMap to maintain original-to-clone node mappings.
 * For every node, we create its clone once and connect cloned neighbors while traversing level by level.
 * Time Complexity: O(V + E), Space Complexity: O(V) for the queue and hashmap.
 */
public class CloneGraph {
    Map<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return node;
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.offer(node);

        while(!q.isEmpty()) {
            Node curr = q.poll();

            Node clonedNode = getCloneNode(curr);

            for(Node nei : curr.neighbors) {
                if(!map.containsKey(nei)) {
                    q.offer(nei);
                }
                Node clonedNeighbor = getCloneNode(nei);
                clonedNode.neighbors.add(clonedNeighbor);
            }
        }
        return map.get(node);
    }

    public Node getCloneNode(Node node) {
        map.computeIfAbsent(node, n ->new Node(node.val));
        return map.get(node);
    }
}
