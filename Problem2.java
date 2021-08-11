// time - O(V + E)
// space - O(n)

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node,copyNode);
        q.add(node);

        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node n: node.neighbors) {
                if(!map.containsKey(n)){
                    Node copy = new Node(n.val);
                    map.put(n,copy); // put the deep copy in the map
                    q.add(n); // put the node in the queue after keeping the deep copy in the map
                }

                map.get(n).neighbors.add(map.get(n)); // add the deep copy of the neighbors

            }
        }

        return copyNode;
    }
}