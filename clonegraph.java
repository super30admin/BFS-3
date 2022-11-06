/*
Time Complexity: O(N+M)
Space Complexity: O(N)
*/
class Solution {
    HashMap<Integer, Node> check = new HashMap<>();
    public Node cloneGraph(Node node) {
        if(node == null)
            return null;
        if(check.containsKey(node.val))
            return check.get(node.val);
        Node clone = new Node(node.val);
        check.put(clone.val, clone);
        for(Node n : node.neighbors)
            clone.neighbors.add(cloneGraph(n));
        return clone;
    }
}