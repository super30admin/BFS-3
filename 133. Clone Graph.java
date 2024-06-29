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

// Time Complexity : O(V + 2E)
// Space Complexity : O(V + 2E)
// Method used : DFS

class Solution {

    public Node cloneGraph(Node node) {

        if(node == null) return node;

        // Hashmap keeps track of old node whose value is a newly created clone node, like 1 : 1(new node)
        HashMap<Node, Node> map = new HashMap();

        map.put(node, new Node(node.val));

        dfs(node, map);

        return map.get(node);
    }

    private void dfs(Node node, HashMap<Node, Node> map)
    {
        // In the given graph node 1 is connected to node 2 and 4. So I need to traverse these neighbor nodes
        for(Node x : node.neighbors)
        {
            // If neighbor node is not present in map it means it has not been cloned yet. So lets clone it.
            if(!map.containsKey(x))
                map.put(x, new Node(x.val));

            // We need to connect the newly created nodes. Assume in the 1st iteration node 2 is created. We need
            // to connect it to node 1 which is already present in the map.
            // In 1st iteration, as we started with node 1, map.get(node) will give me new node with value 1. Now to the new node neighbors we need to add
            // new node 2. So we do as following below. Now to the neighbors we need to add map.get(x), bcoz
            // x is a old node with value 2. We need to add the newly created node with value 2.
            map.get(node).neighbors.add(map.get(x));
        }

        // In the above loop all the newly created nodes 2 and 4 will be added to new node 1 in the 1st iteration.
        // But we also need to apply dfs on newly created nodes 2 and 4 because its neighbor list is empty as of now.
        // So again traverse the old nodes 2 and 4 and check if the new nodes 2 and 4 neighbors list is empty. If thats the case
        // they haven't been traversed yet. So apply dfs on those nodes.
        for(Node x : node.neighbors)
        {
            if(map.get(x).neighbors.size() == 0)
                dfs(x, map);
        }
    }
}
