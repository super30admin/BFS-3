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
    //tc- o(V+E)
    //SC-O(V)
    HashMap<Node,Node> map;
    public Node cloneGraph(Node node) {
        if(node == null) return null;
        map = new HashMap<>();
        dfs(node);
        return map.get(node);
    }

    private void dfs(Node n)
    {
        //basecase
       if(map.containsKey(n)) return;

        //logic
        Node newNode = new Node(n.val);
        map.put(n,newNode);
        List<Node> neighbors = n.neighbors;
        for(Node node : neighbors)
        {
            dfs(node);
            map.get(n).neighbors.add(map.get(node));
        }

    }
}