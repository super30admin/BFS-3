/**
Time Complexity : O(N)
Space Complexity : O(N)
Did this code successfully run on Leetcode : Yes
Any problem you faced while coding this : No
*/
public class CloneGraph
{
    public Node cloneGraph(Node node)
    {
        if(node == null)
            return node;

        Queue<Node> queue = new LinkedList<>();
        Map<Node, Node> map = new HashMap<>();

        map.put(node, new Node(node.val, new ArrayList<>()));
        queue.add(node);

        while (!queue.isEmpty())
        {
            int size = queue.size();
            for(int i = 0; i < size; i++) {
                Node current = queue.poll();
                Node copyNode = map.get(current);

                for (Node neighBor : current.neighbors) {
                    Node newNeighBor = null;
                    if (!map.containsKey(neighBor)) {
                        map.put(neighBor, new Node(neighBor.val, new ArrayList<>()));
                        queue.add(neighBor);
                    }
                    newNeighBor = map.get(neighBor);
                    copyNode.neighbors.add(newNeighBor);
                }
            }
        }
        return map.get(node);
    }
}
