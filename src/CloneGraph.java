//TC = O(V+E) V are vertices, E is edges of the graph
//SC = O(E)
// Was able to run in LeetCode = yes

import java.util.*;

public class CloneGraph {
}

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

//dfs
class CloneGraphDFS {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        map = new HashMap<>();
        clone(node);
        dfs(node);
        return map.get(node);

    }

    private void clone(Node node){
        if(map.containsKey(node)){
            return;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
    }

    private void dfs(Node node){
        //base

        //logic
        for(Node neighbor: node.neighbors){
            if(!map.containsKey(neighbor)){
                clone(neighbor);
                map.get(node).neighbors.add(map.get(neighbor));
                dfs(neighbor);
            }else{
                map.get(node).neighbors.add(map.get(neighbor));
            }

        }

    }
}


//bfs
class CloneGraphBFS {
    HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }

        map = new HashMap<>();
        clone(node);
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        //start bfs
        while(!q.isEmpty()){
            Node curr = q.poll();
            for(Node neighbor: curr.neighbors){
                if(!map.containsKey(neighbor)){
                    clone(neighbor);
                    q.add(neighbor);
                }
                map.get(curr).neighbors.add(map.get(neighbor));
            }
        }

        return map.get(node);

    }

    private void clone(Node node){
        if(map.containsKey(node)){
            return;
        }
        Node newNode = new Node(node.val);
        map.put(node, newNode);
    }


}