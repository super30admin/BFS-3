// Time complexity: O(V+E)
// Space complexity: O(V+E)

// Approach: BFS. Create a map of key as old node and value as new node. Create a queue which will contain nodes. For each neigbor of current node, if map does not contain node, create a deep copy of the node, add the old node to the queue and make connection between neigbor of current node and neighbor of new node.

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node); // add first node
        Node newNode = new Node(node.val); // create clone of first node and add to map
        map.put(node,newNode);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            for(Node n : curr.neighbors) {
                if (!map.containsKey(n)) {
                    Node deepCopyNode = new Node(n.val); // create deep copy
                    map.put(n,deepCopyNode);
                    queue.add(n);
                }
                map.get(curr).neighbors.add(map.get(n)); // make connection of new node to it's new neighbor
            }
        }
        return map.get(node); // return the reference of the first new node
    }
}