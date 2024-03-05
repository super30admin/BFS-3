/*Time Complexity: O(V+E)

Space Complexity: O(V)

Did this code successfully run on Leetcode : Yes

Approach: BFS - Create a copy of the new node. Add it to queue and map. Check the neighbors of polled
node from queue and create a new node and add to map and queue and continue. Finally return copied node.

Prob: 133. Clone Graph
*/

// Definition for a Node.

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;

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

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        HashMap<Node,Node> map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        Node copyNode = new Node(node.val);
        map.put(node,copyNode);
        q.add(node);
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node ne : curr.neighbors){
                if(!map.containsKey(ne)){
                    Node newNode = new Node(ne.val);
                    map.put(ne,newNode);
                    q.add(ne);
                }
                map.get(curr).neighbors.add(map.get(ne));
            }
        }
        return copyNode;
    }
}
}