// Time Complexity:  O(n)
// Space Complexity: O(n)

class Solution {

    public Node cloneGraph(Node node) {

        if(node == null) return null;
        
        Map<Node, Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        map.put(node, new Node(node.val));
        queue.add(node);

        while(!queue.isEmpty()) {
            Node curr = queue.poll();
            Node newNode = map.get(curr);                             // get copy of each node
            List<Node> adjList = curr.neighbors;              
            for(Node n : adjList) {
                if(!map.containsKey(n)) {                             // if neighbor not in map
                    map.put(n, new Node(n.val));                      // add it in map
                    queue.add(n);                                     // add it in queue
                }
                newNode.neighbors.add(map.get(n));                    // then add new neighbor
            }
        }

        return map.get(node);                                         // return new head node

    }

}
