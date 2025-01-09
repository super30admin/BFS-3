// Approach : We maintain map of node.val with its cloned node. Now we process them using BFS - level order traversal
// Time : O(V+E)
// Space :  O(V)
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

class Solution {
    HashMap<Node, Node> map;

    public Node cloneGraph(Node node) {
        if (node == null)
            return null;
        this.map = new HashMap<>();
        Queue<Node> q = new LinkedList<>();
        q.add(node);
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                Node curr = q.poll();
                Node copyCurr = clone(curr);
                // Go over the curr neighbours
                for (Node ne:curr.neighbors) {
                    // add curr neighbours or childrens to the queue
                    if(!map.containsKey(ne)){
                        q.add(ne);
                    }
                    copyCurr.neighbors.add(clone(ne));
                    
                }
            }
        }
        return map.get(node);
    }

    public Node clone(Node node) {
        if (node == null)
            return null;
        if (!map.containsKey(node)) {
            Node newnode = new Node(node.val);
            map.put(node, newnode);
        }
        return map.get(node);
    }

}

// Approach : We maintain map of node.val with its cloned node. Now we process them using BFS - level order traversal
// Time : O(V+E)
// Space :  O(V)
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

class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
      if(node == null) return null;
      this.map = new HashMap<>();
      Queue<Node> q = new LinkedList<>();
      q.add(node);

      while(!q.isEmpty()){
        // without SIZE VARIABLE
        Node curr = q.poll();
        Node copyCurr = clone(curr);
        // we will add curr neighbours to the Queue and then add cloned copies of these neighbours as well
        for(Node ne: curr.neighbors){
            // don't want to process neighbours already in the map
            if(!map.containsKey(ne)){
                q.add(ne);
            }
            // After adding neighbour to the queue now add copy of the curr neighbours to the copyCurr
            copyCurr.neighbors.add(clone(ne));
        }
      }

      return map.get(node); // need to returned cloned node

    }

    public Node clone(Node node){
        if (node == null) return null;
        if(!map.containsKey(node)){
            Node newNode = new Node(node.val);
            map.put(node , newNode);
        }

        return map.get(node);
    }
}


// Approach : We maintain map of node.val with its cloned node. Now we process them using DFS
// Time : O(V+E)
// Space : O(N) =  O(V) # HashMap + O(H) # recursion stack
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

class Solution {
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
      if(node == null) return null;
      this.map = new HashMap<>();
      dfs(node);
      return map.get(node); // need to returned cloned node

    }

    public void dfs(Node node){

        Node copyCurr = clone(node); // deep copy of 1 is created - 1 *

        for(Node ne:node.neighbors){
            if(!map.containsKey(ne)){
                dfs(ne);
            }
            copyCurr.neighbors.add(clone(ne));
        }
        
    }

    public Node clone(Node node){
        if (node == null) return null;
        if(!map.containsKey(node)){
            Node newNode = new Node(node.val);
            map.put(node , newNode);
        }

        return map.get(node);
    }
}

