//Time Complexity : O(V+E)
//Space Complexity : O(V)
//Did this code successfully run on Leetcode : Yes
//Any problem you faced while coding this : None

package com.s30.satish;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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
class Clone_Graph_133 {
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        Queue<Node> q = new LinkedList<>();
        HashMap<Node, Node> map = new HashMap<>();
        Node deepCopy = new Node(node.val);
        q.add(node);
        map.put(node, deepCopy);
        while(!q.isEmpty())
        {
            Node currNode = q.poll();
            for(Node n : currNode.neighbors)
            {
                if(!map.containsKey(n))
                {
                    Node copyNode = new Node(n.val);
                    map.put(n, copyNode);
                    q.add(n);
                }
                map.get(currNode).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }
}