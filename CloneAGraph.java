// https://leetcode.com/problems/clone-graph/

// BFS
// Time Complexity: O(V + E)
// Space Complexity: O(V)

// DFS
// Time Complexity: O(V + E)
// Space Complexity: O(V)

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
    HashMap<Node, Node> map = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        // dfs(node, map);
        Queue<Node> q = new LinkedList<>();
        Node cNode = new Node(node.val);
        map.put(node, cNode);
        q.add(node);
        while(!q.isEmpty()) {
            Node curr = q.poll();
            for(Node n: curr.neighbors) {
                if(!map.containsKey(n)) {
                    Node copy = new Node(n.val);
                    map.put(n, copy);
                    q.add(n);
                }
                map.get(curr).neighbors.add(map.get(n));
            }
        }
        return map.get(node);
    }

    /*
    private void dfs(Node node, HashMap<Node,Node> map) {
        //base
        if(map.containsKey(node)) return;
        //logic
        Node cNode = new Node(node.val);
        map.put(node, cNode);
        for(Node n: node.neighbors) {
            dfs(n, map);
            map.get(node).neighbors.add(map.get(n));
        }
    }
    */
}