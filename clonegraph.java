// Time Complexity : O(v+E)
// Space Complexity : O(V)
// Did this code successfully run on Leetcode : yes
// Any problem you faced while coding this : no


// Your code here along with comments explaining your approach
/*
 * Use Hashmap to store the original node and copy node.
 * Using bfs approach, traverse the whole graph and check if the node exists in map and if not create a deep copy.
 */

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        queue.offer(node);
        Node nodeCopy = new Node(node.val);
        map.put(node, nodeCopy);

        while(!queue.isEmpty()){
            Node currNode = queue.poll();
            for(Node adjNode : currNode.neighbors){
                if(!map.containsKey(adjNode)){
                    map.put(adjNode, new Node(adjNode.val));
                    queue.add(adjNode);
                }
                
                Node adjNodeCopy = map.get(adjNode);
                map.get(currNode).neighbors.add(adjNodeCopy);    
            }
        }

        return map.get(node);
    }
}
