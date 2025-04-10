// TC: O(n + e)
// SC: O(n)
// Did this code successfully run on Leetcode : Yes
// Any problem you faced while coding this : No

// class Node {
//     public int val;
//     public List<Node> neighbors;

//     public Node() {}

//     public Node(int _val, List<Node> _neighbors) {
//         val = _val;
//         neighbors = _neighbors;
//     }
// }

class Solution {
    // Map to keep track of cloned nodes using their unique value as the key.
    private HashMap<Integer, Node> map = new HashMap<>();

    public Node cloneGraph(Node node) {
        if (node == null) return null;
        return dfs(node);
    }

    private Node dfs(Node node) {
        if (map.containsKey(node.val)) {
            return map.get(node.val);
        }
        
        Node newNode = new Node(node.val, new ArrayList<>());
        map.put(node.val, newNode);
        
        for (Node neighbor : node.neighbors) {
            newNode.neighbors.add(dfs(neighbor));
        }
        
        return newNode;
    }
}
