// Time Complexity : O(V+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : Yes
// Approach : As we have to return a deep copy of the graph, we start cloning from the input node using BFS by adding it to the queue. When
// we parse the queue, we create a copy of the node and store it in a hashmap. Then we add the cloned neighbor to the cloned current node’s neighbors list.
// Finally we return the cloned version of the starting node.

class Solution {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if (node == null){
            return null;
        }
        this.map = new HashMap<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            Node curr = queue.poll();
            Node copyCurr = clone(curr);//create the cloned version of current node
            for (Node ne : curr.neighbors) { // looping the neighbors of current node
                if (!map.containsKey(ne)) { // neighbor is not been cloned yet
                    queue.add(ne); //add to queue
                }
                copyCurr.neighbors.add(clone(ne)); // add the cloned neighbor to the cloned current node’s neighbors list
            }
        }
        return map.get(node);
    }

    private Node clone(Node node) {//method to clone a node if it is not already cloned
        if (node == null){
            return null;
        }
        if (map.containsKey(node)){// If node is already cloned, return the clone
            return map.get(node);
        }
        map.put(node, new Node(node.val));
        return map.get(node);
    }
}
