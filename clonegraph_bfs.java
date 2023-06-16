/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

//Time Complexity : O(V+E)
//Space Complexity : O(V+E)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : No

/**
 * Take a map to map original node to the newly created node. Put the node in to
 * a queue. Poll the queue until its empty. for each polled node, iterate over
 * its neighbors and create nodes for them too and then add them to the queue if
 * not present in the map already. And then after each iteration, add the newly
 * created neighbor to the newly created node from the map. finally return the
 * newly created for the initial node.
 *
 */

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node, Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        
        Node newNode = new Node(node.val); //create deep copy of that node
        map.put(node, newNode); //eg. 1 : 1'
        
        //start bfs
        while(!q.isEmpty()){
            Node curr = q.poll();
            List<Node> neighbors = curr.neighbors; //get list of neighbours
            for(Node n: neighbors){
                if(!map.containsKey(n)){
                    Node deepCopy = new Node(n.val);
                    map.put(n, deepCopy);
                    q.add(n);
                }
                //if map doesnot contain deepcopy of curr
                //get deepcopy of curr node from map
                //get the list of that deepcopy
                //add deepcopy of neighbors
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return newNode;
    }
}
