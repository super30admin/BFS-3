// Time Complexity :O(edges*vertex)
// Space Complexity :O(vertex)
// Did this code successfully run on Leetcode :Yes
// Any problem you faced while coding this :No


// Your code here along with comments explaining your approach

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return null;
        
        Node newNode = new Node(node.val); //new node for return
        HashMap<Integer, Node> map = new HashMap(); //store visited nodes
        
        map.put(newNode.val, newNode); //add first node to HashMap
        
        LinkedList<Node> queue = new LinkedList(); //to store **original** nodes need to be visited
        queue.add(node); //add first **original** node to queue
        
        while (!queue.isEmpty()) { //if more nodes need to be visited
            Node n = queue.pop(); //search first node in the queue
            for (Node neighbor : n.neighbors) {
                if (!map.containsKey(neighbor.val)) { //add to map and queue if this node hasn't been searched before
                    map.put(neighbor.val, new Node(neighbor.val));
                    queue.add(neighbor);
                }
                map.get(n.val).neighbors.add(map.get(neighbor.val)); //add neighbor to new created nodes
            }
        }
        
        return newNode;
    }
}