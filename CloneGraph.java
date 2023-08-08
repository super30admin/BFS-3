import java.util.*;

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

// Time Complexity :O(V+E) where V is the number of nodes and E is the edges
// Space Complexity :O(V) where V is the number of nodes
// Did this code successfully run on Leetcode :yes
class CloneGraphBFS {
    private HashMap<Node, Node> map;
    public Node cloneGraph(Node node) {
        if(node == null){
            return node;
        }
        this.map = new HashMap<>();
        Node newHeadNode = clone(node);
        Queue<Node> q = new LinkedList<>();
        q.add(node);

        while(!q.isEmpty()){
            Node current = q.poll();
            for(Node ne: current.neighbors){
                if(!map.containsKey(ne)){
                    Node neClone = clone(ne);
                    q.add(ne);
                }
                map.get(current).neighbors.add(map.get(ne));
            }
        }
        return newHeadNode;
    }

    private Node clone(Node node){
        if(!map.containsKey(node)){
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return map.get(node);
    }
}

// Time Complexity :O(V+E) where V is the number of nodes and E is the edges
// Space Complexity :O(V) where V is the number of nodes
// Did this code successfully run on Leetcode :yes
class cloneGraphDFS{
    private HashMap<Node, Node> map;
    public Node cloneGraph(Node node){
        if(node == null){
            return null;
        }
        this.map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node node){
        //base
        if(map.containsKey(node)){
            return;
        }

        //logic
        Node newNode = clone(node);
        map.put(node, newNode);

        for(Node ne: node.neighbors){
            dfs(ne);
            newNode.neighbors.add(map.get(ne));
        }
    }
    private Node clone(Node node){
        if(!map.containsKey(node)){
            Node newNode = new Node(node.val);
            map.put(node, newNode);
        }
        return map.get(node);
    }
}